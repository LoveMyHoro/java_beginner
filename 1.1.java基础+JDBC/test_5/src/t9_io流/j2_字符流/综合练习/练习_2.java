package t9_io流.j2_字符流.综合练习;

import java.io.*;

public class 练习_2 {
    //利用两次异或不改变数据来加密
    public static void main(String[] args) throws IOException {
        //加密
        FileInputStream fileReader= new FileInputStream("C:\\Users\\iove\\OneDrive\\桌面\\test\\博德之门3.png");
        FileOutputStream fileWriter= new FileOutputStream("C:\\Users\\iove\\OneDrive\\桌面\\test\\jiami.png");
        int b;
        while((b=fileReader.read())!=-1){
            fileWriter.write(b^2);
        }
        fileWriter.close();
        fileReader.close();
        //解密

        FileInputStream fileReader2= new FileInputStream("C:\\Users\\iove\\OneDrive\\桌面\\test\\jiami.png");
        FileOutputStream fileWriter2= new FileOutputStream("C:\\Users\\iove\\OneDrive\\桌面\\test\\jiemi.png");
        int b2=0;
        while((b2=fileReader2.read())!=-1){
            fileWriter2.write(b2^2);
        }

        fileWriter2.close();
        fileReader2.close();

    }
}
