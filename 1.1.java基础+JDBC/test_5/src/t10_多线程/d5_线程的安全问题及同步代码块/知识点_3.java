package t10_多线程.d5_线程的安全问题及同步代码块;

public class 知识点_3 {
    public static void main(String[] args) {
        //1.问题：
        //由于sleep()会让线程休眠，在休眠过程中其他线程会抢夺cpu的执行权
        //此时可能会造成安全问题
        //而且在线程休眠结束后也要重新抢夺线权
        //2.解决方法：
        //同步代码块：把操作共享数据的代码锁起来
        MyThread2 t1=new MyThread2("明日香");
        MyThread2 t2=new MyThread2("赫萝");
        MyThread2 t3=new MyThread2("战场原");
        t1.start();
        t2.start();
        t3.start();
        //3.注意点：
        //（1）同步代码块synchronized不能写在循环的外面
        //因为这样会使一个线程将进入while循环后，将while循环锁住。执行完毕后才会打开锁，让其他线程进入
        //（2）锁对象要唯一。因为锁对象相当于门
    }
}
