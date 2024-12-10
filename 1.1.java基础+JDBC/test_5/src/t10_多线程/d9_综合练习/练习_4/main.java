package t10_多线程.d9_综合练习.练习_4;

public class main {
    public static void main(String[] args) {
        Packet2 p1=new Packet2("明日香");
        Packet2 p2=new Packet2("战场原");
        Packet2 p3=new Packet2("赫萝");
        Packet2 p4=new Packet2("可可罗");
        Packet2 p5=new Packet2("凯尔希");
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();



    }
}
