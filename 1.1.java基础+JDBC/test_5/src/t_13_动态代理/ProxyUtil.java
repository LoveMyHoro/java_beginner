package t_13_动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    /*
    *
    *   方法的作用：给一个明星对象创建一个代理
    *   形参：被代理的明星对象
    *   返回值：被创建的代理
     */
    /*
    *   newProxyInstance()
    *   参数一：用于指定用哪个类加载器
    *   参数二：指定接口，（可能不止一个接口）这些接口用来指明代理实现哪些方法
    *   参数三：用来指定生成的对象要干什么事情
     */
    public static Star createProxy(BigStar bigStar){
        Star star= (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*
                        *   参数一：代理的对象，通常不用
                        *   参数二：要运行的方法
                        *   参数三：调用方法时传递的实参
                         */
                        if("sing".equals(method.getName())){
                            System.out.println("准备话筒，收钱");
                        }
                        else if("dance".equals(method.getName())){
                            System.out.println("准备场地，收钱");
                        }
                        return method.invoke(bigStar,args);
                    }
                }
        );
        return star;
    }
}
