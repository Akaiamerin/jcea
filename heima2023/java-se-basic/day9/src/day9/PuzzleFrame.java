package day9;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
public class PuzzleFrame extends JFrame {
    private static final String PATH = "day9/img/";
    //图片编号数组（原始数组）
    private int[][] curImgIndexArr = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    //游戏成功的图片编号数组（前 15 张图片到位，证明成功）
    private int[][] distImgIndexArr = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    private JPanel imgPanel;
    //0 号图片在每一次打乱后的索引
    private int x0;
    private int y0;
    private JButton upBtn;
    private JButton downBtn;
    private JButton leftBtn;
    private JButton rightBtn;
    private JButton helpBtn;
    private JButton resetBtn;
    //初始化
    public void initFrame() {
        setSize(960, 565);
        setTitle("动漫拼图");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLayout(null);
    }
    //打乱图片下标
    public void getRandomImgIndexArr() {
        Random random = new Random();
        for (int i = 0; i < curImgIndexArr.length; i++) {
            for (int j = 0; j < curImgIndexArr[i].length; j++) {
                int x = random.nextInt(i, curImgIndexArr.length);
                int y = random.nextInt(j, curImgIndexArr[i].length);
                int temp = curImgIndexArr[i][j];
                curImgIndexArr[i][j] = curImgIndexArr[x][y];
                curImgIndexArr[x][y] = temp;
            }
        }
        for (int i = 0; i < curImgIndexArr.length; i++) {
            for (int j = 0; j < curImgIndexArr[i].length; j++) {
                if (curImgIndexArr[i][j] == 0) {
                    x0 = i;
                    y0 = j;
                    return;
                }
            }
        }
    }
    //设置图片位置
    public void setImg(JPanel imgPanel) {
        for (int i = 0; i < curImgIndexArr.length; i++) {
            for (int j = 0; j < curImgIndexArr[i].length; j++) {
                JLabel imgLabel = new JLabel(new ImageIcon(PATH + curImgIndexArr[i][j] + ".png"));
                imgLabel.setBounds(j * 90, i * 90, 90, 90);
                imgPanel.add(imgLabel);
            }
        }
    }
    //初始化视图
    public void initView() {
        JLabel titleLabel = new JLabel(new ImageIcon(PATH + "title.png"));
        titleLabel.setBounds(209, 27, 232, 57);
        add(titleLabel);
        imgPanel = new JPanel();
        setImg(imgPanel);
        imgPanel.setLayout(null);
        imgPanel.setBounds(150, 114, 360, 360);
        add(imgPanel);
        JLabel referImgLabel = new JLabel(new ImageIcon(PATH + "refer.png"));
        referImgLabel.setBounds(574, 114, 122, 121);
        add(referImgLabel);
        upBtn = new JButton(new ImageIcon(PATH + "up.png"));
        upBtn.setBounds(732, 265, 57, 57);
        add(upBtn);
        downBtn = new JButton(new ImageIcon(PATH + "down.png"));
        downBtn.setBounds(732, 347, 57, 57);
        add(downBtn);
        leftBtn = new JButton(new ImageIcon(PATH + "left.png"));
        leftBtn.setBounds(650, 347, 57, 57);
        add(leftBtn);
        rightBtn = new JButton(new ImageIcon(PATH + "right.png"));
        rightBtn.setBounds(813, 347, 57, 57);
        add(rightBtn);
        helpBtn = new JButton(new ImageIcon(PATH + "help.png"));
        helpBtn.setBounds(626, 444, 108, 45);
        add(helpBtn);
        resetBtn = new JButton(new ImageIcon(PATH + "reset.png"));
        resetBtn.setBounds(786, 444, 108, 45);
        add(resetBtn);
        JLabel backgroundLabel = new JLabel(new ImageIcon(PATH + "background.png"));
        backgroundLabel.setBounds(0, 0, 968, 530);
        add(backgroundLabel);
    }
    //判断游戏是否成功
    public boolean isSuccess() {
        for (int i = 0; i < curImgIndexArr.length; i++) {
            for (int j = 0; j < curImgIndexArr[i].length; j++) {
                if (curImgIndexArr[i][j] != distImgIndexArr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    //游戏成功
    public void success() {
        for (int i = 0; i < curImgIndexArr.length; i++) {
            curImgIndexArr[i] = Arrays.copyOfRange(distImgIndexArr[i], 0, distImgIndexArr[i].length);
        }
        curImgIndexArr[curImgIndexArr.length - 1][curImgIndexArr[curImgIndexArr.length - 1].length - 1] = curImgIndexArr.length * curImgIndexArr[curImgIndexArr.length - 1].length;
        upBtn.setEnabled(false);
        downBtn.setEnabled(false);
        rightBtn.setEnabled(false);
        leftBtn.setEnabled(false);
    }
    //重绘视图
    public void repaintView() {
        imgPanel.removeAll();
        setImg(imgPanel);
        add(imgPanel);
        imgPanel.repaint();
    }
    //给按钮添加事件
    public void addBtnEvent() {
        upBtn.addActionListener((ActionEvent event)->{
            if (x0 == 3) {
                return;
            }
            curImgIndexArr[x0][y0] = curImgIndexArr[x0 + 1][y0];
            curImgIndexArr[x0 + 1][y0] = 0;
            x0 = x0 + 1;
            if (isSuccess() == true) {
                success();
            }
            repaintView();
        });
        downBtn.addActionListener((ActionEvent event)->{
            if (x0 == 0) {
                return;
            }
            curImgIndexArr[x0][y0] = curImgIndexArr[x0 - 1][y0];
            curImgIndexArr[x0 - 1][y0] = 0;
            x0 = x0 - 1;
            if (isSuccess() == true) {
                success();
            }
            repaintView();
        });
        leftBtn.addActionListener((ActionEvent event)->{
            if (y0 == 3) {
                return;
            }
            curImgIndexArr[x0][y0] = curImgIndexArr[x0][y0 + 1];
            curImgIndexArr[x0][y0 + 1] = 0;
            y0 = y0 + 1;
            if (isSuccess() == true) {
                success();
            }
            repaintView();
        });
        rightBtn.addActionListener((ActionEvent event)->{
            if (y0 == 0) {
                return;
            }
            curImgIndexArr[x0][y0] = curImgIndexArr[x0][y0 - 1];
            curImgIndexArr[x0][y0 - 1] = 0;
            y0 = y0 - 1;
            if (isSuccess() == true) {
                success();
            }
            repaintView();
        });
        helpBtn.addActionListener((ActionEvent event)->{
            success();
            repaintView();
        });
        resetBtn.addActionListener((ActionEvent event)->{
            for (int i = 0; i < curImgIndexArr.length; i++) {
                curImgIndexArr[i] = Arrays.copyOfRange(distImgIndexArr[i], 0, distImgIndexArr[i].length);
            }
            getRandomImgIndexArr();
            repaintView();
            upBtn.setEnabled(true);
            downBtn.setEnabled(true);
            leftBtn.setEnabled(true);
            rightBtn.setEnabled(true);
        });
    }
    public PuzzleFrame() {
        initFrame();
        getRandomImgIndexArr();
        initView();
        addBtnEvent();
        setVisible(true);
    }
}