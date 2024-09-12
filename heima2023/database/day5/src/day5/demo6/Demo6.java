package day5.demo6;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
public class Demo6 {
    @MyTest
    public void test1() {
        System.out.println("test1");
    }
    @MyTest
    public void test2() {
        System.out.println("test2");
    }
    @MyTest
    public void test3() {
        System.out.println("test3");
    }
    public static void main(String[] args) throws Exception {
        Class<Demo6> clazz = Demo6.class;
        Constructor<Demo6> constructor = clazz.getConstructor();
        Demo6 demo6 = constructor.newInstance();
        Method[] methodArr = clazz.getDeclaredMethods();
        for (int i = 0; i < methodArr.length; i++) {
            Method method = methodArr[i];
            if (method.isAnnotationPresent(MyTest.class) == true) {
                method.invoke(demo6);
            }
        }
    }
}