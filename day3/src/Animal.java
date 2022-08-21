import java.sql.SQLOutput;

public class Animal
{
    //属性
    public String name;
    private int age;  //动物的年龄也不可以随便问   面向对象封装

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
        System.out.println( name + " sleep ");
    }
}
