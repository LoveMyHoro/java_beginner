package t9_io流.j6_综合练习.练习_3_随机点名器;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class 练习_5_2 {
    public static void main(String[] args) throws IOException {
        //地址：F:\java\ClassName.txt
        //男生：30，女生：30;
        GetName();
    }

    private static void GetName() throws IOException {
        File file=new File("F:\\java\\ClassName.txt");
        ArrayList<Student>list=new ArrayList<>();
        double []arr=GetWeight(file,list);
        Random r=new Random();
        double range=r.nextDouble(1);
        System.out.println(range);
        //使用Arrays方法中的二分查找法，返回的是：-插入点-1
        //虽然这个数据在arr数组中不存在，但插入点就相当于范围
        int index= -(Arrays.binarySearch(arr,range)+1);
        Student stu=list.get(index);
        System.out.println(stu);
        double w=stu.getWeight()/2;
        stu.setWeight(w);
    }



    private static double[] GetWeight(File file,ArrayList<Student>list) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String name;
        while((name=br.readLine())!=null){
            String []arr=name.split("-");
            list.add(new Student(arr[0],arr[1],Integer.parseInt(arr[2]),Double.parseDouble(arr[3])));
        }
        double []WeightArr=new double[list.size()];

        for (int i = 0; i < list.size(); i++) {
            WeightArr[i]=list.get(i).getWeight()/list.size();
        }
        System.out.println();
        for (int i = 1; i < list.size(); i++) {
            WeightArr[i]=WeightArr[i]+WeightArr[i-1];
        }
        br.close();
        return  WeightArr;
    }
}
