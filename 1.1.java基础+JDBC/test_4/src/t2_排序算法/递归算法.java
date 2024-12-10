package t2_排序算法;

public class 递归算法 {
    public static void main(String[] args) {
        System.out.println(Method(5));
    }

    private static int Method(int num) {
        if(num==0)return 1;
        return num*Method(num-1);
    }
}
