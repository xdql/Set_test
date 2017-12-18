import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/**
 * Created by ql on 2017/12/18.
 * 使用集合实现注册登陆功能，

 第一步： 提示用户选择功能， A（注册）  B(登陆) 。 要求： 功能选择 的时候要忽略大小写。

 注册：
 1. 提示用户输入注册的账号(数字)与密码，如果输入账号已经存在集合中，提示用户重新输入。 注册完毕之后，把集合中的所有用户信息打印出来。(使用：toArrry()方法)
 登陆：
 提示用户输入登陆的账号与密码,如果账号与密码这个用户已经存在集合中，那么登陆成功，否则登陆失败。
 */
public class Demo2
{
    static Scanner scanner=new Scanner(System.in);
    static List list=new ArrayList();


    public static void main(String args[]) {
        System.out.println("请输入你要做的操作：A(注册),B(登录)");
        String in = scanner.next();
        while(true) {
            if (in.equalsIgnoreCase("A")) {
                //执行注册的功能
                System.out.println("您选择的是注册功能");
                reg();
            } else if (in.equalsIgnoreCase("B")) {
                //User user=null;
                System.out.println("您选择的是登录功能");
                login();
            }
        }
    }
    public static void login()
    {
        while(true) {
            System.out.println("请输入你的账号：");
            int id = scanner.nextInt();
            System.out.println("请输入密码");
            String password = scanner.next();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                User user = (User) iterator.next();
                if (user.id == id && user.password == password) {
                    System.out.println("登录成功，欢迎");
                    break;
                } else {
                    System.out.println("用户或密码错误，请重新输入");
                }
            }
        }
    }

    public static void reg()
    {
        User user=null;
        while(true) {
            System.out.println("请输入用户名：");
            int id = scanner.nextInt();
            user = new User(id, null);
            if (list.contains(id)) {
                System.out.println("已经存在，请重新输入");
            } else {
                break;
            }
        }
        System.out.println("您选择的是密码(数字)");
        String password = scanner.next();
        user.setPassword(password);
        list.add(user);
        System.out.println("注册成功");
        System.out.println("当前已经注册的有："+list);
    }
}


class User
{
    String password;
    int id;
    public  User(int id,String password)
    {
        this.id=id;
        this.password=password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{账号是："+id+"密码是："+password;
    }
}
