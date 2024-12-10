package t7_异常.part_2;

public class 知识点_15_练习 {
    public static void main(String[] args) {
        //定义数组求最大值
        int []arr=null;
        int max=0;
        try{
            max=getMax(arr);
        }catch (NullPointerException e){
            System.out.println("空指针异常");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("索引越界异常");
        }
        System.out.println(max);
    }

    private static int getMax(int[] arr) {
        if(arr==null){
            //手动创建异常对象,把这个异常交给方法调用者处理
            //此时方法的调用就会结束，下面的代码就不会被调用了
            //
            throw new NullPointerException();
        }
        if(arr.length==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        System.out.println("看看我执行了吗");
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}
