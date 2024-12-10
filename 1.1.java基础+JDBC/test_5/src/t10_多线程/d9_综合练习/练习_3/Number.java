package t10_多线程.d9_综合练习.练习_3;

import project3_斗地主.util.CodeUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Number extends Thread{
    static int number=1;
    static Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while(true){
            lock.lock();
            try {
                if(number<=100){
                    if(number%2==1){
                        System.out.println(getName()+"输出："+number);
                    }
                    number++;
                }
                else{
                    break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
