package day4.demo7;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Demo7 {
    public static void insert() {
        String sql = "INSERT INTO stu (id, name, gender) VALUES (NULL, '张三', '男'), (NULL, '李四', '女')";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.executeUpdate();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
    }
    public static void delete() {
        String sql = "DELETE FROM stu WHERE id = ?";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setInt(1, 1);
            prepStmt.executeUpdate();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
    }
    public static void update() {
        String sql = "UPDATE stu SET name = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, "李小四");
            prepStmt.setInt(2, 2);
            prepStmt.executeUpdate();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, null);
        }
    }
    public static void select() {
        String sql = "SELECT * FROM stu";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            retSet = prepStmt.executeQuery();
            while (retSet.next() == true) {
                int id = retSet.getInt(1);
                String name = retSet.getString(2);
                String gender = retSet.getString(3);
                System.out.println("id：" + id + " 姓名：" + name + " 性别：" + gender);
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, retSet);
        }
    }
    public static void main(String[] args) {
        insert();
        delete();
        update();
        select();
    }
}