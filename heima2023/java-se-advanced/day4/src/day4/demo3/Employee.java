package day4.demo3;
public class Employee {
    private String name;
    private Character gender;
    private Integer age;
    private Double height;
    private Boolean isMarried;
    public Employee() {

    }
    public Employee(String name, Character gender, Integer age, Double height, Boolean isMarried) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.isMarried = isMarried;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Character getGender() {
        return gender;
    }
    public void setGender(Character gender) {
        this.gender = gender;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public Boolean getMarried() {
        return isMarried;
    }
    public void setMarried(Boolean married) {
        isMarried = married;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", height=" + height +
                ", isMarried=" + isMarried +
                '}';
    }
}