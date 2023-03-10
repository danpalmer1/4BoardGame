import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket serverSocket;
	private int connectionCounter;
	private static final int MAX_CONNECTIONS = 4;
	
	public Server(ServerSocket serverSocket) {
		
		this.serverSocket = serverSocket;
	}
	
	public void startServer() {
		
		try {
			
			while (!serverSocket.isClosed() && connectionCounter < MAX_CONNECTIONS) {
				
				Socket socket = serverSocket.accept();
				System.out.println("A new player has connected!");
				ClientHandler clientHandler = new ClientHandler(socket);
				
				Thread thread = new Thread(clientHandler);
				thread.start();
				
				connectionCounter++;
			
			}
			
		} catch (IOException e) {
			System.out.println("Maximum player number reached");
		}
		
		closeServerSocket();
	}
	
	public void closeServerSocket() {
		try {
			if( serverSocket != null) {
				serverSocket.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(1235);
		Server server = new Server(serverSocket);
		server.startServer();
				
	}
	
}
