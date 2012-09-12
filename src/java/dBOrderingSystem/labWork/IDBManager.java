package dBOrderingSystem.labWork;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jlombardo
 */
public interface IDBManager {

    void init() throws Exception;

    List<Map> getAllRecords(String sql) throws Exception;

    public void setDriverClassName(String driverClassName);

    public String getDriverClassName();

    public String getPassword();

    public void setPassword(String password);

    public void setUrl(String url);

    public void setUserName(String userName);

    public String getUrl();

    public String getUserName();

    public Connection getConn();

    public void setConn(Connection conn);

    public ResultSet getRs();

    public void setRs(ResultSet rs);

    public Statement getStmt();

    public void setStmt(Statement stmt);

}
