package day11.demo3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Demo3 {
    public static void write(String path, List<Student> list) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < list.size(); i++) {
                Student student = list.get(i);
                bw.write(student.getName() + ", " + student.getGender() + ", " + student.getAge());
                bw.newLine();
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static List<Student> read(String path) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            List<Student> list = new ArrayList<>();
            String str = null;
            while ((str = br.readLine()) != null) {
                String[] arr = str.split(", ");
                Student student = new Student();
                student.setName(arr[0]);
                student.setGender(arr[1]);
                student.setAge(Integer.parseInt(arr[2]));
                list.add(student);
            }
            return list;
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (br != null) {
                    br.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
        return null;
    }
    public static void main(String[] args) {
        String path = "./day11/src/day11/demo3/file.txt";
        List<Student> list = new ArrayList<>(
                Arrays.asList(
                        new Student("张三", "男", 20),
                        new Student("李四", "男", 21),
                        new Student("王五", "男", 22)
                )
        );
        write(path, list);
        List<Student> studentList = read(path);
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }
}