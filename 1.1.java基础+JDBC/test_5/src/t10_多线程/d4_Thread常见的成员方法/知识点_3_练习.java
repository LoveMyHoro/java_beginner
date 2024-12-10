package t10_多线程.d4_Thread常见的成员方法;

import t10_多线程.d3_多线程的实现方式.MyThread2;

public class 知识点_3_练习 {
    public static void main(String[] args) {
        MyThread2 myThread2=new MyThread2();
        Thread t1=new Thread(myThread2,"明日香");
        Thread t2=new Thread(myThread2,"赫萝");
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();



    }
}
