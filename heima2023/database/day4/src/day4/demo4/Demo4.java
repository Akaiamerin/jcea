package day4.demo4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Demo4 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/database";
        String user = "root";
        String password = "111111";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        int id = 2;
        String name = "李小四";
        String sql = "UPDATE stu SET name = '" + name + "' WHERE id = " + id;
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }
}