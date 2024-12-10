package test_13_JDK7时间类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 练习2_SimpleDateFormat {
    public static void main(String[] args) throws ParseException {
        //练习(1)：将"2020-11-11"转换为"2020年11月11日"
        Method1();
        //练习(2): 参加秒杀活动
        Method2();


    }

    private static void Method2() throws ParseException {
        //  秒杀活动开始时间:2023年11月11日 0:0:0(毫秒值)
        //  秒杀活动结束时间:2023年11月11日 0:10:0(毫秒值)
        //  小贾下单并付款的时间为:2023年11月11日 0:01:0
        //  小皮下单并付款的时间为:2023年11月11日 0:11:0
        //  用代码说明这两位同学有没有参加上秒杀活动?
        String st="2023年11月11日 0:0:0";
        String se="2023年11月11日 0:10:0";
        String stu1="2023年11月11日 0:01:0";
        String stu2="2023年11月11日 0:11:0";
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d_st=sdf1.parse(st);
        Date d_se=sdf1.parse(se);
        Date d_stu1=sdf1.parse(stu1);
        Date d_stu2=sdf1.parse(stu2);
        long t_st=d_st.getTime();
        long t_se=d_se.getTime();
        long t_s1=d_stu1.getTime();
        long t_s2=d_stu2.getTime();
        System.out.println(t_s1>=t_st&&t_s1<=t_se);
        System.out.println(t_s2>=t_st&&t_s2<=t_se);
    }

    private static void Method1() throws ParseException {
        String s1="2020-11-11";
        //解析
        SimpleDateFormat slf1=new SimpleDateFormat("yyyy-MM-dd");
        Date d1=slf1.parse(s1);
        //格式化
        SimpleDateFormat slf2=new SimpleDateFormat("yyyy年MM月dd日");
        String s2=slf2.format(d1);
        System.out.println(s2);
    }
}
