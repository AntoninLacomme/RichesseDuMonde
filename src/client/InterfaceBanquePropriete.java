package client;

import java.io.IOException;

import game.countries.Region;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class InterfaceBanquePropriete extends Scene {

	public InterfaceBanquePropriete(Parent root) {
		super(root);

		TabPane main = (TabPane) this.lookup("#idTabPaneBanqueTitre");

		for (Region r : Region.values()) {
			Tab tab = new Tab (r.getName());
			try {
				tab.setContent(new InterfaceRegionPropriete (FXMLLoader.load(getClass().getResource("ressources/fxml/RegionPropriete.fxml")), r));
			} catch (IOException e) {
				e.printStackTrace();
			}
			main.getTabs().add(tab);
		}
	}
}
