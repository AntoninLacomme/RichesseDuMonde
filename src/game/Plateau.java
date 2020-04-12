package game;

import java.util.ArrayList;
import java.util.Random;

import game.actualite.Actualite;
import game.countries.Country;
import game.countries.EnsembleEconomique;
import game.countries.Region;
import game.ressources.Ressource;

public class Plateau {
	
	private class Case {
		public String name;
		public ArrayList<EnsembleEconomique> ensEco;
		public Ressource ressource;
		
		public Case (EnsembleEconomique ensEco, Ressource ressource) {
			this.name = ensEco.name();
			this.ensEco = new ArrayList<EnsembleEconomique> () {{ add(ensEco); }};
			this.ressource = ressource;
		}
		
		public Case (Region region, Ressource ressource) {
			this.name = "Choix " + region.name();
			this.ensEco = region.getAllEnsembleEconomique ();
			this.ressource = ressource;
		}
		
		public Case (String enonce) {
			this.name = enonce;
			this.ressource = null;
		}
		
		public Case (String enonce, Ressource ressource) {
			this.name = enonce;
			this.ressource = ressource;
		}
		
		public String toString () {
			String txt = "\tNom de case : " + this.name;
			
			txt += "\n\tRessource : ";
			if (ressource != null) {
				txt += this.ressource.getName();
			}
			else {
				txt += "null";
			}
			return txt;
		}
	}
	
	// tableau de 64 cases
	private Case[] monPlateau;
	private ArrayList<Ressource> listPlaquette;
	private int actualNbJoker = 9;
	private ArrayList<Actualite> listActualite;
	
	
	public Plateau () {
		this.buildPlateau();
	}
	
	private void buildPlateau () {
		this.initializeListPlaquette();
		this.actualNbJoker = 9;
		this.initializeListActivities();
		
		this.monPlateau = new Case[64];
		
		this.setEuropa ();
		this.setRussia ();
		this.setAmerica();
		this.setUSA ();
		this.setAfrica ();
		this.setOceania();
		this.setAsia();
		
		this.setEnchere ();
		this.setFreeMoney ();
		this.setActuality ();
		this.setJoker();
		this.setChoixMondial();
		
	}

	private void setEuropa () {
		this.monPlateau[0] = new Case (EnsembleEconomique.Scandinavie, this.getPlaquette());
		this.monPlateau[1] = new Case (EnsembleEconomique.Allemagne, this.getPlaquette());
		this.monPlateau[2] = new Case (Region.Europe, this.getPlaquette());
		this.monPlateau[3] = new Case (EnsembleEconomique.RoyaumeUni, this.getPlaquette());
		this.monPlateau[4] = new Case (EnsembleEconomique.France, this.getPlaquette());
		this.monPlateau[5] = new Case (EnsembleEconomique.EuropeMediterraneenne, this.getPlaquette());
		this.monPlateau[6] = new Case (Region.Europe, this.getPlaquette());
		this.monPlateau[7] = new Case (EnsembleEconomique.EuropeDanubienne, this.getPlaquette());
		this.monPlateau[8] = new Case (EnsembleEconomique.EuropeBalkanique, this.getPlaquette());
	}
	private void setAmerica () {
		this.monPlateau[18] = new Case (EnsembleEconomique.Canada, this.getPlaquette());
		this.monPlateau[19] = new Case (EnsembleEconomique.Mexique, this.getPlaquette());
		this.monPlateau[20] = new Case (Region.Amerique, this.getPlaquette());
		this.monPlateau[21] = new Case (EnsembleEconomique.Antilles, this.getPlaquette());
		this.monPlateau[22] = new Case (EnsembleEconomique.Venezuela, this.getPlaquette());
		this.monPlateau[23] = new Case (EnsembleEconomique.PaysAndins, this.getPlaquette());
		this.monPlateau[24] = new Case (Region.Amerique, this.getPlaquette());
		this.monPlateau[25] = new Case (EnsembleEconomique.Bresil, this.getPlaquette());
		this.monPlateau[26] = new Case (EnsembleEconomique.Argentine, this.getPlaquette());
	}
	private void setAfrica () {
		this.monPlateau[36] = new Case (EnsembleEconomique.Maghreb, this.getPlaquette());
		this.monPlateau[37] = new Case (EnsembleEconomique.AfriqueNordEst, this.getPlaquette());
		this.monPlateau[38] = new Case (EnsembleEconomique.AfriqueOccidentale, this.getPlaquette());
		this.monPlateau[39] = new Case (Region.Afrique, this.getPlaquette());
		this.monPlateau[40] = new Case (EnsembleEconomique.AfriqueCentrale, this.getPlaquette());
		this.monPlateau[41] = new Case (EnsembleEconomique.AfriqueGrandsLacs, this.getPlaquette());
		this.monPlateau[42] = new Case (EnsembleEconomique.AfriqueSud, this.getPlaquette());
	}
	private void setAsia () {
		this.monPlateau[50] = new Case (EnsembleEconomique.MoyenOrient, this.getPlaquette());
		this.monPlateau[51] = new Case (EnsembleEconomique.PeninsuleIndienne, this.getPlaquette());
		this.monPlateau[52] = new Case (EnsembleEconomique.PeninsuleIndochinoise, this.getPlaquette());
		this.monPlateau[53] = new Case (Region.Asie, this.getPlaquette());
		this.monPlateau[54] = new Case (EnsembleEconomique.JaponAsie, this.getPlaquette());
		this.monPlateau[55] = new Case (EnsembleEconomique.Chine, this.getPlaquette());
		this.monPlateau[56] = new Case (EnsembleEconomique.Indonesie, this.getPlaquette());
	}
	private void setRussia () {
		this.monPlateau[12] = new Case (EnsembleEconomique.Russie, this.getPlaquette());
		this.monPlateau[13] = new Case (EnsembleEconomique.Russie, this.getPlaquette());
		this.monPlateau[14] = new Case (EnsembleEconomique.Russie, this.getPlaquette());
	}
	private void setUSA () {
		this.monPlateau[30] = new Case (EnsembleEconomique.Russie, this.getPlaquette());
		this.monPlateau[31] = new Case (EnsembleEconomique.Russie, this.getPlaquette());
		this.monPlateau[32] = new Case (EnsembleEconomique.Russie, this.getPlaquette());
	}
	private void setOceania () {
		this.monPlateau[46] = new Case (EnsembleEconomique.Oceanie, this.getPlaquette());
		this.monPlateau[60] = new Case (EnsembleEconomique.Oceanie, this.getPlaquette());
	}
	
	private void setEnchere () {
		this.monPlateau[9] = new Case ("Enchères");
		this.monPlateau[27] = new Case ("Enchères");
		this.monPlateau[35] = new Case ("Enchères");
		this.monPlateau[49] = new Case ("Enchères");
		this.monPlateau[63] = new Case ("Enchères");
	}
	
	private void setJoker () {
		this.monPlateau[17] = new Case ("Joker");
		this.monPlateau[43] = new Case ("Joker");
		this.monPlateau[57] = new Case ("Joker");
	}
	
	private void setActuality() {
		this.monPlateau[11] = new Case ("Actualité");
		this.monPlateau[15] = new Case ("Actualité");
		this.monPlateau[29] = new Case ("Actualité");
		this.monPlateau[33] = new Case ("Actualité");
		this.monPlateau[47] = new Case ("Actualité");
		this.monPlateau[61] = new Case ("Actualité");
	}

	private void setFreeMoney() {
		this.monPlateau[10] = new Case ("Free Money", this.getPlaquette());
		this.monPlateau[16] = new Case ("Free Money", this.getPlaquette());
		this.monPlateau[28] = new Case ("Free Money", this.getPlaquette());
		this.monPlateau[34] = new Case ("Free Money", this.getPlaquette());
		this.monPlateau[44] = new Case ("Free Money", this.getPlaquette());
		this.monPlateau[48] = new Case ("Free Money", this.getPlaquette());
		this.monPlateau[58] = new Case ("Free Money", this.getPlaquette());
		this.monPlateau[62] = new Case ("Free Money", this.getPlaquette());
	}
	
	private void setChoixMondial () {
		this.monPlateau[45] = new Case ("Choix Mondial");
		this.monPlateau[59] = new Case ("Actualité");
	}
	
	private void initializeListPlaquette () {
		this.listPlaquette = new ArrayList<Ressource> ();
		
		for (Ressource r : Ressource.getAllRessources()) {
			this.listPlaquette.add(r);
			this.listPlaquette.add(r);
		}
		
	}
	
	private void initializeListActivities () {
		ArrayList<Actualite> allActualite = Actualite.getAllActualite ();
	}
	
	private Ressource getPlaquette () {		
		int index = new Random().nextInt(this.listPlaquette.size());
		Ressource r = this.listPlaquette.get(index);
		this.listPlaquette.remove(index);
		return r;
	}
	
	public String toString () {
		String all = "";
		int acc = 0;
		for (Case c: this.monPlateau) {
			acc++;
			all += "Case " + acc + " ->\n" + c.toString() + "\n\n";
		}
		return all;
	}
}
