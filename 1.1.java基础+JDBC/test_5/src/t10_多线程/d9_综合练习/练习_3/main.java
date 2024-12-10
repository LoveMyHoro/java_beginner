package t10_多线程.d9_综合练习.练习_3;

public class main {
    public static void main(String[] args) {
        Number n1=new Number();
        Number n2=new Number();
        n1.setName("明日香");
        n2.setName("战场原");
        n1.start();
        n2.start();

    }
}
