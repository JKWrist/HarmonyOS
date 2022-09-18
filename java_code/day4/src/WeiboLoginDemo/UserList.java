package WeiboLoginDemo;

import java.util.ArrayList;

public class UserList
{
    private ArrayList<User> list;

    public ArrayList<User> getList()
    {
        return list;
    }

    public void setList(ArrayList<User> list)
    {
        this.list = list;
    }

    public UserList()
    {
        list = new ArrayList<User>();
    }

    public UserList(ArrayList<User> list)
    {
        this.list = list;
    }

    //有一样的数据返回false
    public boolean check(String name)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getName().equals(name))
            {
                return false;
            }
        }
        return true;
    }
}
