package client;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PlateauJavaFX extends Application {
	
	private Client monclient;

	@Override
	public void start(Stage mainScene) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ressources/fxml/Plateau.fxml"));
		
		Scene scene = new Scene (root);
		mainScene.setScene(scene);
		mainScene.show ();
		mainScene.centerOnScreen();
	}
	
	@Override
	public void init() throws Exception {
		super.init();
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
	}

}
