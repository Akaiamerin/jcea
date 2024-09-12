package day4.demo2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Demo2 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/database";
        String user = "root";
        String password = "111111";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        String sql = """
                    CREATE TABLE stu (
                        id INT NOT NULL AUTO_INCREMENT,
                        name VARCHAR(20),
                        gender CHAR(1),
                        PRIMARY KEY (id)
                    );
                """;
        stmt.execute(sql);
    }
}