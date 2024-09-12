package day2.demo5;
public class Demo5 {
    public static void main(String[] args) {
        Direction[] directionArr = Direction.values();
        for (int i = 0; i < directionArr.length; i++) {
            System.out.println(directionArr[i] + "：" + directionArr[i].getDescription());
        }
        Season[] seasonArr = Season.values();
        for (int i = 0; i < seasonArr.length; i++) {
            System.out.println(seasonArr[i] + "：" + seasonArr[i].getDescription());
        }
        Week[] weekArr = Week.values();
        for (int i = 0; i < weekArr.length; i++) {
            System.out.println(weekArr[i] + "：" + weekArr[i].getDescription());
        }
        Month[] monthArr = Month.values();
        for (int i = 0; i < monthArr.length; i++) {
            System.out.println(monthArr[i] + "：" + monthArr[i].getDescription());
        }
    }
}