package test_12_捕获分组和非捕获分组;
public class Api_捕获分组 {
    public static void main(String[] args) {
        //捕获分组关键词：一致
        //需求1:判断一个字符串的开始字符和结束字符是否一致?只考虑一个字符
        // 举例: a123a b456b 17891 &abc& a123b(false)
        //"\\组号"表示把第X组的内容拿出来再用一次
        String regex="(.).+\\1";
        System.out.println("a123a".matches(regex));
        System.out.println("a123b".matches(regex));



        //需求2:判断一个字符串的开始部分和结束部分是否一致?可以有多个字符
        //举例: abc123abc b456b 123789123 &!@abc&!@ abc123abd(false)
        String regex2="(.+).+\\1";
        System.out.println("abc123abc".matches(regex2));
        System.out.println("abc123abd".matches(regex2));



        //需求3:判断一个字符串的开始部分和结束部分是否一致?开始部分内部每个字符也需要一致
        //举例: aaa123aaa bbb456bbb 111789111 &&abc&&
        //(.):把首字母看做一组
        // \\2:把首字母拿出来再次使用
        // *:作用于\\2,表示后面重复的内容出现0次或多次
        String regex3="((.)\\2*).+\\1";
        System.out.println("aaa123aaa".matches(regex3));
        System.out.println("aaa123aab".matches(regex3));
        //注：这里重复的组号要为2,因为扩了两个括号，以左括号的顺序为准

        //需求4.将字符串：我要学学编编编编程程程程程程，替换为：我要学编程
        //这里引入$
        String s1="我要学学编编编编程程程程程程";
        String regex4="(.)\\1+";//注："\\1"表示重复字符再次出现，"+"表示重复字符至少出现一次
        String result=s1.replaceAll(regex4,"$1");//注：$1表示在组外用第一组的内容
        System.out.println(result);

        //小结
        //正则内部使用：\\组号
        //正则外部使用：$组号



    }
}
