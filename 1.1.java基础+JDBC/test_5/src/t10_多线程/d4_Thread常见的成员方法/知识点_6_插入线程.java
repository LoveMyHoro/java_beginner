package t10_多线程.d4_Thread常见的成员方法;

public class 知识点_6_插入线程 {
    public static void main(String[] args) throws InterruptedException {

        MyThread3 t=new MyThread3("明日香");
        t.start();
        //join():把某个线程插入到当前线程前
        //当前线程：main线程
        //把t线程插入到main线程前，只有当t线程结束后，才会执行main线程

        t.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("main线程"+i);
        }



    }
}
