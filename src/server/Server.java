package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import game.Game;

import java.io.IOException;
import java.net.InetAddress;

public class Server {
	private String host = "127.0.0.1";
	private ServerSocket server = null;
	private boolean isRunning = true;
	
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
		
		Game myGame = new Game ();
	}
	
	
	public void open(){
		Thread t = new Thread(new Runnable() {
						public void run () {
							showInformationsServer ();
					        while(isRunning == true){
					        	try {
					        		Socket client = server.accept();                  
					        		Thread t = new Thread(new ClientProcessor (client));
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
		System.out.println("Server lanc�, en attente de la connection des clients !");
		System.out.println("Adress :\t" + this.host);
		System.out.println("Port   :\t" + this.server.getLocalPort());
	}


	public void close(){
		isRunning = false;
	}   

}
