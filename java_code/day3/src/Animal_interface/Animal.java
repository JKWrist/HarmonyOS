package Animal_interface;

public interface Animal
{
    //Java中的接口在子类中必须重写，和C++的某种虚函数一样
    public void sleep();

    public void eat();

    //接口中默认是加abstract的
    //public abstract void eat2();
}
