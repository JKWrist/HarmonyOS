package com.example.calculator.utils;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * MathUtil
 *
 * @since 2021-04-29
 */
public class MathUtil
{
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

    private MathUtil()
    {
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
    public static String getResultString(String exp)
    {
        Stack<String> numStack = new Stack<>();  //新建一个数字栈
        numStack.push(separateStr); // 数字用@分开，数字栈中@号 为了便于区分小数
        Stack<String> oprStack = new Stack<>();  // 新建一个符号栈

        String[] strings = exp.split("");    // 把要运算的字符串 分割 成一个一个数字或符号
        for (String singleStr : strings)  // 遍历运算字符串
        {
            if (isOperator(singleStr))  // 如果是运算符号
            {
                spiltExp(numStack, oprStack, singleStr);  //把字符前的数字合并
            } else
            {
                numStack.push(singleStr);  // 否则继续把单个数字放入数字栈中
            }
        }
        while (!oprStack.isEmpty())  // 如果运算符栈中不为空，
        {
            combineString(numStack);      //把分割后的数字（除运算字符外）合并
            compute(numStack, oprStack);
        }
        numStack.pop();
        String resultValue = numStack.peek();
        return resultValue;
    }

    private static void spiltExp(Stack<String> numStack, Stack<String> oprStack, String singleStr)
    {
        // 运算符间的字符拼接成一个数字
        combineString(numStack);

        if (!oprStack.isEmpty())   // 如果操作符栈不是空的，说明已有计算的条件，
        {
            // 先处理优先级高的运算符            新传进来的运算符如果 <=  原来的运算符
            while (!oprStack.isEmpty() && priority(singleStr) <= priority(oprStack.peek()))
            {
                combineString(numStack);
                compute(numStack, oprStack);
            }
        }


        oprStack.push(singleStr);  //  如果操作符栈是空的，把运算符放入操作符栈中


    }

    // 计算
    private static void compute(Stack<String> numStack, Stack<String> oprStack)
    {
        BigDecimal result = null;   // 定主一个超大整数

        String operator = oprStack.pop();  // 获取运算的操作符
        BigDecimal leftNumber;
        BigDecimal rightNumber;

        if (operator.equals("%"))
        {   // 如果运算符是 % ， 则只取左边的数 / 100  PXY 修改

            numStack.pop();
            leftNumber = new BigDecimal(numStack.pop());
            result = leftNumber.divide(new BigDecimal("100"));

        } else
        {

            numStack.pop();  // 把栈顶的数出栈 ， 此时栈顶是 @ 符号
            rightNumber = new BigDecimal(numStack.pop());

            numStack.pop();
            leftNumber = new BigDecimal(numStack.pop());

            switch (operator)
            {
                case "-":
                    result = leftNumber.subtract(rightNumber);
                    break;
                case "+":
                    result = leftNumber.add(rightNumber);
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
        }

        // 去除小数点后的0      // 转成不带指数的字符串
        numStack.push(result.stripTrailingZeros().toPlainString());
        numStack.push(separateStr);
    }

    //把分割后的数字（除运算字符外）合并
    private static void combineString(Stack<String> stack)   // 传入数字栈
    {
        if (separateStr.equals(stack.peek()))   // 如果检测到是栈顶 @， 直接返回
        {
            return;
        }
        StringBuilder numberBuilder = new StringBuilder();  //定义一个字符串拼接对象
        while (true)
        {
            String string = stack.peek();    // 定义一个字符串，并把 数字的栈顶字符给它
            if (separateStr.equals(string))  // 如果是最后一个字符 @
            {
                break;  // 退出
            }
            numberBuilder.insert(0, string); // 把数字拼接在字符串最前面
            stack.pop();  // number 栈出栈当前数字，为下个准备
        }
        stack.push(numberBuilder.toString());  // 把合并完成的数字入栈
        stack.push(separateStr);  // 在栈顶放一个 @ 字符
        numberBuilder.delete(0, numberBuilder.length());  // 删除 字符串拼接对象
    }

    /**
     * Determines whether a string is an operator.
     *
     * @param singleStr Character string to be judged
     * @return Judgment Result
     */
    public static boolean isOperator(String singleStr)
    {
        String operators = "-+×÷%";
        if (operators.indexOf(singleStr) > NOT_CONTAIN)
        {
            return true;
        }
        return false;
    }

    private static int priority(String str)
    {
        String highOperator = "×÷%";
        if (highOperator.indexOf(str) > NOT_CONTAIN)
        {
            return HIGH_PRIORITY;
        }
        return LOW_PRIORITY;
    }
}