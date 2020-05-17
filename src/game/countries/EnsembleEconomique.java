package game.countries;

import java.util.ArrayList;

public enum EnsembleEconomique {

	Russie (1, "Russie", new ArrayList<Country> () {{
		add (Country.Russie);
	}}),
	Oceanie (2, "Océanie", new ArrayList<Country> () {{
		add (Country.Australie);
		add (Country.FidjiNouvelleGuinee);
		add (Country.NouvelleZelande);
	}}),
	AfriqueOccidentale (3, "Afrique Occidentale", new ArrayList<Country> () {{
		add (Country.Niger);
		add (Country.Nigeria);
		add (Country.Cameroun);
		add (Country.Ghana);
		add (Country.CoteIvoire);
	}}),
	AfriqueSud (4, "Afrique du Sud", new ArrayList<Country> () {{
		add (Country.AfriqueSud);
		add (Country.Namibie);
		add (Country.UnionSudAfriquaine);
	}}),
	AfriqueGrandsLacs (5, "Afrique des Grands Lacs", new ArrayList<Country> () {{
		add (Country.Zambie);
		add (Country.Kenya);
	}}),
	AfriqueNordEst (6, "Afrique du Nord-Est", new ArrayList<Country> () {{
		add (Country.Ethiopie);
	}}),
	AfriqueCentrale (7, "Afrique Centrale", new ArrayList<Country> () {{
		add (Country.RDCongo);
	}}),
	Scandinavie (8, "Scandinavie", new ArrayList<Country> () {{
		add (Country.Danemark);
		add (Country.Norvege);
		add (Country.Finlande);
	}}),
	Allemagne (9, "Allemagne", new ArrayList<Country> () {{
		add (Country.Allemagne);
	}}),
	EuropeDanubienne (10, "Europe Danubienne", new ArrayList<Country> () {{
		add (Country.Yougoslavie);
		add (Country.Turquie);
	}}),
	EuropeBalkanique (11, "Europe Balkanique", new ArrayList<Country> () {{
		add (Country.PaysBas);
		add (Country.Pologne);
	}}),
	France (12, "France", new ArrayList<Country> () {{
		add (Country.France);
	}}),
	RoyaumeUni (13, "Royaume Uni", new ArrayList<Country> () {{
		add (Country.RoyaumeUni);
	}}),
	EuropeMediterraneenne (14, "Europe Méditerranéenne", new ArrayList<Country> () {{
		add (Country.Italie);
		add (Country.Espagne);
	}}),
	Maghreb (15, "Maghreb", new ArrayList<Country> () {{
		add (Country.Algerie);
	}}),
	USA (16, "USA", new ArrayList<Country> () {{
		add (Country.USA);
	}}),
	Canada (17, "Canada", new ArrayList<Country> () {{
		add (Country.Canada);
	}}),
	Chine (18, "Chine", new ArrayList<Country> () {{
		add (Country.Chine);
	}}),
	PeninsuleIndienne (19, "Péninsule Indienne", new ArrayList<Country> () {{
		add (Country.Inde);
		add (Country.Pakistan);
		add (Country.SriLanka);
	}}),
	Bresil (20, "Brésil", new ArrayList<Country> () {{
		add (Country.Bresil);
	}}),
	Indonesie (21, "Indonésie", new ArrayList<Country> () {{
		add (Country.Indonesie);
		add (Country.Philippines);
	}}),
	JaponAsie (22, "Japon Asie", new ArrayList<Country> () {{
		add (Country.Japon);
		add (Country.Coree);
	}}),
	Venezuela (23, "Venezuela", new ArrayList<Country> () {{
		add (Country.Venezuela);
	}}),
	PaysAndins (24, "Pays Andins", new ArrayList<Country> () {{
		add (Country.Chili);
		add (Country.Colombie);
		add (Country.Bolivie);
		add (Country.Perou);
	}}),
	PeninsuleIndochinoise (25, "Pénisule Indochinoise", new ArrayList<Country> () {{
		add (Country.Cambodge);
		add (Country.VietNam);
		add (Country.Thailande);
		add (Country.Malaisie);
	}}),
	Argentine (26, "Argentine", new ArrayList<Country> () {{
		add (Country.Argentine);
	}}),
	Mexique (27, "Mexique", new ArrayList<Country> () {{
		add (Country.Mexique);
	}}),
	Antilles (28, "Antilles", new ArrayList<Country> () {{
		add (Country.Cuba);
	}}),
	MoyenOrient (29, "Moyen-Orient", new ArrayList<Country> () {{
		add (Country.Iran);
		add (Country.ArabieSaoudite);
	}});
	
	private String name;
	private ArrayList<Country> listPays;
	private int idEnsEco;
	
	EnsembleEconomique (int id, String name, ArrayList<Country> listPays) {
		this.idEnsEco = id;
		this.name = name;
		this.listPays = listPays;
	}
	
	public ArrayList<Country> getCountries () {
		return this.listPays;
	}
	
	public int getID () { return this.idEnsEco; }

	public static EnsembleEconomique getEnsembleEconomiqueContains(Country country) {
		for (EnsembleEconomique ee : EnsembleEconomique.values()) {
			for (Country c : ee.getCountries()) {
				if (c.equals(country)) {
					return ee;
				}
			}
		}
		return null;
	}

	public String getName() {
		return this.name;
	}
}
