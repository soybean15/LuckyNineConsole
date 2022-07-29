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

    int getTotal(){
        return total;
    }

    int getNum(){
        return num;
    }


    void showHands(){

        if (num == 5 ){
            System.out.print("Your hands");
        }else {
            System.out.print("Player "+num+" hands");
        }

        System.out.println(" [Total: "+hand.returnTotal()+"]");
        hand.printHand();
    }
}
