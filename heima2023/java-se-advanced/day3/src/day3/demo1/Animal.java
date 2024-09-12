package day3.demo1;
public abstract class Animal {
    private String name;
    public Animal() {

    }
    public Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract void eat();
}