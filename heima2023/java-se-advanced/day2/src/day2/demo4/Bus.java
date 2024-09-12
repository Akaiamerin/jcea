package day2.demo4;
public class Bus implements Charge {
    public Bus() {

    }
    @Override
    public void charge() {
        System.out.println("公共汽车：1 元/张，不计公里数。");
    }
}