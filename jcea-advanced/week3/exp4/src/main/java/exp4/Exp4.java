package exp4;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;
class Clock {
    private class ClockJFrame extends JFrame implements Runnable {
        private class TimeJPanel extends JPanel {
            public TimeJPanel() {

            }
            @Override
            public void paint(Graphics graph) {
                Graphics2D graph2D = (Graphics2D) graph;
                graph2D.setColor(Color.WHITE);
                graph2D.fill(new Rectangle2D.Double(0, 0, 400, 200));
                graph2D.setColor(Color.BLACK);
                graph2D.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                graph2D.drawString(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒")), 15, 80);
                graph2D.dispose();
            }
        }
        public ClockJFrame() {
            add(new ClockJFrame.TimeJPanel());
            setTitle("电子时钟");
            setSize(400, 200);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
        @Override
        public void run() {
            while (true) {
                try {
                    repaint();
                    Thread.sleep(1000);
                }
                catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            }
        }
        public void start() {
            new Thread(this).start();
        }
    }
    public Clock() {

    }
    public void simulate() {
        new ClockJFrame().start();
    }
}
public class Exp4 {
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.simulate();
    }
}