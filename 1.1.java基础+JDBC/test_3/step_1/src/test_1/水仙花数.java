package test_1;
import java.util.Scanner;
public class 水仙花数 {
    public static void main(String args[]){
        System.out.println("请输入一个数字：");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int cnt=0,sum=0,temp=n;
        while(temp!=0){
            temp/=10;
            cnt++;
        }
        temp=n;
        while(temp!=0){
            int temp2=temp%10;
            sum+= Math.pow(temp2,cnt);
            temp/=10;
        }
        if(sum==n){
            System.out.println("是");
        }
        else{
            System.out.println("不是");
        }

    }
}
