package test_9_正则表达式;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //这是老方法查找qq号
        //qqCheck();
        //1.运用正则表达式----字符串类
        System.out.println("a".matches("[abc]"));
        System.out.println("z".matches("[abc]"));
        //一个[]只匹配一个字符
        System.out.println("ab".matches("[abc]"));
        //可以判断两个字符
        System.out.println("ab".matches("[abc][abc]"));
        System.out.println("------------------------------");
        //判断范围
        System.out.println("a".matches("[a-zA-Z]"));
        System.out.println("ab".matches("[a-zA-Z][a-zA-Z]"));
        //判断数字字符
        System.out.println("2".matches("[0-9]"));

        System.out.println("----------------------------");
        //2.运用正则表达式----预定义字符（一个预定义字符只匹配一个字符）
        //补充：在java中 "\"代表转义字符，改变后面那个字符原本的含义
        //eg
        System.out.println("\"");
        //1.一个预定义字符匹配一个字符
        System.out.println("你".matches(".."));
        System.out.println("你好".matches(".."));
        //2. 由于"\"是转义字符，所以要写成 \\d
        System.out.println("32".matches("\\d\\d"));

        System.out.println("------------------------------");
        //3.运用正则表达式----校验多个字符
        System.out.println("adadwr".matches("\\w{6,}"));
        System.out.println("adad".matches("\\w{6,}"));
        //


    }

    private static void qqCheck() {
        System.out.println("请输入qq号：");
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        while(true){
            int ln=str.length();
            if(ln<6||ln>20){
                System.out.println("长度错误，请重新输入！");
            } else if (str.charAt(0)=='0') {
                System.out.println("0不能在开头！请重新输入");
            } else{
                int temp=1;
                for(int i=0;i<ln;i++){
                    if(str.charAt(i)<'0'||str.charAt(i)>'9'){
                        System.out.println("必须是全数字！请重新输入");
                        temp=0;
                        break;
                    }
                }
                if(temp==1){
                    break;
                }
            }
            System.out.println("请输入qq号：");
            str=sc.next();
        }
        System.out.println("输入成功！您的qq号是:"+str);
    }
}
