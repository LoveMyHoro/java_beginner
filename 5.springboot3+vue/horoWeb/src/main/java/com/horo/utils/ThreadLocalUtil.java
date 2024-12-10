package com.horo.utils;

/**
 * @ClassName ThreadLocalUtil
 * @Author iove
 * @Date 2024/11/14 下午3:14
 * @Version 1.0
 * @Description TODO
 **/

public class ThreadLocalUtil {
    //1.提供ThreadLocal对象
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    //2.提供键获取值
    public static<T> T get() {return (T)THREAD_LOCAL.get();}

    //3.存储键值对
    public static void set(Object value) {THREAD_LOCAL.set(value);}

    //4.清除ThreadLocal，防止内存泄露
    public static void remove() {THREAD_LOCAL.remove();}


}
