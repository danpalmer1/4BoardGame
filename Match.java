public class Match {

    Player p1, p2, p3, p4;

    public Match() {
        //run 10 instances of the game object to reflect a match
        for(int i = 1; i <= 10; i++) {
            new Game(p1, p2, p3, p4, i);
        }
    }
}
