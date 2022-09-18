package WeiboLoginDemo;

public class User
{
    private String name;
    private String birth;
    private int age;
    private String mail;
    private String phone_num;
    private String password;

    public User()
    {
    }
//    public User(String userName, String password, Date birthday, String phone, String email) {
//        this.userName = userName;
//        this.password = password;
//        this.birthday = birthday;
//        this.phone = phone;
//        this.email = email;
//    }

    public User(String userName)
    {
        this.name = userName;
    }

    public User(String userName, String password, String birthday, String phone, String email)
    {
        this.name = userName;
        this.password = password;
        this.birth = birthday;
        this.phone_num = phone;
        this.mail = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBirth()
    {
        return birth;
    }

    public void setBirth(String birth)
    {
        this.birth = birth;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getPhone_num()
    {
        return phone_num;
    }

    public void setPhone_num(String phone_num)
    {
        this.phone_num = phone_num;
    }
}
