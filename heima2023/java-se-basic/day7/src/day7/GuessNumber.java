package day7;
import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class GuessNumber {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 300);
        jFrame.setTitle("猜数字");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setAlwaysOnTop(true);
        jFrame.setLayout(null);
        JLabel jLabel = new JLabel("系统产生了一个 1-100 的随机整数，猜一猜");
        jLabel.setBounds(70, 50, 350, 20);
        jFrame.add(jLabel);
        JTextField jTextField = new JTextField();
        jTextField.setBounds(150, 100, 100, 20);
        jFrame.add(jTextField);
        JButton jButton = new JButton("我猜");
        int randomNumber = new Random().nextInt(1, 101);
        jButton.addActionListener((ActionEvent event)->{
            String guessNumber = jTextField.getText().trim();
            if (Objects.equals(guessNumber, "") == true) {
                JOptionPane.showMessageDialog(jFrame, "数字不能为空！");
                return;
            }
            int number = Integer.parseInt(guessNumber);
            if (number < 1 || number > 100) {
                JOptionPane.showMessageDialog(jFrame, "数字不在 1-100 之间！");
                jTextField.setText("");
            }
            else if (number < randomNumber) {
                JOptionPane.showMessageDialog(jFrame, "数字猜小了!");
                jTextField.setText("");
            }
            else if (number > randomNumber) {
                JOptionPane.showMessageDialog(jFrame, "数字猜大了!");
                jTextField.setText("");
            }
            else {
                JOptionPane.showMessageDialog(jFrame, "数字猜对了!");
            }
        });
        jButton.setBounds(150, 150, 100, 20);
        jFrame.add(jButton);
        jFrame.setVisible(true);
    }
}