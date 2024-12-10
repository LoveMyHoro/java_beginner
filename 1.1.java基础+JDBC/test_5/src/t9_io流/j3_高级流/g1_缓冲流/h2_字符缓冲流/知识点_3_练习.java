package t9_io流.j3_高级流.g1_缓冲流.h2_字符缓冲流;

import java.io.*;

public class 知识点_3_练习 {
    public static void main(String[] args) throws IOException {
        //1.读入
        BufferedReader br=new BufferedReader(new FileReader("F:\\java\\a.txt"));
        String len;
        while((len=br.readLine())!=null){
            System.out.println(len);
        }
        br.close();
        //2.写出
        BufferedWriter bw=new BufferedWriter(new FileWriter("F:\\java\\a.txt",true));
        bw.newLine();
        bw.write("元神");
        bw.newLine();
        bw.write("启动！");
        bw.close();
    }
}
