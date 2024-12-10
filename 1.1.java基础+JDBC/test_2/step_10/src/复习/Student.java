package 复习;

/**
 * @ClassName 复习.student
 * @Author iove
 * @Date 2024/12/3 下午5:48
 * @Version 1.0
 * @Description TODO
 **/

public class Student extends Parent implements Swim{
	static String teachName;
	//注意，静态代码块里面不能使用this，因为static和static是在类实例化之前执行的，而this代表的是类的实例
	static{
		teachName="明日香";
	}
	public String name;
	private int age;
	public Student(String name, int age) {
		super(name, age);
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	//重写方法
	@Override
	public void parentName(){
		System.out.println("我真的是你的父亲");
	}

	public void teachName(){
		System.out.println("老师的名字是："+teachName);
	}

	@Override
	public void swim() {
		System.out.println(Swim.sports);
	}
}
