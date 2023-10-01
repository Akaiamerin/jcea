package exp3;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
class Employee {
    private Integer id;
    private String name;
    private String gender;
    private String birth;
    private String dept;
    public Employee() {

    }
    public Employee(Integer id, String name, String gender, String birth, String dept) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.dept = dept;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    @Override
    public String toString() {
        return id + " " +
                name + " " +
                gender + " " +
                birth + " " +
                dept;
    }
}
public class Exp3 {
    private static final String PATH = "./src/main/resources/list.json";
    public static void writeJSONFile(List<Employee> list) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(PATH));
            bw.write(new ObjectMapper().writeValueAsString(list));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
    public static void readJSONFile() {
        try {
            List<Employee> list = new ObjectMapper().readValue(new File(PATH), new TypeReference<>() {});
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "张三", "男", "1997/11/02", "开发部"));
        list.add(new Employee(2, "大强", "男", "1989/06/11", "营销部"));
        list.add(new Employee(3, "小王", "男", "1993/05/30", "财务部"));
        list.add(new Employee(4, "小胖", "女", "1998/07/10", "开发部"));
        list.add(new Employee(5, "李怡", "女", "2000/05/18", "人事部"));
        writeJSONFile(list);
        readJSONFile();
    }
}