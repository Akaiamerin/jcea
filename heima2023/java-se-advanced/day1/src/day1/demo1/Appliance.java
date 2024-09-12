package day1.demo1;
public abstract class Appliance {
    private String brand;
    private String model;
    private String color;
    private Double price;
    public Appliance() {

    }
    public Appliance(String brand, String model, String color, Double price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}