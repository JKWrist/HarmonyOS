import java.util.Arrays;

public class ArraysTest2
{
    private int[] ar;

    public ArraysTest2(int numValues)
    {
        ar = new int[numValues];
        for (int i = 0; i < ar.length; i++)
        {
            ar[i] = (1000 - (300 + i));
        }
    }

    public static void main(String[] args)
    {
        ArraysTest2 tester = new ArraysTest2(50);
        int[] myArray = tester.get();
        // 比较两个数组
        int[] myOtherArray = tester.get().clone();
        if (Arrays.equals(myArray, myOtherArray))
        {
            System.out.println("这两个数组是相等的!");
        } else
        {
            System.out.println("这两个数组是不相等的!");
        }
        // 填上一些值
        Arrays.fill(myOtherArray, 2, 10, new Double(Math.PI).intValue());
        myArray[30] = 98;
        // 打印数组
        System.out.println("这是一个未排序的数组...");
        System.out.println(Arrays.toString(myArray));
        System.out.println();
        // 数组排序
        Arrays.sort(myArray);
        // 打印被排序的数组 用toString()
        System.out.println("这是一个被排序的数组...");
        System.out.println(Arrays.toString(myArray));
        System.out.println();

        // 得到特殊值的索引
        int index = Arrays.binarySearch(myArray, 98);
        System.out.println("98 被定位在第 " + index + "个位置上");

        String[][] ticTacToe = {{"X", "O", "O"},
                {"O", "X", "X"},
                {"X", "O", "X"}};

        // 用deepToString打印数组()
        System.out.println(Arrays.deepToString(ticTacToe));
        String[][] ticTacToe2 = {{"O", "O", "X"},
                {"O", "X", "X"},
                {"X", "O", "X"}};

        String[][] ticTacToe3 = {{"X", "O", "O"},
                {"O", "X", "X"},
                {"X", "O", "X"}};

        if (Arrays.deepEquals(ticTacToe, ticTacToe2))
        {
            System.out.println("Boards 1 和 2 相等.");
        } else
        {
            System.out.println("Boards 1 和 2 不相等.");
        }

        if (Arrays.deepEquals(ticTacToe, ticTacToe3))
        {
            System.out.println("Boards 1 和 3 are 相等.");
        } else
        {
            System.out.println("Boards 1 和 3 are 不相等.");
        }
    }

    public int[] get()
    {
        return ar;
    }
}
