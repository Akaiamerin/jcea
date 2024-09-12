package day4.demo5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
public class Demo5 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>(Arrays.asList("《JavaEE 企业级开发指南》", "《Oracle 高级编程》", "《MySQL 从入门到精通》", "《Java 架构师之路》"));
        Iterator<String> iter = null;
        iter = collection.iterator();
        while (iter.hasNext() == true) {
            String elem = iter.next();
            System.out.print(elem + " ");
        }
        System.out.println();
        iter = collection.iterator();
        while (iter.hasNext() == true) {
            String elem = iter.next();
            if (elem.length() < 15) {
                System.out.print(elem + " ");
            }
        }
        System.out.println();
        iter = collection.iterator();
        while (iter.hasNext() == true) {
            String elem = iter.next();
            if (elem.contains("Java") == true) {
                System.out.print(elem + " ");
            }
        }
        System.out.println();
        iter = collection.iterator();
        while (iter.hasNext() == true) {
            String elem = iter.next();
            if (elem.contains("Oracle") == true) {
                iter.remove();
            }
            else {
                System.out.print(elem + " ");
            }
        }
        System.out.println();
    }
}