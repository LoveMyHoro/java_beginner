package t10_多线程.d4_Thread常见的成员方法;

public class MyThread3 extends Thread{
    public MyThread3() {
    }

    public MyThread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName()+"@"+i);
            Thread.yield();
        }
    }
}
