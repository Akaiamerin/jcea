package exp2;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
class SimpleImageProcessing {
    private class SimpleImageProcessingJFrame extends JFrame {
        private BufferedImage img;
        private int width;
        private int height;
        private int rotateVal = 0;
        private double tiltX = 0.0;
        private double tiltY = 0.0;
        private JSlider scaleJSlider;
        private int option = 0;
        private static final int ROTATE = 1;
        private static final int TILT = 2;
        private static final int HOR_STITCH = 3;
        private static final int VERT_STITCH = 4;
        private static final int SCALE = 5;
        private class GraphJPanel extends JPanel {
            public GraphJPanel() {

            }
            @Override
            public void paint(Graphics graph) {
                Graphics2D graph2D = (Graphics2D) graph;
                graph2D.clearRect(0, 0, this.getWidth(), this.getHeight());
                int x = width / 4 + width / 2;
                int y = height / 3;
                graph2D.drawImage(img, x, y, width, height, this);
                if (option == SimpleImageProcessingJFrame.ROTATE) {
                    graph2D.clearRect(0, 0, this.getWidth(), this.getHeight());
                    graph2D.rotate(Math.toRadians(rotateVal), x + width / 2, y + height / 2);
                    graph2D.drawImage(img, x, y, width, height, this);
                }
                else if (option == SimpleImageProcessingJFrame.TILT) {
                    graph2D.clearRect(0, 0, this.getWidth(), this.getHeight());
                    graph2D.shear(tiltX, tiltY);
                    graph2D.drawImage(img, x, y, width, height, this);
                }
                else if (option == SimpleImageProcessingJFrame.HOR_STITCH) {
                    graph2D.clearRect(0, 0, this.getWidth(), this.getHeight());
                    graph2D.drawImage(img, x, y, width, height, this);
                    graph2D.drawImage(img, x + width, y, width, height, this);
                }
                else if (option == SimpleImageProcessingJFrame.VERT_STITCH) {
                    graph2D.clearRect(0, 0, this.getWidth(), this.getHeight());
                    graph2D.drawImage(img, x, y, width, height, this);
                    graph2D.drawImage(img, x, y + height, width, height, this);
                }
                else if (option == SimpleImageProcessingJFrame.SCALE) {
                    graph2D.clearRect(0, 0, this.getWidth(), this.getHeight());
                    float scaleValue = scaleJSlider.getValue();
                    int newWidth = (int) (width * scaleValue / 100);
                    int newHeight = (int) (height * scaleValue / 100);
                    graph2D.drawImage(img, x, y, newWidth, newHeight, this);
                }
                graph2D.dispose();
            }
        }
        public SimpleImageProcessingJFrame(String path) {
            try {
                img = ImageIO.read(new File(path));
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
            width = img.getWidth();
            height = img.getHeight();
            JButton rotateBtn = new JButton("旋转（方向键）");
            JButton TiltBtn = new JButton("倾斜（方向键）");
            JButton horStitchBtn = new JButton("水平拼接");
            JButton vertStitchBtn = new JButton("垂直拼接");
            scaleJSlider = new JSlider(1, 1000, 100);
            GraphJPanel graphJPanel = new GraphJPanel();
            rotateBtn.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent event) {
                    if (event.getKeyCode() == KeyEvent.VK_UP) {
                        option = SimpleImageProcessingJFrame.ROTATE;
                        rotateVal--;
                    }
                    else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
                        option = SimpleImageProcessingJFrame.ROTATE;
                        rotateVal++;
                    }
                    graphJPanel.repaint();
                }
            });
            TiltBtn.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent event) {
                    if (event.getKeyCode() == KeyEvent.VK_UP) {
                        option = SimpleImageProcessingJFrame.TILT;
                        tiltY -= 0.1;
                    }
                    else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
                        option = SimpleImageProcessingJFrame.TILT;
                        tiltY += 0.1;
                    }
                    else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
                        option = SimpleImageProcessingJFrame.TILT;
                        tiltX -= 0.1;
                    }
                    else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
                        option = SimpleImageProcessingJFrame.TILT;
                        tiltX += 0.1;
                    }
                    graphJPanel.repaint();
                }
            });
            horStitchBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    option = SimpleImageProcessingJFrame.HOR_STITCH;
                    graphJPanel.repaint();
                }
            });
            vertStitchBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    option = SimpleImageProcessingJFrame.VERT_STITCH;
                    graphJPanel.repaint();
                }
            });
            scaleJSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent event) {
                    option = SimpleImageProcessingJFrame.SCALE;
                    graphJPanel.repaint();
                }
            });
            JPanel jPanel = new JPanel();
            jPanel.add(rotateBtn);
            jPanel.add(TiltBtn);
            jPanel.add(horStitchBtn);
            jPanel.add(vertStitchBtn);
            jPanel.add(scaleJSlider);
            add(jPanel, BorderLayout.SOUTH);
            add(graphJPanel, BorderLayout.CENTER);
            setTitle("简单图像处理界面");
            setSize(800, 600);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }
    public SimpleImageProcessing(String path) {
        new SimpleImageProcessingJFrame(path);
    }
}
public class Exp2 {
    public static void main(String[] args) {
        String path = "./src/main/resources/img.jpg";
        new SimpleImageProcessing(path);
    }
}