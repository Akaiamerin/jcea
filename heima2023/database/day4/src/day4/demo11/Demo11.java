package day4.demo11;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Demo11 {
    public static List<Student> selectAllStudent() {
        String sql = "SELECT * FROM stu";
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        List<Student> studentList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            prepStmt = conn.prepareStatement(sql);
            retSet = prepStmt.executeQuery();
            while (retSet.next() == true) {
                Student student = new Student();
                student.setId(retSet.getInt(1));
                student.setName(retSet.getString(2));
                student.setGender(retSet.getString(3));
                studentList.add(student);
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            JDBCUtils.close(conn, prepStmt, retSet);
        }
        return studentList;
    }
    public static void main(String[] args) {
        List<Student> studentList = selectAllStudent();
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            System.out.println("id：" + student.getId() + " 姓名：" + student.getName() + " 性别：" + student.getGender());
        }
    }
}