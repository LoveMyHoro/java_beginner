package test_10_爬虫;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 练习_1_本地爬取 {
    public static void main(String[] args) {
        //1.待搜索的对象str
        String str="Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11" +
                "因为这两个是长期支持的版本，下一个长期支持的版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";
        //2.获取正则表达式的对象
        Pattern p=Pattern.compile("((?i)java)\\d{0,2}");
        //3.获取文本匹配器的对象，拿着m去读取str，找符合p规则的子串
        Matcher m=p.matcher(str);
        //4.m.find在搜索到匹配的结果时会返回true，并且在底层记录起始索引和结束索引位置+1
        //如果要搜索所有的结果，则利用循环直到m.find()返回false为止,此时已经搜索完毕
        while(m.find()){
            //5.这里会对m.find底层记录的索引进行截取。正因为这里包头不包尾才在记录结束位置时+1
            String s=m.group();
            System.out.println(s);
        }

    }
}
