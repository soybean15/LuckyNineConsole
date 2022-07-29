import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckyNine {
    Scanner sc = new Scanner(System.in);


    int getMax(int[] arr){
        int max = arr[0];
        for(int n : arr){
            if(max<n){
                max=n;
            }
        }
        return max;
    }
    void start(){
        Deck deck = new Deck();
        deck.shuffleDeck();

        Player[] player = new Player[5];

        List<Player> winners = new ArrayList<>();

        int[] score = new int[5];
        int  i= 0;
        int j =0;
        while (i<3){
            for (int k = 0; k < player.length; k++) {
                if (player[k] == null) {
                    player[k] = new Player(k + 1);
                }

                if(i==2 ){
                    if(k==4 ){
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

        showHands(player, score);

        int max = getMax(score);

        for (Player p : player){
            if(p.getTotal() == max){
                winners.add(p);
            }
        }

        showWinners(winners);


    }

    void showHands(Player[] player, int[] score){

        int idx=0;
        for (Player p : player){
            score[idx]=p.getTotal();
            p.showHands();
            idx++;
        }
    }

    void showWinners(List<Player> winners){
        if(winners.size()==1){
            String name ="";
            if(winners.get(0).getNum() == 5){
                name = "You Win";
            }else{
                name= "Player "+winners.get(0).getNum()+" wins";
            }
            System.out.println("Congratulations");
            System.out.println(name);
        }else {
            System.out.println("Congratulation Winners!!");
            int count=1;
            for (Player p : winners){
                if(p.getNum() == 5){
                    System.out.println(count+": You");
                }else {
                    System.out.println(count+": Player "+p.getNum());
                }
                count++;
            }
        }


    }
}
