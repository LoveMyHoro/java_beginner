package t4_Lambda表达式_简化函数式接口的匿名内部类的代码.综合练习;

import java.util.Arrays;

public class test_1 {
    public static void main(String[] args) {
        girl g1=new girl("Aing",15,172);
        girl g2=new girl("Ming",14,188);
        girl g3=new girl("Zhang",17,169);
        girl []arr={g1,g2,g3};
        Arrays.sort(arr,((o1, o2) -> {
            double temp=o1.getAge()-o2.getAge();
            temp=temp==0?o1.getHeight()-o2.getHeight():temp;
            temp=temp==0?o1.getName().compareTo(o2.getName()):temp;
            if(temp>0){
                return 1;
            }
            else if(temp<0){
                return -1;
            }
            else{
                return 0;
            }
        }));
        System.out.println(Arrays.toString(arr));

    }
}
