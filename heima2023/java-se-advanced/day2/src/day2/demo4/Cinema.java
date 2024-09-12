package day2.demo4;
public class Cinema implements Charge, Play {
    public Cinema() {

    }
    @Override
    public void charge() {
        System.out.println("电影院：30 元/张，凭学生证享受半价。");
    }
    @Override
    public void play() {
        System.out.println("正在放映电影。");
    }
}