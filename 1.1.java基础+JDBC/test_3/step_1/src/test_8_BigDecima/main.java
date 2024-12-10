package test_8_BigDecima;

import java.math.BigDecimal;

public class main {
    public static void main(String[] args) {
        BigDecimal bg1=new BigDecimal("0.01");
        BigDecimal bg2=new BigDecimal("0.09");
        BigDecimal bg3=bg1.add(bg2);
        System.out.println(bg3);


    }
}
