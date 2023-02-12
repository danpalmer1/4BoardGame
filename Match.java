public class Match {

    Player p1, p2, p3, p4;

    public Match() {
        //initialize players
        this.p1 = new Player();
        this.p2 = new Player();
        this.p3 = new Player();
        this.p4 = new Player();
        //run 10 instances of the game object to reflect a match
        for(int i = 1; i <= 10; i++) {
            new Game(p1, p2, p3, p4, i);
        }
    }
}
