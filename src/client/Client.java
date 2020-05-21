package client;

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
	
	public static GameClient getGame () {
		if (Client.game == null) {
			Client.game = new GameClient ();
		}
		return Client.game;
	}
	
	@Override
	public void start(Stage mstage) throws Exception {
		/*Parent root = FXMLLoader.load(getClass().getResource("ressources/fxml/TitrePropriete.fxml"));
		
		Country pays = Country.France;
		
		ArrayList<TitreExploitation> lesTitres = pays.getAllTitresExploitation();		
		for (TitreExploitation titre : lesTitres) {
			Stage otherStage = new Stage ();
			InterfaceTitrePropriete scene = new InterfaceTitrePropriete (FXMLLoader.load(getClass().getResource("ressources/fxml/TitrePropriete.fxml")), titre);
			otherStage.setResizable(false);
			otherStage.setScene(scene);
			otherStage.show ();
		}
		
		*/
		/*
		InterfaceBanquePropriete scene = new InterfaceBanquePropriete (FXMLLoader.load(getClass().getResource("ressources/fxml/BanquePropriete.fxml")));
		Stage st = new Stage ();
		st.setScene(scene);
		st.show();*/
		
		InterfaceConnexion mainscene = new InterfaceConnexion (FXMLLoader.load(getClass().getResource("ressources/fxml/SceneConnexion.fxml")));
		mstage.setScene(mainscene);
		mstage.show ();
		mstage.centerOnScreen();
	}
	
	@Override
	public void init() throws Exception {
		/*int[] ports = Protocole.getAvailablePort(2);
		maConnectionClient = new ClientUDP ("Antonin", "127.0.0.1", 10101, ports[0], ports[1]);
		new Thread (maConnectionClient).start ();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		maConnectionClient.getEmptyPlateau();*/
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
	}

	
	
}
