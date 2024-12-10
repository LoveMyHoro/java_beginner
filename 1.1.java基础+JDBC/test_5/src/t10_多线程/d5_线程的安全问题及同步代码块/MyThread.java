package t10_多线程.d5_线程的安全问题及同步代码块;

public class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    public MyThread() {
    }

    //表示这个类的所有对象都共享ticket数据
    static int ticket=0;

    @Override
    public void run() {
        while(true){
            if(ticket<100){
                ticket++;
                System.out.println(getName()+"正在卖"+ticket+"张票");
                try {
                    //让线程休眠一段时间
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                System.out.println(getName()+"票已卖完");
                break;
            }
        }
    }
}
