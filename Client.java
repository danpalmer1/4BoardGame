import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client  {

	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String username;

	 ArrayList<Integer> p1Set = new ArrayList<>(0), p2Set, p3Set, p4Set; //unique to each game
     ArrayList<Integer> p1num, p2num, p3num, p4num; //holds players selected numbers
     ArrayList<ArrayList<Integer>> arr = new ArrayList<>(4); 

     boolean p1_p2, p1_p3, p1_p4 = false;
     boolean p2_p1, p2_p3, p2_p4 = false;
     boolean p3_p1, p3_p2, p3_p4 = false;
     boolean p4_p1, p4_p2, p4_p3 = false;
     //random number
    public void game() {
    	
       
        p1Set = new ArrayList<>(0); p2Set = new ArrayList<>(0); p3Set = new ArrayList<>(0); p4Set = new ArrayList<>(0);
        p1num = new ArrayList<>(0); p2num = new ArrayList<>(0); p3num = new ArrayList<>(0); p4num = new ArrayList<>(0);
        
  

        //adds number to each player set
        arr.add(p1Set); arr.add(p2Set); arr.add(p3Set); arr.add(p4Set);
        
        ArrayList<Integer> set = new ArrayList<>(0);
      
            for(int j = 0; j < 3; j++) {
                set.add((int)(Math.random()*20 + 1));
            }
        System.out.println(" Your List was created with " + set.toString()); 
        //p1Set.add(set);
   
    }
 
	public Client(Socket socket, String username) {
		try {
			this.socket = socket;
			this.bufferedWriter= new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader= new BufferedReader( new InputStreamReader(socket.getInputStream()));
			this.username = username;
		} catch (IOException e) {
			closeEverything(socket, bufferedReader, bufferedWriter);

		}
	}
	
	
	public void sendMessage() {
		try {
			
			bufferedWriter.write(username);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
			Scanner scan = new Scanner(System.in);
			while( socket.isConnected()) {
				String messageToSend = scan.nextLine();
				bufferedWriter.write(username + "" + messageToSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();
				
			}
			

		} catch (IOException e) {
			closeEverything(socket, bufferedReader, bufferedWriter);

		}
	}
	
	public void listenForMessage() {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				String msgFromGame;
				
				while (socket.isConnected()) {
					try {
						msgFromGame = bufferedReader.readLine();
						System.out.println(msgFromGame);
					}catch (IOException e) {
						closeEverything(socket, bufferedReader, bufferedWriter);

					}
					
				}
			}
		}).start();
		
	}


	public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
		try {
			if ( bufferedReader != null) {
				bufferedReader.close();
			}
			
			if ( bufferedWriter != null) {
				bufferedWriter.close();
			}
			
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner Scan = new Scanner(System.in);
		Socket socket = new Socket("localhost", 1235);
		System.out.println("Enter your username for the game");
		String username = Scan.nextLine();
		Client client = new Client(socket, username);
		client.game();
		client.listenForMessage();
		client.sendMessage();

				
	}
	
}
