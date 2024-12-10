package test_5_Object_Clone;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        int []arr={1,2,3,4,5,6};
        User u1=new User("明日香",18,"eve",arr);

        User u2=(User)u1.clone();
        //因为重写了toString方法，可以不返回对象的地址而返回对象值
        System.out.println(u1);
        System.out.println(u2);
        //重写后的拷贝方法
        User u3=(User) u1.clone();
        int []arr2=u3.getData();
        arr2[0]=66;
        System.out.println(u1);
        System.out.println(u3);
        //利用第三方代码克隆
        Gson gson=new Gson();
        //把对象变成一个字符串
        String s=gson.toJson(u1);
        System.out.println(s);
        //再把字符串变成对象。
        //s是字符串，User是要转换成的对象，.class是固定格式
        User u4=gson.fromJson(s,User.class);
        System.out.println(u4);


    }
}
