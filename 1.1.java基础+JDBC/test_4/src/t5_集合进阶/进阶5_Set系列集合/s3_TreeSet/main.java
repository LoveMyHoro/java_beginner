package t5_集合进阶.进阶5_Set系列集合.s3_TreeSet;

import com.sun.source.tree.Tree;
import t5_集合进阶.进阶5_Set系列集合.s1_HashSet.Student;

import java.util.TreeSet;

public class main {
    public static void main(String[] args) {
        Student s1=new Student("明日香",11);
        Student s2=new Student("赫萝",22);
        Student s3=new Student("able",24);
        TreeSet<Student> t=new TreeSet<>();
        t.add(s1);
        t.add(s2);
        t.add(s3);
        System.out.println(t);
    }
}
