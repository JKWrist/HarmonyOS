package com.example.calculator.slice;

import com.example.calculator.ResourceTable;
import com.example.calculator.utils.MathUtil;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.agp.window.service.WindowManager;

import java.util.EmptyStackException;
import java.util.regex.Pattern;


/*
页面载体
 */
public class MainAbilitySlice extends AbilitySlice
{
    private static int[] numberIds = {ResourceTable.Id_bt0,
            ResourceTable.Id_bt1, ResourceTable.Id_bt2, ResourceTable.Id_bt3,
            ResourceTable.Id_bt4, ResourceTable.Id_bt5, ResourceTable.Id_bt6,
            ResourceTable.Id_bt7, ResourceTable.Id_bt8, ResourceTable.Id_bt9};

    private static int[] operatorIds = {ResourceTable.Id_bt_in,
            ResourceTable.Id_bt_de, ResourceTable.Id_bt_mul, ResourceTable.Id_bt_div,
            ResourceTable.Id_bt_per, ResourceTable.Id_bt_eq, ResourceTable.Id_bt_delete};

    private TextField inputText;
    private Text preResult;

    @Override
    public void onStart(Intent intent)
    {
        // 禁止软键盘弹出
        getWindow().setLayoutFlags(WindowManager.LayoutConfig.MARK_ALT_FOCUSABLE_IM,
                WindowManager.LayoutConfig.MARK_ALT_FOCUSABLE_IM);
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initView();
        initlistener();
    }

    private void initView()
    {
        inputText = findComponentById(ResourceTable.Id_textfield);
        preResult = findComponentById(ResourceTable.Id_text_res);
    }

    private void initlistener()
    {
        findComponentById(ResourceTable.Id_btC).setClickedListener(new Component.ClickedListener()
        {
            @Override
            public void onClick(Component component)
            {
                preResult.setText("");
                inputText.setText("");
            }
        });

        findComponentById(ResourceTable.Id_bt_delete).setClickedListener(new Component.ClickedListener()
        {
            @Override
            public void onClick(Component component)
            {
                if (inputText.getText().isEmpty())
                {
                    return;
                }
                inputText.setText(inputText.getText().substring(0, inputText.getText().length() - 1));
            }
        });

        findComponentById(ResourceTable.Id_bt_eq).setClickedListener(new Component.ClickedListener()
        {
            @Override
            public void onClick(Component component)
            {
                calculateResult(inputText.getText(), false);
            }
        });

        for (int componentId : numberIds)
        {
            findComponentById(componentId).setClickedListener(new Component.ClickedListener()
            {
                @Override
                public void onClick(Component component)
                {
                    bindNumberClickListener(componentId);
                }
            });
        }

        for (int componentId : operatorIds)
        {
            findComponentById(componentId).setClickedListener(new Component.ClickedListener()
            {
                @Override
                public void onClick(Component component)
                {
                    bindOperatorClickListener(componentId);
                }
            });
        }
    }

    private void bindNumberClickListener(int componentId)
    {
        String oldValue = inputText.getText();
        String inputValue = "";
        if (findComponentById(componentId) instanceof Button)
        {
            Button btn = (Button) findComponentById(componentId);
            inputValue = btn.getText();
        }

        if (oldValue.isEmpty() && ".".equals(inputValue))
        {
            return;
        }
        if ("0".equals(oldValue) && !".".equals(inputValue))
        {
            inputText.setText(inputValue);
        }
        else
        {
            inputText.append(inputValue);
        }
        calculateResult(inputText.getText(), true);
    }

    private void bindOperatorClickListener(int componentId)
    {
        String oldValue = inputText.getText();
        String inputValue = "";
        if (findComponentById(componentId) instanceof Button)
        {
            Button btn = (Button) findComponentById(componentId);
            inputValue = btn.getText();
        }

        if (oldValue.isEmpty())
        {
            inputText.setText(inputValue);
        }
        else if (MathUtil.isOperator(oldValue.substring(oldValue.length() - 1))
                && MathUtil.isOperator(inputValue))
        {
            String newValue = oldValue.substring(0, oldValue.length() - 1) + inputValue;
            inputText.setText(newValue);
        }
        else
        {
            inputText.append(inputValue);
        }
        calculateResult(inputText.getText(), true);
    }

    private void calculateResult(String exp, Boolean isAutoCalculate)
    {
        if (exp.isEmpty())
        {
            return;
        }
        // 只有数字 不计算
        String pattern = "(\\d*\\.?\\d*)|(0\\.\\d*[1-9])";
        boolean isMatch = Pattern.matches(pattern, exp);
        if (isMatch)
        {
            return;
        }
        // 末位是运算符 不计算
        if (MathUtil.isOperator(exp.substring(exp.length() - 1)))
        {
            return;
        }

        String resultValue;
        try
        {
            resultValue = MathUtil.getResultString(exp);
        } catch (NumberFormatException | ArithmeticException | EmptyStackException e)
        {
            preResult.setText("错误");
            return;
        }

        if (isAutoCalculate)
        {
            preResult.setText(resultValue);
            return;
        }
        preResult.setText("");
        inputText.setText(resultValue);
    }

    @Override
    public void onActive()
    {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent)
    {
        super.onForeground(intent);
    }
}
