package t10_多线程.d5_线程的安全问题及同步代码块;

public class MyThread3 implements Runnable{
    public MyThread3() {
    }

    //表示这个类的所有对象都共享ticket数据
    static int ticket=0;
    //锁对象，一定要是唯一的，通常用当前类的自解码文件
    @Override
    public void run() {
        while(true){
            if (extracted()) break;
        }
    }

    private synchronized static boolean extracted() {
        if(ticket==100){
            System.out.println("票已卖完");
            return true;
        }
        else{
            ticket++;
            System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
            try {
                //让线程休眠一段时间
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
    }
        return false;
    }
}
