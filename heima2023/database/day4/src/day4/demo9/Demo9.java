package day4.demo9;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Demo9 {
    public static Student selectStudentById(Integer id) {
        String sql = "SELECT * FROM stu WHERE id = ?";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        Student student = null;
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setInt(1, id);
            retSet = prepStmt.executeQuery();
            while (retSet.next() == true) {
                student = new Student();
                student.setId(retSet.getInt(1));
                student.setName(retSet.getString(2));
                student.setGender(retSet.getString(3));
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, retSet);
        }
        return student;
    }
    public static void main(String[] args) {
        Student student = selectStudentById(1);
        System.out.println("id：" + student.getId() + " 姓名：" + student.getName() + " 性别：" + student.getGender());
    }
}