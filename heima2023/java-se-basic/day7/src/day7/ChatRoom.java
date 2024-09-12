package day7;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class ChatRoom {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 300);
        jFrame.setTitle("聊天室");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setAlwaysOnTop(true);
        jFrame.setLayout(null);
        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(10, 10, 360, 200);
        jFrame.add(jTextArea);
        JTextField jTextField = new JTextField();
        jTextField.setBounds(10, 230, 200, 20);
        jFrame.add(jTextField);
        JButton sendJBtn = new JButton("发送");
        sendJBtn.setBounds(220, 230, 70, 20);
        sendJBtn.addActionListener((ActionEvent event)->{
            String str = jTextField.getText().trim();
            jTextArea.append(str + System.lineSeparator());
            jTextField.setText("");
        });
        jFrame.add(sendJBtn);
        JButton clearJBtn = new JButton("清空");
        clearJBtn.setBounds(300, 230, 70, 20);
        clearJBtn.addActionListener((ActionEvent event)->{
            jTextArea.setText("");
        });
        jFrame.add(clearJBtn);
        jFrame.setVisible(true);
    }
}