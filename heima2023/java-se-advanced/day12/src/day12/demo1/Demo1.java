package day12.demo1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Demo1 {
    public static void write(String path, Student student) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(student);
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static void read(String path) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            Student stu = (Student) ois.readObject();
            System.out.println(stu);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        String path = "./day12/src/day12/demo1/file.txt";
        Student student = new Student("张三", "男", 20);
        write(path, student);
        read(path);
    }
}