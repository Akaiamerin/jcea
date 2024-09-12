package day12.demo7;
public class King2 {
    private String name;
    private static King2 king2 = null;
    private King2(String name) {
        this.name = name;
    }
    public static synchronized King2 getInstance() {
        if (king2 == null) {
            king2 = new King2("皇帝");
        }
        return king2;
    }
}