package day7;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
public class ShowDateTime {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 300);
        jFrame.setTitle("显示日期时间");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setAlwaysOnTop(true);
        jFrame.setLayout(null);
        JLabel dateJLabel = new JLabel("日期");
        dateJLabel.setBounds(50, 50, 100, 20);
        jFrame.add(dateJLabel);
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        String dateStr = DateTimeFormatter.ofPattern("yyyy 年 MM 月 dd 日").format(localDate);
        JLabel dateStrJLabel = new JLabel(dateStr);
        dateStrJLabel.setBounds(50, 80, 200, 20);
        jFrame.add(dateStrJLabel);
        JLabel timeJLabel = new JLabel("时间");
        timeJLabel.setBounds(50, 150, 100, 20);
        jFrame.add(timeJLabel);
        LocalTime localTime = localDateTime.toLocalTime();
        String timeStr = DateTimeFormatter.ofPattern("HH 时 mm 分 ss 秒").format(localTime);
        JLabel timeStrJLabel = new JLabel(timeStr);
        timeStrJLabel.setBounds(50, 180, 200, 20);
        jFrame.add(timeStrJLabel);
        jFrame.setVisible(true);
    }
}