package t5_集合进阶.进阶2_单列集合顶层接口Collection.c1_迭代器遍历;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class c2_迭代器遍历 {
    //1.迭代器不依赖索引
    public static void main(String[] args) {
        Collection<String> list=new ArrayList<>();
        list.add("add");
        list.add("cffg");
        list.add("bcc");

        //1.类型为Iterator<String>，表示这个Iterator对象可以遍历存储了String类型元素的列表。
        //2.补充知识点
        /*（1）在Java中，我们无法直接通过接口来创建实例对象。在代码示例中，我们调用了list.iterator()方法，
        这个方法返回的是实现了Iterator接口的具体类的实例对象，而不是直接的Iterator接口的实例对象。
        具体来说，在ArrayList类中实现了Iterator接口，通过调用iterator()方法，我们获得的是ArrayList内部的一个实现了Iterator接口的迭代器实例对象。
        这个迭代器对象内部封装了对ArrayList集合的遍历逻辑，我们通过这个迭代器对象来访问和遍历ArrayList中的元素。
        因此，尽管我们说iterator的数据类型是Iterator，但实际获得的是ArrayList实现的Iterator接口的具体实例对象。
          （2）在这个例子中，Iterator是一个接口，而具体的迭代器类（如ArrayList内部实现的迭代器）都实现了这个接口。
          通过将迭代器对象赋值给类型为Iterator的变量，我们实现了多态：即用接口的引用指向具体实现类的对象。
          （3）这种用法符合多态的概念，即一个对象可以在程序运行时表现出多种形态。

         */
        Iterator<String>it=list.iterator();
        while(it.hasNext()){
            String temp=it.next();
            System.out.println(temp);
        }
        //当上面的循环结束以后，指针已经指到了最后没有元素的位置，且不会复位。当想要再次遍历时，要创建新的迭代器


    }
}
