package t10_多线程.d9_综合练习.练习_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Gift extends Thread{
    static int count=100;
    static Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while(true){
            lock.lock();
            try {
                if(count<10){
                    System.out.println("剩余礼物数量小于10，停止发放");
                    break;
                }
                else{
                    count--;
                    System.out.println(getName()+"正在送礼物,剩余礼物数量为"+count);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
