package exp3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Exp3 {
    private static final String PATH = "./src/exp3/Exp3.txt";
    public static void refreshFile(Map<String, Integer> voteMap) {
        StringBuilder strBld = new StringBuilder();
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            strBld.append(entry.getKey()).append("：").append(entry.getValue());
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(PATH));
            bw.write(String.valueOf(strBld));
            bw.newLine();
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
    public static void insertElector(Map<String, Integer> voteMap, Scanner sc) {
        System.out.print("请输入需要被投票的人姓名：");
        String electorName = sc.next();
        System.out.print("请输入" + electorName + "的起始票数：");
        int voteNum = sc.nextInt();
        voteMap.put(electorName, voteNum);
        refreshFile(voteMap);
    }
    public static void OutputVote() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(PATH));
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
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
    public static void InputVote(Map<String, Integer> voteMap, Scanner sc) {
        System.out.print("请输入要投票的人的姓名：");
        String voterName = sc.next();
        voteMap.put(voterName, voteMap.getOrDefault(voterName, 0) + 1);
        refreshFile(voteMap);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> voteMap = new HashMap<>();
        while (true) {
            System.out.println("1. 添加候选人 2. 查看当前投票 3. 投票 4. 退出");
            int option = sc.nextInt();
            if (option == 1) {
                insertElector(voteMap, sc);
            }
            else if (option == 2) {
                OutputVote();
            }
            else if (option == 3) {
                InputVote(voteMap, sc);
            }
            else if (option == 4) {
                break;
            }
        }
        sc.close();
    }
}