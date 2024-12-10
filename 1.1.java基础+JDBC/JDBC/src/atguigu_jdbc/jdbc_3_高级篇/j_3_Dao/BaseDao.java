package atguigu_jdbc.jdbc_3_高级篇.j_3_Dao;

import atguigu_jdbc.jdbc_3_高级篇.j_2_工具类封装V2.JDBCUtilV2;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
    这个类封装了
      3.获取执行url语句的对象
      4.编写sql语句
      5.处理结果
    这三步，1，2，6已经由工具类的封装完成了

 */
public class BaseDao {

    //1.通用的增删改方法
    //params表示占位符，...表示传进来几个都可以，也可以不传
    public int executeUpdate(String sql,Object ...params) throws SQLException {
        Connection connection = JDBCUtilV2.getConnection();
        //预编译
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        //判断是否传进来了占位符
        if(params!=null&&params.length!=0){
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1,params[i]);
            }
        }
        //这个方法返回的是受影响的行数
        int row=preparedStatement.executeUpdate();

        //释放资源
        preparedStatement.close();
        //判断是否开启了事物
       if(connection.getAutoCommit()){
            JDBCUtilV2.release();
        }
        return  row;
    }

    /*
    通用的查询多个Javabean对象的方法，例如：多个员工对象，多个部门对象等
    这里的clazz接收的是T类型的Class对象，
    如果查询员工信息，clazz代表Employee.class，
    如果查询部门信息，clazz代表Department.class，
    返回List<T> list
     */
    public <T> List<T> executeQuery(Class<T>clazz,String sql,Object ...params) throws Exception {
        Connection connection=JDBCUtilV2.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        //设置占位符
        if(params!=null&&params.length!=0){
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1,params[i]);
            }
        }
        ArrayList<T>list=new ArrayList<>();
        ResultSet res=preparedStatement.executeQuery();

        /*
        获取结果集的元数据对象。
        元数据对象中有该结果集一共有几列、列名称是什么等信息
         */
        ResultSetMetaData metaData=res.getMetaData();
        //获取结果集列数
        int columnCount=metaData.getColumnCount();

        //遍历结果集ResultSet，把查询结果中的一条一条记录，变成一个一个T 对象，放到list中。
        while(res.next()){
            //循环一次代表有一行，代表有一个T对象
            //要求这个类型必须有公共的无参构造
            T t=clazz.newInstance();

            //把这条记录的每一个单元格的值取出来，设置到t对象对应的属性中。
            for (int i = 1; i <= columnCount; i++) {
                 //for循环一次，代表取某一行的1个单元格的值
                Object value=res.getObject(i);
                //获取第i列的属性名
                String columnName = metaData.getColumnLabel(i);
                 //获取该属性对应的Field对象
                Field field=clazz.getDeclaredField(columnName);
                //这么做可以操作private的属性
                field.setAccessible(true);
                //t代表第i行这个对象
                field.set(t,value);
            }
            list.add(t);

        }
        res.close();
        preparedStatement.close();
        if(connection.getAutoCommit()){
            JDBCUtilV2.release();
        }
        return list;
    }

    /*
    返回单个结果
     */
    public <T> T executeQueryBean(Class<T>clazz,String sql,Object ...params)throws Exception{
        List<T> list=this.executeQuery(clazz,sql,params);
        if(list==null||list.size()==0){
            return null;
        }
        return list.get(0);
    }
}
