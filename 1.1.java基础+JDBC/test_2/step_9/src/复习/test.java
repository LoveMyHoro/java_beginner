package 复习;

/**
 * @ClassName test
 * @Author iove
 * @Date 2024/12/3 下午5:48
 * @Version 1.0
 * @Description TODO
 **/

public class test {
	public static void main(String[] args) {
		Student.name="撒大苏打";
		Student student=new Student("Asuka",14);
		System.out.println(student.getName());
		student.parentAge();
		DuoTai(student);
	}
	public static void DuoTai(parent parent){
		parent=(Student)parent;
		parent.parentAge();
	}

}
