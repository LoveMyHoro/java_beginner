package t9_io流.j6_综合练习.练习_3_随机点名器;

import java.io.*;
import java.util.Random;

public class 练习_3 {
    public static void main(String[] args) throws IOException {
        //地址：F:\java\ClassName.txt
        //男生：30，女生：30;
        File file=new File("F:\\java\\ClassName.txt");
        int number=GetNumber(file);
        String ForName="左冰蕊";
        for(int i=1;i<=10;i++){
            String name=GetName(file,number);
            if(i==3){
                while(true){
                    if(!name.equals(ForName)){
                        name=GetName(file,number);
                        continue;
                    }
                    break;
                }
            }
            System.out.println("第"+i+"次点到名字的是"+name);
        }

    }

    private static String GetName(File file,int Number) throws IOException {
        Random r=new Random();
        int NameNumber=r.nextInt(1,Number+1);
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
