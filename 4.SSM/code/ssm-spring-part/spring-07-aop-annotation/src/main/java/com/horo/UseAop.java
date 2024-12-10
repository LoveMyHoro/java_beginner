package com.horo;

import com.horo.dyn.ProxyFactory;

/**
 * @ClassName UseAop
 * @Author iove
 * @Date 2024/9/30 上午11:07
 * @Version 1.0
 * @Description TODO
 **/

public class UseAop {
    /**
     * 这里只介绍动态代理
     * @param args
     */
    public static void main(String[] args) {

        //1.创建目标对象
        Calculator target=new CalculatorPureImpl();
        //2.创建代理工厂
        ProxyFactory factory=new ProxyFactory(target);
        //3.得到代理类
        Calculator proxy=(Calculator)factory.getProxy();
        proxy.add(1,1);
    }
}
