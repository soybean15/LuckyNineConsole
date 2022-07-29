import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> deck = new ArrayList<>();

    public Deck(){
        generateCards();
    }

    Card getCard(int index){
        return deck.get(index);
    }

    void shuffleDeck(){
        Collections.shuffle(deck);

    }
   private void generateCards(){
        Card card =null;
        char[] symbols ={'♦','♥','♠','♣'};
        for(int i = 0;i<4;i++){
            char symbol = symbols[i];
            for(int j = 1; j<=10;j++){
                card = new Card(j, symbol);
                this.deck.add(card);
            }
        }
    }
}
