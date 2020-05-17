package client;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import game.countries.Country;
import game.countries.EnsembleEconomique;
import game.ressources.TitreExploitation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableListBase;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class InterfaceEnsembleEconomiquePropriete extends Pane {
	
	private HashMap <Integer, TitreExploitation> listTitresExploitation = new HashMap<Integer, TitreExploitation> ();

	public InterfaceEnsembleEconomiquePropriete (Parent root, EnsembleEconomique ee) {
		SplitPane splitpane = new SplitPane ();
		splitpane.setDividerPositions(0.29797979797979796);
		splitpane.setPrefHeight(603);
		splitpane.setPrefWidth(900);
		
		AnchorPane panelist = new AnchorPane ();
		panelist.setPrefWidth(200);
		
		AnchorPane apaneshow = new AnchorPane ();
		Pane paneshow = new Pane ();
		paneshow.setPrefHeight(598);
		paneshow.setPrefWidth(627);

		ListView lv = new ListView ();
		lv.setPrefHeight(598);
		lv.setPrefWidth(266);
	    lv.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	            TitreExploitation titre = listTitresExploitation.get(lv.getSelectionModel().getSelectedIndex());
	            try {
	            	paneshow.getChildren().clear();
	            	paneshow.getChildren().add(new InterfaceTitrePropriete(FXMLLoader.load(getClass().getResource("ressources/fxml/TitrePropriete.fxml")), titre));
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	    });
		
	    int acc = 0;
		for (Country c : ee.getCountries()) {
			for (TitreExploitation t : c.getAllTitresExploitation()) {
				lv.getItems().add(t.getRessource().getName() + " " + t.getPercent() + "%");
				listTitresExploitation.put(acc, t);
				acc++;
			}
		}
		panelist.getChildren().add(lv);
		apaneshow.getChildren().add(paneshow);

		splitpane.getItems().add(panelist);
		splitpane.getItems().add(apaneshow);
		this.getChildren().add(splitpane);
	}

}
