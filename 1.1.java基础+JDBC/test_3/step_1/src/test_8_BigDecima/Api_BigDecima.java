package test_8_BigDecima;
//类似于大整数，不过BigDecima是对小数操作
public class Api_BigDecima {
    /*
    1.关于小数
    （1）float是32位，其中小数23位。double是64位，其中小数52位
    2.BigDecima的常见成员方法基本和BigInteger一样，其中有一个需要注意。
    divide(BigDecima val):除法
    divide(BigDecima val,精确几位，舍入模式):除法
    注：当除不尽的时候要标注精确几位

    3.注意：如果表示的数字没有超过double范围时，建议使用静态方法valueof。
    类似的，在BigDecima的valueof中0~10的整数对象已经创建好了（10.0这类的不包括，因为是小数），分享相同的空间
     */
}
