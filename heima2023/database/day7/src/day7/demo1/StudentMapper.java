package day7.demo1;
import java.util.List;
public interface StudentMapper {
    int insertStudent(Student student);
    List<Student> selectAllStudent();
}