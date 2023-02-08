import java.util.ArrayList;
import java.util.Scanner; 

public class Game {

    ArrayList<Integer> p1Set, p2Set, p3Set, p4Set; //unique to each game
    ArrayList<Integer> p1num, p2num, p3num, p4num; //holds players selected numbers
    //int[] p1Set, p2Set, p3Set, p4Set; //unique to each game

    int gameInSet; 
    //boolean for testing 
    boolean winDetected = false;

    public Game(Player p1, Player p2, Player p3, Player p4, int gameInSet) {
        this.gameInSet = gameInSet;
        //output for testing
        System.out.println("Game " + gameInSet + " out of 10 has begun.");
        //1.3 randomly assign numbers 1-20 to each players # set
        //1.3 randomly assign 3 numbers 1-20 to each players # set
        //init 4 empty array lists
        p1Set = new ArrayList<>(0); p2Set = new ArrayList<>(0); p3Set = new ArrayList<>(0); p4Set = new ArrayList<>(0);

        //initalize array set for player's selected numbers
        //should start with an empty number array. and each turn they will populate it
        p1num = new ArrayList<>(0); p2num = new ArrayList<>(0); p3num = new ArrayList<>(0); p4num = new ArrayList<>(0);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(4); 

        //adds number to each player set
        arr.add(p1Set); arr.add(p2Set); arr.add(p3Set); arr.add(p4Set);
        int listC = 1; //tracks the count of lists
        for(ArrayList<Integer> set : arr) {
            for(int j = 0; j < 3; j++) {
                set.add((int)(Math.random()*20 + 1));
            }
            //output for testing
           System.out.println("List " + listC + " created with " + set.toString()); 
           listC++;
        }

        //bools represent green dots 
        //ex: if p1 has a superset of p2s numbers then p1_p2 = true
        boolean p1_p2, p1_p3, p1_p4 = false;
        boolean p2_p1, p2_p3, p2_p4 = false;
        boolean p3_p1, p3_p2, p3_p4 = false;
        boolean p4_p1, p4_p2, p4_p3 = false;
    


        //if players turn allow them to select a number between 1-20 
        int pt = 1;
        //loops around each player until one of them detects a winner.
        while(true){

            //player one 
            if(pt == 1){
                System.out.println("Player " + pt + " turn!");
                System.out.println("You set of numbers: " + p1Set);
                System.out.println("Player " + pt + " Your current list of numbers! \n" + p1num);
                //player add number to their set
                
                //testing feature with scanner
                //replace scanner with GUI input
                Scanner pAdd = new Scanner(System.in);
    
                System.out.println("player " + pt + " please enter a number");
                int pnum = pAdd.nextInt();

                //if in range and not already in list
                //  add to list
                //if value not in range
                //  ask for a new number until one is valid
                // detect if there is win with recently added number
                // if no win continue on
                if(pnum <= 20 & pnum >0 & !p1num.contains(pnum)){
                    p1num.add(pnum);
                    
                    //check if any dots should turn green
                    //will need to change for GUI
                    p1_p2 = isSuperSet(p1num, p2num);
                    p1_p3 = isSuperSet(p1num, p3num);
                    p1_p4 = isSuperSet(p1num, p4num);
                    
                    //testing isSuperSet
                    System.out.println("p1_p2 " + p1_p2 + " p1_p3 " + p1_p3 + " p1_p4 " + p1_p4);

                    //if p1 has a superset for all 3 players p1 wins
                    if(p1_p2 && p1_p3 && p1_p4) {
                        winDetected = true;
                    }
                }

                else {
                    //loops until player enters a valid number
                    while(true){
                        System.out.println(" invalid number. player " + pt + " please enter a valid number!");
                        pnum = pAdd.nextInt();
                        if(pnum <= 20 & pnum >0 & !p1num.contains(pnum)){
                            p1num.add(pnum);
                            break;
            
                        }


                    }

                }
                if(winDetected){
                    System.out.println("Player " + pt + " wins!");
                    p1num.clear();
                    p2num.clear();
                    p3num.clear();
                    p4num.clear();
                    break;
                    
                }
                //if a win is not detected
                if(!winDetected){
                    pt++;
                }

        }

    


            //player 2
            if(pt == 2){
                System.out.println("Player " + pt + " turn!");
                System.out.println("You set of numbers: " + p2Set);
                System.out.println("Player " + pt + " Your current list of numbers! \n" + p2num);
                //player add number to their set
                
                //testing feature with scanner
                //replace scanner with GUI input
                Scanner pAdd = new Scanner(System.in);

                System.out.println("player " + pt + " please enter a number");
                int pnum = pAdd.nextInt();

                //if in range and not already in list
                //  add to list
                //if value not in range
                //  ask for a new number until one is valid
                // detect if there is win with recently added number
                // if no win continue on
                if(pnum <= 20 & pnum >0 & !p2num.contains(pnum)){
                    p2num.add(pnum);
                    // break;

                    //check if any dots should turn green
                    //will need to change for GUI
                    p2_p1 = isSuperSet(p2num, p1num);
                    p2_p3 = isSuperSet(p2num, p3num);
                    p2_p4 = isSuperSet(p2num, p4num);
                    
                    //testing isSuperSet
                    System.out.println("p2_p1 " + p2_p1 + " p2_p3 " + p2_p3 + " p2_p4 " + p2_p4);

                    //if p2 has a superset for all 3 players p1 wins
                    if(p2_p1 && p2_p3 && p2_p4) {
                        winDetected = true;
                    }
    
                }
                else{
                    //loops until player enters a valid number
                    while(true){
                        System.out.println(" invalid number. player " + pt + " please enter a valid number!");
                        pnum = pAdd.nextInt();
                        if(pnum <= 20 & pnum >0 & !p2num.contains(pnum)){
                            p2num.add(pnum);
                            break;
            
                        }
    
    
                    }
    
                }
                if(winDetected){
                    System.out.println("Player " + pt + " wins!");
                    p1num.clear();
                    p2num.clear();
                    p3num.clear();
                    p4num.clear();
                    break;
                    
                }
                //if a win is not detected
                if(!winDetected){
                    pt++;
                }
            }




            //player 3
            if(pt == 3){
                System.out.println("Player " + pt + " turn!");
                System.out.println("You set of numbers: " + p3Set);
                System.out.println("Player " + pt + " Your current list of numbers! \n" + p3num);
                //player add number to their set
                
                //testing feature with scanner
                //replace scanner with GUI input
                Scanner pAdd = new Scanner(System.in);

                System.out.println("player " + pt + " please enter a number");
                int pnum = pAdd.nextInt();
    
                //if in range and not already in list
                //  add to list
                //if value not in range
                //  ask for a new number until one is valid
                // detect if there is win with recently added number
                // if no win continue on
                if(pnum <= 20 & pnum >0 & !p3num.contains(pnum)){
                    p3num.add(pnum);

                    //check if any dots should turn green
                    //will need to change for GUI
                    p3_p1 = isSuperSet(p3num, p1num);
                    p3_p2 = isSuperSet(p3num, p2num);
                    p3_p4 = isSuperSet(p3num, p4num);
                    
                    //testing isSuperSet
                    System.out.println("p3_p1 " + p3_p1 + " p3_p2 " + p3_p2 + " p3_p4 " + p3_p4);

                    //if p2 has a superset for all 3 players p1 wins
                    if(p3_p1 && p3_p2 && p3_p4) {
                        winDetected = true;
                    }
                }
                else{
                    //loops until player enters a valid number
                    while(true){
                        System.out.println(" invalid number. player " + pt + " please enter a valid number!");
                        pnum = pAdd.nextInt();
                        if(pnum <= 20 & pnum >0 & !p3num.contains(pnum)){
                            p3num.add(pnum);
                            break;
            
                        }
    
    
                    }
    
                }
                if(winDetected){
                    System.out.println("Player " + pt + " wins!");
                    p1num.clear();
                    p2num.clear();
                    p3num.clear();
                    p4num.clear();
                    break;
                    
                }
                //if a win is not detected
                if(!winDetected){
                    pt++;
                }
            }




            //player 4
            if(pt == 4){
                System.out.println("Player " + pt + " turn!");
                System.out.println("You set of numbers: " + p4Set);
                System.out.println("Player " + pt + " Your current list of numbers! \n" + p4num);
                //player add number to their set
                
                //testing feature with scanner
                //replace scanner with GUI input
                Scanner pAdd = new Scanner(System.in);

                System.out.println("player " + pt + " please enter a number");
                int pnum = pAdd.nextInt();

                
    
                //if in range and not already in list
                //  add to list
                //if value not in range
                //  ask for a new number until one is valid
                // detect if there is win with recently added number
                // if no win continue on
                if(pnum <= 20 & pnum >0 & !p4num.contains(pnum)){
                    p4num.add(pnum);
                   // break;

                   //check if any dots should turn green
                    //will need to change for GUI
                    p4_p1 = isSuperSet(p4num, p1num);
                    p4_p2 = isSuperSet(p4num, p2num);
                    p4_p3 = isSuperSet(p4num, p3num);
                    
                    //testing isSuperSet
                    System.out.println("p4_p1 " + p4_p1 + " p4_p2 " + p4_p2 + " p4_p3 " + p4_p3);

                    //if p2 has a superset for all 3 players p1 wins
                    if(p4_p1 && p4_p2 && p4_p3) {
                        winDetected = true;
                    }
                }
                else{
                    //loops until player enters a valid number
                    while(true){
                        System.out.println(" invalid number. player " + pt + " please enter a valid number!");
                        pnum = pAdd.nextInt();
                        if(pnum <= 20 & pnum >0 & !p4num.contains(pnum)){
                            p4num.add(pnum);
                            break;
            
                        }
    
    
                    }
    
                }
                if(winDetected){
                    System.out.println("Player " + pt + " wins!");
                    p1num.clear();
                    p2num.clear();
                    p3num.clear();
                    p4num.clear();
                    break;
                    
                }
                //if a win is not detected
                if(!winDetected){
                    //for player 4 it will change back to 1 so it can loop back to player one
                    pt = 1;
                }
            }
            //break if there is a win from one of players

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
}