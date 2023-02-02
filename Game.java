public class Game {
    
    int[] p1Set, p2Set, p3Set, p4Set; //unique to each game
    int gameInSet; 

    public Game(Player p1, Player p2, Player p3, Player p4, int gameInSet) {
        this.gameInSet = gameInSet;
        System.out.println("Game " + gameInSet + " out of 10 has begun.");
        //1.3 randomly assign numbers 1-20 to each players # set
    }
}
