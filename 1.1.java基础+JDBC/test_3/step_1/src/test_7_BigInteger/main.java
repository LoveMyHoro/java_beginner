package test_7_BigInteger;

import java.math.BigInteger;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        //1
        BigInteger bd1=new BigInteger(4,new Random());
        System.out.println(bd1);
        //2.
        BigInteger bd2=new BigInteger("99999999999999999999999");
        System.out.println(bd2);
        //3.
        BigInteger bd3=BigInteger.valueOf(16);
        BigInteger bd4=BigInteger.valueOf(16);
        System.out.println(bd3==bd4);
        //4.

    }
}
