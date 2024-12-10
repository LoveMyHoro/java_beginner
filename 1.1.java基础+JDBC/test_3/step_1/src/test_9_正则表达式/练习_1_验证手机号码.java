package test_9_正则表达式;

import java.sql.SQLOutput;
import java.util.Scanner;

public class 练习_1_验证手机号码 {
    public static void main(String[] args) {
        System.out.println("请输入手机号码：");
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String regex1="1[3-9]\\d{9}";//正则表达式
        while(true){
            if(s.matches(regex1)==false){
                System.out.println("格式不正确！请重新输入");
        }
            else{
                System.out.println("输入成功！");
                break;
            }
            System.out.println("请输入手机号码：");
            s=sc.next();
        }
    }
}
