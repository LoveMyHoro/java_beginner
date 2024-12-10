package t4_Lambda表达式_简化函数式接口的匿名内部类的代码;

import java.util.Arrays;

public class test_1 {
    public static void main(String[] args) {
        //将字符串数组按照长度从长到短逆序排序
        String []arr={"aaaa","aaaaaa","aa","aaa","aaaaaaaa"};

        Arrays.sort(arr,((o1, o2) ->{
            return o2.length()-o1.length();
        }));
        
        System.out.println(Arrays.toString(arr));
    }
}
