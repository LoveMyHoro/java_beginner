public class Servlet3 {
    //Servlet继承结构

    /*

    1.Servlet接口：规范接口,所有的Servlet必须实现

        + public void init(ServletConfig config) throws ServletException;
            初始化方法,容器在构造servlet对象后,自动调用的方法,容器负责实例化一个ServletConfig对象,并在调用该方法时传入
            ServletConfig对象可以为Servlet 提供初始化参数

        + public ServletConfig getServletConfig();
            获取ServletConfig对象的方法,后续可以通过该对象获取Servlet初始化参数

        + public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;
            处理请求并做出响应的服务方法,每次请求产生时由容器调用
            容器创建一个ServletRequest对象和ServletResponse对象,容器在调用service方法时,传入这两个对象

        + public String getServletInfo();
            获取ServletInfo信息的方法

        + public void destroy();
            Servlet实例在销毁之前调用的方法

   */
    /*
    2.GenericServlet 抽象类

    GenericServlet 抽象类是对Servlet接口一些固定功能的粗糙实现,以及对service方法的再次抽象声明,
    并定义了一些其他相关功能方法
        + private transient ServletConfig config;
            初始化配置对象作为属性
        + public GenericServlet() { }
            构造器,为了满足继承而准备
        + public void destroy() { }
            销毁方法的平庸实现
        + public String getInitParameter(String name)
            获取初始参数的快捷方法
        + public Enumeration<String> getInitParameterNames()
            返回所有初始化参数名的方法
        + public ServletConfig getServletConfig()
            获取初始Servlet初始配置对象ServletConfig的方法
        + public ServletContext getServletContext()
            获取上下文对象ServletContext的方法
        + public String getServletInfo()
            获取Servlet信息的平庸实现
        + public void init(ServletConfig config) throws ServletException()
            初始化方法的实现,并在此调用了init的重载方法
        + public void init() throws ServletException
            重载init方法,为了让我们自己定义初始化功能的方法
        + public void log(String msg)
        + public void log(String message, Throwable t)
            打印日志的方法及重载
        + public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;
            服务方法再次声明
        + public String getServletName()
            获取ServletName的方法
     */
    /*
       3 HttpServlet 抽象类
     */
    /*
       4 自定义Servlet

       自定义Servlet中,必须要对处理请求的方法进行重写
            要么重写service方法
            要么重写doGet/doPost方法
        否则就会调用父类HttpServlet中的service方法，导致抛出405错误
     */
}
