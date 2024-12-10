package t6_方法引用.练习;

import t6_方法引用.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 练习_1 {
    public static void main(String[] args) {
        ArrayList<String>list=new ArrayList<>();
        Collections.addAll(list,"明日香,17","赫萝,15","战场原,17");
        List<Student> newlist=list.stream().map(Student::new).collect(Collectors.toList());
        System.out.println(newlist);
    }
}
