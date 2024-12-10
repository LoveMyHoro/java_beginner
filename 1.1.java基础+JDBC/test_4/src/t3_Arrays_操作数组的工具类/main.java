package t3_Arrays_操作数组的工具类;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        //1.toString():将数组拼接成字符串
        int []arr={5,4,7,5,2,4,1,9};
        System.out.println(Arrays.toString(arr));
        //2.sort():升序排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //3.binarySearch():利用二分查找查找元素
        //（1）实验前提：数组元素必须是升序的
        //（2）若存在，则返回索引。若不存在，则返回 -插入点-1（-1是为了防止无法区分-0）
        int index=Arrays.binarySearch(arr,7);
        System.out.println(index);
        //4.copyOf():拷贝数组
        //(1)要指定拷贝长度,如果长度大于原数组长度，则会补上默认值0
        int []arr2=Arrays.copyOf(arr,4);
        System.out.println(Arrays.toString(arr2));
        //5.copyOfRange():可以指定范围的拷贝数组(包头不包尾)
        int []arr3= Arrays.copyOfRange(arr,4,10);
        System.out.println(Arrays.toString(arr3));
        //6.fill():填充数组
        //将数组中的值替换为指定的值
        Arrays.fill(arr3,111);
        System.out.println(Arrays.toString(arr3));


        /************************重点*****************************/
        //7.sort(数组,排序的规则):自定义排序方式（排序的规则：比如升序还是降序）
        //（1）只能给引用数据类型进行排序
        //（2）如果数组是基本数据类型的，需要变成其对应的包装类（如int->integer）
        //（3）第二个参数是一个接口，所以我们在调用方法的时候，需要传递这个接口的实现类对象，作为排序的规则
        //但这个实现类，我只要使用一次，所以就没有必要单独去写一个类，直接采用匿名内部类的方式就可以了
        //（4）使用的是Comparator的匿名内部类
        //（5）其底层原理见截图

        //o1:无序序列中的元素，o2:有序序列中的元素
        //简单理解
        //o1-o2:升序
        //o2-o1:降序
        Integer [] arr4={5,4,7,5,2,4,1,9};
        Arrays.sort(arr4, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(Arrays.toString(arr4));





    }
}
