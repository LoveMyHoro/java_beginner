package t9_io流.j2_字符流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 知识点_7_练习 {
    public static void main(String[] args) throws IOException {
        FileWriter file=new FileWriter("C:\\Users\\iove\\OneDrive\\桌面\\java.txt");
        char []arr={'a','a','a'};
        file.write("元神，启动！",2,2);
        file.write('好');
        file.write(arr);
        file.close();
    }
}
