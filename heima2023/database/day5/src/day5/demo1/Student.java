package day5.demo1;
public class Student {
    private String name;
    private Integer age;
    public Student() {

    }
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void show() {
        System.out.println("大家好，我叫" + name + "，我今年" + age + "岁");
    }
}