package t4_Lambda表达式_简化函数式接口的匿名内部类的代码;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        //1.匿名内部类方法
        method(new Swim() {
            @Override
            public void swimming() {
                System.out.println("正在利用匿名内部类方法游泳");
            }
        });
        //2.Lambda方法
        method(()->{
            System.out.println("正在利用lambda方法游泳");
        });
        //3.Lambda省略写法
        Integer []arr={1,3,7,4,2};
        Arrays.sort(arr,((o1, o2) -> o2-o1));
        System.out.println(Arrays.toString(arr));

    }
    public static void method(Swim s){
        s.swimming();
    }

}
//只能用于只有一个方法的接口
@FunctionalInterface
interface Swim{
    public abstract void swimming();
}

