package 复习;

/**
 * @ClassName parent
 * @Author iove
 * @Date 2024/12/3 下午6:06
 * @Version 1.0
 * @Description TODO
 **/

public class Parent {
	private  String name;
	private int age;
	public Parent(){

	}
	public Parent(String name, int age){
		this.name=name;
		this.age=age;
	}
	public void parentName(){
		System.out.println("我是你的父亲");
	}
	public void parentAge(){
		System.out.println(name+"的年龄是="+this.age);
	}
}
