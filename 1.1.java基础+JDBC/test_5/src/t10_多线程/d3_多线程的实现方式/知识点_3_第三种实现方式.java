package t10_多线程.d3_多线程的实现方式;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class 知识点_3_第三种实现方式 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        *多线程的第三种实现方式(对前两种方式的补充)
        *   特点：可以获取到多线程的运行结果
        *
        *   1.创建一个类实现Callable接口
        *   2.重写call（是有返回值的，表示多线程要执行任务）
        *   3.创建MyCallable的对象（表示多线程要执行的任务）
        *   4.创建FutureTask的对象（表示管理多线程运行的结果）
        *   5.创建Thread类的对象，并启动（表示线程）
        *
         */
        //创建MyCallable的对象（表示多线程要执行的任务）
        MyCallable mc=new MyCallable();
        //创建FutureTask的对象（表示管理多线程运行的结果）
        FutureTask<Integer>ft=new FutureTask<>(mc);
        //创建Thread类的对象，并启动（表示线程）
        Thread thread=new Thread(ft);
        //启动线程
        thread.start();
        //获取多线程运行的结果
        Integer result=ft.get();
        System.out.println(result);

    }
}
