package game.countries;

import java.util.ArrayList;

public enum EnsembleEconomique {

	Russie ("Russie", new ArrayList<Country> () {{
		add (Country.Russie);
	}}),
	Oceanie ("Océanie", new ArrayList<Country> () {{
		add (Country.Australie);
		add (Country.FidjiNouvelleGuinee);
		add (Country.NouvelleZelande);
	}}),
	AfriqueOccidentale ("Afrique Occidentale", new ArrayList<Country> () {{
		add (Country.Niger);
		add (Country.Nigeria);
		add (Country.Cameroun);
		add (Country.Ghana);
		add (Country.CoteIvoire);
	}}),
	AfriqueSud ("Afrique du Sud", new ArrayList<Country> () {{
		add (Country.AfriqueSud);
		add (Country.Namibie);
		add (Country.UnionSudAfriquaine);
	}}),
	AfriqueGrandsLacs ("Afrique des Grands Lacs", new ArrayList<Country> () {{
		add (Country.Zambie);
		add (Country.Kenya);
	}}),
	AfriqueNordEst ("Afrique du Nord-Est", new ArrayList<Country> () {{
		add (Country.Ethiopie);
	}}),
	AfriqueCentrale ("Afrique Centrale", new ArrayList<Country> () {{
		add (Country.RDCongo);
	}}),
	Scandinavie ("Scandinavie", new ArrayList<Country> () {{
		add (Country.Danemark);
		add (Country.Norvege);
		add (Country.Finlande);
	}}),
	Allemagne ("Allemagne", new ArrayList<Country> () {{
		add (Country.Allemagne);
	}}),
	EuropeDanubienne ("Europe Danubienne", new ArrayList<Country> () {{
		add (Country.Yougoslavie);
		add (Country.Turquie);
	}}),
	EuropeBalkanique ("Europe Balkanique", new ArrayList<Country> () {{
		add (Country.PaysBas);
		add (Country.Pologne);
	}}),
	France ("France", new ArrayList<Country> () {{
		add (Country.France);
	}}),
	RoyaumeUni ("Royaume Uni", new ArrayList<Country> () {{
		add (Country.RoyaumeUni);
	}}),
	EuropeMediterraneenne ("Europe Méditerranéenne", new ArrayList<Country> () {{
		add (Country.Italie);
		add (Country.Espagne);
	}}),
	Maghreb ("Maghreb", new ArrayList<Country> () {{
		add (Country.Algerie);
	}}),
	USA ("USA", new ArrayList<Country> () {{
		add (Country.USA);
	}}),
	Canada ("Canada", new ArrayList<Country> () {{
		add (Country.Canada);
	}}),
	Chine ("Chine", new ArrayList<Country> () {{
		add (Country.Chine);
	}}),
	PeninsuleIndienne ("Péninsule Indienne", new ArrayList<Country> () {{
		add (Country.Inde);
		add (Country.Pakistan);
		add (Country.SriLanka);
	}}),
	Bresil ("Brésil", new ArrayList<Country> () {{
		add (Country.Bresil);
	}}),
	Indonesie ("Indonésie", new ArrayList<Country> () {{
		add (Country.Indonesie);
		add (Country.Philippines);
	}}),
	JaponAsie ("Japon Asie", new ArrayList<Country> () {{
		add (Country.Japon);
		add (Country.Coree);
	}}),
	Venezuela ("Venezuela", new ArrayList<Country> () {{
		add (Country.Venezuela);
	}}),
	PaysAndins ("Pays Andins", new ArrayList<Country> () {{
		add (Country.Chili);
		add (Country.Colombie);
		add (Country.Bolivie);
		add (Country.Perou);
	}}),
	PeninsuleIndochinoise ("Pénisule Indochinoise", new ArrayList<Country> () {{
		add (Country.Cambodge);
		add (Country.VietNam);
		add (Country.Thailande);
		add (Country.Malaisie);
	}}),
	Argentine ("Argentine", new ArrayList<Country> () {{
		add (Country.Argentine);
	}}),
	Mexique ("Mexique", new ArrayList<Country> () {{
		add (Country.Mexique);
	}}),
	Antilles ("Antilles", new ArrayList<Country> () {{
		add (Country.Cuba);
	}}),
	MoyenOrient ("Moyen-Orient", new ArrayList<Country> () {{
		add (Country.Iran);
		add (Country.ArabieSaoudite);
	}});
	
	private String name;
	private ArrayList<Country> listPays;
	
	
	EnsembleEconomique (String name, ArrayList<Country> listPays) {
		this.name = name;
		this.listPays = listPays;
	}
}
