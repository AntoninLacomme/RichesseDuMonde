package game.countries;

import java.util.ArrayList;
import java.awt.Color;

public enum Region {
	Afrique ("A", "Afrique", new Color (165, 42, 42), new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.AfriqueCentrale);
		add (EnsembleEconomique.AfriqueGrandsLacs);
		add (EnsembleEconomique.AfriqueNordEst);
		add (EnsembleEconomique.AfriqueOccidentale);
		add (EnsembleEconomique.AfriqueSud);
		add (EnsembleEconomique.Maghreb);
	}}),
	Amerique ("B", "Amérique (sauf USA)", Color.RED, new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.Canada);
		add (EnsembleEconomique.Bresil);
		add (EnsembleEconomique.Mexique);
		add (EnsembleEconomique.Venezuela);
		add (EnsembleEconomique.PaysAndins);
		add (EnsembleEconomique.Argentine);
		add (EnsembleEconomique.Antilles);
	}}),
	USA ("C", "USA", new Color(255, 140, 0), new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.USA);
	}}),
	Europe ("D", "Europe", Color.BLUE, new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.Scandinavie);
		add (EnsembleEconomique.Allemagne);
		add (EnsembleEconomique.EuropeBalkanique);
		add (EnsembleEconomique.EuropeDanubienne);
		add (EnsembleEconomique.EuropeMediterraneenne);
		add (EnsembleEconomique.RoyaumeUni);
		add (EnsembleEconomique.France);
	}}),
	Asie ("E", "Asie", new Color(255, 228, 54), new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.Chine);
		add (EnsembleEconomique.PeninsuleIndochinoise);
		add (EnsembleEconomique.PeninsuleIndienne);
		add (EnsembleEconomique.Indonesie);
		add (EnsembleEconomique.JaponAsie);
		add (EnsembleEconomique.MoyenOrient);
	}}),
	Oceanie ("F", "Oceanie", new Color (128, 0, 128), new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.Oceanie);
	}}),
	Russie ("G", "Russie (et C.E.I)", Color.GRAY, new ArrayList<EnsembleEconomique> () {{
		add (EnsembleEconomique.Russie);
	}});
	
	private String id;
	private String name;
	private Color color;
	private ArrayList<EnsembleEconomique> mesEnsemblesEco;
	
	Region (String id, String name, Color color, ArrayList<EnsembleEconomique> listEnsembleEco) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.mesEnsemblesEco = listEnsembleEco;		
	}

	public ArrayList<EnsembleEconomique> getAllEnsembleEconomique() {
		return this.mesEnsemblesEco;
	}
	
	public String getID () { return this.id; }
	
	public static Region getRegionContains (Country country) {
		for (Region r : Region.values()) {
			for (EnsembleEconomique ee : r.mesEnsemblesEco) {
				for (Country c : ee.getCountries()) {
					if (c.equals(country)) {
						return r;
					}
				}
			}
		}
		return null;
	}
	
	public static Region getRegionByID (String id) {
		for (Region r: Region.values()) {
			if (r.getID().equals(id)) {
				return r;
			}
		}
		return null;
	}

	public Color getColor() {
		return this.color;
	}

	public String getName() {
		return this.name;
	}
}
