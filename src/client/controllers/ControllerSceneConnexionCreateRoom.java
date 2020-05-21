package client.controllers;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import client.Client;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import server.MainServerUDP;

public class ControllerSceneConnexionCreateRoom {
	
	@FXML
	TextField textfieldIP;
	@FXML
	TextField textfieldPort;
	@FXML
	Spinner spinnerNbJoueur;	
	@FXML
	Spinner spinnerNbBot;
	@FXML
	Button buttonLaunchGame;
	
	public void initialize () {
		String ip = "127.0.0.1";
		int port = 10101;
		try (final DatagramSocket socket = new DatagramSocket()) {
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			ip = socket.getLocalAddress().getHostAddress();
			socket.close();
			
		} catch (SocketException e1) {
			e1.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		Client.getGame().setConnectionClient(ip, port);
		
		textfieldIP.setText(ip);
		textfieldPort.setText(""+ port);
		
		
		ObservableList<String> list = FXCollections.observableArrayList("1", "2", "3", "4");
		
		SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(list);
		spinnerNbJoueur.setValueFactory(valueFactory);
		
		SpinnerValueFactory<String> valueFactory2 = new SpinnerValueFactory.ListSpinnerValueFactory<String>(this.getMinListBots());
		spinnerNbBot.setValueFactory(valueFactory2);
	}
	
	@FXML
	public void addPlayer (Event e) {
		SpinnerValueFactory<String> valueFactory2 = new SpinnerValueFactory.ListSpinnerValueFactory<String>(this.getMinListBots());
		spinnerNbBot.setValueFactory(valueFactory2);
	}
	
	@FXML
	public void launchGame (Event e) {
		// premièrement, lancement d'un serveur
		Platform.runLater(new Runnable () {			
			@Override
			public void run() {
				Thread tServer = new Thread (new MainServerUDP (10101));
				tServer.start();
			}
		});
		
		
		Platform.runLater(new Runnable () {			
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				Client.getGame().launchConnectionClient();
				
				for (int i=0; i<Integer.parseInt(spinnerNbJoueur.getValue().toString()); i++) {
					System.out.println("Il faudrait lancé un bot");
				}
			}
		});
		
	}
	
	private ObservableList<String> getMinListBots () {
		ObservableList<String> list = FXCollections.observableArrayList();
		int players = Integer.parseInt(spinnerNbJoueur.getValue().toString());
		int minPlayer = 2;
		
		int base = minPlayer - players;
		if (base < 0) { base = 0; }
		for (int i = base; i< 5 - players; i++) {
			list.add("" + i);
		}
		return list;
	}
}
