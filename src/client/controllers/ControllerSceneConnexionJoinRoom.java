package client.controllers;

import client.Client;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerSceneConnexionJoinRoom {

	@FXML
	TextField textfieldIP;
	@FXML
	TextField textfieldPort;
	@FXML
	Button buttonJoinGame;
	@FXML
	Label labelError;
	
	public void initialize () {
		textfieldIP.setText("127.0.0.1");
		textfieldPort.setText("10101");
	}
	
	public void joinGame (Event e) {
		labelError.setText("");
		if (this.isCorrectIp(textfieldIP.getText())) {
			int port = -1;
			try {
				port = Integer.parseInt(textfieldPort.getText());
				
				Client.getGame().setConnectionClient(textfieldIP.getText(), Integer.parseInt(textfieldPort.getText()));
				Client.getGame().launchConnectionClient();

				Client.setInterfacePartie();
			}
			catch (Exception e1) {
				labelError.setText(labelError.getText() + "Un port doit être numérique");
			}
		}
	}


	private boolean isCorrectIp(String ip) {
		String temp = ip;
		for (int i=0; i<3; i++) {
			int index = temp.indexOf('.');
			if (index < 0) { 
				labelError.setText("Une adresse IP s'écrit sous la forme xx.xx.xx.xx\n");
				return false;
			}
			
			try {
				int value = Integer.parseInt(temp.substring(0, index));
				if (value > 255 || value < 0) {
					labelError.setText("Valeur ip impossible (valeures comprises entre 0 et 255)0\n.");
					return false;
				}
			}
			catch (Exception e) {
				labelError.setText("Les valeures doivent être numériques et comprises entre 0 et 255.\n");
				return false;
			}

			temp = temp.substring(index + 1);
		}
		try {
			int value = Integer.parseInt(temp.substring(0));
			if (value > 255 || value < 0) {
				labelError.setText("Valeur ip impossible (valeures comprises entre 0 et 255).\n");
			}
		}
		catch (Exception e) {
			labelError.setText("Les valeures doivent être numériques et comprises entre 0 et 255.\n");
			return false;
		}
		return true;
	}
}
