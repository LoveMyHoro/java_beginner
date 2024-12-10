package t7_异常.练习;

import jdk.dynalink.linker.GuardedInvocationTransformer;

import java.util.Scanner;
//快捷键：ctrl+alt+t
public class 练习_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                Girl g1 = new Girl();
                System.out.println("请输入姓名");
                String name = sc.next();
                g1.setName(name);
                System.out.println("请输入年龄");
                String age = sc.next();
                g1.setAge(Integer.parseInt(age));
                //没问题时跳出
                break;
            } catch (NumberFormatException e) {
                System.out.println("年龄格式有误，请重新输入");
            }catch (RuntimeException e){
                System.out.println("姓名或年龄有误。请重新输入");
            }
        }
        System.out.println("成功运行");
    }

}
