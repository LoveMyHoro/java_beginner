package t9_io流.j6_综合练习.练习_4_登陆注册;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 练习_2_User对象方法 {
    public static void main(String[] args) throws IOException {
        File file=new File("F:\\java\\userinfo.txt");
        BufferedReader br=new BufferedReader(new FileReader(file));
        ArrayList<User>list=new ArrayList<>();
        String line;
        while((line=br.readLine())!=null){
            String []userinfo=line.split("&");
            String name=userinfo[0].split("=")[1];
            String password=userinfo[1].split("=")[1];
            String count=userinfo[2].split("=")[1];
            User user=new User(name,password,Integer.parseInt(count));
            list.add(user);
        }
        br.close();
        System.out.println("请输入用户名：");
        Scanner sc=new Scanner(System.in);
        String username=sc.next();
        System.out.println("请输入密码：");
        String password=sc.next();

        for (User user : list) {
            if(user.getUsername().equals(username)){
                if(user.getCount()==3){
                    System.out.println("密码输错三次，账户已被锁定！");
                }
                else{
                    if(user.getPassword().equals(password)){
                        System.out.println("登录成功！");
                        user.setCount(0);
                        break;
                    }
                    else{
                        System.out.println("密码错误，登录失败！");
                        user.setCount(user.getCount()+1);
                        break;
                    }
                }
            }
        }
        System.out.println(list);
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        for (User user : list) {
            bw.write(user.toString());
            bw.newLine();
        }
        bw.close();

    }
}
