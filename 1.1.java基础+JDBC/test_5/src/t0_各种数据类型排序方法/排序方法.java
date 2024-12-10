package t0_各种数据类型排序方法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 排序方法 {
    public static void main(String[] args) {
        //1.集合
        //Collections.sort();
        //2.数组
        int []arr={2,1,4,3,2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
