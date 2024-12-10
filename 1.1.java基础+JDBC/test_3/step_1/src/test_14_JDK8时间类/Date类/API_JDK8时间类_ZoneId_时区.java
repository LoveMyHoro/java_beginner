package test_14_JDK8时间类.Date类;

import java.time.ZoneId;
import java.util.Set;

public class API_JDK8时间类_ZoneId_时区 {
        public static void main(String[] args) {
        //ZoneId类:时区
        //（1）获取所有时区名称
        Set<String> zoneIds= ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds);
        System.out.println(zoneIds.size());
        //（2）获取当前默认时区
        ZoneId zoneId=ZoneId.systemDefault();
        System.out.println(zoneId);
        //（3）获取指定的时区
        ZoneId zoneId1=ZoneId.of("America/Marigot");
        System.out.println(zoneId1);

    }
}
