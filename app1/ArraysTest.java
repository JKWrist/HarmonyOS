public class ArraysTest {
	public static void main(String[] args)
	{
		test_array();
		print_matrix();
	}

	public static void test_array()
	{
		// 第1，2步: 声明并初始化数组变量
		int[] array1 = { 2, 3, 5, 7, 11, 13, 17, 19 };
		int[] array2;

		// 第3步: 显示数组初始化值
		System.out.print("array1 is ");
		printArray(array1);
		System.out.println();
		// 第4步: array2引用array1
		array2 = array1;
		// 更改array2
		array2[0] = 0;
		array2[2] = 2;
		array2[4] = 4;
		array2[6] = 6;
		// 打印array1
		System.out.print("array1 is ");
		printArray(array1);
		System.out.println();
	}

	public static void print_matrix()
	{
		// 第5步: 声明一个整数类型的二维数组
		int[][] matrix = new int[5][];
		// 第6步: 将这个矩阵构成三角形
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[i];
			for (int j = 0; j < i; j++) {
				matrix[i][j] = i * j;
			}
		}
		// 第7步打印矩阵
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("matrix[" + i + "] is ");
			printArray(matrix[i]);
			System.out.println();
		}
	}
	public static void printArray(int[] array) {
		System.out.print('<');
		for (int i = 0; i < array.length; i++) {
			// 打印一个元素
			System.out.print(array[i]);
			// 输出最后一个元素的时候不输出逗号
			if ((i + 1) < array.length) {
				System.out.print(", ");
			}
		}
		System.out.print('>');
	}
}