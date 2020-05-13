package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import game.ressources.Ressource;
import protocole.DataUDP;
import protocole.Inventaire;

public class Player {
	private String idPlayer;
	private String name;
	private InetAddress ip;
	private int portEmission;
	private int portReception;
	
	private Inventaire inventaire;
	
	public Player (String name, InetAddress ip, int portEmission, int portReception) {
		this.idPlayer = "";
		this.name = name;
		this.ip = ip;
		this.portReception = portReception;
		this.portEmission = portEmission;
		
		this.inventaire = new Inventaire ();
	}
	
	public String getName() { return this.name; }
	public String getID () { return this.idPlayer; }
	public InetAddress getIP () { return this.ip; }
	public int getPortEmission () { return this.portEmission; }
	public int getPortReception () { return this.portReception; }

	public void sendDataToPlayer(DataUDP data) {
		Thread sending = new Thread () {
			@Override
			public void run () {
				byte[] buffer = data.getBytes();
				DatagramSocket client;
				try {
					client = new DatagramSocket();
			        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, getIP(), getPortReception());
			        packet.setData(buffer);
			        client.send(packet);
			        
		        }
				catch (SocketException e) {
					e.printStackTrace();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		sending.start ();
	}

	public void payMoney(int money) {
		this.inventaire.addMoney (-1 * money);
	}

	public void addMoney(int money) {
		this.inventaire.addMoney (money);
	}

	public boolean hasRessource(Ressource ressource) {
		return inventaire.hasRessource (ressource);
	}
	
	public String toString () {
		return "--------------------------\n"
				+ " >>> Joueur "
				+ this.name
				+ "\n >>> IP "
				+ this.ip.toString()
				+"\n >>> Port Emission "
				+ this.portEmission
				+"\n >>> Port Reception "
				+ this.portReception
				+ "\n--------------------------";
	}
}
