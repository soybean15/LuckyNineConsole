import java.util.Scanner;

public class LuckyNine {
    Scanner sc = new Scanner(System.in);
    void start(){
        Deck deck = new Deck();
        deck.shuffleDeck();

        Player[] player = new Player[5];
        int  i= 0;
        int j =0;
        while (i<3){
            for (int k = 0; k < player.length; k++) {
                if (player[k] == null) {
                    player[k] = new Player(k + 1);
                }

                if(i==2 ){
                    if(k==0 ){
                        player[k].showHands();
                        System.out.println("Request Card? Enter Y for yes, any key for no:");
                        String key = sc.next();
                        if(key.equalsIgnoreCase("y")){
                            Card card = deck.getCard(j);
                            player[k].receiveCard(card);
                        }
                    }else {
                        if( player[k].request()){

                            Card card = deck.getCard(j);
                            player[k].receiveCard(card);

                        }
                    }

                }else {
                    Card card = deck.getCard(j);
                    player[k].receiveCard(card);
                }
               j++;
            }

            i++;
        }

        for (Player p : player){
            p.showHands();
        }

    }
}
