package t5_集合进阶.进阶2_单列集合顶层接口Collection.c0_基本原理;

import java.util.ArrayList;
import java.util.Collection;

public class 基本方法 {
    public static void main(String[] args) {
        //（1）list系列集合中的有序指的是存取有序，比如存的顺序是张三，李四，王五。取的顺序也是张三，李四，王五
        //（2）Collection是一个接口，我们不能直接创建它的对象。所以，现在我们学习它的方法的时候，只能创建它的实现类对象。如ArrayList

        //1.添加元素
        //（1）如果我们向list中添加1元素，那么方法永远返回true，因为list系列是允许元素重复的。相反，set系列不允许重复
        //这是多态方式创建对象
        Collection <String>coll=new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        System.out.println(coll);

        //2.删除元素
        //（1）因为Collection里面定义的是共性的方法，所以此时不能通过索引删除，只能通过元素的对象进行删除
        //（2）删除成功返回true，失败返回false


        //3.判断是否包含
        //（1）底层利用的是equals方法进行比较，从而判断是否包含。
        //（2）由于equals方法底层是通过判断地址是否相同来判断是否包含，所以在存取的是自定义对象时，由于自定义对象创建对象时都是new一片新的空间
        //所以此时在比较地址就会出问题，解决方法就是要重写equals方法
        //
    }
}
