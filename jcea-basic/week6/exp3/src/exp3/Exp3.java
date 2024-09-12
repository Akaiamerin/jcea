package exp3;
class Poker {
    private static class Card {
        private String suit;
        private String figure;
        private static final String[] SUIT_ARR = {"黑桃", "红桃", "梅花", "方块"};
        private static final String[] FIGURE_ARR = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        public Card() {

        }
        public Card(String suit, String figure) {
            this.suit = suit;
            this.figure = figure;
        }
        @Override
        public String toString() {
            return suit + " " + figure;
        }
    }
    private Card[] card;
    public Poker() {
        card = new Card[52];
        for (int i = 0; i < Card.SUIT_ARR.length; i++) {
            for (int j = 0; j < Card.FIGURE_ARR.length; j++) {
                card[i * 13 + j] = new Card(Card.SUIT_ARR[i], Card.FIGURE_ARR[j]);
            }
        }
    }
    public void shufflePoker() {
        for (int i = 0; i < card.length; i++) {
            int randIndex1 = (int) (Math.random() * card.length);
            int randIndex2 = (int) (Math.random() * card.length);
            Card temp = card[randIndex1];
            card[randIndex1] = card[randIndex2];
            card[randIndex2] = temp;
        }
    }
    public void dealPoker() {
        for (int i = 0; i < card.length; i++) {
            System.out.println(card[i]);
        }
    }
}
public class Exp3 {
    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.shufflePoker();
        poker.dealPoker();
    }
}