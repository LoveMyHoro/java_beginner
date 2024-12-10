package t10_多线程.d10_线程池.x3_最大并行数;

public class 知识点_1 {
    public static void main(String[] args) {
        int cnt=Runtime.getRuntime().availableProcessors();
        System.out.println(cnt);
    }
}
