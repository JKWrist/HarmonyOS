package com.huawei.cookbook.slice;

import com.huawei.cookbook.ResourceTable;
import com.huawei.cookbook.utils.MathUtil;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;

import java.util.EmptyStackException;
import java.util.regex.Pattern;

/**
 * MainAbilitySlice
 * 
 * @since 2021-04-29
 */
public class MainAbilitySlice extends AbilitySlice {
	/**
	 * number component
	 */
	private static int[] numberComponentIds = { ResourceTable.Id_seven, ResourceTable.Id_eight, ResourceTable.Id_nine,
			ResourceTable.Id_four, ResourceTable.Id_five, ResourceTable.Id_six, ResourceTable.Id_one,
			ResourceTable.Id_two, ResourceTable.Id_three, ResourceTable.Id_zero, ResourceTable.Id_radix_point
	};

	/**
	 * operator component
	 */
	private static int[] operatorComponentIds = { ResourceTable.Id_divide, ResourceTable.Id_multiply,
			ResourceTable.Id_minus, ResourceTable.Id_divide_remainder, ResourceTable.Id_plus
	};

	private TextField inputText;
	private Text preResult;

	@Override
	public void onStart(Intent intent) {
		super.onStart(intent);
		super.setUIContent(ResourceTable.Layout_ability_main);
		initView();
		initListener();
	}

	private void initView() {
		if (findComponentById(ResourceTable.Id_input_text) instanceof TextField) {
			inputText = (TextField) findComponentById(ResourceTable.Id_input_text);
			inputText.requestFocus();
		}
		if (findComponentById(ResourceTable.Id_pre_result) instanceof Text) {
			preResult = (Text) findComponentById(ResourceTable.Id_pre_result);
		}
	}

	private void initListener() {
		findComponentById(ResourceTable.Id_number_cancel).setClickedListener(new Component.ClickedListener() {
			@Override
			public void onClick(Component component) {
				preResult.setText("");
				inputText.setText("");
			}
		});

		findComponentById(ResourceTable.Id_delete).setClickedListener(new Component.ClickedListener() {
			@Override
			public void onClick(Component component) {
				if (inputText.getText().isEmpty()) {
					return;
				}
				inputText.setText(inputText.getText().substring(0, inputText.getText().length() - 1));
			}
		});

		findComponentById(ResourceTable.Id_equal_sign).setClickedListener(new Component.ClickedListener() {
			@Override
			public void onClick(Component component) {
				calculateResult(inputText.getText(), false);
			}
		});

		for (int componentId : numberComponentIds) {
			findComponentById(componentId).setClickedListener(new Component.ClickedListener() {
				@Override
				public void onClick(Component component) {
					bindNumberClickListener(componentId);
				}
			});
		}

		for (int componentId : operatorComponentIds) {
			findComponentById(componentId).setClickedListener(new Component.ClickedListener() {
				@Override
				public void onClick(Component component) {
					bindOperatorClickListener(componentId);
				}
			});
		}
	}

	private void bindNumberClickListener(int componentId) {
		String oldValue = inputText.getText();
		String inputValue = "";
		if (findComponentById(componentId) instanceof Text) {
			Text text = (Text) findComponentById(componentId);
			inputValue = text.getText();
		}

		if (oldValue.isEmpty() && ".".equals(inputValue)) {
			return;
		}
		if ("0".equals(oldValue) && !".".equals(inputValue)) {
			inputText.setText(inputValue);
		} else {
			inputText.append(inputValue);
		}
		calculateResult(inputText.getText(), true);
	}

	private void bindOperatorClickListener(int componentId) {
		String oldValue = inputText.getText();
		String inputValue = "";
		if (findComponentById(componentId) instanceof Text) {
			Text text = (Text) findComponentById(componentId);
			inputValue = text.getText();
		}
		if (oldValue.isEmpty()) {
			inputText.setText(inputValue);
		} else if (MathUtil.isOperator(oldValue.substring(oldValue.length() - 1))
				&& MathUtil.isOperator(inputValue)) {
			String newValue = oldValue.substring(0, oldValue.length() - 1) + inputValue;
			inputText.setText(newValue);
		} else {
			inputText.append(inputValue);
		}
		calculateResult(inputText.getText(), true);
	}

	private void calculateResult(String exp, Boolean isAutoCalculate) {
		if (exp.isEmpty()) {
			return;
		}
		// 只有数字 不计算
		String pattern = "(\\d*\\.?\\d*)|(0\\.\\d*[1-9])";
		boolean isMatch = Pattern.matches(pattern, exp);
		if (isMatch) {
			return;
		}
		// 末位是运算符 不计算
		if (MathUtil.isOperator(exp.substring(exp.length() - 1))) {
			return;
		}

		String resultValue;
		try {
			resultValue = MathUtil.getResultString(exp);
		} catch (NumberFormatException | ArithmeticException | EmptyStackException e) {
			preResult.setText("错误");
			return;
		}

		if (isAutoCalculate) {
			preResult.setText(resultValue);
			return;
		}
		preResult.setText("");
		inputText.setText(resultValue);
	}

	@Override
	public void onActive() {
		super.onActive();
	}

	@Override
	public void onForeground(Intent intent) {
		super.onForeground(intent);
	}
}