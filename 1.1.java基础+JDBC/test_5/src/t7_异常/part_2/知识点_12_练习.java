package t7_异常.part_2;

import javax.xml.transform.sax.SAXSource;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

public class 知识点_12_练习 {
    public static void main(String[] args) {
        //1.第一问:如果try中没有问题则正常执行
        //2.第二问:如果try中遇到多个问题时，要写多个catch与之对应,但一次只能捕获一个异常
        //注意点：如果我们要捕捉多个异常，这些异常中存在父子关系的话，那么父类一定要写在下面。因为多态
        //3.第三问:没有捕获时就使用jvm虚拟机默认的处理方式，抛出异常
        //4.第四问:不会
        int []arr={1,2,3,4,5};
        try{
            System.out.println(arr[10]);
            System.out.println(2/0);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界异常");
        }catch (Exception e){
            System.out.println("除数不为0");
        }
        System.out.println("运行结束");
    }
}
