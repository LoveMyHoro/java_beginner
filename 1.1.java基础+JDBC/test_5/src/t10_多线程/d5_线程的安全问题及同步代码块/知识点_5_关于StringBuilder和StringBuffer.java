package t10_多线程.d5_线程的安全问题及同步代码块;

public class 知识点_5_关于StringBuilder和StringBuffer {
    public static void main(String[] args) {
        //1.StringBuffer中的所有方法前都有synchronized，称为是线程安全的
        //而StringBuilder中的方法前没有。
        //2.单线程环境下选择StringBuilder，多线程环境下选择StringBuffer

    }
}
