package t10_多线程.d9_综合练习.练习_1;

public class main {
    public static void main(String[] args) {
        ticket t1=new ticket();
        ticket t2=new ticket();
        t1.setName("明日香");
        t2.setName("战场原");
        t1.start();
        t2.start();
    }
}
