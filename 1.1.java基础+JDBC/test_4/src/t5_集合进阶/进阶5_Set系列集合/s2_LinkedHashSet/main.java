package t5_集合进阶.进阶5_Set系列集合.s2_LinkedHashSet;

import t5_集合进阶.进阶5_Set系列集合.s1_HashSet.Student;

import java.util.LinkedHashSet;

public class main {
    public static void main(String[] args) {
        LinkedHashSet <Student>hs1=new LinkedHashSet<>();
        Student s1=new Student("明日香",11);
        Student s2=new Student("赫鲁普",12);
        Student s3=new Student("赫萝",15);
        Student s4=new Student("kks",16);
        hs1.add(s1);
        hs1.add(s2);
        hs1.add(s3);
        hs1.add(s4);
        System.out.println(hs1);
    }
}
