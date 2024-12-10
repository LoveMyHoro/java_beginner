package t10_多线程.d3_多线程的实现方式;

public class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //获取当前线程的对象
            Thread t=MyThread1.currentThread();
            System.out.println(t.getName()+"亲爱的，我在未来等你");
        }
    }
}
