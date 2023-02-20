/**
 * Main
 */
public class Main {

   	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
                Player p1 = new Player();
                Player p2 = new Player();
                Player p3 = new Player();
                Player p4 = new Player();
                Game game = new Game (p1, p2, p3, p4, 1); 
                Match match = new Match(); 
                GUI gui = new GUI(match);
               // game.playGame();
        }
}