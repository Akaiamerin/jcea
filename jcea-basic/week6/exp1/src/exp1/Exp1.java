package exp1;
class Fan {
    private static final Integer SLOW = 1;
    private static final Integer MEDIUM = 2;
    private static final Integer FAST = 3;
    private Integer speed;
    private Boolean on;
    private Double radius;
    private String color;
    public Fan() {
        speed = Fan.SLOW;
        on = false;
        radius = 5.0;
        color = "blue";
    }
    public Fan(Integer speed, Boolean on, Double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    public Integer getSpeed() {
        return speed;
    }
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
    public Boolean getOn() {
        return on;
    }
    public void setOn(Boolean on) {
        this.on = on;
    }
    public Double getRadius() {
        return radius;
    }
    public void setRadius(Double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        String str = speed + " " +
                radius + " " +
                color + " ";
        if (on == true) {
            str += "fan is on";
        }
        else {
            str += "fan is off";
        }
        return str;
    }
}
public class Exp1 {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        System.out.println(fan1);
        Fan fan2 = new Fan(Fan.FAST, true, 10.0, "white");
        System.out.println(fan2);
    }
}