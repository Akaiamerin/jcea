package day6.demo1;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
public class Demo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> proxy = (List<Integer>) Proxy.newProxyInstance(
                ArrayList.class.getClassLoader(),
                list.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = method.invoke(list, args);
                        if (method.getName().equals("remove")) {
                            Iterator<Integer> iter = list.iterator();
                            while (iter.hasNext() == true) {
                                Integer elem = iter.next();
                                if (Objects.equals(elem, args[0]) == true) {
                                    iter.remove();
                                }
                            }
                        }
                        return result;
                    }
                }
        );
        proxy.addAll(Arrays.asList(1, 2, 3, 1));
        System.out.println(proxy);
        proxy.remove(Integer.valueOf(1));
        System.out.println(proxy);
    }
}