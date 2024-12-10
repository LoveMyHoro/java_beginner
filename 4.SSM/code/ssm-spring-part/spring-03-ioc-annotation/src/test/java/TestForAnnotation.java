import com.horo.ioc_01_Bean注解标记和扫描.XxxController;
import com.horo.ioc_02_组件作用域和周期方法注解.JavaBean;
import com.horo.ioc_03_Bean属性赋值_引用类型自动装配.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestForAnnotation {
    @Test
    public void testIoc1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");
        XxxController bean =(XxxController) context.getBean("xxxController");
        System.out.println("bean = " + bean);
    }
    @Test
    public void testIoc2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean bean1 = context.getBean(JavaBean.class);
        JavaBean bean2 = context.getBean(JavaBean.class);
        System.out.println(bean1==bean2);

    }
    @Test
    public void testIo3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-03.xml");
        UserController bean = context.getBean(UserController.class);
        bean.show();
    }
    @Test
    public void testIoc4(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-04.xml");
        com.horo.ioc_04_Bean属性赋值_基本类型属性赋值.JavaBean bean = context.getBean(com.horo.ioc_04_Bean属性赋值_基本类型属性赋值.JavaBean.class);
        System.out.println(bean);
    }
}
