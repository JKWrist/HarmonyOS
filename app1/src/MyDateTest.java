public class MyDateTest {
	public static void main(String[] args) {
		MyDate my_birth = new MyDate(20, 8, 2022); // 通过第一个构造函数new了一个叫my_birth的对象，并在参数里面赋值
		MyDate the_next_week = my_birth.addDays(7); // 这个对象调用了addDays(int more_days)的方法，赋值给the_next_week的变量
		the_next_week.print(); // 调用print()方法
	}
}