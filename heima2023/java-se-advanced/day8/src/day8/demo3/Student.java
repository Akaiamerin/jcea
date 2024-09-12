package day8.demo3;
import java.util.Objects;
public class Student {
    private String name;
    private Character gender;
    private Integer age;
    public Student() {

    }
    public Student(String name, Character gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
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
        if (Objects.equals('男', gender) == false && Objects.equals('女', gender) == false) {
            throw new GenderException("性别异常");
        }
        this.gender = gender;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        if (age < 18 || age > 70) {
            throw new AgeException("年龄异常");
        }
        this.age = age;
    }
}