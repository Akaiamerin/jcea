package day3.demo1;
public class Dog extends Animal {
    public Dog() {

    }
    public Dog(String name) {
        super(name);
    }
    @Override
    public void eat() {
        System.out.println("吃");
    }
    public void watchDoor() {
        System.out.println("看门");
    }
}