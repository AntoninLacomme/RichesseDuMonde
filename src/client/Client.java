package client;

import javafx.application.Application;
import protocole.DataUDP;
import protocole.Protocole;

public class Client {

	private ClientUDP maConnectionClient;
	
	public Client (String name) {
		int[] ports = Protocole.getAvailablePort(2);
		maConnectionClient = new ClientUDP ("Antonin", "127.0.0.1", 10101, ports[0], ports[1]);
		new Thread (maConnectionClient).start ();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		maConnectionClient.getEmptyPlateau();
		
		Application.launch(PlateauJavaFX.class, new String[0]);
	}
	
	
}
