package t9_io流.j6_综合练习.练习_5_配置文件;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class 知识点_4_基本操作 {
    public static void main(String[] args) {
        //1.创建集合的对象
        Properties prop=new Properties();
        //2.添加数据
        //细节：虽然我们可以往Properties中添加任意的数据类型，但是一般只会添加字符串
        prop.put("aaa","bbb");
        prop.put("ccc","ddd");
        //3.遍历
        //（1）键找值
        Set<Object>keys=prop.keySet();
        for (Object key : keys) {
            System.out.println(prop.get(key));
        }
        //（2）键值对
        Set<Map.Entry<Object,Object>>entrys=prop.entrySet();
        for (Map.Entry<Object, Object> entry : entrys) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
