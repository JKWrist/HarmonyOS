public class Test_Person
{
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.weight = 80;
        p1.height = 180;
        p1.sex = "man";
        p1.setUser_name("小白");
        p1.call_phone();
        p1.getUser_name();
    }
}
