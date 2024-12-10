package t5_集合进阶.进阶5_Set系列集合.s1_HashSet;

public class main {
    public static void main(String[] args) {
        Student s1=new Student("明日香",11);
        Student s2=new Student("明日香",11);
        //重写后的HasCode方法
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        //哈希碰撞例子
        System.out.println("abc".hashCode());
        System.out.println("acD".hashCode());
    }
}
