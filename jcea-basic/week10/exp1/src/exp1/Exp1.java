package exp1;
class Miami<T> {
    private T name;
    private T year1;
    private T year2;
    private T year3;
    public Miami() {

    }
    public Miami(T name, T year1, T year2, T year3) {
        this.name = name;
        this.year1 = year1;
        this.year2 = year2;
        this.year3 = year3;
    }
    @Override
    public String toString() {
        return name + " " +
                year1 + " " +
                year2 + " " +
                year3;
    }
}
class Detroit<T> extends Miami<T> {
    public Detroit() {

    }
    public Detroit(T name, T year1, T year2, T year3) {
        super(name, year1, year2, year3);
    }
}
class Philadelphia<T> extends Miami<T> {
    public Philadelphia() {

    }
    public Philadelphia(T name, T year1, T year2, T year3) {
        super(name, year1, year2, year3);
    }
}
public class Exp1 {
    public static void main(String[] args) {
        Miami<String> miami = new Miami<>("迈阿密热火队", "2006", "2012", "2013");
        System.out.println(miami);
        Detroit<String> detroit = new Detroit<>("底特律活塞队", "1989", "1990", "2004");
        System.out.println(detroit);
        Philadelphia<String> philadelphia = new Philadelphia<>("费城 76 人队", "1955", "1967", "1983");
        System.out.println(philadelphia);
    }
}