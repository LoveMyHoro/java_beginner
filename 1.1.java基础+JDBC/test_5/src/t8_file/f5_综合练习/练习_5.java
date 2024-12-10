package t8_file.f5_综合练习;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 练习_5 {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\iove\\OneDrive\\桌面\\垃圾桶");
        Map<String,Integer>map=Find(file);
        System.out.println(map);
    }
    public static Map<String,Integer> Find(File src){
        if(src==null){
            return null;
        }
        Map<String,Integer>map=new HashMap<>();
        File []files=src.listFiles();
        for (File file : files) {
            if(file.isFile()){
                String name=file.getName();
                String []arr=name.split("\\.");
                if(arr.length>=2){
                    String endName=arr[arr.length-1];
                    if(map.containsKey(endName)){
                        map.put(endName,map.get(endName)+1);
                    }
                    else{
                        map.put(endName,1);
                    }
                }
            }
            else{
                Map<String,Integer>sonMap=Find(file);
                Set<Map.Entry<String,Integer>>entries=sonMap.entrySet();
                for (Map.Entry<String, Integer> entry : entries) {
                    String key=entry.getKey();
                    int value=entry.getValue();
                    if(map.containsKey(key)){
                        map.put(key,map.get(key)+value);
                    }
                    else{
                        map.put(key,value);
                    }
                }
            }
        }
        return map;



    }
}
