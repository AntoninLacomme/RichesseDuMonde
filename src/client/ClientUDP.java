package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import server.ServerUDP;
import protocole.CallBackUDP;
import protocole.DataUDP;

public class ClientUDP extends ServerUDP {
	private String name;
	private int portDefault;
	private int portConnection;
	private int myportEnvoi;
	private InetAddress ipConnect;
	
	private DatagramSocket envoi;
	
	public ClientUDP (String name, String ipConnect, int portDefault, int myportEnvoi, int myportReception) {
		super (myportReception);
		
		this.name = name;
		this.portDefault = portDefault;
		this.portConnection = portDefault;
		this.myportEnvoi = myportEnvoi;
		
		try {
			this.ipConnect = InetAddress.getByName(ipConnect);
		} catch (UnknownHostException errorIP) {
			errorIP.printStackTrace();
		}

		try {
			this.envoi = new DatagramSocket(myportEnvoi);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		this.setEventListener("HELLO_WORLD", new CallBackUDP () {
			@Override
			public void run (DataUDP data) {
				System.out.println("LE SERVER A REPONDU HELLO WORLD");
				DataUDP data1 = new DataUDP ("HELLO_WORLD");
				data1.addData("hello", ":p");
				data1.addData("world", "C:");
				sendPacket(data1);
			}
		});
		
		
		this.messageStartingServer = "Lancement du client " + this.name;
		
		DataUDP data = new DataUDP ("CONNECTION");
		data.addData("name", this.name);
		data.addData("port", String.valueOf(myportReception));
		this.sendPacket(data);
	}
	
	public void getEmptyPlateau () {
		DataUDP message = new DataUDP ("GET_EMPTY_PLATEAU");
		this.sendPacket(message);
	}
	
	synchronized protected void sendPacket (DataUDP message) {
		Thread sending = new Thread () {
			@Override
			public void run () {
				byte[] buffer = message.getBytes();
				DatagramSocket client;
				try {
			        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, ipConnect, portConnection);
			        packet.setData(buffer);
			        System.err.println("Envoi packet au serveur\n" + new String(buffer));
			        envoi.send(packet);			        
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
}
