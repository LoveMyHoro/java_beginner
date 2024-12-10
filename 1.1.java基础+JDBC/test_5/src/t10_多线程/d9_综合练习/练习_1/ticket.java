package t10_多线程.d9_综合练习.练习_1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ticket extends Thread{
    static int count=0;
    static Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while(true){
            lock.lock();
            try {
                if(count<3000){
                    count++;
                    System.out.println(getName()+"正在卖第"+count+"张票");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    System.out.println("票已卖完");
                    break;
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }
    }
}
