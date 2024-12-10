package t10_多线程.d8_等待唤醒机制.d1_生产者方式实现;

public class Cook extends Thread{
    @Override
    public void run() {
        while(true){
            synchronized (Desk.lock){
                if(Desk.count==0){
                    break;
                }
                else{
                    if(Desk.foodFlag==1){
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else {
                        System.out.println("厨师做了一碗面条");
                        //修改桌子上的食物状态
                        Desk.foodFlag=1;
                        //唤醒消费者开吃
                        Desk.lock.notifyAll();
                    }
                }
            }
        }

    }
}
