package Animal_interface;

//extends 继承
public class Cat implements Animal
{

    @Override
    public void sleep()
    {
        System.out.println("在猫窝睡觉");
    }

    @Override
    public void eat()
    {
        System.out.println("吃鱼");
    }
}
