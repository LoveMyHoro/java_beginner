package t10_多线程.d10_线程池.x1_一般线程池;

public class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"-----"+i);
        }
    }
}
