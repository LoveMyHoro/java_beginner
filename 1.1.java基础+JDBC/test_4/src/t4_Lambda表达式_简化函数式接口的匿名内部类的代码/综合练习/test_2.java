package t4_Lambda表达式_简化函数式接口的匿名内部类的代码.综合练习;

public class test_2  {
    public static void main(String[] args) {
        System.out.println(Method(20));
    }

    private static int Method(int i) {
        if(i==1){
            return 1;
        }
        else if(i==2){
            return 2;
        }
        else if(i==3){
            return 4;
        }
        return Method(i-1)+Method(i-2)+Method(i-3);
    }
}
