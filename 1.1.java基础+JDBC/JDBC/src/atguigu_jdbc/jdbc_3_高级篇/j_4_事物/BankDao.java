package atguigu_jdbc.jdbc_3_高级篇.j_4_事物;

import java.sql.SQLException;

public interface BankDao {
    int addMoney(Integer id,Integer money) throws SQLException;

    int subMoney(Integer id,Integer money) throws SQLException;
}
