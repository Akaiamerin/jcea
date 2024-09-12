package day2.demo6;
public enum Gender {
    BOY("男"),
    GIRL("女");
    private String description;
    Gender() {

    }
    Gender(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}