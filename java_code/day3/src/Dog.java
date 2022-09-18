
//继承父类 extends 用于继承
public class Dog extends Animal
{

    @Override
    public void eat()
    {
//        super.eat();
        System.out.println(name + " 吃骨头 ");
    }
}
