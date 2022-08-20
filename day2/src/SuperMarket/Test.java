package SuperMarket;
import java.util.Scanner;
public class Test
{
    public static void main(String[] args)
    {
        Person p1 = new Person();
        SuperMarket s1 = new SuperMarket();
        s1.setName("天虹超市");
        Goods [] goods = new Goods[5];
        for (int j = 0; j < 5; j++)
        {
            goods[j] = new Goods();
            System.out.println(goods[j].getName());
        }
        goods[0].setName("手机");
        goods[1].setName("电脑");
        goods[2].setName("电视");
        goods[3].setName("冰箱");
        goods[4].setName("洗衣机");
        s1.setGoods(goods);

        System.out.println("-------- 欢迎来到超市购物 ----------");

        while(true)
        {
            System.out.println("-------- 请输入购物人员 ----------");
            Scanner scan = new Scanner(System.in);
            p1.setName(scan.next());

            System.out.println("-------- 请输入购买商品 ----------");
            scan = new Scanner(System.in);
            String str1 = scan.next();
            int buy_num = -1;
            for (int i = 0; i < 5; i++)
            {
                if(str1.equals(s1.goods[i].getName()))
                {
                    buy_num = i;
                }
            }
            if (buy_num != -1)
            {
                System.out.println(p1.getName() + " 在 " + s1.getName() + " 购买了 " + str1);
            }
            else
            {
                System.out.println("超市没有此商品");
            }
        }

    }
}
