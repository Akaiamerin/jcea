package day2.demo5;
public enum Month {
    JANUARY("一月"),
    FEBRUARY("二月"),
    MARCH("三月"),
    APRIL("四月"),
    MAY("五月"),
    JUNE("六月"),
    JULY("七月"),
    AUGUST("八月"),
    SEPTEMBER("九月"),
    OCTOBER("十月"),
    NOVEMBER("十一月"),
    DECEMBER("十二月");
    private String description;
    Month() {

    }
    Month(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}