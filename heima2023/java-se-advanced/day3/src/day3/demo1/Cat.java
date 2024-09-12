package day3.demo1;
public class Cat extends Animal {
    public Cat() {

    }
    public Cat(String name) {
        super(name);
    }
    @Override
    public void eat() {
        System.out.println("吃");
    }
    public void catchMice() {
        System.out.println("抓老鼠");
    }
}