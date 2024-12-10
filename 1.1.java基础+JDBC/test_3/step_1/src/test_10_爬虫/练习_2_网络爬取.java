package test_10_爬虫;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 练习_2_网络爬取 {
    public static void main(String[] args) throws IOException {
        URL ur1=new URL("https://prts.wiki/w/%E9%A6%96%E9%A1%B5");
        URLConnection conn=ur1.openConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        String regex="乌尔比安.{0,}";
        Pattern pattern=Pattern.compile(regex);
        while((line=br.readLine())!=null){
            Matcher matcher=pattern.matcher(line);
            while (matcher.find()){
                System.out.println(matcher.group());
            }
        }
        br.close();

    }
}
