package server;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import game.Game;

public class ClientProcessor implements Runnable {
	
	private Socket client;
	private PrintWriter writer = null;
	private BufferedInputStream reader = null;
	private Game myGame;

	public ClientProcessor(Socket client, Game myGame) {
		this.client = client;
		this.myGame = myGame;
	}

	@Override
	public void run() {
		System.err.println("Lancement du traitement de la connexion cliente");

		boolean closeConnexion = false;

	    while(!client.isClosed()){
	        try {
	        	//Ici, nous n'utilisons pas les mêmes objets que précédemment
	        	//Je vous expliquerai pourquoi ensuite
	        	writer = new PrintWriter(client.getOutputStream());
	            reader = new BufferedInputStream(client.getInputStream());
		            
	            //On attend la demande du client            
	            String response = read();

	            InetSocketAddress remote = (InetSocketAddress)client.getRemoteSocketAddress();
	            
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
	            	case "CONNECTION":
	            		toSend = "true";
	            		myGame.linkNewPlayer(this, "player" + new Random().nextInt(256));
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
	            	client.close();
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
	        catch (InterruptedException e) {
				e.printStackTrace();
			}
	    
	    }
	}
   
	//La méthode que nous utilisons pour lire les réponses
	   
	public String read() {   
		String response = "";
		int stream;
		byte[] b = new byte[4096];
		try {
			stream = reader.read(b);
		} 
		catch (Exception e) {
			stream = 0;
		}
		response = new String(b, 0, stream);
		return response;
	}
	
	private String read(BufferedInputStream reader) throws IOException {
		byte[] byteValues = new byte[1024];
		reader.read(byteValues);
		return new String(byteValues);
    }
	
	synchronized private void sendEventToClient (Thread thradToSleeping, String event, CallBack functionCallback) {
		Thread send = new Thread (new Runnable () {
			@Override
			public void run() {
				try {
					PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
					BufferedInputStream reader = new BufferedInputStream(client.getInputStream());
					
					System.out.println("Ici le serveur, j'ai essayé d'envoyer <" + event + "> au client");
					writer.write(event);
					writer.flush ();

					String response = read(reader);
					functionCallback.execute(response);
					
					synchronized (thradToSleeping) { thradToSleeping.notify(); }
				} 
				catch (IOException e) {
					e.printStackTrace();
				}	
			}
		});
		send.start();

		synchronized (thradToSleeping) {
			try {
				thradToSleeping.wait();
			} 
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public String askName(Thread threadToSleeping) {
		String[] name = new String[1];
		System.out.println("Demande de son nom au client");
		this.sendEventToClient(threadToSleeping, "GET_NAME", new CallBack () {
			@Override
			public void execute(String response) { 
				name[0] = response;
				System.out.println("Nom du client reçu ! Il s'appelle " + response);
			}
		});
		return name[0];
	}
}
