import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    private final char[][] hand = new char[5][23];

    public Hand(){
        fillHand();
    }

    int returnTotal(){
        int total = 0;
        for (Card card : cards) {
            total = total + card.getCardNum();
            if (total >= 10) {
                total = total % 10;
            }
        }
        return total;
    }

    void addCard(Card card){
        cards.add(card);
        placeCard();
    }

    void placeCard(){

        int i=0;
        int start = 0;
        int end = 7;
        while (i<cards.size()){
            char[][] card = cards.get(i).getCard();

            for (int j =0; j<5; j++){
                for(int k=start, _k=0; k<end; k++){

                    hand[j][k] = card[j][_k++];
                }
            }
            start+=8;
            end+=8;
            i++;
        }

    }

    void printHand() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 23; j++) {
                System.out.print(hand[i][j]);
            }
            System.out.println();
        }

    }

    void fillHand() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 23; j++) {
               hand[i][j] =' ';
            }

        }

    }
}
