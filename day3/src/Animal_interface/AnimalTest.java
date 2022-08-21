package Animal_interface;

public class AnimalTest
{
    public static void main(String[] args)
    {
        Cat cat1 = new Cat();
        cat1.eat();
        cat1.sleep();

        Dog dog1 = new Dog();
        dog1.eat();
        dog1.sleep();
    }
}
