package atguigu_jdbc.jdbc_3_高级篇.j_2_工具类封装V2;

public class ThreadLocal<C> {
/*
    ThreadLocal用于保存某个线程共享变量，原因是在Java中，每一个线程对象中都有一个ThreadLocalMap<ThreadLocal， Object>，
    其key就是一个ThreadLocal，而Object即为该线程的共享变量。

    而这个map是通过ThreadLocal的set和get方法操作的。对于同一个static ThreadLocal，不同线程只能从中get，set，remove自己的变量，
    而不会影响其他线程的变量。

    含义就是连接池的连接可以通过ThreadLocal保存
 */
}
