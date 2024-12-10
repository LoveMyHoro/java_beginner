package t5_集合进阶.进阶5_Set系列集合.s3_TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class 第二种排序方法 {
    public static void main(String[] args) {
        //1.创建集合
        //o1；表示当前要添加的元素
        //o2：表示当前已经在红黑树存在的元素
        //2.返回值大于0，认为要添加的元素是大的，排右边。小于0,排左边。等于0,已存在，舍弃
        TreeSet<String>ts=new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //按照长度排序
                int i=o1.length()-o2.length();
                //如果一样长则按照首字母排序
                i=i==0?o1.compareTo(o2):i;
                return i;
            }
        });
        ts.add("aaa");
        ts.add("ab");
        ts.add("abc");
        System.out.println(ts);
    }
}
