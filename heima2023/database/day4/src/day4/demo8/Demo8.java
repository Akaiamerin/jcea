package day4.demo8;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Demo8 {
    public static void createTable() {
        String sql = """
                CREATE TABLE user (
                    id INT NOT NULL AUTO_INCREMENT,
                    username VARCHAR(20),
                    password VARCHAR(20),
                    PRIMARY KEY (id)
                );
                """;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, stmt, null);
        }
    }
    public static void insert() {
        String sql = "INSERT INTO user (id, username, password) VALUES (NULL, 'user1', 'a'), (NULL, 'user2', 'a')";
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, stmt, null);
        }
    }
    public static void login(String username, String password) {
        String sql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        Connection conn = null;
        Statement stmt = null;
        ResultSet retSet = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            retSet = stmt.executeQuery(sql);
            if (retSet.next() == true) {
                System.out.println("登录成功");
            }
            else {
                System.out.println("用户名或密码错误");
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, stmt, retSet);
        }
    }
    public static void main(String[] args) {
        createTable();
        insert();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = sc.nextLine();
        System.out.print("请输入密码：");
        String password = sc.nextLine();
        login(username, password);
        sc.close();
    }
}