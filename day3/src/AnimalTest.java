public class AnimalTest
{
    //快捷输入 main
    public static void main(String[] args)
    {
        Animal sheep = new Animal();
        sheep.setName("懒羊羊");
        sheep.sleep();

        //私有的只能内部使用
//        sheep.age = 18;
        Animal.neek_name = "小黑";
        Animal.run();
    }
}
