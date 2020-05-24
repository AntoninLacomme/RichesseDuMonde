package client;

import java.io.IOException;
import java.util.ArrayList;

import game.countries.Country;
import game.ressources.TitreExploitation;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import protocole.Protocole;

public class Client extends Application {
	static private GameClient game;
	static public Stage mainStage;
	
	public static GameClient getGame () {
		if (Client.game == null) {
			Client.game = new GameClient ();
		}
		return Client.game;
	}
	
	public static Stage getMainStage () {
		return Client.mainStage;
	}
	
	@Override
	public void start(Stage mstage) throws Exception {
		Client.mainStage = mstage;	

		Client.setInterfaceConnexion();
		
		Client.mainStage.show ();
		Client.mainStage.centerOnScreen();
		
	}
	
	@Override
	public void init() throws Exception {
		
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();		
		try {
			game.sendEventDeconnected ();
			game.closeConnectionClient();
		} catch (Exception e) {
			// aucun client existant ???
		}
	}
	
	public static void setInterfaceConnexion () {
		try {
			InterfaceConnexion mainscene = new InterfaceConnexion (FXMLLoader.load(Client.class.getResource("ressources/fxml/SceneConnexion.fxml")));
			Client.mainStage.setScene(mainscene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setInterfacePartie () {
		try {
			InterfacePartie mainscene = new InterfacePartie (FXMLLoader.load(Client.class.getResource("ressources/fxml/ScenePartie.fxml")));
			Client.mainStage.setScene(mainscene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
