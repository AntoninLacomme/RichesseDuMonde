package client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;

import server.CallBack;

public class Client {
	private String name;	
	private Socket connexion;
	private String[] answerServer = new String[1];

	public Client (String host, int port, String name) {
		this.setName(name);
		
		try {
			connexion = new Socket (host, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		System.err.println("Lancement du traitement de la connexion server");
		
		Thread waitingServer = new Thread (new ConnectionClient (connexion, this));
		waitingServer.start();
    
		
		this.sendEventToServer("CONNECTION", new CallBack () {
			@Override
			public void execute(String response) { }
		});
		
	}
	
	
	
	private String read(BufferedInputStream reader) throws IOException {
		byte[] byteValues = new byte[1024];
		reader.read(byteValues);
		return new String(byteValues);
    } 
	
	synchronized private void sendEventToServer (String event, CallBack functionCallback) {
		Thread myself = Thread.currentThread();
		Thread send = new Thread (new Runnable () {
			@Override
			public void run() {
				try {
					PrintWriter writer = new PrintWriter(connexion.getOutputStream(), true);
					BufferedInputStream reader = new BufferedInputStream(connexion.getInputStream());
					
					writer.write(event);
					writer.flush ();

					String response = read(reader);
					functionCallback.execute(response);
					
					synchronized (myself) { myself.notify(); }
				} 
				catch (IOException e) {
					e.printStackTrace();
				}	
			}
		});
		send.start();

		synchronized (myself) {
			try {
				myself.wait();
			} 
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
