package day5;
public class WaterDispenser {
    private String brand;
    private String color;
    private Integer capacity;
    private String model;
    public WaterDispenser() {

    }
    public WaterDispenser(String brand, String color, Integer capacity, String model) {
        this.brand = brand;
        this.color = color;
        this.capacity = capacity;
        this.model = model;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void output() {
        System.out.println("品牌：" + brand);
        System.out.println("颜色：" + color);
        System.out.println("容量：" + capacity + "L");
        System.out.println("模式：" + model);
    }
}