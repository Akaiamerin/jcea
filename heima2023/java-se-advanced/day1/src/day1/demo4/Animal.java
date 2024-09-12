package day1.demo4;
public abstract class Animal extends Food {
    private String variety;
    private Double Price;
    public Animal() {

    }
    public Animal(Double weight, String variety, Double price) {
        super(weight);
        this.variety = variety;
        Price = price;
    }
    public String getVariety() {
        return variety;
    }
    public void setVariety(String variety) {
        this.variety = variety;
    }
    public Double getPrice() {
        return Price;
    }
    public void setPrice(Double price) {
        Price = price;
    }
}