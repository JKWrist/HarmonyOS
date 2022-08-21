package Transportation;

// 快递类
public class Express
{
    private String expressNumber; // 快递单号
    private double goodsWeight; // 货物重量

    public String getExpressNumber()
    {
        return expressNumber;
    }

    public void setExpressNumber(String number)
    {
        this.expressNumber = expressNumber;
    }

    public double getGoodsWeight()
    {
        return goodsWeight;
    }

    public void setGoodsWeight(double goodsWeight)
    {
        this.goodsWeight = goodsWeight;
    }

    public Express(String expressNumber, double goodsWeight)
    {
        this.expressNumber = expressNumber;
        this.goodsWeight = goodsWeight;
    }

    // 送货准备
    public void sendBefore()
    {
        System.out.println("---------订单开始处理，仓库准备出货---------");
        System.out.println("货物重量：" + this.getGoodsWeight() + "kg");
        System.out.println("货物检验完毕!");
        System.out.println("货物装车完毕!");
        System.out.println("运货人已通知!");
        System.out.println("快递单号：" + this.getExpressNumber());
    }

    // 送货途中
    public void sending(Truck t)
    {
        System.out.println(t.getTransporter()
                + "正在驾驶编号为" + t.getNumber()
                + "的" + t.getModel() + "运输货物！");
        t.transport();
        t.getPosition();
    }

    // 货车保养
    public void sendAfter(Truck t)
    {
        System.out.println("货物运输任务已完成！");
        System.out.println(t.getTransporter()
                + "所驾驶的编号为" + t.getNumber()
                + "的" + t.getModel() + "已归还！");
    }
}

