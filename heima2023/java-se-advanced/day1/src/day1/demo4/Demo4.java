package day1.demo4;
public class Demo4 {
    public static void main(String[] args) {
        Cucumber cucumber = new Cucumber();
        cucumber.eat();
        cucumber.use();
        System.out.println();
        Eggplant eggplant = new Eggplant();
        eggplant.eat();
        eggplant.use();
        System.out.println();
        Banana banana = new Banana();
        banana.eat();
        banana.use();
        System.out.println();
        Durian durian = new Durian();
        durian.eat();
        durian.use();
        System.out.println();
        FinlessEel finlessEel = new FinlessEel();
        finlessEel.eat();
        System.out.println();
        Hairtail hairtail = new Hairtail();
        hairtail.eat();
    }
}