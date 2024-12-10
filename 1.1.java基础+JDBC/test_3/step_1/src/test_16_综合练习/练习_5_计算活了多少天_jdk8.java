package test_16_综合练习;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class 练习_5_计算活了多少天_jdk8 {
    public static void main(String[] args) {
        LocalDate today=LocalDate.now();
        LocalDate birth=LocalDate.of(2003,8,26);
        System.out.println(today);
        long days=ChronoUnit.DAYS.between(birth,today);
        System.out.println(days);
    }
}
