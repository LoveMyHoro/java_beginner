package t6_方法引用.练习;

import t6_方法引用.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 练习_2 {
    public static void main(String[] args) {
        Student s1=new Student("明日香",17);
        Student s2=new Student("战场原",16);
        Student s3=new Student("赫萝",15);
        ArrayList<Student>list=new ArrayList<>();
        Collections.addAll(list,s1,s2,s2);
        //使用类名方法引用成员函数
        String []arr=list.stream().map(Student::getName).toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }
}
