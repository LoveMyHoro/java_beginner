package t5_集合进阶.进阶3_泛型_多用于数据类型不确定的时候.f5_综合练习;

public class hashiqiDog extends Dog{
    public hashiqiDog() {
    }

    public hashiqiDog(String name, int age) {
        super(name, age);
    }
    @Override
    public void Eat(String something){
        System.out.println("一只叫"+this.getName()+"的"+this.getAge()+"的哈士奇，正在吃"+something);
    }
}
