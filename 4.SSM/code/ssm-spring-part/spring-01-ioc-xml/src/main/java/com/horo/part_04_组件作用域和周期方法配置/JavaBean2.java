package com.horo.part_04_组件作用域和周期方法配置;

public class JavaBean2 {

  //周期方法要求： 方法命名随意，但是要求方法必须是 public void 无形参列表
  public void init() {
    // 初始化逻辑
    System.out.println("JavaBean init");
  }



  public void cleanup() {
    // 释放资源逻辑
    System.out.println("JavaBean cleanup");
}
}