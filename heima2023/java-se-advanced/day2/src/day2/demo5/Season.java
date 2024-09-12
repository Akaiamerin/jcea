package day2.demo5;
public enum Season {
    SPRING("春"),
    SUMMER("夏"),
    AUTUMN("秋"),
    WINTER("冬");
    private String description;
    Season() {

    }
    Season(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}