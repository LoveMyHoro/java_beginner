package test_16_综合练习;

import java.sql.SQLOutput;
import java.util.Scanner;

public class 练习_3_字符串整数转二进制 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s1=sc.next();
        String regret="[0-9]*";
        while(true){
            if(!s1.matches(regret)){
                System.out.println("输入有误，请重新输入！");
                s1=sc.next();
            }
            else{
                break;
            }
        }
        int num=Integer.parseInt(s1);
        while(num>0){
            int temp=num%2;
            num/=2;
            sb.insert(0,temp);//0代表插入头部
        }
        String s2=sb.toString();
        System.out.println(s2);
    }
}
