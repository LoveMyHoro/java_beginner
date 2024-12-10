package t_12_反射.练习_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class main {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        Student s=new Student("明日香",18,'女',170,"游戏");
        Teacher t=new Teacher("战场原",7200);
        SaveData(s);
    }

    private static void SaveData(Object obj) throws IOException, IllegalAccessException {
        Class aClass = obj.getClass();
        BufferedWriter bw=new BufferedWriter(new FileWriter("F:\\java\\saveData.txt"));
        Field []fields=aClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName()+"="+field.get(obj));
            bw.write(field.getName()+"="+field.get(obj));
            bw.newLine();
        }
        bw.close();



    }
}
