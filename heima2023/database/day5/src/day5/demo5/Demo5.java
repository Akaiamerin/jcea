package day5.demo5;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
public class Demo5 {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("./day5/src/day5/demo5/demo5.properties");
        props.load(fis);
        String className = props.getProperty("className");
        Class<HelloWorld> clazz = (Class<HelloWorld>) Class.forName(className);
        Constructor<HelloWorld> constructor = clazz.getConstructor();
        HelloWorld helloWorld = constructor.newInstance();
        Method show = clazz.getMethod("show");
        show.invoke(helloWorld);
        fis.close();
    }
}