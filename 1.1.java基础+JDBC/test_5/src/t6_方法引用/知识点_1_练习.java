package t6_方法引用;

import java.util.Arrays;

public class 知识点_1_练习 {
    public static void main(String[] args) {
        Integer []arr={1,3,2,4,1,7};
        Arrays.sort(arr, 知识点_1_练习::deSort);
        System.out.println(Arrays.toString(arr));
    }
    public static int deSort(int num1,int num2){
        return num2-num1;
    }
}
