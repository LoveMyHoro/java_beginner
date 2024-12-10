package test_14_JDK8时间类.Date类;

import java.time.Instant;

public class API_JDK8时间类_Instant_时间戳 {
    /*
            static Instant now() 获取当前时间的Instant对象(标准时间)
            static Instant ofXxxx(long epochMilli) 根据(秒/毫秒/纳秒)获取Instant对象
            ZonedDateTime atZone(ZoneIdzone) 指定时区
            boolean isxxx(Instant otherInstant) 判断系列的方法
            Instant minusXxx(long millisToSubtract) 减少时间系列的方法
            Instant plusXxx(long millisToSubtract) 增加时间系列的方法
        */
    public static void main(String[] args) {
        //（1）获取当前时间的Instant对象
        Instant now=Instant.now();
        System.out.println(now);


        //（2）根据(秒/毫秒/纳秒)获取Instant对象
        Instant instant1=Instant.ofEpochMilli(0L);
        System.out.println(instant1);
        Instant instant2=Instant.ofEpochSecond(1000L);
        System.out.println(instant2);
        Instant instant3=Instant.ofEpochSecond(1000L,100L);
        System.out.println(instant3);

    }
}
