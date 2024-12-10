package t1_集合进阶.进阶7_双列集合.s4_TreeMap.练习_2;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Random r=new Random();
        char []arr={'a','A'};
        ArrayList <Character>list=new ArrayList<>();
        for(int i=0;i<80;i++){
            char temp=(char)(arr[r.nextInt(2)]+r.nextInt(26));
            list.add(temp);
        }
        TreeMap <Character,Integer>treeMap=new TreeMap<>();
        for(char temp:list){
            if(treeMap.containsKey(temp)){
                int num=treeMap.get(temp)+1;
                treeMap.put(temp,num);
            }
            else{
                treeMap.put(temp,0);
            }
        }
        treeMap.forEach((key,value)->{
            System.out.print(key+"("+value+")");
        });
    }
}
