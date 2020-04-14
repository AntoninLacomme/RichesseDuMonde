package client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;

public class ConnectionClient implements Runnable {
	
	private Socket serv;
	private Client client;
	private PrintWriter writer = null;
	private BufferedInputStream reader = null;
	
	public ConnectionClient (Socket server, Client client) {
		this.client = client;
		this.serv = server;
	}

	@Override
	public void run() {
		System.err.println("Lancement du traitement de la connexion server du client");
		
    	

	    while(true){
	    	System.out.println("-");
	        try {   
	        	try {
	    			writer = new PrintWriter(serv.getOutputStream());
	    			reader = new BufferedInputStream(serv.getInputStream());
	    		} catch (IOException e1) { }
	        	
	        	
	            String response = read(reader);
	            System.out.println("-> " + response);
	            
	            //On traite la demande du client en fonction de la commande envoyée
	            String toSend = "";
	            
	            System.out.println("<" + response + ">");
	            
	            switch(response){
	            	case "GET_NAME":
	            		toSend = this.client.getName ();
	            		break;
	            	default : 
	            		toSend = "Commande inconnu !";                     
	            		break;
	            }
	            
	            System.out.println("J'envoi <" + toSend + "> au serveur");

	            writer.write(toSend);
	            writer.flush();	
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
	    
	    System.out.println("---");
	
	}
	
	private String read(BufferedInputStream reader) throws IOException {
		byte[] byteValues = new byte[1024];
		reader.read(byteValues);
		return new String(byteValues).trim();
    }

}
