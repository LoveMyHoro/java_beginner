package t2_集合综合练习.练习_4;

import java.lang.reflect.Array;
import java.util.*;

public class main {
    public static void main(String[] args) {
        ArrayList<String>list1=new ArrayList<>();
        Collections.addAll(list1,"南京市","扬州市","苏州市");
        ArrayList<String>list2=new ArrayList<>();
        Collections.addAll(list2,"武汉市","孝感市","十堰市");
        ArrayList<String>list3=new ArrayList<>();
        Collections.addAll(list3,"石家庄市","唐山市","邢台市");
        HashMap<String,ArrayList<String>>map=new HashMap<>();
        map.put("江苏省",list1);
        map.put("湖北省",list2);
        map.put("河北省",list3);
        Set<Map.Entry<String,ArrayList<String>>>set=map.entrySet();
        for(Map.Entry<String,ArrayList<String>> entry:set){
            String key=entry.getKey();
            ArrayList<String> value=entry.getValue();
            StringJoiner sj=new StringJoiner(",","","");
            for(String temp:value){
                sj.add(temp);
            }
            System.out.println(key+"="+sj);
        }
    }
}
