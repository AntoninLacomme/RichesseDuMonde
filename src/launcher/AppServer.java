package launcher;
import server.MainServerUDP;

public class AppServer {
	public static void main(String[] args) {
		Thread tServer = new Thread (new MainServerUDP (10101));
		tServer.start();
	}

}
