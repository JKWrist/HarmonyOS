public class Phone
{
    private String s_vender;
    public Phone(String vender)
    {
        s_vender = vender;
    }
    public void call()
    {
        System.out.println(s_vender + "call");
    }
    public void send_message()
    {
        System.out.println(s_vender + "send_message");
    }
}
