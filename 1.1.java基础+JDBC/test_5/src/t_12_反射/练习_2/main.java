package t_12_反射.练习_2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class main {
    public static void main(String[] args) throws IOException {
        //读取配置文件中的信息
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("src\\t_12_反射\\练习_2\\prop.properties");
        prop.load(fis);
        fis.close();
        System.out.println(prop);

    }
}
