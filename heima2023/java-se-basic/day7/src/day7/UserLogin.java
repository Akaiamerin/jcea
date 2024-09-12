package day7;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class UserLogin {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 300);
        jFrame.setTitle("用户登录");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setAlwaysOnTop(true);
        jFrame.setLayout(null);
        JLabel usernameJLabel = new JLabel("用户名");
        usernameJLabel.setBounds(50, 50, 50, 20);
        jFrame.add(usernameJLabel);
        JTextField usernameJTextField = new JTextField();
        usernameJTextField.setBounds(150, 50, 180, 20);
        jFrame.add(usernameJTextField);
        JLabel passwordJLabel = new JLabel("密码");
        passwordJLabel.setBounds(50, 100, 50, 20);
        jFrame.add(passwordJLabel);
        JPasswordField passwordJTextField = new JPasswordField();
        passwordJTextField.setBounds(150, 100, 180, 20);
        jFrame.add(passwordJTextField);
        JButton submitJButton = new JButton("登录");
        submitJButton.setBounds(50, 200, 280, 20);
        jFrame.add(submitJButton);
        String defaultUsername = "admin";
        char[] defaultPassword = new char[]{'1', '1', '1', '1', '1', '1'};
        submitJButton.addActionListener((ActionEvent event)->{
            String username = usernameJTextField.getText();
            char[] password = passwordJTextField.getPassword();
            if (Objects.equals(username, defaultUsername) == true && Arrays.equals(password, defaultPassword) == true) {
                JOptionPane.showMessageDialog(jFrame, "登录成功");
                usernameJTextField.setText("");
                passwordJTextField.setText("");
            }
            else {
                JOptionPane.showMessageDialog(jFrame, "用户名或密码错误");
            }
        });
        jFrame.setVisible(true);
    }
}