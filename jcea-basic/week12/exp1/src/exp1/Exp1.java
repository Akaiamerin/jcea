package exp1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
class Diary {
    private String name;
    private String weather;
    private String title;
    private String content;
    public Diary() {

    }
    public Diary(String name, String weather, String title, String content) {
        this.name = name;
        this.weather = weather;
        this.title = title;
        this.content = content;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
public class Exp1 {
    public static void writeDiary(String path, Diary diary, Scanner sc) {
        System.out.print("请输入姓名：");
        diary.setName("姓名：" + sc.nextLine());
        System.out.print("请输入天气：");
        diary.setWeather("天气：" + sc.nextLine());
        System.out.print("请输入标题：");
        diary.setTitle("标题：" + sc.nextLine());
        System.out.print("请输入内容：");
        diary.setContent("内容：" + sc.nextLine());
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path, true));
            String diaryDate = "日期：" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            bw.write(diaryDate + " ");
            bw.write(diary.getName() + " ");
            bw.write(diary.getWeather() + " ");
            bw.write(diary.getTitle() + " ");
            bw.write(diary.getContent());
            bw.newLine();
            bw.flush();
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static void readDiary(String path) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String str = null;
            StringBuilder strBld = new StringBuilder();
            while ((str = br.readLine()) != null) {
                strBld.append(str);
            }
            System.out.println(strBld);
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            try {
                if (br != null) {
                    br.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "./src/exp1/exp1.txt";
        Diary diary = new Diary();
        while (true) {
            System.out.println("日记本");
            System.out.println("1. 编写日记");
            System.out.println("2. 查看日记");
            int option = sc.nextInt();
            if (option == 1) {
                writeDiary(path, diary, sc);
            }
            else if (option == 2) {
                readDiary(path);
            }
            else {
                break;
            }
        }
        sc.close();
    }
}