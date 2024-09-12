package day12.demo7;
public class King1 {
    private String name;
    private static King1 king1 = new King1("皇帝");
    private King1(String name) {
        this.name = name;
    }
    public static King1 getInstance() {
        return king1;
    }
}