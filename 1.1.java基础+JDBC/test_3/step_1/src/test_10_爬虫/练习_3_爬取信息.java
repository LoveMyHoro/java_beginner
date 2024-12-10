package test_10_爬虫;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 练习_3_爬取信息 {
    public static void main(String[] args) {
/*
需求：

​	把下面文本中的座机电话，邮箱，手机号，热线都爬取出来。

来黑马程序员学习Java，手机号:18512516758，18512508907或者联系邮箱:boniu@itcast.cn，
座机电话:01036517895，010-98951256邮箱:bozai@itcast.cn，
热线电话:400-618-9090 ，400-618-4000，4006184000，4006189090
 */
        String str="来黑马程序员学习Java，手机号:18512516758，18512508907或者联系邮箱:boniu@itcast.cn，\n" +
                "座机电话:01036517895，010-98951256邮箱:bozai@itcast.cn，\n" +
                "热线电话:400-618-9090 ，400-618-4000，4006184000，4006189090";

        String regex1="1[3-9]\\d{9}";
        String regex2="\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}";
        String regex3="θ\\d{2,3}-?[1-9]\\d{4,9}";
        String regex4="400-?[1-9]\\d{2}-?[1-9]\\d{3}";

        String regex=regex1+"|"+regex2+"|"+regex3+"|"+regex4;

        Pattern pattern=Pattern.compile(regex);
        Matcher m=pattern.matcher(str);
        while (m.find()){
            String s=m.group();
            System.out.println(s);
        }

    }
}
