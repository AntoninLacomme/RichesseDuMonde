package game.ressources;

import game.countries.Country;

public enum Ressource {
	Petrole ("Pétrole", 12),
	Acier ("Acier", 11),
	Fer ("Fer", 10),
	Cuivre ("Cuivre", 9),
	Cobalt ("Cobalt", 6),
	GazNaturel ("Gaz Naturel", 8),
	Argent ("Argent", 7),
	ConstructionAutomobile ("Construction Automobile", 8),
	ConstructionNavale ("Construction Navale", 7),
	Aluminium ("Aluminum", 9),
	Plomb ("Plomb", 6),
	Uranium ("Uranium", 8),
	Houille ("Houille", 11),
	CotonBrut ("Coton Brut", 5),
	LaineBrute ("Laine Brute", 5),
	Cafe ("Café", 4),
	Or ("Or", 10),
	Sucre ("Sucre", 9),
	Riz ("Riz", 7),
	Ble ("Blé", 10),
	The ("Thé", 5),
	Cacao ("Cacao", 4),
	CaoutchoucNaturel ("Caoutchouc Naturel", 4),
	Nickel ("Nickel", 6);
	
	private String nameRessource;
	private int coeffRessource;
	
	Ressource (String name, int coefficient) {
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
	
	public int getCoeff () { return this.coeffRessource; }
	
	public String getName () { return this.nameRessource; }
	
	static public Ressource[] getAllRessources () {
		return Ressource.values();
	}

	public boolean isEqual(Ressource ressource) {
		if (this.name() == ressource.name()) { return true; }
		return false;
	}
}
