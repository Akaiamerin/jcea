package day4.demo3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Demo3 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/database";
        String user = "root";
        String password = "111111";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO stu (id, name, gender) VALUES (NULL, '张三', '男'), (NULL, '小红', '女')";
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }
}