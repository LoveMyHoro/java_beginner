package t1_集合进阶.进阶7_双列集合.s4_TreeMap.练习_1;

import t1_集合进阶.进阶7_双列集合.s2_HashMap.练习_1.Student;

import java.util.Comparator;
import java.util.TreeMap;

public class main_2 {
    public static void main(String[] args) {
        Student s1=new Student("mrx",11);
        Student s2=new Student("holo",15);
        Student s3=new Student("kkl",9);
        TreeMap<Student,String>treeMap=new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int i=o1.getAge()-o2.getAge();
                i=i==0?o1.getName().compareTo(o2.getName()):i;
                return i;
            }
        });
        treeMap.put(s1,"河南");
        treeMap.put(s2,"北京");
        treeMap.put(s3,"山东");
        System.out.println(treeMap);
    }
}
