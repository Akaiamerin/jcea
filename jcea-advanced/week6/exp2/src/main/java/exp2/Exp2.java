package exp2;
import animal.Animal;
class Dog extends Animal {
    public Dog() {

    }
    @Override
    public void shout() {
        System.out.println("dog.shout()");
    }
    @Override
    public void move() {
        System.out.println("dog.move()");
    }
}
class Cat extends Animal {
    public Cat() {

    }
    @Override
    public void shout() {
        System.out.println("cat.shout()");
    }
    @Override
    public void move() {
        System.out.println("cat.move()");
    }
}
public class Exp2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.shout();
        dog.move();
        Cat cat = new Cat();
        cat.shout();
        cat.move();
    }
}