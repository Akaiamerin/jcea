package day5.demo4;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class Demo4 {
    public static void main(String[] args) throws Exception {
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getConstructor(String.class, Integer.class);
        Person person = constructor.newInstance("张三", 20);
        System.out.println(person.getName() + " " + person.getAge());
        Method setName = clazz.getMethod("setName", String.class);
        setName.invoke(person, "李四");
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person, 21);
        System.out.println(person.getName() + " " + person.getAge());
    }
}