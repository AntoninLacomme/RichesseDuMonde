package game.ressources;

import java.util.ArrayList;

import game.countries.Country;
import game.countries.EnsembleEconomique;
import game.countries.Region;

public enum Ressource {
	Petrole (0, "Pétrole", 12),
	Acier (1, "Acier", 11),
	Fer (2, "Fer", 10),
	Cuivre (3, "Cuivre", 9),
	Cobalt (4, "Cobalt", 6),
	GazNaturel (5, "Gaz Naturel", 8),
	Argent (6, "Argent", 7),
	ConstructionAutomobile (7, "Construction Automobile", 8),
	ConstructionNavale (8, "Construction Navale", 7),
	Aluminium (9, "Aluminum", 9),
	Plomb (10, "Plomb", 6),
	Uranium (11, "Uranium", 8),
	Houille (12, "Houille", 11),
	CotonBrut (13, "Coton Brut", 5),
	LaineBrute (14, "Laine Brute", 5),
	Cafe (15, "Café", 4),
	Or (16, "Or", 10),
	Sucre (17, "Sucre", 9),
	Riz (18, "Riz", 7),
	Ble (19, "Blé", 10),
	The (20, "Thé", 5),
	Cacao (21, "Cacao", 4),
	CaoutchoucNaturel (22, "Caoutchouc Naturel", 4),
	Nickel (23, "Nickel", 6);
	
	int idRessource;
	private String nameRessource;
	private int coeffRessource;
	
	Ressource (int id, String name, int coefficient) {
		this.idRessource = id;
		this.nameRessource = name;
		this.coeffRessource = coefficient;
	}
	
	public int getValueByCoeff (int coeff) {		
		if (coeff > 100 || coeff < 0) { return 0; }		
		if (coeff >= 90) { return this.coeffRessource * 2000000; }		
		if (coeff >= 70) { return this.coeffRessource * 1000000; }		
		if (coeff >= 50) { return this.coeffRessource * 500000; }		
		if (coeff >= 30) { return this.coeffRessource * 100000; }
		return 0;
	}
	
	public int getID () { return this.idRessource; }
	
	public int getCoeff () { return this.coeffRessource; }
	
	public String getName () { return this.nameRessource; }
	
	static public Ressource[] getAllRessources () {
		return Ressource.values();
	}
	
	static public Ressource getRessourceByID (int id) {
		for (Ressource r : Ressource.values()) {
			if (r.getID () == id) {
				return r;
			}
		}
		return null;
	}

	static public Ressource getRessourceByName (String name) {
		for (Ressource r : Ressource.values()) {
			if (r.getName().equals(name)) {
				return r;
			}
		}
		return null;
	}
	
	public boolean isEqual(Ressource ressource) {
		if (this.name() == ressource.name()) { return true; }
		return false;
	}

	public static ArrayList<TitreExploitation> getAllTitresExploitation (Ressource ressource) {
		ArrayList<TitreExploitation> titres = new ArrayList<TitreExploitation> ();
		for (Region r : Region.values()) {
			for (EnsembleEconomique ee : r.getAllEnsembleEconomique()) {
				for (Country c : ee.getCountries()) {
					for (TitreExploitation t : c.getAllTitresExploitation()) {
						if (t.getRessource().equals(ressource)) {
							titres.add(t);
						}
					}
				}
			}
		}
		return titres;
	}
}
