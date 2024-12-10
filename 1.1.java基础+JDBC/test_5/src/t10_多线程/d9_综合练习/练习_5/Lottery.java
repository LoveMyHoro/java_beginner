package t10_多线程.d9_综合练习.练习_5;

import t9_io流.j6_综合练习.练习_4_登陆注册.User;

import java.util.*;

public class Lottery extends Thread{
    ArrayList<Integer>list=new ArrayList<>();

    public Lottery(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (Lottery.class){
                if(list.size()==0){
                    System.out.println("奖励已被抽取完毕");
                    break;
                }
                else{
                    Collections.shuffle(list);
                    int temp=list.get(0);
                    System.out.println(getName()+"又产生了一个"+temp+"元大奖");
                    list.remove(0);
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
