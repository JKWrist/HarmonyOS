public class first
{
    public static void test1()
    {
        int num = 1;
        String userName = "asd";
        boolean isTrue = false;

        if(isTrue)
        {
            System.out.println("已经创建");
        }
        else
        {
            System.out.println("没有创建");
        }
    }

    public static void test2()
    {
        int sum = 0;
        for (int i = 0; i < 100 ;i++)
        {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void test3()
    {
        int age = 20;
        switch (age)
        {
            case 10:
                System.out.println(age);
                break;
            case 20:
                System.out.println(age);
                break;
            case 0:
                System.out.println("case 0");
                break;
        }
    }

    public static void test4()
    {
        int[] age = new int[5];
        age[0] = 10;
        age[4] = 20;

        String [] name = new String[5];
        name[0] = "123";
        name[4] = "456";

        for (int i = 0; i < 5; i++)
        {
            System.out.println( "age = " + age[i] + " name = " + name[i]);
        }
    }

    public static void test5()
    {
        String user1 = "张三";
        System.out.println(user1.hashCode());

        user1 = "李四";
        System.out.println(user1.hashCode());

        String user2 = "李四";
        System.out.println(user2.hashCode());
    }

    public static void test6()
    {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);

        String str3 = new String ("abc");
        String str4 = new String ("abc");
        System.out.println(str3 == str4); // false

        String s1 = "ja";
        String s2 = "va";
        String s3 = "java";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);//false
        System.out.println(s3.equals(s4));//true
    }

    //2022.8.20 上周java基础回顾
    public static void main(String[] args)
    {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
        test6();
    }

}
