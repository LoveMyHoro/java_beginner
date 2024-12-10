package test_13_JDK7时间类;

import java.util.Calendar;
import java.util.Date;

public class Api_JDK7时间Calendar {
/*
1.Calendar代表了系统当前时间的日历对象，可以单独修改或获取时间中的年，月，日
细节：Calendar是一个抽象类，不能直接创建对象。获取Calendar日历类对象方法：getInstance()
2.常用方法见图片
 */
public static void main(String[] args) {
    //（1）获取日历对象
    //底层原理：会根据不同时区获取不同的日历对象
    //且会把时间中的纪元，年，月，日，时，分，秒，星期，等等都放到一个数组中
    //注意：月份的范围是0~11,且1代表星期日
    Calendar c=Calendar.getInstance();
    System.out.println(c);

    //（2）修改日历
    Date d=new Date(0);
    c.setTime(d);
    System.out.println(c);
    //（3）获取日历信息
    //0：纪元，1：年，2：月，3：一年中的第几周，4：一月中的第几周，5：一个月中的第几天
    int year=c.get(1);
    int month=c.get(2)+1;
    int day=c.get(5);
    System.out.println(year+" "+month+" "+day);
    //也可以用索引对应的常量
    year=c.get(Calendar.YEAR);
    month=c.get(Calendar.MONTH)+1;
    day=c.get(Calendar.DAY_OF_MONTH);
    System.out.println(year+" "+month+" "+day);
    //（4）修改日历的某个字段信息
    Calendar c2=Calendar.getInstance();
    //改变年份
    c2.set(Calendar.YEAR,2003);
    year=c2.get(Calendar.YEAR);
    month=c2.get(Calendar.MONTH)+1;
    day=c2.get(Calendar.DAY_OF_MONTH);
    System.out.println(year+" "+month+" "+day);
    //（5）增加/减少字段指定的值
    c2.add(Calendar.MONTH,-1);

}
}
