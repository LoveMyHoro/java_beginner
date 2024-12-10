package test_16_综合练习;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

public class 练习_6_判断平年闰年 {
    public static void main(String[] args) {
        //以2000年为例
        //方法1：把时间设置为2000年3月1日,减一天判断二月有多少天
        //（1）jdk7_Calendar
        Calendar c=Calendar.getInstance();
        c.set(2000,2,1);//因为jdk7的Calendar月份下标从0开始
        c.add(Calendar.DAY_OF_MONTH,-1);
        int day1=c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day1==29);
        //（2）jdk_8_LocalDate
        LocalDate l1=LocalDate.of(2000,3,1);
        LocalDate l2=l1.minusDays(1);//修改后产生新的对象
        int day2=l2.getDayOfMonth();
        System.out.println(day2==29);

        //方法2：直接使用jdk8的方法判断
        System.out.println(l2.isLeapYear());


    }
}
