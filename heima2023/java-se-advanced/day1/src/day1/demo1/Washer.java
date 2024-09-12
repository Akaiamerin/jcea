package day1.demo1;
public class Washer extends Appliance {
    private String motorType;
    private Double capacity;
    public Washer() {

    }
    public Washer(String brand, String model, String color, Double price, String motorType, Double capacity) {
        super(brand, model, color, price);
        this.motorType = motorType;
        this.capacity = capacity;
    }
    public String getMotorType() {
        return motorType;
    }
    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }
    public Double getCapacity() {
        return capacity;
    }
    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }
}