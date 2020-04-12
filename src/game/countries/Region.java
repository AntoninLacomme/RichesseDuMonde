package game.countries;

import java.util.ArrayList;
import java.awt.Color;

public enum Region {
	Afrique ("Afrique", new Color (165, 42, 42), new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.AfriqueCentrale);
		add (EnsembleEconomique.AfriqueGrandsLacs);
		add (EnsembleEconomique.AfriqueNordEst);
		add (EnsembleEconomique.AfriqueOccidentale);
		add (EnsembleEconomique.AfriqueSud);
		add (EnsembleEconomique.Maghreb);
	}}),
	Amerique ("Amérique (sauf USA)", Color.RED, new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.Canada);
		add (EnsembleEconomique.Bresil);
		add (EnsembleEconomique.Mexique);
		add (EnsembleEconomique.Venezuela);
		add (EnsembleEconomique.PaysAndins);
		add (EnsembleEconomique.Argentine);
		add (EnsembleEconomique.Antilles);
	}}),
	USA ("USA", Color.ORANGE, new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.USA);
	}}),
	Europe ("Europe", Color.BLUE, new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.Scandinavie);
		add (EnsembleEconomique.Allemagne);
		add (EnsembleEconomique.EuropeBalkanique);
		add (EnsembleEconomique.EuropeDanubienne);
		add (EnsembleEconomique.EuropeMediterraneenne);
		add (EnsembleEconomique.RoyaumeUni);
		add (EnsembleEconomique.France);
	}}),
	Asie ("Asie", Color.YELLOW, new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.Chine);
		add (EnsembleEconomique.PeninsuleIndochinoise);
		add (EnsembleEconomique.PeninsuleIndienne);
		add (EnsembleEconomique.Indonesie);
		add (EnsembleEconomique.JaponAsie);
		add (EnsembleEconomique.MoyenOrient);
	}}),
	Oceanie ("Oceanie", new Color (128, 0, 128), new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.Oceanie);
	}}),
	Russie ("Russie (et C.E.I)", Color.GRAY, new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.Russie);
	}});
	
	private String name;
	private Color color;
	private ArrayList<EnsembleEconomique> mesEnsemblesEco;
	
	Region (String name, Color color, ArrayList<EnsembleEconomique> listEnsembleEco) {
		this.name = name;
		this.color = color;
		this.mesEnsemblesEco = listEnsembleEco;		
	}

	public ArrayList<EnsembleEconomique> getAllEnsembleEconomique() {
		return this.mesEnsemblesEco;
	}
}
