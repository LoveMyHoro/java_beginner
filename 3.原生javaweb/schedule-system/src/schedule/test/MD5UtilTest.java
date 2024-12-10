package schedule.test;

import org.junit.Test;
import schedule.util.MD5Util;

public class MD5UtilTest {
    @Test
    public void testMD5() {
        String encrypt = MD5Util.encrypt("114514");
        System.out.println(encrypt);
    }
}
