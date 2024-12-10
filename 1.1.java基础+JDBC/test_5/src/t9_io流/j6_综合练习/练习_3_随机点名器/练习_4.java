package t9_io流.j6_综合练习.练习_3_随机点名器;

import java.io.*;
import java.util.*;

public class 练习_4 {
    public static void main(String[] args) throws IOException {
        //地址：F:\java\ClassName.txt
        //男生：30，女生：30;
        File file=new File("F:\\java\\ClassName.txt");
        int number=GetNumber(file);
        for(int i=0;i<2;i++){
            LoopRead(file,number);
        }

    }

    private static void LoopRead(File file, int number) throws IOException {
        ArrayList<Integer>list=new ArrayList<>();
        Random r=new Random();
        while(list.size()!=number){
            int NameNumber=r.nextInt(1,number+1);
            if(!list.contains(NameNumber)){
                String name=GetName(file,NameNumber);
                System.out.println("点名的是："+name+",第"+NameNumber+"行");
                list.add(NameNumber);
            }
        }
        System.out.println(list);

    }

    private static String GetName(File file,int NameNumber) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String s;
        int temp=0;
        while((s=br.readLine())!=null){
            temp++;
            if(temp==NameNumber){
                return s.split("-")[0];
            }
        }
        br.close();
        return null;
    }

    private static int GetNumber(File file) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String s;
        int number=0;
        while((s=br.readLine())!=null){
            number++;
        }
        br.close();
        return number;
    }
}
