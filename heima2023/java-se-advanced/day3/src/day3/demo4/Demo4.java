package day3.demo4;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Demo4 {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒")));
    }
}