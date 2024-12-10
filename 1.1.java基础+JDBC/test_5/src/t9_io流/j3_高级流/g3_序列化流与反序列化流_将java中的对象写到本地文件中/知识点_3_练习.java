package t9_io流.j3_高级流.g3_序列化流与反序列化流_将java中的对象写到本地文件中;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class 知识点_3_练习 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("F:\\java\\oos.txt"));
        Student student=(Student) ois.readObject();
        System.out.println(student.getName()+","+student.getAge()+","+student.getAddress());
        ois.close();
    }
}
