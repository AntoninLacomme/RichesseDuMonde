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

		boolean closeConnexion = false;
		PrintWriter writer;
		BufferedInputStream reader;
		

	    while(true){
	        try {
	        	//Ici, nous n'utilisons pas les mêmes objets que précédemment
	        	//Je vous expliquerai pourquoi ensuite
	        	writer = new PrintWriter(this.connexion.getOutputStream());
	            reader = new BufferedInputStream(this.connexion.getInputStream());
		            
	            //On attend la demande du client            
	            String response = this.read(reader);

	            InetSocketAddress remote = (InetSocketAddress)this.connexion.getRemoteSocketAddress();
	            
	            //On affiche quelques infos, pour le débuggage
	            String debug = "";
	            debug = "Thread : " + Thread.currentThread().getName() + "\n";
	            debug += "Demande de l'adresse : " + remote.getAddress().getHostAddress() +"\n";
	            debug += " Sur le port : " + remote.getPort() + "\n";
	            debug += "\t -> Commande reçue : " + response + "\n";
	            System.err.println("\n" + debug);
	            
	            //On traite la demande du client en fonction de la commande envoyée
	            String toSend = "";
	            
	            switch(response.toUpperCase()){
	            	case "GET_NAME":
	            		toSend = this.name;
	            		break;
	            	default : 
	            		toSend = "Commande inconnu !";                     
	            		break;
	            }

	            writer.write(toSend);
	            writer.flush();
	            
	            if(closeConnexion){
	            	System.err.println("COMMANDE CLOSE DETECTEE ! ");
	            	writer = null;
	            	reader = null;
	            	this.connexion.close();
	            }
	
	        } 
	        catch(SocketException e){
	        	System.err.println("LA CONNEXION A ETE INTERROMPUE ! ");
	            break;
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	            System.out.println(e.toString());
	        }
		}
	    
	    
		
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
