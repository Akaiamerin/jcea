package day4.demo6;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCUtils {
    private static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/database";
    private static final String USER = "root";
    private static final String PASSWORD = "111111";
    static {
        try {
            Class.forName(CLASS_NAME);
        }
        catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        return null;
    }
    public static void close(Connection conn, Statement stmt, ResultSet retSet) {
        try {
            if (retSet != null) {
                retSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}