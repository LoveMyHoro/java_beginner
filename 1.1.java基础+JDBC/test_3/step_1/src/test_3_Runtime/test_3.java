package test_3_Runtime;

import java.io.IOException;

public class test_3 {
    public static void main(String args[]) throws IOException {
        //1.获取Runtime对象
        Runtime r=Runtime.getRuntime();
        //r.exit(0);//相当于System.exit(0)
        System.out.println(r.maxMemory()/1024/1024);
        r.exec("shutdown -a");
        new test_3_2();
    }

}
