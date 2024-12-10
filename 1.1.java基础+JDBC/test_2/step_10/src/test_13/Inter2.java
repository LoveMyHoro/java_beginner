package test_13;

public interface Inter2 {
    public default void method1(){
        System.out.println("方法执行中__默认方法");
        this.show();
    }
    public static void method2(){
        System.out.println("方法执行中__接口静态方法");
        show2();
    }
    private void show(){//
        System.out.println("这里是执行日志");
    }
    private static void show2(){
        System.out.println("这里是执行日志");
    }


}
