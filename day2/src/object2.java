public class object2
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 20;
        int c = 5;
        System.out.println(sum(a, b));
        System.out.println(getmax(a, b));
        System.out.println(getmax(a, b, c));
    }

    public static int sum(int num1, int num2)
    {
        return num1 + num2;
    }

    public static int getmax(int num1, int num2)
    {
        return num1 > num2 ? num1: num2;
    }

    public static int getmax(int num1, int num2, int num3)
    {
        int num =  num1 > num2 ? num1: num2;
        return num > num3 ? num: num3;
    }
}
