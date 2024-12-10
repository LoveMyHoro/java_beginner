package t9_io流.j3_高级流.g3_序列化流与反序列化流_将java中的对象写到本地文件中;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class 知识点_2_练习 {
    public static void main(String[] args) throws IOException {
        Student s1=new Student("明日香",17,"南京");
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("F:\\java\\oos.txt"));
        oos.writeObject(s1);
        oos.close();
    }
}
