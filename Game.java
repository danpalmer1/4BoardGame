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
}