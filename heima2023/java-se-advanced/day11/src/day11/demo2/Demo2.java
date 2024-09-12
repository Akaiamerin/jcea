package day11.demo2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Demo2 {
    public static void write(String path, List<String> list) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i));
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
    public static List<String> read(String path) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            List<String> list = new ArrayList<>();
            String str = null;
            while ((str = br.readLine()) != null) {
                list.add(str);
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
        String path = "./day11/src/day11/demo2/file.txt";
        List<String> list = new ArrayList<>(Arrays.asList("张三", "李四", "王五"));
        write(path, list);
        List<String> strList = read(path);
        for (int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }
    }
}