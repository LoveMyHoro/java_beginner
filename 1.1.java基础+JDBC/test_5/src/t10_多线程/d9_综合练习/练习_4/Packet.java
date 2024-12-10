package t10_多线程.d9_综合练习.练习_4;

import cn.hutool.core.math.Money;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Packet extends Thread{
    static double number=100;
    static int cnt=3;
    static double min_number=0.01;

    public Packet() {
    }

    public Packet(String name) {
        super(name);
    }

    @Override
    public void run() {
            synchronized (Packet.class){
                if(cnt==0){
                    System.out.println(getName()+"没抢到");
                }else{
                    double prize=0;
                    if(cnt==1){
                        prize=number;
                    }
                    else{
                        Random r=new Random();
                        double bounds= number-(cnt-1)*min_number;
                        prize=r.nextDouble(bounds);
                        if(prize<min_number){
                            prize=min_number;
                        }
                    }
                    number=number-prize;
                    cnt--;
                    System.out.println(getName()+"抢到了"+prize+"元");
                }
            }


    }
}
