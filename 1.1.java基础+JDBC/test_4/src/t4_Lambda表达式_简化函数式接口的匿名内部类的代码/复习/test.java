package t4_Lambda表达式_简化函数式接口的匿名内部类的代码.复习;

/**
 * @ClassName test
 * @Author iove
 * @Date 2024/12/3 下午8:09
 * @Version 1.0
 * @Description TODO
 **/

public class test {
	public static void main(String args[]){
		test("明日香",()->{return "驾驶Eva";});
	}
	public static void test(String name, Sport sport){
		System.out.println(name+"在"+sport.doSport());
	}
}
