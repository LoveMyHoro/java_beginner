package t9_io流.j6_综合练习.练习_2_Hutool包制作假数据;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.*;

public class HutCreate {
    public static void main(String[] args) {
        String SurnameNet="https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d";
        String ManNameNet="http://www.haoming8.cn/baobao/10881.html";
        String WomenNameNet="http://www.haoming8.cn/baobao/7641.html";
        String Surname= HttpUtil.get(SurnameNet);
        String ManName=HttpUtil.get(ManNameNet);
        String WomenName=HttpUtil.get(WomenNameNet);
        List<String>SureList= ReUtil.findAll("([^a-zA-Z]{4})(，|。)",Surname,1);
        List<String>ManList=ReUtil.findAll("([\\u4E00-\\u9FA5]{2})(、)",ManName,1);
        List<String>WomenList=ReUtil.findAll("(.. ){4}..",WomenName,0);

        SureList.remove(SureList.size()-1);
        SureList.remove(SureList.size()-1);
        ArrayList<String> list1=new ArrayList<>();
        for (String string : SureList) {
            for (int i = 0; i < string.length(); i++) {
                list1.add(string.charAt(i)+"");
            }
        }
        ArrayList<String>list2=new ArrayList<>();
        for (String string : ManList) {
            if(!list2.contains(string)){
                list2.add(string);
            }
        }
        ArrayList list3=new ArrayList<>();
        for (String string : WomenList) {
            String []arr=string.split(" ");
            for (int i = 0; i < arr.length; i++) {
                list3.add(arr[i]);
            }
        }
        //4.获取姓名
        ArrayList<String>list=CreateName(list1, list2, list3, 5, 5);
        Collections.shuffle(list);
        System.out.println(list);
        FileUtil.writeLines(list,"F:\\java\\ClassName.txt","UTF-8");
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
}
