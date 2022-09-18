package com.huawei.cookbook.utils;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * MathUtil
 * 
 * @since 2021-04-29
 */
public class MathUtil {
	// 数字栈中分隔数字时使用
	private static String separateStr = "@";

	// 保留小数位数
	private static final int DECIMAL_DIGIT = 6;

	// 不包含指定字符
	private static final int NOT_CONTAIN = -1;

	// 高优先级
	private static final int HIGH_PRIORITY = 2;

	// 低优先级
	private static final int LOW_PRIORITY = 1;

	private MathUtil() {
	}

	/**
	 * thinking:
	 * 1.Split the expression into numbers and operators, and store them in two
	 * stacks.
	 * 2.Numbers directly into the digital stack
	 * 3.If the priority is less than or equal to the previous operator in the
	 * stack, the
	 * calculation result is stored in the digit stack, and the current operator is
	 * stored in the symbol stack.
	 * If the priority is higher than that of the previous operator in the stack,
	 * the current symbol is directly
	 * added to the stack.
	 * 4.Obtain the two values of the digit stack and an operator of the symbol
	 * stack in sequence, perform operations
	 * in sequence, and import the results into the digit stack.
	 * 5.The final symbol stack is empty and the number stack contains only one
	 * digit, which is the final calculation
	 * result.
	 * 
	 * @param exp Mathematical Expression String
	 * @return Calculation result string
	 */
	public static String getResultString(String exp) {
		Stack<String> numStack = new Stack<>();
		numStack.push(separateStr); // 数字用@分开，数字栈中@号 为了便于区分小数
		Stack<String> oprStack = new Stack<>();

		String[] strings = exp.split("");
		for (String singleStr : strings) {
			if (isOperator(singleStr)) {
				spiltExp(numStack, oprStack, singleStr);
			} else {
				numStack.push(singleStr);
			}
		}
		while (!oprStack.isEmpty()) {
			combineString(numStack);
			compute(numStack, oprStack);
		}
		numStack.pop();
		String resultValue = numStack.peek();
		return resultValue;
	}

	private static void spiltExp(Stack<String> numStack, Stack<String> oprStack, String singleStr) {
		// 运算符间的字符拼接成一个数字
		combineString(numStack);
		if (!oprStack.isEmpty()) {
			// 先处理优先级高的运算符
			while (!oprStack.isEmpty() && priority(singleStr) <= priority(oprStack.peek())) {
				combineString(numStack);
				compute(numStack, oprStack);
			}
		}
		oprStack.push(singleStr);
	}

	private static void compute(Stack<String> numStack, Stack<String> oprStack) {
		BigDecimal result = null;

		numStack.pop();
		BigDecimal rightNumber = new BigDecimal(numStack.pop());

		numStack.pop();
		BigDecimal leftNumber = new BigDecimal(numStack.pop());

		String operator = oprStack.pop();
		switch (operator) {
			case "-":
				result = leftNumber.subtract(rightNumber);
				break;
			case "+":
				result = leftNumber.add(rightNumber);
				break;
			case "%":
				result = leftNumber.divideAndRemainder(rightNumber)[1];
				break;
			case "×":
				result = leftNumber.multiply(rightNumber);
				break;
			case "÷":
				result = leftNumber.divide(rightNumber, DECIMAL_DIGIT, BigDecimal.ROUND_HALF_UP);
				break;
			default:
				break;
		}
		numStack.push(result.stripTrailingZeros().toPlainString());
		numStack.push(separateStr);
	}

	private static void combineString(Stack<String> stack) {
		if (separateStr.equals(stack.peek())) {
			return;
		}
		StringBuilder numberBuilder = new StringBuilder();
		while (true) {
			String string = stack.peek();
			if (separateStr.equals(string)) {
				break;
			}
			numberBuilder.insert(0, string);
			stack.pop();
		}
		stack.push(numberBuilder.toString());
		stack.push(separateStr);
		numberBuilder.delete(0, numberBuilder.length());
	}

	/**
	 * Determines whether a string is an operator.
	 * 
	 * @param singleStr Character string to be judged
	 * @return Judgment Result
	 */
	public static boolean isOperator(String singleStr) {
		String operators = "-+×÷%";
		if (operators.indexOf(singleStr) > NOT_CONTAIN) {
			return true;
		}
		return false;
	}

	private static int priority(String str) {
		String highOperator = "×÷%";
		if (highOperator.indexOf(str) > NOT_CONTAIN) {
			return HIGH_PRIORITY;
		}
		return LOW_PRIORITY;
	}
}