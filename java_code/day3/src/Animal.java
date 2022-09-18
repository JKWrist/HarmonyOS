import java.sql.SQLOutput;

public class Animal
{
    //属性
    public String name;
    private int age;  //动物的年龄也不可以随便问   面向对象封装

    //Java叫构造方法 C++叫构造函数
    //Java叫方法重载，C++叫函数重载
    public Animal(String name)
    {
        System.out.println("有参数构造方法");
        this.name = name;
    }

    public Animal()
    {
        System.out.println("无参数构造方法");
    }

    //行为
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    //父类提出共有的方法
    public void sleep()
    {
        //快捷输入 sout
        System.out.println(name + " sleep ");
    }

    public void eat()
    {
        System.out.println(name + " eat ");
    }

    //static静态方法
    public static void run()
    {
        System.out.println(" run ");
    }

    public static String neek_name;
}
