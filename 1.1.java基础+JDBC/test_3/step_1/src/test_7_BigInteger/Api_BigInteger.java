package test_7_BigInteger;
//注：（1）大整数的操作都要通过方法来实现
//   （2）BigInteger的对象一旦创建，内部记录的值不能发生改变，若操作过程中产生了新的值，要用新的BigInteger对象接收
public class Api_BigInteger {
    /*
    1.BigInteger的构造方法
    （1）public BigInteger (int num,Random rnd):获取随机的大整数，范围[0~2的num次方减一],rnd是一个Random对象
    （2）public BigInteger (String val): 将整数字符串val转变为大整数。注：val必须是整数
    注：BigInteger的对象一旦创建，内部记录的值不能发生改变

    （3）public BigInteger (String val,int radix):获取指定进制的大整数。比如（100，2）返回的是4，因为100在二进制中代表4
    （4）静态方法获取BigInteger的对象，内部有优化
    eg:BigInteger bd5=BigInteger.valueof(100);
    注：括号内部的数子只能是在long范围内。且在内部已经创建了-16~16的对象。多次调用这个范围的数字时使用的是相同的地址

    2.BigInteger的常见成员方法
    (1)add():加法
    (2)subtract():减法
    (3)multiply():乘法
    (4)divide():除法,获取商
    (5)divideAndRemainder():除法，获取商和余数
    (6)equals():比较是否相同
    (7)pow():次幂
    (8)max/min():返回较大/较小值
    (9)intValue():转为int类型整数，超出范围有误


    3.相关
     */
}
