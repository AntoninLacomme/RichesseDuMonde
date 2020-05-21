package client.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import client.Client;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ControllerSceneConnexion {
	
	@FXML
	Button buttonValidationPseudo;
	@FXML
	TextField textfieldSaisiePseudo;
	@FXML
	Label labelErrorPseudo;
	
	@FXML
	Button buttonCreatePartie;
	@FXML
	Button buttonJoinPartie;
	
	@FXML
	Pane idPaneAction;

	@FXML
	public void validationPseudo(Event e){
		String pseudo = textfieldSaisiePseudo.getText().trim();
	    labelErrorPseudo.setText("");
	    buttonCreatePartie.setDisable(true);
	    buttonJoinPartie.setDisable(true);
	    idPaneAction.getChildren().clear();
	    
	    if (pseudo.length() < 6) {
	    	labelErrorPseudo.setText("Votre pseudo doit faire au minimum 6 charactères.");
	    	return;
	    }
	    
	    Client.getGame().setPseudo (pseudo);
	    buttonCreatePartie.setDisable(false);
	    buttonJoinPartie.setDisable(false);
	}
	
	@FXML 
	public void createRoom (Event e) {
	    idPaneAction.getChildren().clear();
	  
	    try {
			idPaneAction.getChildren().add(FXMLLoader.load(new File("src/client/ressources/fxml/PaneCreationRoom.fxml").toURI().toURL()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@FXML
	public void joinRoom (Event e) {
	    idPaneAction.getChildren().clear();
	    System.out.println("Rejoindre une room");
		
	}
}
