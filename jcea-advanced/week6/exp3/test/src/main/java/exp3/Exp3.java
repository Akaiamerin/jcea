package exp3;
import animal.Animal;
import java.util.ServiceLoader;
public class Exp3 {
    public static void main(String[] args) {
        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);
        for (Animal animal : animals) {
            animal.shout();
            System.out.println(animal.hashCode());
        }
    }
}