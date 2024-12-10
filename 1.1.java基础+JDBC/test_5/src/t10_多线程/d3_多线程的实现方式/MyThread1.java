package t10_多线程.d3_多线程的实现方式;

public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+"@"+i);
        }
    }
}
