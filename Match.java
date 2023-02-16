public class Match {

    Player p1, p2, p3, p4;

    public Match() {
        //initialize players
        this.p1 = new Player();
        this.p2 = new Player();
        this.p3 = new Player();
        this.p4 = new Player();
        //run 10 instances of the game object to reflect a match
        for(int i = 1; i <= 1; i++) {
            new Game(p1, p2, p3, p4, i);
            //after every game, clear each players sets
            p1.clearNumbers();
            p2.clearNumbers();
            p3.clearNumbers();
            p4.clearNumbers();

            System.out.println("Scores after game " + i);
            System.out.println("p1: " + p1.getScore());
            System.out.println("p2: " + p2.getScore());
            System.out.println("p3: " + p3.getScore());
            System.out.println("p4: " + p4.getScore());
        }
    }

    public Player getPlayer(int playerNumber) {
        Player toReturn = new Player();
        switch(playerNumber) {
            case 1:
                toReturn = p1;
            case 2: 
                toReturn = p2;
            case 3:
                toReturn = p3;
            case 4:
                toReturn = p4;
        }
        return toReturn;
    }
}
