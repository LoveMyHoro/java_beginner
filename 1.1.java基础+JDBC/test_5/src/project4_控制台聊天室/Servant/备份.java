package project4_控制台聊天室.Servant;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class 备份 extends Thread{
    static ArrayList<Socket>list=new ArrayList<>();
    private Socket socket;
    public 备份(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        Socket sc=null;
        try {
            while(true){
                sc=socket;
                String choose="";
                InputStream is=sc.getInputStream();
                int b=0;
                while((b=is.read())!=-1){
                    choose+=(char)b;
                    System.out.println(b);
                }
                if(choose.equals("1")){
                    System.out.println("登录");
                    Login(sc);
                }
                else if(choose.equals("3")){
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                sc.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

     private void Login(Socket sc) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src\\project4_控制台聊天室\\login.txt"));
        String []arr=br.readLine().split("&");
        String name=arr[0].split("=")[1],password=arr[1].split("=")[1];
        br.close();


        Properties prop=new Properties();
        BufferedReader br2=new BufferedReader(new FileReader("src\\project4_控制台聊天室\\user.properties"));
        prop.load(br2);
        Set<Object>keys=prop.keySet();

        String message="";
        int cnt=0;
        for (Object key : keys) {
            System.out.println(prop.get(key));
            if(name.equals(key)){
                if(password.equals(prop.get(key))){
                    message="登陆成功,请开始发送信息";
                    cnt=1;
                    OutputStream os=sc.getOutputStream();
                    os.write("登陆成功,请开始发送信息".getBytes(StandardCharsets.UTF_8));
                    os.flush();
                    sc.shutdownOutput();
                    Chat();
                    return;
                }
                else{
                    message="密码错误，请重新输入";
                    cnt=-1;
                }
            }
        }

        if(cnt==0){
            message="用户不存在，请重新输入";
        }
        OutputStream os=sc.getOutputStream();
        os.write(message.getBytes(StandardCharsets.UTF_8));
        os.flush();
        sc.shutdownOutput();

    }
    private void Chat() throws IOException {
        while(true){
            Socket sc=this.socket;
            InputStreamReader isr=new InputStreamReader(sc.getInputStream());
            int b=0;
            String message="";
            while((b=isr.read())!=-1){
                message+=(char)b;
            }
            for (Socket socket1 : list) {

            }
        }

    }
}
