package server;

import game.Plateau;
import game.actualite.Actualite;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Random;

import client.Client;
import server.Server;

public class Launcher implements Runnable {
	
	private String host;
	private int port;
	private String name;

	public Launcher(String host, int port, String name) {
		this.host = host;
		this.port = port;
		this.name = name;
	}

	public static void main(String[] args) {		
		Server monServ = new Server (10101);  //On lance notre serveur
		monServ.open();
		
		Thread client1 = new Thread (new Launcher ("127.0.0.1", 10101, "Joueur 1"));
		Thread client2 = new Thread (new Launcher ("127.0.0.1", 10101, "Joueur 2"));
		Thread client3 = new Thread (new Launcher ("127.0.0.1", 10101, "Joueur 3"));
		Thread client4 = new Thread (new Launcher ("127.0.0.1", 10101, "Joueur 4"));
		client1.start();
		client2.start();
		client3.start();
		client4.start();
	}

	@Override
	synchronized public void run() {
		Client client = new Client (this.host, this.port, this.name);
		
	}

}

