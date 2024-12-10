package t6_方法引用;

import java.util.Arrays;

public class 知识点_7_训练 {
    public static void main(String[] args) {
        //  将大写字母转为小写
        String []arr={"aaa","bbb","ccc"};
        Arrays.stream(arr).map(String::toUpperCase).forEach(s-> System.out.println(s));
    }
}
