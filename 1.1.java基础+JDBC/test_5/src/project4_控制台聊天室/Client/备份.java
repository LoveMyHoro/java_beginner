package project4_控制台聊天室.Client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class 备份 {
    static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("服务器已经连接成功");
        while(true){
            Socket sc=new Socket("127.0.0.1",9929);
            System.out.println("==============欢迎来到黑马聊天室================");
            System.out.println("1登录");
            System.out.println("2注册");
            System.out.println("3退出");
            System.out.println("请输入您的选择：");
            String choose=scn.next();
            if(choose.equals("1")){
                Login(sc);
            }
            else if(choose.equals("2")){
                Register(sc);
            }
            else if(choose.equals("3")){
                break;
            }
            else{
                System.out.println("无此选项，请重新输入");
            }
        }
        //sc.close();
    }

    private static void Login(Socket sc) throws IOException {
        System.out.println("请输入用户名：");
        String name=scn.next();
        System.out.println("请输入密码：");
        String password=scn.next();
        File file=new File("src\\project4_控制台聊天室\\login.txt");
        FileWriter fw=new FileWriter(file);
        fw.write("username="+name+"&password="+password);
        fw.flush();

        OutputStream os=sc.getOutputStream();
        os.write("1".getBytes(StandardCharsets.UTF_8));
        os.flush();
        sc.shutdownOutput();
        System.out.println("已发送至服务端");
        InputStream is=sc.getInputStream();
        InputStreamReader isr=new InputStreamReader(is);
        String message="";
        int b;
        while((b=isr.read())!=-1){
            message+=(char)b;
        }
        if(message.equals("登陆成功,请开始发送信息")){
            System.out.println(message);
            Chat(sc);
        }
        else{
            System.out.println(message);
        }
    }

    private static void Chat(Socket sc) throws IOException {
        while(true){
            System.out.println("请输入要发送的信息：");
            String message=scn.next();

            OutputStream os=sc.getOutputStream();
            os.write("你好呀".getBytes(StandardCharsets.UTF_8));
            os.flush();
        }
    }

    private static void Register(Socket sc) {
    }
}
