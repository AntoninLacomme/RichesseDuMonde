package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

import protocole.CallBackUDP;
import protocole.DataUDP;

public class ServerUDP implements Runnable {
	
	protected DatagramSocket server;
	protected ArrayList<Event> eventsListeners = new ArrayList<Event> ();
	
	protected boolean runServer = true;
	protected String messageStartingServer = "Le serveur n'a pas pus démarrer...";
	protected int portReception;
	
	public ServerUDP (int port) {
		this.portReception = port;
		try {
			this.server = new DatagramSocket(port);
			this.messageStartingServer = "Lancement du serveur";
		} catch (SocketException e) {
			e.printStackTrace();
		}

		
		this.setEventListener("SHUTDOWN", new CallBackUDP () {
			@Override
			public void run (DataUDP data) {
				shutdown ();
			}
		});
	}
	
	public Event getEventByName (String name) {
		for (Event ev : this.eventsListeners) {
			if (ev.getNom().equals(name)) {
				return ev;
			}
		}
		return null;
	}

	@Override
	public void run() {
		System.err.println(messageStartingServer);
		while (runServer) {
			byte[] buffer = new byte[8192];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			try {
				server.receive(packet);
				
				Thread tTraitement = new Thread () {
					@Override
					public void run () {
						packet.setLength(buffer.length);
						System.err.print("------ Reception Packet ------\nIP : " 
											+ packet.getAddress().toString() 
											+ "\nPort : " 
											+ packet.getPort() 
											+ "\nMessage : " 
											+ new String(packet.getData()).trim()
											+ "\n------------------------------\n");
						traitementRequeteClient (packet);
					}
				};
				tTraitement.start();
			} 
			catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}
	
	protected void setEventListener (String name, CallBackUDP fx) {
		Event ev = new Event (name, fx);
		for (Event e : this.eventsListeners) {
			if (e.getNom().equals(ev.getNom())) {
				System.err.println("Cet évènement <" + ev.getNom() + "> a déjà été défini sur ce server !");
				return;
			}
		}
		this.eventsListeners.add(ev);
	}
	
	public void closeServer () {
		this.shutdown();
	}
	
	synchronized private void traitementRequeteClient (DatagramPacket packet) {
		DataUDP data = new DataUDP (packet);
		data.convertMessageToData();
		
		String commande = data.getNameCommand ();
		for (Event e : this.eventsListeners) {
			if (e.getNom().equals(commande)) {
				e.applyEvent(data);
				return;
			}
		}
	}
	
	protected void sendPacket (InetAddress ip, int port, DataUDP message) {
		Thread sending = new Thread () {
			@Override
			public void run () {
				byte[] buffer = message.getBytes();
				DatagramSocket client;
				try {
					client = new DatagramSocket();
			        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, ip, port);
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
	
	protected void shutdown () {
		System.err.println("SHUTDOWN - Demande d'arrêt du server");
		runServer = false;
		Thread.currentThread().interrupt();
		this.server.close();
	}

}
