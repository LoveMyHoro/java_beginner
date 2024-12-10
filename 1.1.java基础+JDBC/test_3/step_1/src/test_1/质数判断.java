package test_1;
import java.util.Scanner;

public class 质数判断 {
    public static void main(String args[]){
        System.out.println("请输入一个数字：");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=2;i<= Math.sqrt(n);i++){
            if(n%i==0){
                System.out.println(n+"不是质数");
                return;
            }
        }
        System.out.println("是质数");

    }

}
