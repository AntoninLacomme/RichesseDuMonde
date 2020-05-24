package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

import protocole.CallBackUDP;
import protocole.DataUDP;
import game.Case;
import game.Game;

public class MainServerUDP extends ServerUDP {
	private int maxPlayers = 4;
	
	private ListPlayers mesPlayers;
	private Game game;

	public MainServerUDP(int port) {
		super(port);
		
		game = new Game (this);	
		Thread tGame = new Thread (game);
		tGame.start ();
		
		this.mesPlayers = new ListPlayers ();
		
		this.setEventListener("CONNECTION", new CallBackUDP () {
			@Override
			public void run (DataUDP data) {
				eventConnection (data);
			}
		});
		
		this.setEventListener ("DECONNECTION", new CallBackUDP () {
			@Override
			public void run (DataUDP data) {
				eventDeconnection (data);
			}
		});
		
		this.setEventListener ("GET_EMPTY_PLATEAU", new CallBackUDP () {
			@Override
			public void run (DataUDP data) {
				eventGetEmptyPlateau (data);
			}
		});
	}
	
	synchronized Player findPlayerByIp (InetAddress ip, int port) {
		try {
			System.out.println("A chercher : " + ip.toString() + " / " + port);
			for (Player p : mesPlayers.getPlayers()) {
				System.out.println("ID : " + p.getIP().toString() + "\nPORT : " + p.getPortEmission());
				if (p.getIP().equals(ip) && p.getPortEmission() == port) {
					return p;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	// ------- Fonctions events ------ \\
	
	synchronized protected void eventGetEmptyPlateau (DataUDP data) {
		DataUDP datas = new DataUDP ("ANSWER_EMPTY_PLATEAU");

		for (Case c : this.game.getPlateau().getAllCases()) {
			if (c.getIDRessource() >= 0) {
				datas.addData(c.getID(), c.getIDRessource() + "");
			}
			else {
				datas.addData(c.getID(), "");
			}
		}
		Player p = this.findPlayerByIp(data.getIp(), data.getPort());
		p.sendDataToPlayer(datas);
	}
	
	synchronized protected void eventConnection (DataUDP data) {
		System.out.println("Hey, j'ai reçu un event CONNECTION, visiblement de le type s'appelerai " + data.getValue("name") + "\nIP >>> " + data.getIp().toString() + "\nPORT >>> " + data.getPort());
		Player player = new Player (data.getValue("name"), data.getIp(), data.getPort(), Integer.parseInt(data.getValue("port")));
		System.out.println(player.toString ());
		try {
			for (Player p : mesPlayers.getPlayers()) {
				if (p.getIP().equals(player.getIP()) && p.getPortReception() == player.getPortReception()) {
					System.out.println("Ce client est déjà enregistré comme étant connecté Oo");
					return;
				}
			}

			this.mesPlayers.add(player);
			
			if (mesPlayers.getPlayers().size() >= this.maxPlayers) {
				System.out.println("La partie est complète, on peut lancer la game !");
				game.startGame ();
				return;
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized protected void eventDeconnection (DataUDP data) {
		try {
			for (Player p : mesPlayers.getPlayers()) {
				if (p.getIP().equals(data.getIp()) && p.getPortReception() == Integer.parseInt(data.getValue("port"))) {
					System.out.println("Le client " + p.getName() + " c'est déconnecté");
					mesPlayers.remove(p);
					return;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void sendPacket (Player p, DataUDP message) {
		Thread sending = new Thread () {
			@Override
			public void run () {
				byte[] buffer = message.getBytes();
				DatagramSocket client;
				try {
					client = new DatagramSocket();
			        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, p.getIP(), p.getPortReception());
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
	
	@Override
	protected void shutdown () {
		System.err.println("SHUTDOWN - Demande d'arrêt du server");
		runServer = false;
	}

	public ArrayList<Player> getAllPlayers() {
		try {
			return mesPlayers.getPlayers();
		} catch (InterruptedException e) {
			return null;
		}
	}
}
