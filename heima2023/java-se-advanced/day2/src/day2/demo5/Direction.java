package day2.demo5;
public enum Direction {
    UP("上"),
    DOWN("下"),
    LEFT("左"),
    RIGHT("右");
    private String description;
    Direction() {

    }
    Direction(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}