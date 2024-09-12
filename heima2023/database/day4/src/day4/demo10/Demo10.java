package day4.demo10;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Demo10 {
    public static int deleteStudentById(Integer id) {
        String sql = "DELETE FROM stu WHERE id = ?";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        int count = 0;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setInt(1, id);
            count = prepStmt.executeUpdate();
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, retSet);
        }
        return count;
    }
    public static void main(String[] args) {
        int count = deleteStudentById(1);
        System.out.println(count);
    }
}