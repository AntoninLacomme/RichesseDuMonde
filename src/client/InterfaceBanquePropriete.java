package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import game.countries.Country;
import game.countries.Region;
import game.ressources.Ressource;
import game.ressources.TitreExploitation;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class InterfaceBanquePropriete extends Scene {

	private HashMap <Integer, TitreExploitation> listTitresExploitation = new HashMap<Integer, TitreExploitation> ();
	
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
		

		
		Tab tabsearch = new Tab ("Recherche");
		
		Pane mainpane = new Pane ();	
		
		SplitPane splitpane = new SplitPane ();
		splitpane.setDividerPositions(0.29797979797979796);
		splitpane.setPrefHeight(603);
		splitpane.setPrefWidth(900);
		
		AnchorPane panelist = new AnchorPane ();
		
		AnchorPane panelisttitre = new AnchorPane ();
		
		AnchorPane apaneshow = new AnchorPane ();
		Pane paneshow = new Pane ();

		ListView lv = new ListView ();
		lv.setPrefHeight(598);
		lv.setPrefWidth(266);
		
		ListView lvtitres = new ListView ();

		lvtitres.setPrefHeight(598);
		lvtitres.setPrefWidth(266);
				
	    lv.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	            Ressource r = Ressource.getRessourceByName(lv.getSelectionModel().getSelectedItem().toString());
	            ArrayList<TitreExploitation> lesTitres = Ressource.getAllTitresExploitation (r);
	            lvtitres.getItems().clear();
	            listTitresExploitation = new HashMap<Integer, TitreExploitation> ();

	    	    int acc = 0;
	            for (TitreExploitation t : lesTitres) {
	            	lvtitres.getItems().add(t.getRessource().getName() + " " + t.getPercent() + "%");
	            	listTitresExploitation.put(acc, t);
	    			acc++;
	    		}
	        }
	    });
	    
	    lvtitres.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	        	TitreExploitation titre = listTitresExploitation.get(lvtitres.getSelectionModel().getSelectedIndex());
	            try {
	            	paneshow.getChildren().clear();
	            	paneshow.getChildren().add(new InterfaceTitrePropriete(FXMLLoader.load(getClass().getResource("ressources/fxml/TitrePropriete.fxml")), titre));
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	    });
		
		for (Ressource r : Ressource.values()) {
			lv.getItems().add(r.getName());
		}
		
		
		panelist.getChildren().add(lv);
		panelisttitre.getChildren().add(lvtitres);
		apaneshow.getChildren().add(paneshow);

		splitpane.getItems().add(panelist);
		splitpane.getItems().add(panelisttitre);
		splitpane.getItems().add(apaneshow);
		mainpane.getChildren().add(splitpane);
		
		tabsearch.setContent(mainpane);
		main.getTabs().add(tabsearch);
	}
}
