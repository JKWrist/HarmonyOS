package Animal_abstract;

//继承类，实现方法
public class Dog extends Animal implements DogAnimal
{

    @Override
    public void eat()
    {
        System.out.println("吃骨头");
    }

    @Override
    public void walk()
    {
        System.out.println("狂奔");
    }
}
