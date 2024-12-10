package test_13_JDK7时间类;

import java.util.Date;
import java.util.Random;

public class Api_JDK7时间Date {
    //1.（1）过去世界标准时间：格林威治时间（GMT）
    //  （2）现在用原子钟的震动频率计算标准时间（UTC）
    //  （3）中国在东八区，世界标准时间+8
    //2.Date是java中的时间类（从计算机的时间原点开始计算）
    //  （1）无参构造创建对象时：默认表示系统当前时间
    //  （2）有参构造创建对象时：默认指定时间(时间原点+参数)
    //3.Date的方法
    //   （1）getTime()获取时间
    //   （2）setTime()设置时间
    public static void main(String[] args) {
        //4.Date的使用
        //需求1：打印时间原点一年后的时间
        test1();
        //需求2：比较两个时间对象哪个在前，哪个在后
        test2();


    }
    public static void test1() {
        Date d1=new Date();
        d1.setTime(12345999);
        System.out.println(d1);
        Date d2=new Date(0L);//参数是long类型，传入0表示从时间原点开始经过0秒的时间，就是时间原点（东八区要+8）
        System.out.println(d2);
        //getTime()获取时间
        Date d3=new Date(1000);
        long t1=d3.getTime();
        System.out.println(t1);
        //4.需求练习
        //需求1：打印时间原点开始一年后的时间
        Date d4=new Date(1000000000L);//时间原点
        long t2=d4.getTime();
        t2=t2+1000L*60*60*24*365;//1000L表示long类型，防止计算数值超过int.1000ms=1s
        d4.setTime(t2);
        System.out.println(d4);
        System.out.println("------------------------");
    }
    public static void test2() {
        Random r=new Random();
        Date d1=new Date(Math.abs(r.nextInt()));
        Date d2=new Date(Math.abs(r.nextInt()));
        System.out.println(d1);
        System.out.println(d2);
        long t1=d1.getTime();
        long t2=d2.getTime();
        System.out.println(t1>t2);
    }


}
