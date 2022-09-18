import java.util.HashSet;
import java.util.Set;

public class SetExample
{
    public static void main(String[] args)
    {
        Set set = new HashSet(); // HashSet是Set的子接口
        set.add("one");
        set.add("second");
        set.add("3rd");
        set.add(new Integer(4));
        set.add(new Float(5.0F));
        set.add("second");
        set.add(new Integer(4));
        System.out.println(set);
    }
}