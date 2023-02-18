import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    
    int gameNumber; //game out of match set of 10
    boolean winDetected; //true= ? false= ?
    Player[] players = new Player[4]; //array of 4 players

    //stores the dot values for all players. ex: playerDots[0][1] stores value for p1_p2 = true
    //if p1 has a superset of p2s numbers. 
    //p1_p1 p1_p2 p1_p3 p1_p4
    //p2_p1 p2_p2 p2_p3 p2_p4 ...
    boolean[][] playerDots = new boolean[4][4]; //4x4 array to represent dots
    int playerTurn; //0-3 to match array of players 

    /* constructor method */
    public Game(Player p1, Player p2, Player p3, Player p4, int gameNumber) {
        //insert players into player set
        players[0] = p1;
        players[1] = p2;
        players[2] = p3;
        players[3] = p4;

        //set game #
        this.gameNumber = gameNumber;
        
        //start with player 1
        playerTurn = 0;
        winDetected = false; //initialize winDetected

        //initialize playerDots array with values
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                //px_px = true
                if(i == j) {
                    playerDots[i][j] = true;
                }
                else {
                    playerDots[i][j] = false;
                }
            }
        }

        //generate new numbers for each player
        generatePlayerNumberSets();
    } //end of constructor


    //generate 3 numbers for each player's number set
    private void generatePlayerNumberSets() {
        for (Player p : players) { //for every player in the player arr
            while(p.numbers.size() < 3) { //while numbers list is less than 3 
                int toAdd = (int)(Math.random() * 20 + 1); //random num 1-20
                //check if random # is in set already
                if(!p.getNumbers().contains(toAdd)) {
                    p.addNumber(toAdd);
                }
            }
            //System.out.println(p.getNumbers()); //for testing
        }
    }

    public void playGame() {
        while(!winDetected) { //while loop until game is won
            //print player #, their number set and the game board
            System.out.println("Player " + (playerTurn + 1) + " turn!");
            System.out.print("You set of numbers: " + players[playerTurn].getNumbers());
            printPlayerDots();
            //add new number to player set
            //closing the scanner in the funtction closes the input stream so have to pass the scanner
            //close after the game loop ends
            Scanner pAdd = new Scanner(System.in);
            addNextNumber(players[playerTurn], pAdd);

            //check for supersets
            for(int i = 0; i < 4; i++) {
                playerDots[playerTurn][i] = isSuperSet(players[playerTurn].getNumbers(), players[i].getNumbers());
            }
            
            //check for a win
            winDetected = detectWin();
            
            if(winDetected) {
                //if win detected add up scores
                System.out.println("Player " + (playerTurn + 1) + " wins!");
                calcScores(playerTurn);
                pAdd.close();
            }
            //if no winner change player turn
            else {
                //if its p4s turn loop back to p1
                if(playerTurn == 3) {
                    playerTurn = 0;
                }
                else {
                    playerTurn++;
                }
            }
            System.out.println();
        }
    }

    //adds the number inputted to players set
    private void addNextNumber(Player player, Scanner pAdd) {
        System.out.print("Player " + (playerTurn + 1) + " please enter a number: ");
        int pnum = pAdd.nextInt();

        boolean numAccepted = false;

        //if in range and not already in list
        //  add to list
        //if value not in range
        //  ask for a new number until one is valid
        while(!numAccepted) {
            if(pnum <= 20 & pnum > 0 & !player.getNumbers().contains(pnum)){
                player.addNumber(pnum);
                numAccepted = true;
            }
            
            else {
                System.out.println("Number must be less than 20 and not already in your list: ");
                pnum = pAdd.nextInt();
            }
        }
    }

    //3.1 check if one players numbers are a superset of another
    //given 2 lists, x and y, return true if x is a superset of y
    boolean isSuperSet(ArrayList<Integer> x, ArrayList<Integer> y) {
        boolean superSetDetected = false;

        //if y is > x, x cannot be a superset of y
        //if y is empty it is a subset of x, but that breaks the game
        if(x.size() >= y.size() && !y.isEmpty()) {
            if(x.containsAll(y)) {
                superSetDetected = true;
            }
        }

        return superSetDetected;
    }

    //det
    private boolean detectWin() {
        boolean tempWin = true;
        int counter = 0;
            while(tempWin && counter < 4) {
                if(playerDots[playerTurn][counter] == true) {
                    tempWin = true;
                    counter++;
                }
                else {
                    tempWin = false;
                }
            }
        return tempWin;
    }


    //print a console representation of the playerDots array
    //2D 4x4 [3,0] [3,1] [3,2] [3,3]
    //       [2,0] [2,1] [2,2] [2,3]
    //       [1,0] [1,1] [1,2] [1,3]
    //       [0,0] [0,1] [0,2] [0,3]   
    private void printPlayerDots() {
        for(int i = playerDots.length-1; i >= 0; i--) {
            //each row
            System.out.println();
            for(int k = 0; k < playerDots[i].length; k++) {
                System.out.print(" [" + playerDots[i][k] + "] ");
            }
        }
        System.out.println();
    }

    private void calcScores(int winner) {
        //winner gets 10 pts, everyone else gets the sum of their numbers
        for(int i = 0; i < 4; i++) {
            //add 10 to winner score
            if(i == winner) {
                players[i].addScore(10);
            }
            else {
                int sum = 0;
                ArrayList<Integer> nums = players[i].getNumbers();
                //calculate sum of players number set
                for (Integer x : nums) {
                    sum += x;
                }

                players[i].addScore(sum);
            }
        }
    }

 }