package t1_集合进阶.进阶7_双列集合.s2_HashMap.练习_1;

import java.util.*;
/*
练习：80个学生投票要去的景点（A，B，C，D），找到得票数最多的景点
 */
public class main {
    public static void main(String[] args) {

        String []arr={"A","B","C","D"};
        Random r=new Random();
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<80;i++){
            list.add(arr[r.nextInt(4)]);
            //System.out.printf(list.get(i));
        }
        HashMap<String,Integer>map=new HashMap<>();
        for(String name:list){
            if(map.containsKey(name)){
                Integer num=map.get(name)+1;
                map.put(name,num);
            }
            else{
                map.put(name,0);
            }
        }
        System.out.println(map);
    }
}
