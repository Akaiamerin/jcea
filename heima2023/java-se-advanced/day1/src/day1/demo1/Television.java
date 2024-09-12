package day1.demo1;
public class Television extends Appliance {
    private Double screenSize;
    private Double resolution;
    public Television() {

    }
    public Television(String brand, String model, String color, Double price, Double screenSize, Double resolution) {
        super(brand, model, color, price);
        this.screenSize = screenSize;
        this.resolution = resolution;
    }
    public Double getScreenSize() {
        return screenSize;
    }
    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }
    public Double getResolution() {
        return resolution;
    }
    public void setResolution(Double resolution) {
        this.resolution = resolution;
    }
}