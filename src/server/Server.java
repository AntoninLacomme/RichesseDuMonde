package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Semaphore;

import game.Game;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

public class Server {
	private String host = "127.0.0.1";
	private ServerSocket server = null;
	private boolean isRunning = true;
	
	private Game myGame;
	
	public Server (int port) {
		try {
			this.server = new ServerSocket(port, 5, InetAddress.getByName(host));
		}
		catch (UnknownHostException e) {
	        e.printStackTrace();
	    } 
		catch (IOException e) {
	        e.printStackTrace();
	    }
		
		Semaphore max = new Semaphore (1);
		this.myGame = new Game (max);
	}
	
	
	public void open(){
		Thread t = new Thread(new Runnable() {
						public void run () {
							showInformationsServer ();
					        while(isRunning == true){
					        	try {
					        		Socket client = server.accept();                  
					        		Thread t = new Thread(new ClientProcessor (client, myGame));
					        		t.start();
					        	} 
				           		catch (IOException e) {
				           			e.printStackTrace();
				           		}
					        }
					            
				            try {
				            	server.close();
				            } 
				            catch (IOException e) {
				            	e.printStackTrace();
				            	server = null;
				            }
						}   
		});
	      
		t.start();
	}
	   
	protected void showInformationsServer() {
		System.out.println("Server lancé, en attente de la connection des clients !");
		System.out.println("Adress :\t" + this.host);
		System.out.println("Port   :\t" + this.server.getLocalPort());
	}


	public void close(){
		isRunning = false;
	}   

}
