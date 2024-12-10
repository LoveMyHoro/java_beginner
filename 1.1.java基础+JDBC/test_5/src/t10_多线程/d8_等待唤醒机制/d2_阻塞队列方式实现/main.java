package t10_多线程.d8_等待唤醒机制.d2_阻塞队列方式实现;

import java.util.concurrent.ArrayBlockingQueue;

public class main {
    public static void main(String[] args) {
        //利用阻塞队列的方式实现生产者和消费者（等待唤醒机制）
        // 注意（1）生产者和消费者必须使用同一个阻塞队列
        //    （2）阻塞队列底层都有锁且相同的阻塞队列用的是同一把锁
        //    （3）打印语句放在外面，有时候可能会被其他语句重复打印，因为没有上锁

        //1.创建阻塞队列的对象
        ArrayBlockingQueue<String>queue=new ArrayBlockingQueue<>(1);
        //2.创建线程的对象
        Cook c=new Cook(queue);
        Foodie f=new Foodie(queue);
        c.start();
        f.start();


    }
}
