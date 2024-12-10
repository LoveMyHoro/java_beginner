package t10_多线程.d4_Thread常见的成员方法;

public class 知识点_5_礼让线程 {
    public static void main(String[] args) {
        //在类中加入Thread.yield()
        MyThread3 t1=new MyThread3("明日香");
        MyThread3 t2=new MyThread3("赫萝");
        t1.start();
        t2.start();
    }
}
