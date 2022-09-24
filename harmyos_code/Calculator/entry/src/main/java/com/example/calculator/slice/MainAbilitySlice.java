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
            ResourceTable.Id_bt7, ResourceTable.Id_bt8, ResourceTable.Id_bt9, ResourceTable.Id_bt_end};

    private static int[] operatorIds = {ResourceTable.Id_bt_in,
            ResourceTable.Id_bt_de, ResourceTable.Id_bt_mul, ResourceTable.Id_bt_div,
            ResourceTable.Id_bt_per};

    // 从 operatorIds 数组中移除下面两个Id, 并在 numberIds 数组中添加 end 小数点 Id
    //, ResourceTable.Id_bt_delete   PXY 修改
    //, ResourceTable.Id_bt_eq        PXY 修改

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

    private void initView() // 查找 显示框的两个 id 值
    {
        inputText = (TextField) findComponentById(ResourceTable.Id_textfield);
        preResult = (Text) findComponentById(ResourceTable.Id_text_res);
    }

    private void initlistener()  //如果按 C 键 ， 清空显示窗口的值
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
        // 按 delete 键时，删除一个数字或符号
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

        // 如果按了 = 号，把得到的结果放到输入框中  pxy 修改
        findComponentById(ResourceTable.Id_bt_eq).setClickedListener(new Component.ClickedListener()
        {
            @Override
            public void onClick(Component component)
            {
                if (!(preResult.getText().isEmpty()))
                {

                    inputText.setText(preResult.getText());
                    preResult.setText("");
                }

                // calculateResult(inputText.getText(), false);
            }
        });

        // 给数字按键安装监听器
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

        //给运算符按键安装监听器
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
    {   //数字按键被按下后进入事件处理方法
        String oldValue = inputText.getText();
        String inputValue = "";
        if (findComponentById(componentId) instanceof Button)
        {     // 判断是不是 Button 的id被按下
            Button btn = (Button) findComponentById(componentId);
            inputValue = btn.getText();  // 获取按键的 Text
        }

        if (oldValue.isEmpty() && ".".equals(inputValue))
        {  //如果只输入  “. ” 不处理
            return;
        }
        if ("0".equals(oldValue) && !".".equals(inputValue))
        {  // 如果原来的数是 0， 并且新输入的不是 . ,用新数替换 0
            inputText.setText(inputValue);  // 把 数字前面的 0 去除
        } else
        {
            inputText.append(inputValue);  // 把输入的数拼接
        }
        calculateResult(inputText.getText(), true);
    }

    private void bindOperatorClickListener(int componentId)
    {  // 按运算符按键安装监听器
        String oldValue = inputText.getText();
        String inputValue = "";
        if (findComponentById(componentId) instanceof Button)
        {
            Button btn = (Button) findComponentById(componentId);
            inputValue = btn.getText();
        }

        if (oldValue.isEmpty())
        {
            inputText.setText("");  // 如果只按运算符， 不显示  PXY 修改

            // 如果最后一位是运算符 且 不是% 运算符，新输入的也是运算符， 就用新的替换旧的  Pxy 修改
        } else if (MathUtil.isOperator(oldValue.substring(oldValue.length() - 1))
                && MathUtil.isOperator(inputValue) && !(oldValue.substring(oldValue.length() - 1).equals("%")))
        {
            String newValue = oldValue.substring(0, oldValue.length() - 1) + inputValue;
            inputText.setText(newValue);
        } else
        {
            inputText.append(inputValue);  // 把运算符拼接上数字
        }
        calculateResult(inputText.getText(), true);         //计算结果
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
        // 末位是运算符 不计算   排除末位是%号 PXY 修改
        if (MathUtil.isOperator(exp.substring(exp.length() - 1)) && !(exp.substring(exp.length() - 1).equals("%")))
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
