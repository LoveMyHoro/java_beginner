package 复习;

/**
 * @ClassName test
 * @Author iove
 * @Date 2024/12/3 下午7:19
 * @Version 1.0
 * @Description TODO
 **/

public class test {
	public static void main(String[] args) {
		Student student=new Student();
		System.out.println(student.getName());
		//实例化
		Swim swim=new Swim() {
			@Override
			public String swim() {
				return "明日方舟1";
			}
		};
		System.out.println(swim.swim());
		ForSwim(()->{
			return "明日方舟2";
		});
	}
	public static void ForSwim(Swim swim){
		System.out.println(swim.swim());
	}
}
