package t10_多线程.d9_综合练习.练习_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Lottery extends Thread{
    ArrayList<Integer>list=new ArrayList<>();

    public Lottery(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        //每一个集合都会创建自己的集合
        ArrayList<Integer>BoxList=new ArrayList<>();
        while(true){
            synchronized (Lottery.class){
                if(list.size()==0){
                    int sum=0;
                    for(Integer i : BoxList) {
                         sum+=i;
                        }
                    System.out.println(BoxList+","+Collections.max(BoxList)+","+sum);
                    break;
                }
                else{
                    Collections.shuffle(list);
                    int temp=list.get(0);
                    System.out.println(getName()+"又产生了一个"+temp+"元大奖");
                    list.remove(0);
                    BoxList.add(temp);
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
