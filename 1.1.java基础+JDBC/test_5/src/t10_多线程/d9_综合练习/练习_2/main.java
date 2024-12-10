package t10_多线程.d9_综合练习.练习_2;

public class main {
    public static void main(String[] args) {
        Gift g1=new Gift();
        Gift g2=new Gift();
        g1.setName("明日香");
        g2.setName("战场原");
        g1.start();
        g2.start();
    }
}
