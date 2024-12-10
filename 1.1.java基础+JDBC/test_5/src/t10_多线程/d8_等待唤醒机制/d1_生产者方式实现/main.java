package t10_多线程.d8_等待唤醒机制.d1_生产者方式实现;

public class main {
    public static void main(String[] args) {
        Cook c=new Cook();
        Foodie f=new Foodie();
        c.setName("明日香");
        f.setName("战场原");
        c.start();
        f.start();
    }
}
