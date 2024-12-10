package test_16_综合练习;

import java.util.Calendar;
import java.util.Date;

public class 练习_4_计算活了多少天_jdk7 {
    public static void main(String[] args) {
        Calendar birth=Calendar.getInstance();
        Calendar now=Calendar.getInstance();
        birth.set(2003,7,26);//因为月份的下标是从0开始的
        long start=birth.getTimeInMillis();
        long end=now.getTimeInMillis();
        System.out.println(now);
        long day=(end-start)/(1000*60*60*24);
        System.out.println(day);

    }
}
