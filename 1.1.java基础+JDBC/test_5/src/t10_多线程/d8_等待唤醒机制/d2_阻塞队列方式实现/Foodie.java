package t10_多线程.d8_等待唤醒机制.d2_阻塞队列方式实现;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread{
    ArrayBlockingQueue<String>queue;

    public Foodie(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("吃货在吃面条");

        }
    }
}
