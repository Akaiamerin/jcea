package exp1;
class Person {
    private String name;
    private String address;
    private Integer phone;
    private String email;
    public Person() {

    }
    public Person(String name, String address, Integer phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    @Override
    public String toString() {
        return name + " " +
                address + " " +
                phone + " " +
                email;
    }
}
class Student extends Person {
    private String grade;
    public Student() {

    }
    public Student(String name, String address, Integer phone, String email, String grade) {
        super(name, address, phone, email);
        this.grade = grade;
    }
    @Override
    public String toString() {
        return super.toString() + " " + grade;
    }
}
class Employee extends Person {
    private String date;
    private String office;
    private Double salary;
    public Employee() {

    }
    public Employee(String name, String address, Integer phone, String email, String date, String office, Double salary) {
        super(name, address, phone, email);
        this.date = date;
        this.office = office;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return super.toString() + " " +
                date + " " +
                office + " " +
                salary;
    }
}
class Faculty extends Employee {
    private String rank;
    private String workTime;
    public Faculty() {

    }
    public Faculty(String name, String address, Integer phone, String email, String date, String office, Double salary, String rank, String workTime) {
        super(name, address, phone, email, date, office, salary);
        this.rank = rank;
        this.workTime = workTime;
    }
    @Override
    public String toString() {
        return super.toString() + " " +
                rank + " " +
                workTime;
    }
}
class Staff extends Employee {
    private String title;
    public Staff() {

    }
    public Staff(String name, String address, Integer phone, String email, String date, String office, Double salary, String title) {
        super(name, address, phone, email, date, office, salary);
        this.title = title;
    }
    @Override
    public String toString() {
        return super.toString() + " " + title;
    }
}
public class Exp1 {
    public static void main(String[] args) {
        Student student = new Student("学生", "学生地址", 111, "学生邮箱", "学生年级");
        System.out.println(student);
        Employee employee = new Employee("雇员", "雇员地址", 222, "雇员邮箱", "受聘日期", "办公室", 222.2);
        System.out.println(employee);
        Faculty faculty = new Faculty("教员", "教员地址", 333, "教员邮箱", "受聘日期", "办公室", 333.3, "办公时间", "级别");
        System.out.println(faculty);
        Staff staff = new Staff("职员", "职员地址", 444, "职员邮箱", "受聘日期", "办公室", 444.4, "职务称号");
        System.out.println(staff);
    }
}