package t9_io流.j6_综合练习.练习_4_登陆注册;

import java.io.*;
import java.util.Random;

public class UserCreate {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            CreateUser();
        }

    }
    public static  void CreateUser() throws IOException {
        File file=new File("F:\\java\\userinfo.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        Random r = new Random();
        String username="";
        String password="";
        for (int i = 0; i < r.nextInt(4, 8); i++) {
            int i1 = 'a' + r.nextInt(26);
            username+=(char) i1;
        }
        for (int i = 0; i < r.nextInt(3, 8); i++) {
            password+=r.nextInt(9);
        }
        System.out.println(username);
        System.out.println(password);
        bw.write("username="+username+"&password="+password+"&count="+0);
        bw.newLine();
        bw.close();
    }
}
