package day7.demo1;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
public class Demo1 {
    public static void insertStudent() {
        SqlSession session = SessionFactoryUtils.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = new Student(null, "张三", 20, "男");
        int count = studentMapper.insertStudent(student);
        if (count > 0) {
            session.commit();
        }
        session.close();
    }
    public static void selectAllStudent() {
        SqlSession session = SessionFactoryUtils.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.selectAllStudent();
        System.out.println(studentList);
    }
    public static void main(String[] args) {
        insertStudent();
        selectAllStudent();
    }
}