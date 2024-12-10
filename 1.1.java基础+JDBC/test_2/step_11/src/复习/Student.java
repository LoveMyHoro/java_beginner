package 复习;

/**
 * @ClassName Student
 * @Author iove
 * @Date 2024/12/3 下午7:08
 * @Version 1.0
 * @Description TODO
 **/

public class Student {
	private String name;
	private int age;
	public Student(){

	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		subject subject = new subject();
		return subject.getSubjectName();
	}
	class subject{
		private String subjectName="英语";
		public String getSubjectName(){
			return subjectName;
		}
		public void getStudentName(){
			System.out.println(name);
		}

	}
}
