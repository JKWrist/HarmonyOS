import java.util.ArrayList;

public class ArringListTest
{
    public static void main(String[] args)
    {
        String[] userNameList = new String[5];
        userNameList[0] = "张三";
        userNameList[1] = "李四";
        for (int i = 0; i < 5; i++)
        {
            System.out.println(userNameList[i]);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}
