import java.util.ArrayList;

public class Game {
    
    ArrayList<Integer> p1Set, p2Set, p3Set, p4Set; //unique to each game
    int gameInSet; 

    public Game(Player p1, Player p2, Player p3, Player p4, int gameInSet) {
        this.gameInSet = gameInSet;
        //output for testing
        System.out.println("Game " + gameInSet + " out of 10 has begun.");
        //1.3 randomly assign 3 numbers 1-20 to each players # set
        //init 4 empty array lists
        p1Set = new ArrayList<>(0); p2Set = new ArrayList<>(0); p3Set = new ArrayList<>(0); p4Set = new ArrayList<>(0);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(4); 
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
    }
}
