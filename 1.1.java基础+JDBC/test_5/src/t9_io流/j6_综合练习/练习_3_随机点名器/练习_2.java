package t9_io流.j6_综合练习.练习_3_随机点名器;

import java.io.*;
import java.util.Random;

public class 练习_2 {
    public static void main(String[] args) throws IOException {
        //地址：F:\java\ClassName.txt
        //男生：30，女生：30;
        File file=new File("F:\\java\\ClassName.txt");
        int number=GetNumber(file);
        double ManNumber=0,WomenNumber=0,sum=0;
        for(int i=0;i<1000000;i++){
            String name=GetGender(file,number);
            if(name.split("-")[1].equals("男")){
                ManNumber++;
            }
            else {
                WomenNumber++;
            }
            sum++;
        }
        System.out.println("男生占比:"+ManNumber);
        System.out.println("女生占比:"+WomenNumber);


    }

    private static String GetGender(File file, int number) throws IOException {
        Random r=new Random();
        double gender=r.nextDouble();
        System.out.println("性别："+gender);
        if(gender<=0.7){
            while(true){
                String name=GetName(file,number);
                if(name.split("-")[1].equals("女")){
                    return name;
                }
            }
        }
        else{
            while(true){
                String name=GetName(file,number);
                if(name.split("-")[1].equals("男")){
                    return name;
                }
            }
        }
    }

    private static String GetName(File file,int Number) throws IOException {
        Random r=new Random();
        int NameNumber=r.nextInt(1,Number+1);
        System.out.println("学生行数:"+NameNumber);
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String s;
        int temp=0;
        while((s=br.readLine())!=null){
            temp++;
            if(temp==NameNumber){
                return s;
            }
        }
        br.close();
        return null;
    }

    private static int GetNumber(File file) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        int number=0;
        while(br.readLine()!=null){
            number++;
        }
        br.close();
        return number;
    }
}
