package Animal_abstract;

//public class Animal
//抽象类
public abstract class Animal
{
    //抽象类中可以写普通的方法，普通类中不能写抽象方法
    public void sleep()
    {
        System.out.println("睡觉");
    }

    //抽象方法，逻辑不实现，逻辑由继承者自己操作
    //abstract 抽象
    public abstract void eat();

}
