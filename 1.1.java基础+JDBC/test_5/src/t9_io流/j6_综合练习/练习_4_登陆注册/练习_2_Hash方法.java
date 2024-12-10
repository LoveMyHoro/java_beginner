package t9_io流.j6_综合练习.练习_4_登陆注册;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class 练习_2_Hash方法 {
    public static void main(String[] args) throws IOException {
        File file=new File("F:\\java\\userinfo.txt");
        BufferedReader br=new BufferedReader(new FileReader(file));
        String line;
        HashMap<String,String>usermap=new HashMap<String, String>();
        HashMap<String,Integer>countmap=new HashMap<>();
        while((line=br.readLine())!=null){
            String []userinfo=line.split("&");
            String name=userinfo[0].split("=")[1];
            String password=userinfo[1].split("=")[1];
            String count=userinfo[2].split("=")[1];
            usermap.put(name,password);
            countmap.put(name,Integer.parseInt(count));
        }
        br.close();
        System.out.println("请输入用户名：");
        Scanner sc=new Scanner(System.in);
        String username=sc.next();
        System.out.println("请输入密码：");
        String password=sc.next();
        String user=username+password;
        if(usermap.containsKey(username)){
            if(countmap.get(username)>=3){
                System.out.println("输入失败超过三次，账户已被锁定");
            }
            else{
                if(usermap.get(username)==password){
                    System.out.println("登录成功！");
                }
                else{
                    System.out.println("密码有误，输入失败");
                    countmap.put(username,countmap.get(username)+1);
                }
            }
        }
        System.out.println(countmap);
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        usermap.forEach((key,value)->{

        });

    }
}
