package t10_多线程.d10_线程池.x1_一般线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void main(String[] args) throws InterruptedException {
        //获取线程池对象
        ExecutorService pool1= Executors.newCachedThreadPool();
        //提交任务
        pool1.submit(new MyThread());
        Thread.sleep(1000);
        pool1.submit(new MyThread());
        pool1.submit(new MyThread());

        //一般不销毁线程池
        pool1.shutdown();
    }
}
