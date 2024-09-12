package day5.demo2;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
public class Demo2 {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getMethod("add", Object.class);
        add.invoke(list, "a");
        System.out.println(list);
    }
}