public class 面向对象进阶_6_多态的优势和弊端 {
    //1.多态的优势
    //（1）利于解耦合（比如今天传入的是student，过段时间传入teacher类）
    //（2）利用父类作为参数，可以接收所有子类对象，体现了多态的拓展性和便利
    //2.多态的弊端
    //（1）不能调用子类特有的方法
    //
    //3.解决方法：强制转换
    //eg:Animal a=new Dog()
    //   Dog d=(Dog) a;//因为父类的范围大于子类的范围，只能强转
    //那么问题来了，我们怎么知道要转成什么类型呢?有两种方法
    //答：（1）a instanceof Dog ,如果是，则返回true,再利用 Dog d=(Dog) 强转;如果不是，返回false.
    //   （2）a instanceof Dog b,如果是，则返回true,再把a强转为Dog类型的b;如果不是，返回false.不强转
    //
    //4.具体例子见test_6



}
