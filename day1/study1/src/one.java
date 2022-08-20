import java.util.Scanner;

public class one
{
    public static void test01()
    {
        // System.out.println("hello world\n");
        int age1 = 18;
        System.out.println(age1);

        age1 = 20;
        System.out.println(age1);

        String userName = "xiaobai";
        System.out.println(userName);

        int age2 = 18;
        int sum = age1 + age2;
        System.out.println(sum);

        //引用数据类型
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        System.out.println(input);
    }

    //流程控制语句
    public static void test02()
    {
        int age = 18;
        if(age >= 18)
        {
            System.out.println("成年人");
        }
        else
        {
            System.out.println("青少年");
        }
    }

    //判断奇偶
    public static void test03()
    {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        if(1 == num % 2)
        {
            System.out.println("奇数");
        }
        else
        {
            System.out.println("偶数");
        }
    }
    //循环
    public static void test04()
    {
        int sum = 0;
        for (int i = 1; i <= 100; i++)
        {
            sum += i;
        }
        System.out.println(sum);
    }

    //鸡兔同笼，35个头，94个脚
    public static void test05()
    {
        int iChicken = 0;
        int iRabbit = 0;
        int foot = 0;
        //穷举
        for (iChicken = 0; iChicken < 35; iChicken++)
        {
            iRabbit = 35 - iChicken;
            foot = iChicken * 2 + 4 * iRabbit;
            System.out.println("脚的个数");
            System.out.println(foot);
            if(94 == foot)
            {
                System.out.println("鸡的个数");
                System.out.println(iChicken);
                System.out.println("兔子的个数");
                System.out.println(iRabbit);
                break;
            }
        }
    }

    //for循环 水仙花数
    public static void test06()
    {
        int num = 100;
        while(num <= 999)
        {
            int one_digit = num % 10;
            int ten_digit = (num / 10) % 10;
            int hundred_digit = num / 100;
//            System.out.println(num);
//            System.out.println("one_digit");
//            System.out.println(one_digit);
//            System.out.println("ten_digit");
//            System.out.println(ten_digit);
//            System.out.println("hundred_digit");
//            System.out.println(hundred_digit);

            if(num == one_digit * one_digit * one_digit + ten_digit * ten_digit * ten_digit +
                    hundred_digit * hundred_digit * hundred_digit)
            {
                System.out.println("水仙花数");
                System.out.println(num);
            }
            num++;
        }
    }

    public static void main(String[] args)
    {
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
        test06();
    }
}
