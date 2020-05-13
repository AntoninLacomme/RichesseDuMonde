package game;

import java.util.ArrayList;

import game.countries.EnsembleEconomique;
import game.countries.Region;
import game.ressources.Ressource;

public class Case {
		public String name;
		public ArrayList<EnsembleEconomique> ensEco;
		public Ressource ressource;
		public String idCase;
		
		public Case (EnsembleEconomique ensEco, Ressource ressource) {
			this.name = ensEco.name();
			this.ensEco = new ArrayList<EnsembleEconomique> () {{ add(ensEco); }};
			this.ressource = ressource;
			this.idCase = "" + ensEco.getID();
		}
		
		public Case (Region region, Ressource ressource) {
			this.name = "Choix " + region.name();
			this.ensEco = region.getAllEnsembleEconomique ();
			this.ressource = ressource;
			this.idCase = region.getID ();
		}
		
		public String getID () {
			return this.idCase;
		}
		
		public int getIDRessource () {
			if (this.ressource != null) {
				return this.ressource.getID();
			}
			return -1;
		}
		
		public Case (String enonce) {
			this.idCase = enonce;
			this.name = enonce;
			this.ressource = null;
		}
		
		public Case (String enonce, Ressource ressource) {
			this.idCase = enonce;
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