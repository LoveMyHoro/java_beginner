package project4_控制台聊天室.Servant;

import javax.print.attribute.standard.Severity;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class servant {
    static ArrayList<Socket>list=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(9999);
        System.out.println("服务器启动");

        Properties prop=new Properties();
        prop.load(new FileReader("src\\project4_控制台聊天室\\user.properties"));

        while(true){
            Socket socket=ss.accept();
            System.out.println("连接成功");
            new SeThread(socket,prop).start();
        }

    }

}
class SeThread extends Thread{
    private Socket socket;
    private Properties prop;
    public SeThread(Socket socket, Properties prop) {
        this.socket=socket;
        this.prop=prop;
    }

    @Override
    public void run() {
        try {
            Socket sc=this.socket;
            BufferedReader br=new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String choose=br.readLine();
            System.out.println(choose);
            switch (choose){
                case "1"->{
                    System.out.println("服务端登录");
                    Login(sc);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void Login(Socket sc) throws IOException {
        //接收客户端用户信息
        BufferedReader br=new BufferedReader(new InputStreamReader(sc.getInputStream()));
        String userinfo=br.readLine();

        System.out.println(userinfo);
        //进行判断
        String []arr=userinfo.split("&");
        String name=arr[0].split("=")[1];
        String password=arr[1].split("=")[1];
        System.out.println(name+","+password);
        //1代表登陆成功，2代表密码错误，3代表用户不存在

        //导入用户信息
        Properties prop=new Properties();
        prop.load(new FileReader("src\\project4_控制台聊天室\\user.properties"));
        if(prop.containsKey(name)){
            if(password.equals(prop.get(name))){
                System.out.println("登陆成功");
                servant.list.add(sc);
                WriteBack("1",sc);
                Chat(sc,name);
            }
            else{
                WriteBack("2",sc);
            }
        }
        else{
            WriteBack("3",sc);
        }







    }

    private void Chat(Socket sc,String name) throws IOException {
        while(true){
            BufferedReader br=new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String message=br.readLine();
            message=name+"说了："+message;
            WriteToAll(message);
        }
    }

    private void WriteToAll(String message) throws IOException {
        for (Socket sc : servant.list) {
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
            bw.write(message);
            bw.newLine();
            bw.flush();
        }
    }

    private void WriteBack(String message,Socket sc) throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
        bw.write(message);
        bw.newLine();
        bw.flush();
    }

}
