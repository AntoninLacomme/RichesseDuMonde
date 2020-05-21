package client;

import client.controllers.ControllerSceneConnexion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceConnexion<T> extends Scene {

	public InterfaceConnexion(Parent mstage) {
		super(mstage);
	
		FXMLLoader load = new FXMLLoader(Client.class.getResource("ressources/fxml/SceneConnexion.fxml"));
		load.setController(new ControllerSceneConnexion ());
	}

}
