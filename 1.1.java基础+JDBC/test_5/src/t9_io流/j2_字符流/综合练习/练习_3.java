package t9_io流.j2_字符流.综合练习;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class 练习_3 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader=new FileReader("C:\\Users\\iove\\OneDrive\\桌面\\test\\java.txt");
        int b;
        StringBuilder sb=new StringBuilder();
        while((b=fileReader.read())!=-1){
            sb.append((char)b);
        }
        fileReader.close();
        Integer []arr=Arrays.stream(sb.toString().split("-"))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);
        String s=Arrays.toString(arr).replace(", ","-");
        String result=s.substring(1,s.length()-1);
        System.out.println(result);
        FileWriter fileRWriter= new FileWriter("C:\\Users\\iove\\OneDrive\\桌面\\test\\copy.txt");
        fileRWriter.write(result);
        fileRWriter.close();
    }
}
