package test_11_爬虫进阶应用;

import java.lang.classfile.attribute.SignatureAttribute;

public class Api_正则表达式在字符串方法中的应用 {
    public static void main(String[] args) {
        //1.具体有哪几个方法见图片
        //2.具体见test方法
        test();
        //3.判断一个方法是否识别正则表达式就看它的参数中是否有regex
    }
    public static void test(){
        /*
            有一段字符串:小诗诗dqwefqwfqwfwq12312小丹丹dqwefqwfqwfwq12312小惠惠
            要求1:把字符串中三个姓名之间的字母替换为vs
            要求2:把字符串中的三个姓名切割出来
            */
        String s="小诗诗dqwefqwfqwfwq12312小丹丹dqwefqwfqwfwq12312小惠惠";
        //1.replaceAll方法
        //细节:
        //方法在底层跟之前一样也会创建文本解析器的对象
        //然后从头开始去读取字符串中的内容，只要有满足的，那么就切割。
        String regex="[\\w&&[^_]]+";
        String result=s.replaceAll(regex,"vs");
        System.out.println(result);
        //2.split方法
        String []result2=result.split("[vs]");
        for (int i = 0; i < result2.length; i++) {
            System.out.println(result2[i]);
        }

    }
}
