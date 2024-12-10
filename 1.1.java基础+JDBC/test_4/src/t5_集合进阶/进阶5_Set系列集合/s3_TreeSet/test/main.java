package t5_集合进阶.进阶5_Set系列集合.s3_TreeSet.test;

import java.util.TreeSet;

public class main {
    public static void main(String[] args) {
        Student2 s1=new Student2("Asuka",17,90,50,91);
        Student2 s2=new Student2("Holo",15,102,97,55);
        Student2 s3=new Student2("zhanc",18,19,20,21);
        Student2 s4=new Student2("able",24,2,86,99);
        TreeSet<Student2> t=new TreeSet<>();
        t.add(s1);
        t.add(s2);
        t.add(s3);
        t.add(s4);
        for(Student2 temp:t){
            System.out.println(temp);
        }
    }
}
