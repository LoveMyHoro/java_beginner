package t10_多线程.d5_线程的安全问题及同步代码块;

public class 知识点_4_练习 {
    public static void main(String[] args) {
        //技巧“：先写同步代码块，再将代码块抽出来生成方法
        MyThread3 myThread3=new MyThread3();
        Thread t1=new Thread(myThread3);
        Thread t2=new Thread(myThread3);
        Thread t3=new Thread(myThread3);
        t1.setName("明日香");
        t2.setName("战场原");
        t3.setName("赫萝");
        t1.start();
        t2.start();
        t3.start();

    }
}
