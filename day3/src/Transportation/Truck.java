package Transportation;

// 交通货车类
public class Truck extends GPS
{
    private String number;    // 车辆编号
    private String model;    // 车辆型号
    private String transporter; // 运货人

    public Truck(String number, String model, String transporter)
    {
        this.number = number;
        this.model = model;
        this.transporter = transporter;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getNumber()
    {
        return number;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getModel()
    {
        return model;
    }

    public void setTransporter(String transporter)
    {
        this.transporter = transporter;
    }

    public String getTransporter()
    {
        return transporter;
    }

    // 运输方法
    public void transport()
    {
        System.out.println("货物正在运输......");
    }

    @Override
    public String getPosition()
    {
        String position = "北京";
        System.out.println("货物当前位置是：" + position);
        return position;
    }
}
