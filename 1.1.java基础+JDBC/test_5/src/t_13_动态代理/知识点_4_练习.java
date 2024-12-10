package t_13_动态代理;

public class 知识点_4_练习 {
    public static void main(String[] args) {
        //1.获取代理对象
        BigStar bigStar=new BigStar("鸡哥");
        Star proxy = ProxyUtil.createProxy(bigStar);

        //2.调用代理的方法
        String result=proxy.sing("鸡你太美");
        System.out.println(result);
    }
}
