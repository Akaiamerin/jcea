package day1.demo4;
public abstract class Food {
    private Double weight;
    public Food() {

    }
    public Food(Double weight) {
        this.weight = weight;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public abstract void eat();
}