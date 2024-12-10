package test_16_综合练习;

import java.util.Scanner;

public class 练习_2_字符串转数字 {
    public static void main(String[] args) {
        //校验字符串要用字符串
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一串数字：");
        String s1=sc.next();
        String regex="[^0](\\d{1,9})";
        while(true){
            if(!s1.matches(regex)){
                System.out.println("输入有误！请重新输入：");
                s1=sc.next();
            }
            else{
                break;
            }
        }
        int num=0;
        for(int i=0;i<s1.length();i++){
            int temp=s1.charAt(i);
            num=num*10+(temp-'0');
        }
        System.out.println(num);

    }
}
