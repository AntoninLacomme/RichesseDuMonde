package client;

import protocole.Protocole;

public class GameClient {

	private ClientUDP maConnectionClient;
	private String ip;
	private int port;
	private String pseudo;
	
	public void setConnectionClient (String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public void launchConnectionClient () {
		int[] ports = Protocole.getAvailablePort(2);
		maConnectionClient = new ClientUDP (pseudo, ip, port, ports[0], ports[1]);
		new Thread (maConnectionClient).start ();
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
}
