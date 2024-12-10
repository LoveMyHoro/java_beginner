package t9_io流.j6_综合练习.练习_1_网络爬虫_制造假数据;

import org.w3c.dom.ls.LSInput;

import javax.xml.transform.Source;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//百家姓网址：https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d
//男生名字：http://www.haoming8.cn/baobao/10881.html
//女生名字：http://www.haoming8.cn/baobao/7641.html
public class main {
    public static void main(String[] args) throws IOException {
        String SurnameNet="https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d";
        String ManNameNet="http://www.haoming8.cn/baobao/10881.html";
        String WomenNameNet="http://www.haoming8.cn/baobao/7641.html";
        String SurName=WebCrawler(SurnameNet);
        String ManName=WebCrawler(ManNameNet);
        //System.out.println(ManName);
        String WomenName=WebCrawler(WomenNameNet);
        //1.姓氏处理
        ArrayList<String>SurNameList=Get(SurName,"([^a-zA-Z]{4})(，|。)",1);
        SurNameList.remove(SurNameList.size()-1);
        SurNameList.remove(SurNameList.size()-1);
        ArrayList<String>list1=new ArrayList<>();
        for (String string : SurNameList) {
            for (int i = 0; i < string.length(); i++) {
                list1.add(string.charAt(i)+"");
            }
        }
        //2.处理男生名字
        ArrayList<String>ManNameList=Get(ManName,"([\\u4E00-\\u9FA5]{2})(、)",1);
        ArrayList<String>list2=new ArrayList<>();
        for (String string : ManNameList) {
            if(!list2.contains(string)){
                list2.add(string);
            }
        }
        //System.out.println(list2);
        //3.处理女生
        ArrayList<String>WomenNameList=Get(WomenName,"(.. ){4}..",0);
        ArrayList list3=new ArrayList<>();
        for (String string : WomenNameList) {
            String []arr=string.split(" ");
            for (int i = 0; i < arr.length; i++) {
                list3.add(arr[i]);
            }
        }
        //System.out.println(list3);
        //4.获取姓名
        ArrayList<String>list=CreateName(list1, list2, list3, 10, 10);
        Collections.shuffle(list);
        //写出数据
        BufferedWriter bw=new BufferedWriter(new FileWriter("F:\\java\\Name.txt"));
        for (String string : list) {
            bw.write(string);
            bw.newLine();
        }
        bw.close();


    }

    private static ArrayList<String> CreateName(ArrayList<String>SureList,ArrayList<String>ManList,ArrayList<String>WomanList,int BoyCount,int girlCount) {
        ArrayList<String>NameList=new ArrayList<>();
        HashSet<String> GirlSet=new HashSet<>();
        while(GirlSet.size()<girlCount){
            Collections.shuffle(SureList);
            Collections.shuffle(WomanList);
            GirlSet.add(SureList.get(0)+WomanList.get(0));
        }
        HashSet<String> ManSet=new HashSet<>();
        while(ManSet.size()<BoyCount){
            Collections.shuffle(SureList);
            Collections.shuffle(ManList);
            ManSet.add(SureList.get(0)+ManList.get(0));
        }
        Random r=new Random();
        for (String string : GirlSet) {
            NameList.add(string+"-女-"+(r.nextInt(8)+18));
        }
        for (String string : ManSet) {
            NameList.add(string+"-男-"+(r.nextInt(10)+18));
        }
        return NameList;
    }

    private static ArrayList<String> Get(String Str,String regex,int number) {
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(Str);
        ArrayList<String>list=new ArrayList<>();
        while(matcher.find()){
            //System.out.println(matcher.group(number));
            list.add(matcher.group(number));
        }
        return list;
    }

    public static String WebCrawler(String net) throws IOException {
        StringBuilder sb=new StringBuilder();
        URL url=new URL(net);
        URLConnection con=url.openConnection();
        InputStreamReader isr=new InputStreamReader(con.getInputStream());
        int ch;
        while((ch=isr.read())!=-1){
            sb.append((char)ch);
        }
        isr.close();
        return sb.toString();

    }
}

