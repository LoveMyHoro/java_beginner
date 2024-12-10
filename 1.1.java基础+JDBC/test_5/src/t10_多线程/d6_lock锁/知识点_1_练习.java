package t10_多线程.d6_lock锁;

public class 知识点_1_练习 {
    public static void main(String[] args) {
        MyThread t1=new MyThread("明日香");
        MyThread t2=new MyThread("战场原");
        MyThread t3=new MyThread("赫萝");
        t1.start();
        t2.start();
        t3.start();
    }
}
