package t11_网络编程.w3_综合练习;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class MyThread extends Thread{
    Socket socket;
    public MyThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            BufferedInputStream bis=new BufferedInputStream(socket.getInputStream());
            //利用UUID生成文件名
            String name= UUID.randomUUID().toString().replace("-","");
            File file=new File("F:\\copy\\"+name+".png");
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file));
            int len;
            byte []bytes=new byte[1024];
            while((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            bos.flush();

            OutputStream os=socket.getOutputStream();
            os.write("上传成功".getBytes(StandardCharsets.UTF_8));


            os.close();
            bis.close();
            bos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
