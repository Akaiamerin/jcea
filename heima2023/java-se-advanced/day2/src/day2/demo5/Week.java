package day2.demo5;
public enum Week {
    SUNDAY("星期日"),
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六");
    private String description;
    Week() {

    }
    Week(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}