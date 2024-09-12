package exp4;
class Person {
    public String name;
    public String address;
    public Person() {

    }
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    @Override
    public String toString() {
        return name + " " + address;
    }
}
abstract class Employee extends Person {
    public Integer id;
    public Double salary;
    public Integer age;
    public Employee() {

    }
    public Employee(String name, String address, Integer id, Double salary, Integer age) {
        super(name, address);
        this.id = id;
        this.salary = salary;
        this.age = age;
    }
    abstract Double payRaise();
    @Override
    public String toString() {
        return super.toString() + " " +
                id + " " +
                salary + " " +
                age;
    }
}
class Manager extends Employee {
    public Integer level;
    public Manager() {

    }
    public Manager(String name, String address, Integer ID, Double salary, Integer age, Integer level) {
        super(name, address, ID, salary, age);
        this.level = level;
    }
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public Double payRaise() {
        if (level == 1) {
            salary += 0.1 * salary;
        }
        else if (level == 2) {
            salary += 0.2 * salary;
        }
        return salary;
    }
    @Override
    public String toString() {
        return super.toString() + " " + level;
    }
}
public class Exp4 {
    public static void main(String[] args) {
        Manager manager1 = new Manager("员工", "员工地址", 333, 3333.0, 33, 1);
        System.out.println(manager1);
        manager1.payRaise();
        System.out.println(manager1);
        Manager manager2 = new Manager("经理", "经理地址", 444, 4444.0, 44, 2);
        System.out.println(manager2);
        manager2.payRaise();
        System.out.println(manager2);
    }
}