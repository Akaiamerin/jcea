package day1.demo4;
public class Banana extends Vegetative {
    public Banana() {

    }
    @Override
    public void eat() {
        System.out.println("脆皮香蕉");
    }
    @Override
    public void use() {
        System.out.println("做香蕉面膜");
    }
}