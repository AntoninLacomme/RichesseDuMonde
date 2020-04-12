package server;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.text.DateFormat;
import java.util.Date;

public class ClientProcessor implements Runnable {
	
	private Socket client;
	private PrintWriter writer = null;
	private BufferedInputStream reader = null;

	public ClientProcessor(Socket client) {
		this.client = client;
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
}
