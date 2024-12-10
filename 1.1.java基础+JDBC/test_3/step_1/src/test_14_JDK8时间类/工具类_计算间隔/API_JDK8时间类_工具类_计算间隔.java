package test_14_JDK8时间类.工具类_计算间隔;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class API_JDK8时间类_工具类_计算间隔 {
    /*
    1.三个常用工具类
    （1）Duration：用于计算两个时间间隔（秒，纳秒）
    （2）Period：用于计算两个日期的间隔（年，月，日）
    （3）ChronoUnit：用于计算两个日期间隔
     */
    public static void main(String[] args) {
        Period();
        Duration();
        ChronoUnit();

    }

    private static void ChronoUnit() {
        // 当前时间
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
// 生日时间
        LocalDateTime birthDate = LocalDateTime.of(2000, 1, 1,0, 0, 0);
        System.out.println(birthDate);

        System.out.println("相差的年数:" + ChronoUnit.YEARS.between(birthDate, today));
        System.out.println("相差的月数:" + ChronoUnit.MONTHS.between(birthDate, today));
        System.out.println("相差的周数:" + ChronoUnit.WEEKS.between(birthDate, today));
        System.out.println("相差的天数:" + ChronoUnit.DAYS.between(birthDate, today));
        System.out.println("相差的时数:" + ChronoUnit.HOURS.between(birthDate, today));
        System.out.println("相差的分数:" + ChronoUnit.MINUTES.between(birthDate, today));
        System.out.println("相差的秒数:" + ChronoUnit.SECONDS.between(birthDate, today));
        System.out.println("相差的毫秒数:" + ChronoUnit.MILLIS.between(birthDate, today));
        System.out.println("相差的微秒数:" + ChronoUnit.MICROS.between(birthDate, today));
        System.out.println("相差的纳秒数:" + ChronoUnit.NANOS.between(birthDate, today));
        System.out.println("相差的半天数:" + ChronoUnit.HALF_DAYS.between(birthDate, today));
        System.out.println("相差的十年数:" + ChronoUnit.DECADES.between(birthDate, today));
        System.out.println("相差的世纪(百年)数:" + ChronoUnit.CENTURIES.between(birthDate, today));
        System.out.println("相差的千年数:" + ChronoUnit.MILLENNIA.between(birthDate, today));
        System.out.println("相差的纪元数:" + ChronoUnit.ERAS.between(birthDate, today));
    }

    private static void Duration() {
        // 本地日期时间对象。
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

// 出生的日期时间对象
        LocalDateTime birthDate = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
        System.out.println(birthDate);

        Duration duration = Duration.between(birthDate, today);//第二个参数减第一个参数
        System.out.println("相差的时间间隔对象:" + duration);

        System.out.println("============================================");
        System.out.println(duration.toDays());//两个时间差的天数
        System.out.println(duration.toHours());//两个时间差的小时数
        System.out.println(duration.toMinutes());//两个时间差的分钟数
        System.out.println(duration.toMillis());//两个时间差的毫秒数
        System.out.println(duration.toNanos());//两个时间差的纳秒数
    }

    private static void Period() {
        //当前日期
        LocalDate today= LocalDate.now();
        System.out.println(today);
        //出生日期
        LocalDate birth=LocalDate.of(2000,1,1);
        System.out.println(birth);
        //间隔对象
        Period per=Period.between(birth,today);
        System.out.println(per);
        //输出
        System.out.println(per.getYears());
        System.out.println(per.getMonths());
        System.out.println(per.getDays());
        //计算相差总月数
        System.out.println(per.toTotalMonths());
    }
}
