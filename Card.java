public class Card {
    private final int cardNum;
    private final char symbol;

    private final char[][] card= new char[5][7];

    public Card(int cardNum, char symbol){
        this.cardNum = cardNum;
        this.symbol = symbol;

        createCard( cardNum,  symbol);
    }

    char[][] getCard(){
        return card;
    }

    int getCardNum(){
        return cardNum;
    }

    private void createCard(int cardNum, char symbol){
        String numStr = String.valueOf(cardNum);

        for (int i = 0;i<5; i++){
            for (int j = 0; j<7;j++){
                card[i][j]=' ';
                if(i>0 && i<4){
                    if(j<1 || j>5){
                        card[i][j]='|';
                    }
                }else{
                    if(j%6==0){
                        card[i][j]='+';
                    }else{
                        card[i][j]='-';
                    }
                }

                if(i==1 ){
                    int index = j-1;
                    if(numStr.length()>1){
                        if(j>0 && j<3){
                            card[i][j]=numStr.charAt(index);
                        }
                    }else {
                        card[i][1]=numStr.charAt(0);
                    }

                }
                if(i==3){
                    int index = j-4;
                    if(numStr.length()>1){
                        if(j>3 && j<6){
                            card[i][j]=numStr.charAt(index);
                        }
                    }else {
                        card[i][5]=numStr.charAt(0);
                    }

                }


            }
         //   card[2][3]=symbol;
            card[2][1]=symbol;
            card[2][5]=symbol;
        }
    }

    void displayCard(){
        for (int i = 0;i<5; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(card[i][j]);
            }
            System.out.println("");
        }

    }

}
