package 复习;

/**
 * @ClassName 复习.student
 * @Author iove
 * @Date 2024/12/3 下午5:48
 * @Version 1.0
 * @Description TODO
 **/

public class Student extends parent{
	public static String name;
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

}
