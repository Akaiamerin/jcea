package day4.demo1;
import java.sql.Connection;
import java.sql.DriverManager;
public class Demo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/database";
        String user = "root";
        String password = "111111";
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}