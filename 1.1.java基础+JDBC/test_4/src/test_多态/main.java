package test_多态;

public class main {
    public static void main(String[] args) {
        Player p1=new student();
        p1.swim();
    }
}
interface Player{
    public void swim();
}
class student implements Player{
    @Override
    public void swim(){
        System.out.println("游泳");
    }
}
