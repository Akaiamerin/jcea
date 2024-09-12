package day4.demo12;
import java.time.LocalDate;
public class Employee {
    private Integer id;
    private String name;
    private String gender;
    private String post;
    private Double salary;
    private LocalDate entryDate;
    private Integer deptId;
    public Employee() {

    }
    public Employee(Integer id, String name, String gender, String post, Double salary, LocalDate entryDate, Integer deptId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.post = post;
        this.salary = salary;
        this.entryDate = entryDate;
        this.deptId = deptId;
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
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public LocalDate getEntryDate() {
        return entryDate;
    }
    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }
    public Integer getDeptId() {
        return deptId;
    }
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}