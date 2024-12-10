package atguigu_jdbc.jdbc_3_高级篇.j_4_事物;

import atguigu_jdbc.jdbc_3_高级篇.j_3_Dao.BaseDao;

import java.sql.SQLException;

public class BankDaoImpl extends BaseDao implements BankDao {
    public int addMoney(Integer id,Integer money) throws SQLException {
            String sql = "update t_bank set money = money + ? where id = ? ";
            return executeUpdate(sql,money,id);
    }

   public int subMoney(Integer id,Integer money) throws SQLException {
            String sql = "update t_bank set money = money - ? where id = ? ";
            return executeUpdate(sql,money,id);
    }
}
