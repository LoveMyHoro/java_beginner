package t5_集合进阶.进阶3_泛型_多用于数据类型不确定的时候.f1_泛型类.test;


import java.util.Arrays;

/*
        当我们在编写一个类的时候，如果不确定类的类型，那么这个类就可以定义为泛型类
 */
public class MyArrayList <E>{
    //E表示不确定的数据类型
    Object []obj=new Object[10];
    int size=0;

    public boolean add(E e){
        obj[size]=e;
        size++;
        return true;
    }
    public E get(int index){
        return (E)obj[index];
    }
    @Override
    public String toString(){
        return Arrays.toString(obj);
    }

}
