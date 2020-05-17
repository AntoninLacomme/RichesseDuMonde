package client;

import java.awt.Color;
import game.countries.EnsembleEconomique;
import game.countries.Region;
import game.ressources.TitreExploitation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

public class InterfaceTitrePropriete extends Pane {
	
	public InterfaceTitrePropriete(Parent root, TitreExploitation titre) {
		super(root);
		this.setTextLabelByID("labelNameRessource", titre.getRessource().getName());
		this.setTextLabelByID("labelPercentRessource", titre.getPercent() + " %");
		
		Pane paneTitreExploitation = (Pane) this.lookup("#paneRessource");
		Color color = Region.getRegionContains(titre.getCountry()).getColor();
		paneTitreExploitation.setStyle("-fx-background-color: #" 
				+ this.parseDecToHex(color.getRed())
				+ this.parseDecToHex(color.getGreen())
				+ this.parseDecToHex(color.getBlue())
				+ ";");
		
		
		ListView lv = (ListView) this.lookup("#listViewData");
		lv.getItems().add("  \t\t\t\t\t%");
		for (int i = 0; i<4; i++) {
			int val = 30 + i * 20;
			String rapport = this.splitValue(""+ titre.getRessource().getValueByCoeff(val));
			if (rapport.length() <= 7) {
				rapport += "\t";
			}
			lv.getItems().add(" " + rapport + "\t\t\t" + val);
		}
		
		this.setTextLabelByID("labelPrixAchat", this.splitValue(""+ titre.getPrix()) + " €");
		this.setTextLabelByID("labelPays", titre.getCountry().getName());
		this.setTextLabelByID("labelRegion", EnsembleEconomique.getEnsembleEconomiqueContains(titre.getCountry()).getName());
	}
	
	private void setTextLabelByID (String id, String message) {
		Label labelPercentExploitation = (Label) this.lookup("#" + id);
		labelPercentExploitation.setText(message);
	}
	
	private String splitValue (String value) {
		if (value.length() <= 3) {
			return value;
		}
		return this.splitValue(value.substring(0, value.length() - 3)) + " " + value.substring(value.length() - 3);
	}
	
	private String parseDecToHex (int dec) {
		String tmp = Integer.toString(dec, 16);
		if (tmp.length() == 1) {
			return "0" + tmp;
		}
		return tmp;
	}

}
