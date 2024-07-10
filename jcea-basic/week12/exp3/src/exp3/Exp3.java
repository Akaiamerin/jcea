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
    public static void refreshFile(String path, Map<String, Integer> voteMap) {
        StringBuilder strBld = new StringBuilder();
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            strBld.append(entry.getKey()).append("：").append(entry.getValue());
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            bw.write(String.valueOf(strBld));
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
    public static void insertElector(String path, Map<String, Integer> voteMap, Scanner sc) {
        System.out.print("请输入需要被投票的人姓名：");
        String electorName = sc.nextLine();
        System.out.print("请输入" + electorName + "的起始票数：");
        int voteNum = sc.nextInt();
        voteMap.put(electorName, voteNum);
        refreshFile(path, voteMap);
    }
    public static void outputVote(String path) {
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
    public static void inputVote(String path, Map<String, Integer> voteMap, Scanner sc) {
        System.out.print("请输入要投票的人的姓名：");
        String voterName = sc.nextLine();
        voteMap.put(voterName, voteMap.getOrDefault(voterName, 0) + 1);
        refreshFile(path, voteMap);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "./src/exp3/exp3.txt";
        Map<String, Integer> voteMap = new HashMap<>();
        while (true) {
            System.out.println("1. 添加候选人 2. 查看当前投票 3. 投票 4. 退出");
            int option = sc.nextInt();
            if (option == 1) {
                insertElector(path, voteMap, sc);
            }
            else if (option == 2) {
                outputVote(path);
            }
            else if (option == 3) {
                inputVote(path, voteMap, sc);
            }
            else if (option == 4) {
                break;
            }
        }
        sc.close();
    }
}