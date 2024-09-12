package day2.demo4;
public class Taxi implements Charge {
    public Taxi() {

    }
    @Override
    public void charge() {
        System.out.println("出租车：1.6 元/公里，起价 3 公里。");
    }
}