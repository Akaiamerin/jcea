package day1.demo4;
public abstract class Vegetative extends Food {
    private String color;
    public Vegetative() {

    }
    public Vegetative(Double weight, String color) {
        super(weight);
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public abstract void use();
}