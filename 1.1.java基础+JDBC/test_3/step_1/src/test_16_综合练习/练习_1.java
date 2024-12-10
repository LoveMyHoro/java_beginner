package test_16_综合练习;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class 练习_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum=0;
        ArrayList <Integer>list=new ArrayList<>();
        while(sum<=200){
            System.out.printf("集合数据和为"+sum+",未超过200.请继续输入数字:");
            String temp=sc.next();
            String regex="[0-9]*";
            if(!temp.matches(regex)){
                System.out.println("只能输入数字！");
                continue;
            }
            //字符串转数字
            int num=Integer.parseInt(temp);
            if(num<1||num>200){
                System.out.println("数字不符合范围，请重新输入");
                continue;
            }
            list.add(num);
            sum+=num;
        }
        System.out.println("输入结束");
        System.out.println(list);

    }
}
