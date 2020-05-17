package client;

import java.io.IOException;

import game.countries.EnsembleEconomique;
import game.countries.Region;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

public class InterfaceRegionPropriete extends Pane {
	
	public InterfaceRegionPropriete (Parent root, Region r) {
		super (root);
		
		TabPane main = (TabPane) this.lookup("#idTabPaneEnsembleEconomique");
		
		for (EnsembleEconomique ee : r.getAllEnsembleEconomique()) {
			Tab tab = new Tab (ee.getName());
			try {
				tab.setContent(new InterfaceEnsembleEconomiquePropriete (FXMLLoader.load(getClass().getResource("ressources/fxml/EnsembleEconomiquePropriete.fxml")), ee));
			} catch (IOException e) {
				e.printStackTrace();
			}
			main.getTabs().add(tab);
		}
	}
}
