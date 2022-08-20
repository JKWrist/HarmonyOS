public class Person
{
    public String user_name;
    public int weight;
    public int height;
    public String sex;

    public void sleep()
    {
        System.out.println("sleep");
    }

    public void call_phone()
    {
        System.out.println("call_phone");
    }
    public String getUser_name()
    {
        System.out.println(user_name);
        return user_name;
    }
    public void setUser_name(String name)
    {
        user_name = name;
    }
}
