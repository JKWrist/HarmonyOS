public class ToolsHuawei implements Tools
{

    @Override
    public void mouse() {
        System.out.println("接入usb");
    }

    public static void main(String[] args) {
        ToolsHuawei h1 = new ToolsHuawei();
        h1.mouse();
    }
}
