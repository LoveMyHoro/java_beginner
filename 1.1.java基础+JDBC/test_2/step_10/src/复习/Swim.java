package 复习;

public interface Swim {
	String sports="Swim666";
	default void sportName(){
		System.out.println("这是接口的default方法");
	}
	public void swim();
}
