package day5.demo1;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
public class Demo1 {
    public static void main(String[] args) throws Exception {
        Class<Student> clazz = Student.class;
        Constructor<Student> constructor = clazz.getDeclaredConstructor(String.class, Integer.class);
        Student student = constructor.newInstance("张三", 20);
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(student);
    }
}