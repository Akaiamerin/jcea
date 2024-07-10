package exp3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Exp3 {
    public static void initPoker(List<String> poker, List<String> figure, List<String> suit) {
        for (int i = 0; i < suit.size(); i++) {
            for (int j = 0; j < figure.size(); j++) {
                poker.add(suit.get(i) + figure.get(j));
            }
        }
    }
    public static List<List<String>> dealPoker(List<String> poker) {
        List<String> card1 = new ArrayList<>();
        List<String> card2 = new ArrayList<>();
        List<String> card3 = new ArrayList<>();
        Collections.shuffle(poker);
        for (int i = 0; i < poker.size(); i++) {
            if (i % 3 == 0) {
                card1.add(poker.get(i));
            }
            else if (i % 3 == 1) {
                card2.add(poker.get(i));
            }
            else if (i % 3 == 2) {
                card3.add(poker.get(i));
            }
        }
        List<List<String>> playerList = new ArrayList<>(Arrays.asList(card1, card2, card3));
        return playerList;
    }
    public static void outputPoker(List<String> poker, List<List<String>> playerList) {
        System.out.print("底牌：");
        for (int i = poker.size() - 3; i < poker.size(); i++) {
            System.out.print(poker.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < playerList.size(); i++) {
            System.out.print(i + "号玩家的牌：");
            for (int j = 0; j < playerList.get(i).size(); j++) {
                System.out.print(playerList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        List<String> poker = new ArrayList<>(Arrays.asList("大王", "小王"));
        List<String> suit = new ArrayList<>(Arrays.asList("黑桃", "红桃", "梅花", "方块"));
        List<String> figure = new ArrayList<>(Arrays.asList("3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"));
        initPoker(poker, figure, suit);
        outputPoker(poker, dealPoker(poker));
    }
}