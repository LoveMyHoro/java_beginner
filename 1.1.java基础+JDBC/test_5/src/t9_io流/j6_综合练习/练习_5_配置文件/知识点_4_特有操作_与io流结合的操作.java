package t9_io流.j6_综合练习.练习_5_配置文件;

import java.io.*;
import java.util.Properties;

public class 知识点_4_特有操作_与io流结合的操作 {
    public static void main(String[] args) throws IOException {
        //1.写入
        Properties prop=new Properties();
        prop.put("aaa","111");
        prop.put("bbb","222");
        prop.put("ccc","333");
        BufferedWriter bw=new BufferedWriter(new FileWriter("java\\a.properties"));
        prop.store(bw,"test");
        bw.close();
        //2.读取
        Properties prop2=new Properties();
        BufferedReader br=new BufferedReader(new FileReader("java\\a.properties"));
        prop2.load(br);
        br.close();
        System.out.println(prop2);
    }
}
