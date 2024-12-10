package t9_io流.j3_高级流.g1_缓冲流.h3_练习;

import javax.annotation.processing.Filer;
import java.io.*;
import java.util.*;

public class 练习_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new FileReader("F:\\java\\csb.txt") {
        });
        BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter("F:\\copy\\csb.txt"));
        String len;
        ArrayList<String> list=new ArrayList<>();
        while((len= bufferedReader.readLine())!=null){
            list.add(len);
        }
        //重写排序方法
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num1=Integer.parseInt(o1.split("\\.")[0]);
                int num2=Integer.parseInt(o2.split("\\.")[0]);
                return num1-num2;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            bufferedWriter.write(list.get(i));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();
        //第二种排序方法：利用TreeMap
        BufferedReader bufferedReader2= new BufferedReader(new FileReader("F:\\java\\csb.txt"));
        BufferedWriter bufferedWriter2= new BufferedWriter(new FileWriter("F:\\copy\\csb2.txt"));
        TreeMap<Integer,String>map=new TreeMap<>();
        while((len= bufferedReader2.readLine())!=null){
            map.put(Integer.parseInt(len.split("\\.")[0]),len);
        }
        Set<Integer>set=map.keySet();
        Iterator<Integer>iterator=set.iterator();
        while(iterator.hasNext()){
            bufferedWriter2.write(map.get(iterator.next()));
            bufferedWriter2.newLine();
        }
        bufferedWriter2.close();
        bufferedReader2.close();
    }
}
