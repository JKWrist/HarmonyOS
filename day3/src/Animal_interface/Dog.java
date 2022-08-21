package Animal_interface;

public class Dog implements Animal
{
    @Override
    public void sleep()
    {
        System.out.println("在狗窝睡觉");
    }

    @Override
    public void eat()
    {
        System.out.println("吃骨头");
    }
}
