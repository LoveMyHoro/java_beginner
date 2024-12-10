package test_13_JDK7时间类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Api_JDK7时间SimpleDateFormat {
    //1.作用：（1）格式化：把时间变成我们喜欢的格式
    //       （2）把字符串表示的时间变成Date对象
    //2.构造方法：（1）SimpleDateFormat()：构建一个SimpleDateFormat，空参表示使用默认格式
    //          （2）SimpleDateFormat(String pattern)构建一个SimpleDateFormat，使用指定格式
    //3.常用方法：（1）format(Date date) 格式化（日期对象->字符串）
    //          （2）parse(String source) 解析（字符串->日期对象）
    public static void main(String[] args) throws ParseException {
        //1.格式化
        Method1();
        //2.解析
        Method2();

    }
    private static void Method1() {
        SimpleDateFormat sdf=new SimpleDateFormat();
        Date d1=new Date();
        String str=sdf.format(d1);
        System.out.println(str);
        //带参指定格式
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分:ss秒 EE");
        String str2=sdf2.format(d1);
        System.out.println(str2);
    }
    private static void Method2() throws ParseException {
        //定义一个字符串对象
        String str="2023-11-11 11:11:11";
        //创建带参的SimpleDateFormat对象
        //注：创建对象的格式要跟字符串的格式完全一致
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=sdf.parse(str);
        System.out.println(date);
        System.out.println(date.getTime());
    }

}
