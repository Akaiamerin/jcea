package day1.demo1;
public class Fridge extends Appliance {
    private String style;
    private String coolingMethod;
    public Fridge() {

    }
    public Fridge(String brand, String model, String color, Double price, String style, String coolingMethod) {
        super(brand, model, color, price);
        this.style = style;
        this.coolingMethod = coolingMethod;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public String getCoolingMethod() {
        return coolingMethod;
    }
    public void setCoolingMethod(String coolingMethod) {
        this.coolingMethod = coolingMethod;
    }
}