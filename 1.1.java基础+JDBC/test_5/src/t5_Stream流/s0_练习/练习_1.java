package t5_Stream流.s0_练习;

import java.util.ArrayList;

public class 练习_1 {
    public static void main(String[] args) {
        ArrayList<String>list=new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        //利用stream流解决
        list.stream().filter(name->name.startsWith("张")).filter(name->name.length()==3).forEach(name-> System.out.println(name));
    }
}
