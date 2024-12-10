package t10_多线程.d4_Thread常见的成员方法;

public class 知识点_1 {
    public static void main(String[] args) throws InterruptedException {
        //1.getName方法·
        //细节：若我们没有给线程设置名字，线程会使用默认的名称。格式：Thread-x(x从0开始)
        //
        MyThread2 t1=new MyThread2();
        MyThread2 t2=new MyThread2();
        t1.start();
        t2.start();


        //2.setName
        //细节：Thread的构造方法可以设置构造方法，其子类若想使用其构造方法要依靠super()方法
        MyThread2 t3=new MyThread2("明日香");
        t3.start();


        //3.currentThread
        //哪条线程执行到在这个方法，此时获取到的是哪个线程的对象
        Thread t=Thread.currentThread();
        String name=t.getName();
        System.out.println(name);
        //可见，输出结果是main
        //细节：当JVM虚拟机启动之后，会自动的启动多条线程
        //其中有一条线程就叫做main线程，并执行里面的代码
        //在以前，我们写的所有代码，其实都是运行在main线程中


        //4.sleep()方法：让线程休眠指定的时间，单位为毫秒(1秒=1000毫秒)
        //  1.细节：哪条线程执行到这段代码，哪条线程就会在这里停留对应的时间
        //  2.方法的参数：就表示睡眠的时间，单位毫秒
        //  3.当时间到了之后，线程会自动的醒来，继续执行下面的其他代码
        System.out.println(11111);
        Thread.sleep(5000);
        System.out.println(22222);



    }
}
