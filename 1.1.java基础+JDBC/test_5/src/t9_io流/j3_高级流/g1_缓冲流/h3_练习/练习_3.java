package t9_io流.j3_高级流.g1_缓冲流.h3_练习;

import java.io.*;

public class 练习_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader("F:\\java\\cnt.txt"));
        String line=bufferedReader.readLine();
        int num=Integer.parseInt(line);
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("F:\\java\\cnt.txt"));
        switch (num){
            case 1,2,3->{
                System.out.println("欢迎使用本软件,第"+num+"次免费使用");
                bufferedWriter.write((num+1)+"");
            }
            default -> {
                System.out.println("本软件只能免费使用3次，欢迎您注册会员后继续使用！");
                bufferedWriter.write((num+1)+"");
            }
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
}
