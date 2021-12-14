import java.util.Scanner;

public class ludoGame {
    /**
     * This is a LUDO GAME
     *
     * @author programmer X
     * code cheza kiwewe
     *
     */

    private int tokens = 4;
    int players;
    int tokenCount=0;
    int firstPlayer;
    int nextPlayer = 0;
    int tokensUsed=0;


    ludoGame(int player) {
        if (player <= 1) {
            throw new IllegalArgumentException("Players must be more than 1");
        }
        if (player >= 2) {
            System.out.println("Welcome Aboard");
            players = player;
            playFirstTime();
        }
    }

    public int Roll() {
        int die;
        die = (int) (Math.random() * 7);
        return die;

    }


    public void playFirstTime() {
        int i;
        for (i = 1; i <= players; i++) {
            int die1 = Roll();
            System.out.println("Player of id: " + i + " got die value: " + die1);
            if(die1==6){
                firstPlayer=i;
                System.out.println("The first player is player of id: "+firstPlayer);
                CurrentPlayer(firstPlayer);
            }
            else{
                System.out.println("Rolling  Again....");
                rollMissedPlayers(i);
            }

        }
    }
    public void rollMissedPlayers(int i){

        if(nextPlayer==0 && firstPlayer!=0){
            int die1 = Roll();
            if(die1==6) {
                nextPlayer = nextPlayer + i;
                System.out.println("The next Player is player of id: " + nextPlayer);
                CurrentPlayer(nextPlayer);
            }
            else{
                rollMissedPlayers(i);
            }

        }
        else if(nextPlayer==0 && firstPlayer==0){
            int die1 = Roll();
            if(die1==6) {
                firstPlayer=i;
                System.out.println("The first player is player of id: "+firstPlayer);
                CurrentPlayer(firstPlayer);

            }
            else{
                rollMissedPlayers(i);
            }


        }

    }
    public void tokenCountonYard(boolean b,int player){
        if(b==true) {
            int currentPlayer = player;
            if (currentPlayer == firstPlayer) {
                tokens = tokens - 1;
                System.out.println("Player of id: " + currentPlayer + " has a token count on his/her yard of: " + tokens);
            } else {
                for (int i = 1; i < players; i++) {
                    do {
                        if (currentPlayer == i) {
                            tokens = tokens - 1;
                            tokensUsed++;
                            System.out.println("Player of id: " + currentPlayer + " has token count on his/her yard of: " + tokens);

                        }
                    } while (moveTokenOutOfYard(currentPlayer));
                    if (currentPlayer == i) {
                        System.out.println("Player of id: " + currentPlayer + " has token count on his/her yard of: " + tokens);
                    }


                }
            }
        }
        else{
            System.out.println(" ");
        }
    }

    public int CurrentPlayer(int player){
        moveTokenOutOfYard(player);
        tokenCountonYard(moveTokenOutOfYard(player),player);
        return player;

    }

    public int tokenMoves(){

        return 0;

    }
    public boolean moveTokenOutOfYard(int player){
        int die2 = Roll();
        Scanner ans = new Scanner(System.in);
        char answ;

        if(tokensUsed < tokens && die2 == 6){
            System.out.println("Player id: "+ player + " Do you want to take a token from your yard y/n");
            answ = ans.next().charAt(0);
            if (answ == 'y'){
                return true;
            }
            else{
                System.out.println("Okay no token taken");
                return false;
            }
        }
        else{
            System.out.println("You don't have any tokens left :(");
            return false;
        }
    }



    public static void main(String[] args) {
        ludoGame a = new ludoGame(3);




    }
}