package day4.demo11;
public class Student {
    private Integer id;
    private String name;
    private String gender;
    public Student() {

    }
    public Student(Integer id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
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
}