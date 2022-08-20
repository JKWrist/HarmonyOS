import java.util.Random;
import java.util.Scanner;

// alt + Enter 提示解决方案

public class two
{
    public static void test1()
    {
        Random ran = new Random();

        //Boolean型
        boolean flag = true;
        while(flag)
        {
//            int res = ran.nextInt();
//            System.out.println(res);

            int res = ran.nextInt(100 );   //bound是提示
            System.out.println(res);
        }
    }

    //猜数字大小
    public static void GuessNum()
    {
        Random ran = new Random();
        int res = ran.nextInt(100 );   //bound是提示，不需要输入
        System.out.println(res);

        while(true)
        {
            Scanner scn = new Scanner(System.in);
            int num = scn.nextInt();

            if(num < res)
            {
                System.out.println(num + "数字猜小了");
            }
            else if(num > res)
            {
                System.out.println(num + "数字猜大了");
            }
            else
            {
                System.out.println(num + "正确");
            }
        }
    }

    public static void testArray()
    {
        int[] ages = new int[5];
        String[] names = new String[5];
        ages[0] = 1;
        names[0] = "xiao bai";

        ages[1] = 2;
        names[0] = "xiao hong";

        ages[4] = 3;
        names[4] = "xiao lan";

        for (int i = 0; i < 5; i++)
        {
            System.out.println(ages[i] + " " + names[i]);
        }
    }

    public static void main(String[] args)
    {
//        test1();
//        GuessNum();
        testArray();
    }
}
