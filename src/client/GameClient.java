package client;

import client.controllers.ControllerMainPlateau;
import protocole.Protocole;

public class GameClient {

	private MyClientUDP maConnectionClient;
	private String ip;
	private int port;
	private String pseudo;
	
	public void setConnectionClient (String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public void launchConnectionClient () {
		int[] ports = Protocole.getAvailablePort(2);
		maConnectionClient = new MyClientUDP (pseudo, ip, port, ports[0], ports[1]);
		new Thread (maConnectionClient).start ();
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void closeConnectionClient() {
		maConnectionClient.closeServer();
	}

	public void setControllerPlateau(ControllerMainPlateau controllerMainPlateau) {
		this.maConnectionClient.setControllerMainPlateau(controllerMainPlateau);
	}

	public void sendEventDeconnected () {
		maConnectionClient.sendEventDeconnected ();
	}
}
