package t10_多线程.d8_等待唤醒机制.d1_生产者方式实现;

public class Foodie extends Thread {
    @Override
    public void run() {
        /*
        * 1.循环
        * 2.同步代码块
        * 3.判断共享代码是否到了末尾（到了末尾）
        * 4.判断共享数据是否到了末尾（没有到末尾，执行核心逻辑）
         */
        while(true){
            synchronized (Desk.lock){
                //判断共享代码是否到了末尾（到了末尾）
                if(Desk.count==0){
                    break;
                }
                else{
                    //先判断桌子上是否有面条
                    if(Desk.foodFlag==0){
                        //如果没有，就等待
                        //这一步是让当前线程和锁进行绑定
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else{
                        //如果有就开吃
                        Desk.count--;
                        System.out.println("吃货在吃面条，还能再吃"+Desk.count+"碗！！！");
                        //吃完之后唤醒厨师继续做
                        Desk.lock.notifyAll();
                        //修改桌子的状态
                        Desk.foodFlag=0;
                    }
                }

            }
        }
    }
}
