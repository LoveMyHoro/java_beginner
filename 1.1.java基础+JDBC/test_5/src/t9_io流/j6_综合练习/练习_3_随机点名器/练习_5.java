package t9_io流.j6_综合练习.练习_3_随机点名器;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class 练习_5 {
    public static void main(String[] args) throws IOException {
        for(int i=0;i<100;i++){
            GetName();
        }
    }

    private static void GetName() throws IOException {
        File file=new File("F:\\java\\ClassName.txt");
        BufferedReader br=new BufferedReader(new FileReader(file));
        ArrayList<Student>list=new ArrayList<>();
        String s;
        while((s=br.readLine())!=null){
            String []arr=s.split("-");
            list.add(new Student(arr[0],arr[1],Integer.parseInt(arr[2]),Double.parseDouble(arr[3])));
        }
        br.close();
        double []weightArr=new double[list.size()];
        double sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i).getWeight();
        }
        for (int i = 0; i < list.size(); i++) {
            weightArr[i]=list.get(i).getWeight()/sum;
        }
        for(int i=1;i<weightArr.length;i++){
            weightArr[i]=weightArr[i]+weightArr[i-1];
        }
        System.out.println(Arrays.toString(weightArr));

        double range=Math.random();
        System.out.println(range);
        int index=-Arrays.binarySearch(weightArr,range)-1;
        double w=list.get(index).getWeight()/2;
        list.get(index).setWeight(w);
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        for (Student student : list) {
            bw.write(student.toString());
            bw.newLine();
        }
        bw.close();
    }
}
