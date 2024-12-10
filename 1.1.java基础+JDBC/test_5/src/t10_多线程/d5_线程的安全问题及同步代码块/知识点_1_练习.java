package t10_多线程.d5_线程的安全问题及同步代码块;

public class 知识点_1_练习 {
    public static void main(String[] args) {
        MyThread t1=new MyThread("明日香");
        MyThread t2=new MyThread("赫萝");
        MyThread t3=new MyThread("战场原");
        t1.start();
        t2.start();
        t3.start();
    }
}
