package t7_异常.part_2;

public class 知识点_14_练习 {
    public static void main(String[] args) {
            //一般使用printStackTrace
            //在底层是利用System.err.println()进行输出，把异常的错误信息以红色的字体输出在控制台
            //细节：仅仅是打印信息，不会停止程序的运行
            int []arr={1,2,3,4,5};
                try{
                    System.out.println(arr[10]);
                }catch (ArrayIndexOutOfBoundsException e){
                    //(1)getMessage方法
                    /*
                    String message=e.getMessage();
                    System.out.println(message);
                    */
                    //(2)toString方法
                    /*String str=e.toString();
                    System.out.println(str);
                    */
                    //(3)printStackTrace方法
                    e.printStackTrace();
                }
                System.out.println("我运行了");

                //补充了解的知识：
                //错误的输出语句（用来打印错误信息）
                System.err.println("打印的错误信息");



    }

}
