package project4_控制台聊天室.Client;

import cn.hutool.core.collection.SpliteratorUtil;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;



public class Client {
    static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Socket sc=new Socket("127.0.0.1",9999);
        System.out.println("服务器已经连接成功");
        while (true) {
            System.out.println("==============欢迎来到黑马聊天室================");
            System.out.println("1登录");
            System.out.println("2注册");
            System.out.println("请输入您的选择：");
            String choose=scn.next();
            switch (choose){
                case "1"->{
                    System.out.println("登录");
                    Login(sc);
                }
                case "2"->{
                    System.out.println("注册");
                    Register();
                }
                default -> {
                    System.out.println("无此选项，请重新输入");
                }
            }
        }


    }

    private static void Register() throws IOException {
        System.out.println("请输入用户名");
        String username=scn.next();
        System.out.println("请输入密码");
        String password=scn.next();
        StringBuilder sb=new StringBuilder();
        sb.append(username).append("=").append(password);
        BufferedWriter bw=new BufferedWriter(new FileWriter("src\\project4_控制台聊天室\\user.properties",true));
        bw.newLine();
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();

    }

    private static void Login(Socket sc) throws IOException {
        //向服务端发送选择
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
        bw.write("1");
        bw.newLine();
        bw.flush();
        //像服务端发送账号信息
        System.out.println("请输入用户名：");
        String username=scn.next();
        System.out.println("请输入密码");
        String password=scn.next();
        StringBuilder sb=new StringBuilder();
        sb.append("username=").append(username).append("&password=").append(password);

        bw.write(sb.toString());
        bw.newLine();
        bw.flush();

        //接收服务端反馈
        BufferedReader br=new BufferedReader(new InputStreamReader(sc.getInputStream()));
        String message=br.readLine();

        switch (message){
            case "1"->{
                System.out.println("登陆成功");
                new MyThread(sc).start();
                Chat(sc);
            }
            case "2"->{
                System.out.println("密码有误");
            }
            case "3"->{
                System.out.println("用户不存在");
            }
        }


    }
    private  static void Chat(Socket sc) throws IOException {
        while(true){
            System.out.println("请输入您要说的话");
            String message=scn.next();
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
            bw.write(message);
            bw.newLine();
            bw.flush();
        }
    }
}
