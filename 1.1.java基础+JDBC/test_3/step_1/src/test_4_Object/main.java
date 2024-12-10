package test_4_Object;

public class main {


    public static void main(String[] args) {
        //1.Object中未重写的toString方法返回的是地址值
        Object obj =new Object();
        String str1=obj.toString();
        System.out.println(str1);

        //2.toString重写后返回属性值
        Student stu=new Student("明日香",18);
        String s=stu.toString();
        System.out.println(s);

        //3.equals重写后比较的是属性值而不是地址值
        Student s1=new Student();
        Student s3=new Student();
        System.out.println(s3.equals(s1));


    }

}
