package day5.demo3;
import java.lang.reflect.Field;
public class Demo3 {
    public static void setProperty(Object obj, String propertyName, Object value) throws Exception {
        Class<?> clazz = obj.getClass();
        Field field = clazz.getDeclaredField(propertyName);
        field.setAccessible(true);
        field.set(obj, value);
    }
    public static Object getProperty(Object obj, String propertyName) throws Exception {
        Class<?> clazz = obj.getClass();
        Field field = clazz.getDeclaredField(propertyName);
        field.setAccessible(true);
        return field.get(obj);
    }
    public static void main(String[] args) throws Exception {
        Student student = new Student("张三", 20);
        setProperty(student, "age", 21);
        System.out.println(student);
        String name = (String) getProperty(student, "name");
        System.out.println(name);
    }
}