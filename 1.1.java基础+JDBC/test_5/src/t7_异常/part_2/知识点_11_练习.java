package t7_异常.part_2;

public class 知识点_11_练习 {
    public static void main(String[] args) {
        int []arr={1,2,3,4};
        try{
            System.out.println(arr[10]);
            //此处出现了异常程序就会在这里创建一个ArrayIndexOutOfBoundsException对象
            //拿着这个对象到catch的小括号中对比，看括号中的变量是否可以接收这个对象
            //如果可以接收，就表明该异常被捕获，执行catch里面对应的代码
        }catch (ArrayIndexOutOfBoundsException e){

            System.out.println("异常处理成功");
        }
        System.out.println("看我运行了吗");
    }
}
