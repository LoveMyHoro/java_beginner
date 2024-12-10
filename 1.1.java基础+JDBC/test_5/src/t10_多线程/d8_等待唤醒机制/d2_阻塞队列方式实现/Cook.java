package t10_多线程.d8_等待唤醒机制.d2_阻塞队列方式实现;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread{
    //阻塞队列，但是没有传值
    ArrayBlockingQueue<String>queue;

    public Cook(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("厨师正在做饭");
        try {
            queue.put("面条");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
            }
        }

    }
}
