package t10_多线程.d9_综合练习.练习_7;

import t10_多线程.d9_综合练习.练习_7.Lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer>list=new ArrayList<>();
        Collections.addAll(list,10,5,20,50,100,200,500,800,2,80,300,700);

        //创建多线程要运行的参数对象
        Lottery l1=new Lottery(list);
        //创建多线程运行结果的管理对象
        FutureTask<Integer>ft1=new FutureTask<>(l1);
        FutureTask<Integer>ft2=new FutureTask<>(l1);
        //创建线程对象
        Thread t1=new Thread(ft1);
        Thread t2=new Thread(ft2);
        t1.setName("明日香");
        t2.setName("战场原");
        t1.start();
        t2.start();
        System.out.println(ft1.get()+","+ft2.get());
        //1.堆内存是唯一的，栈内存不是唯一的。
        //2.每一个线程都有自己的栈

    }
}
