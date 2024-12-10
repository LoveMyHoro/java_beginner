package t1_集合进阶.进阶9_可变参数;

public class main {
    public static void main(String[] args) {
        Method(4,7,3,4,5,6,2,9);
    }

    private static void Method(int a,int ...arr) {
        for(int i=0;i<a;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
