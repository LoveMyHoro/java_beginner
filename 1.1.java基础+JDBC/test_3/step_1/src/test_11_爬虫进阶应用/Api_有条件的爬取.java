package test_11_爬虫进阶应用;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Api_有条件的爬取 {
    public static void main(String[] args) {
        String str="Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11" +
                "因为这两个是长期支持的版本，下一个长期支持的版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";
        /*
        需求1：	爬取版本号为8，11.17的Java文本，但是只要Java，不显示版本号。

        需求2：爬取版本号为8，11，17的Java文本。正确爬取结果为：Java8 Java11 Java17 Java17

        需求3：爬取除了版本号为8，11，17的Java文本。
         */
        //补充：
        //?理解为前面的数据Java
        //=表示在Java后面要跟随的数据
        //但是在获取的时候，只获取前半部分
        //1.需求1
        String regex1="((?i)java)(?=8|11|17)";
        //2.需求2
        String regex2="((?i)java)(?:8|11|17)";
        //3.需求3
        String regex3="((?i)java)(?!8|11|17)";

        Pattern pattern=Pattern.compile(regex1);
        Matcher matcher= pattern.matcher(str);
        while(matcher.find()){
            String s=matcher.group();
            System.out.println(s);
        }
    }
}
