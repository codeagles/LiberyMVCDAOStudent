package dao.dbc;
import java.sql.*;
public class DBConnection {
	private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://localhost:1433; DatabaseName=LibraryManager";
    private static  final String userName = "sa";
    private static  final String password = "123456";
    private  Connection conn = null;
    boolean flag = false;
    
    /** 
     * @功能 创建数据库连接 
     * @返回值 connection型值 
     */
    public Connection getConnection() {
        try {
        	Class.forName(driver); 
        	conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
           System.out.println("获取数据库连接失败！");
        }
        return conn;
    }
    
     /** 
     * @功能 关闭数据库连接
     */
    public void closed() {
    	if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭con对象失败！");
			}
    }
  
}