package exp2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class Exp2 {
    public static String createFile(Scanner sc) {
        System.out.println("请输入内容，停止请输入 stop：");
        StringBuilder strBld = new StringBuilder();
        while (true) {
            String str = sc.nextLine();
            if (Objects.equals(str, "stop") == true) {
                break;
            }
            if (str.length() > 0) {
                strBld.append(str).append(System.lineSeparator());
            }
            else {
                strBld.append(str);
            }
        }
        return String.valueOf(strBld);
    }
    public static void openFile(Scanner sc) {
        System.out.print("请输入打开文件路径：");
        String path = sc.nextLine();
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
    public static void editFile(Scanner sc) {
        System.out.print("请输入修改文件路径：");
        String path = sc.nextLine();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String str = null;
            StringBuilder oldStrBld = new StringBuilder();
            while ((str = br.readLine()) != null) {
                oldStrBld.append(str);
            }
            System.out.println("请输入要修改的内容（修改前的文字:修改后的文字），停止修改请输入 stop：");
            String editStr = null;
            while (true) {
                editStr = sc.nextLine();
                if (Objects.equals(editStr, "stop") == true) {
                    break;
                }
                if (editStr.length() > 0) {
                    String[] newStrArr = editStr.split(":");
                    if (newStrArr.length > 0) {
                        oldStrBld = new StringBuilder(String.valueOf(oldStrBld).replace(newStrArr[0], newStrArr[1]));
                    }
                }
            }
            bw = new BufferedWriter(new FileWriter(path, true));
            bw.write(String.valueOf(oldStrBld));
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
                if (br != null) {
                    br.close();
                }
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
    public static void saveFile(String str, Scanner sc) {
        System.out.print("保存文件路径：");
        String path = sc.nextLine();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path, true));
            bw.write(str);
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = null;
        while (true) {
            System.out.println("1: 新建文件 2: 打开文件 3: 修改文件 4: 保存文件 5: 退出");
            int option = sc.nextInt();
            if (option == 1) {
                str = createFile(sc);
            }
            else if (option == 2) {
                openFile(sc);
            }
            else if (option == 3) {
                editFile(sc);
            }
            else if (option == 4) {
                saveFile(str, sc);
            }
            else if (option == 5) {
                break;
            }
        }
        sc.close();
    }
}