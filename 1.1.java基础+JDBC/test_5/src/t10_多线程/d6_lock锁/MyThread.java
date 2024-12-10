package t10_多线程.d6_lock锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    public MyThread() {
    }

    //表示这个类的所有对象都共享ticket数据
    static int ticket=0;
    //创建锁，由于lock是接口，所以不能直接new
    static Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while(true){
            //synchronized (MyThread.class) {
            lock.lock();
            try {
                if (ticket < 100) {
                    ticket++;
                    System.out.println(getName() + "正在卖" + ticket + "张票");
                        //让线程休眠一段时间
                    Thread.sleep(10);
                } else {
                    System.out.println(getName() + "票已卖完");
                    break;
                    }
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                } finally {
                //由于finally中的方法一定会被执行，所以把开锁的代码放进finally中，放在break跳出循环时没有开锁
                    lock.unlock();
            }
            //}
        }
    }
}
