package t10_多线程.d9_综合练习.练习_4;

import t10_多线程.d9_综合练习.练习_3.Number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Packet2 extends Thread{
    static BigDecimal number=BigDecimal.valueOf(100);
    static int cnt=3;
    static BigDecimal min_number=BigDecimal.valueOf(0.01);

    public Packet2() {
    }

    public Packet2(String name) {
        super(name);
    }

    @Override
    public void run() {
            synchronized (Packet2.class){
                if(cnt==0){
                    System.out.println(getName()+"没抢到");
                }else{
                    BigDecimal prize;
                    if(cnt==1){
                        prize=number;
                    }
                    else{
                        Random r=new Random();
                        double bounds= number.subtract(BigDecimal.valueOf(cnt-1).multiply(min_number)).doubleValue();
                        prize=BigDecimal.valueOf(r.nextDouble(bounds));
                        if(prize.doubleValue()<min_number.doubleValue()){
                            prize=min_number;
                        }
                    }
                    prize = prize.setScale(2, RoundingMode.HALF_UP);
                    number=number.subtract(prize);
                    cnt--;
                    System.out.println(getName()+"抢到了"+prize+"元");
                }
            }


    }
}
