public class object1 {
    public static void main(String[] args)
    {
        addSum(10, 12);
        print_odd(10, 20);
    }

    public static void addSum(int num1, int num2)
    {
//        int num1 = 18;
//        int num2 = 19;
        System.out.println(num1 + num2);
    }

    public static void print_odd(int num1, int num2)
    {
        for (int i = num1; i <= num2; i++)
        {
            if(1 == i % 2)
            {
                System.out.println(i);
            }
        }
    }
}
