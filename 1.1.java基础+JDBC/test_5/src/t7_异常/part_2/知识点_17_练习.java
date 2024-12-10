package t7_异常.part_2;

import t7_异常.练习.Girl;

import java.util.Scanner;

public class 知识点_17_练习 {
    public static void main(String[] args) {
        //自定义NameFormatException和AgeFormatException异常方法
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
                e.printStackTrace();
            }catch (AgeFormatException e){
                e.printStackTrace();
            }catch (NameFormatException e){
                e.printStackTrace();
            }
        }
        System.out.println("成功运行");
    }

}
