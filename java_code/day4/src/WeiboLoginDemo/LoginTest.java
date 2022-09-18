package WeiboLoginDemo;
/*
需求:
        ----微博注册页面--
        请输入姓名：Annie
        请输入密码：123456
        请再次输入密码：123456
        请输入手机号码：18018276532
        请输入出生日期yyyy-mm-dd：1999-02-25
        请输入电子邮箱：Annie@163.com
        Annie恭喜你，注册成功！

需求分析:
        创建类其实本质上来说属于模块划分
        此需求需要创建的类
         1、用户类
         2、数组类   -》选择什么样的数据结构进行存储
         3、测试类
*/

import java.util.Scanner;

public class LoginTest
{
    public static void main(String[] args)
    {
        UserList list = new UserList();
        Scanner scan = new Scanner(System.in);

        int inputNum = 3;
        while(0 != inputNum--)
        {
            String name = scan.nextLine();
            User user = new User(name);
            list.getList().add(user);
        }

        while (true)
        {
            String name = scan.nextLine();
            if(list.check(name))
            {
                User user = new User(name);
                //可以注册新用户
                list.getList().add(user);
                System.out.println("可以注册新用户");
            }
            else
            {
                System.out.println("arraylist中已有，不可以注册新用户");
            }
        }
    }
}
