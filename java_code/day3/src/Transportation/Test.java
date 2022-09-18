package Transportation;

public class Test
{
    public static void main(String[] args)
    {
        // 快递任务类对象
        Express express = new Express("202202180293838", 80);
        express.sendBefore();// 送货准备方法
        System.out.println("----------------------------------------");

        // 创建交通工具对象
        Truck t = new Truck("J1186", "货车", "村长");
        express.sending(t);
        System.out.println("----------------------------------------");

        // 调用送货后方法
        express.sendAfter(t);

        // 通过内部类的形式实现汽车保养接口
        Tool tool = new Tool()
        {
            @Override
            public void maintenance()
            {
                System.out.println("货物运输车辆保养完毕!");
            }
        };
        tool.maintenance();
        System.out.println("----------------------------------------");
    }
}

