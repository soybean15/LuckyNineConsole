public class Player {
    private final int num;
    private final Hand hand = new Hand();

    private int total;

    public Player(int num){
        this.num = num;
    }

    void receiveCard(Card card){
        hand.addCard(card);
        total= hand.returnTotal();
    }

    boolean request(){
       return total<6;
    }


    void showHands(){

        if (num == 1 ){
            System.out.println("Your hands");
        }else {
            System.out.println("Player "+num+" hands");
        }

        System.out.println("Total Hands: "+hand.returnTotal());
        hand.printHand();
    }
}
