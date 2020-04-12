package game.countries;

import java.util.HashMap;

import game.ressources.Ressource;

public enum Country {
	Russie ("Russie", new HashMap <Ressource, Integer> () {{
			put (Ressource.CotonBrut, 25);
			put (Ressource.Aluminium, 20);
			put (Ressource.Cobalt, 20);
			put (Ressource.Sucre, 20);
			put (Ressource.GazNaturel, 40);
			put (Ressource.Or, 20);
			put (Ressource.Cuivre, 15);
			put (Ressource.Nickel, 30);
			put (Ressource.Houille, 20);
			put (Ressource.ConstructionNavale, 10);
			put (Ressource.Ble, 25);
			put (Ressource.Plomb, 20);
			put (Ressource.Acier, 30);
			put (Ressource.Fer, 30);
			put (Ressource.Petrole, 30);
			put (Ressource.LaineBrute, 20);
		}}),	
	Japon ("Japon", new HashMap <Ressource, Integer> () {{
			put (Ressource.Acier, 20);
			put (Ressource.Riz, 10);
			put (Ressource.Nickel, 15);
			put (Ressource.ConstructionNavale, 50);
			put (Ressource.Aluminium, 10);
			put (Ressource.ConstructionAutomobile, 30);
		}}),
	Coree ("Corée", new HashMap <Ressource, Integer> () {{
			put (Ressource.ConstructionNavale, 20);
		}}),
	USA ("USA", new HashMap <Ressource, Integer> () {{
			put (Ressource.CotonBrut, 20);
			put (Ressource.Plomb, 20);
			put (Ressource.Argent, 20);
			put (Ressource.Sucre, 10);
			put (Ressource.Uranium, 15);
			put (Ressource.Ble, 15);
			put (Ressource.ConstructionAutomobile, 25);
			put (Ressource.Houille, 25);
			put (Ressource.Fer, 5);
			put (Ressource.Or, 15);
			put (Ressource.Petrole, 25);
			put (Ressource.Aluminium, 35);
			put (Ressource.Cuivre, 25);
			put (Ressource.GazNaturel, 25);
			put (Ressource.Acier, 15);
		}}),
	Chine ("Chine", new HashMap <Ressource, Integer> () {{
			put (Ressource.CotonBrut, 25);
			put (Ressource.The, 25);
			put (Ressource.LaineBrute, 15);
			put (Ressource.Fer, 20);
			put (Ressource.Sucre, 10);
			put (Ressource.Houille, 35);
			put (Ressource.Ble, 25);
			put (Ressource.Acier, 15);
			put (Ressource.Plomb, 15);
			put (Ressource.Riz, 40);
		}}),
	Allemagne ("Allemagne", new HashMap <Ressource, Integer> () {{
			put (Ressource.ConstructionNavale, 10);
			put (Ressource.Aluminium, 10);
			put (Ressource.ConstructionAutomobile, 20);
			put (Ressource.Acier, 10);
		}}),
	Bresil ("Brésil", new HashMap <Ressource, Integer> () {{
			put (Ressource.Cafe, 35);
			put (Ressource.CotonBrut, 5);
			put (Ressource.Or, 5);
			put (Ressource.Fer, 25);
			put (Ressource.Cacao, 20);
			put (Ressource.Acier, 5);
			put (Ressource.Sucre, 15);
		}}),
	Canada ("Canada", new HashMap <Ressource, Integer> () {{
			put (Ressource.GazNaturel, 10);
			put (Ressource.Or, 10);
			put (Ressource.Argent, 15);
			put (Ressource.Cuivre, 15);
			put (Ressource.Nickel, 25);
			put (Ressource.Plomb, 15);
			put (Ressource.Ble, 10);
			put (Ressource.Cobalt, 10);
			put (Ressource.Uranium, 40);
			put (Ressource.Aluminium, 15);
		}}),
	Australie ("Australie", new HashMap <Ressource, Integer> () {{
			put (Ressource.Argent, 15);
			put (Ressource.Aluminium, 10);
			put (Ressource.Uranium, 10);
			put (Ressource.LaineBrute, 35);
			put (Ressource.Fer, 10);
			put (Ressource.Plomb, 20);
			put (Ressource.Nickel, 10);
		}}),
	Mexique ("Mexique", new HashMap <Ressource, Integer> () {{
		put (Ressource.Petrole, 10);
		put (Ressource.Cafe, 10);
		put (Ressource.Argent, 25);
	}}),
	Perou ("Pérou", new HashMap <Ressource, Integer> () {{
		put (Ressource.Plomb, 10);
		put (Ressource.Argent, 20);
	}}),
	Bolivie ("Bolivie", new HashMap <Ressource, Integer> () {{
		put (Ressource.Argent, 5);
	}}),
	Inde ("Inde", new HashMap <Ressource, Integer> () {{
		put (Ressource.The, 35);
		put (Ressource.Riz, 25);
		put (Ressource.Sucre, 25);
		put (Ressource.CotonBrut, 15);
		put (Ressource.Houille, 5);
		put (Ressource.CaoutchoucNaturel, 5);
		put (Ressource.Fer, 5);
		put (Ressource.Ble, 15);
	}}),
	France ("France", new HashMap <Ressource, Integer> () {{
		put (Ressource.ConstructionAutomobile, 15);
		put (Ressource.Ble, 10);
		put (Ressource.Uranium, 10);
	}}),
	CoteIvoire ("Côte d'Ivoire", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cafe, 10);
		put (Ressource.Cacao, 35);
	}}),
	Ghana ("Ghana", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cacao, 20);
	}}),
	Malaisie ("Malaisie", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cacao, 15);
		put (Ressource.CaoutchoucNaturel, 35);
	}}),
	Cameroun ("Cameroun", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cacao, 5);
	}}),
	Nigeria ("Nigeria", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cacao, 5);
	}}),
	Colombie ("Colombie", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cafe, 25);
	}}),
	Indonesie ("Indonésie", new HashMap <Ressource, Integer> () {{
		put (Ressource.The, 5);
		put (Ressource.Cafe, 15);
		put (Ressource.CaoutchoucNaturel, 30);
		put (Ressource.Riz, 15);
	}}),
	Ethiopie ("Ethiopie", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cafe, 5);
	}}),
	Thailande ("Thailande", new HashMap <Ressource, Integer> () {{
		put (Ressource.CaoutchoucNaturel, 20);
		put (Ressource.Riz, 5);
	}}),
	Philippines ("Philippines", new HashMap <Ressource, Integer> () {{
		put (Ressource.CaoutchoucNaturel, 5);
	}}),
	Cambodge ("Cambodge", new HashMap <Ressource, Integer> () {{
		put (Ressource.CaoutchoucNaturel, 5);
	}}),
	RDCongo ("République Démocratique du Congo", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cobalt, 35);
	}}),
	Zambie ("Zambie", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cobalt, 20);
		put (Ressource.Cuivre, 10);
	}}),
	Norvege ("Norvège", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cobalt, 5);
		put (Ressource.Nickel, 10);
	}}),
	Finlande ("Finlande", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cobalt, 5);
	}}),
	Italie ("Italie", new HashMap <Ressource, Integer> () {{
		put (Ressource.ConstructionAutomobile, 5);
	}}),
	Espagne ("Espagne", new HashMap <Ressource, Integer> () {{
		put (Ressource.ConstructionAutomobile, 5);
	}}),
	Yougoslavie ("Yougoslavie", new HashMap <Ressource, Integer> () {{
		put (Ressource.ConstructionNavale, 5);
	}}),
	Danemark ("Danemark", new HashMap <Ressource, Integer> () {{
		put (Ressource.ConstructionNavale, 5);
	}}),
	Pakistan ("Pakistan", new HashMap <Ressource, Integer> () {{
		put (Ressource.CotonBrut, 10);
	}}),
	Chili ("Chili", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cuivre, 25);
	}}),
	Pologne ("Pologne", new HashMap <Ressource, Integer> () {{
		put (Ressource.Cuivre, 5);
		put (Ressource.Houille, 5);
	}}),
	PaysBas ("Pays-Bas", new HashMap <Ressource, Integer> () {{
		put (Ressource.GazNaturel, 5);
	}}),
	Algerie ("Algérie", new HashMap <Ressource, Integer> () {{
		put (Ressource.GazNaturel, 5);
	}}),
	RoyaumeUni ("Royaume-Uni", new HashMap <Ressource, Integer> () {{
		put (Ressource.GazNaturel, 5);
	}}),
	AfriqueSud ("Afrique du Sud", new HashMap <Ressource, Integer> () {{
		put (Ressource.Houille, 5);
	}}),
	NouvelleZelande ("Nouvelle Zélande", new HashMap <Ressource, Integer> () {{
		put (Ressource.LaineBrute, 15);
	}}),
	Argentine ("Argentine", new HashMap <Ressource, Integer> () {{
		put (Ressource.LaineBrute, 10);
	}}),
	UnionSudAfriquaine ("Union Sud-Afrique", new HashMap <Ressource, Integer> () {{
		put (Ressource.Or, 40);
		put (Ressource.LaineBrute, 5);
	}}),
	NouvelleCaledonie ("Nouvelle Calédonie", new HashMap <Ressource, Integer> () {{
			put (Ressource.Nickel, 10);
		}}),
	FidjiNouvelleGuinee ("Fidji - Nouvelle Guinée", new HashMap <Ressource, Integer> () {{
			put (Ressource.Or, 10);
		}}),
	ArabieSaoudite ("Arabie Saoudite", new HashMap <Ressource, Integer> () {{
		put (Ressource.Petrole, 15);
	}}),
	Iran ("Iran", new HashMap <Ressource, Integer> () {{
		put (Ressource.Petrole, 10);
	}}),
	Venezuela ("Venezuala", new HashMap <Ressource, Integer> () {{
		put (Ressource.Petrole, 5);
	}}),
	VietNam ("Viet-Nam", new HashMap <Ressource, Integer> () {{
		put (Ressource.Riz, 5);
	}}),
	Cuba ("Cuba", new HashMap <Ressource, Integer> () {{
		put (Ressource.Sucre, 20);
	}}),
	SriLanka ("Sri Lanka", new HashMap <Ressource, Integer> () {{
		put (Ressource.The, 15);
	}}),
	Kenya ("Kenya", new HashMap <Ressource, Integer> () {{
		put (Ressource.The, 15);
	}}),
	Turquie ("Turquie", new HashMap <Ressource, Integer> () {{
		put (Ressource.The, 5);
	}}),
	Namibie ("Namibie", new HashMap <Ressource, Integer> () {{
		put (Ressource.Uranium, 10);
	}}),
	Niger ("Niger", new HashMap <Ressource, Integer> () {{
		put (Ressource.Uranium, 10);
	}});
	
	

	public String name;
	private HashMap<Ressource, Integer> possessions;
	
	Country (String name, HashMap<Ressource, Integer> possesions) {
		this.name = name;
		this.possessions = possesions;
	}
	
	public Country[] getAllCountries () {
		return Country.values();
	}
	

}
