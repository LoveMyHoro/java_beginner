package t9_io流.j3_高级流.g3_序列化流与反序列化流_将java中的对象写到本地文件中.练习;

import java.io.*;
import java.util.ArrayList;

public class 练习_1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //如果一次需要序列化多个对象，通常把对象添加到集合中，然后把集合序列化
        oos();
        ois();
    }

    private static void ois() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("F:\\java\\oos.txt"));
        ArrayList<Student>list=(ArrayList<Student>) ois.readObject();
        System.out.println(list);
    }

    private static void oos() throws IOException {
        Student s1=new Student("明日香",17);
        Student s2=new Student("赫萝",15);
        Student s3=new Student("战场原",17);
        ArrayList<Student>list=new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        ObjectOutputStream  oos=new ObjectOutputStream(new FileOutputStream("F:\\java\\oos.txt"));
        oos.writeObject(list);
        oos.close();
    }

}
