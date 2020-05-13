package protocole;

import java.util.ArrayList;

import game.ressources.Ressource;
import game.ressources.TitreExploitation;

public class Inventaire {
	private int money;
	private ArrayList<TitreExploitation> mesTitres;
	
	public Inventaire () {
		this.money = 0;
		this.mesTitres = new ArrayList<TitreExploitation> ();
	}

	public void addMoney(int i) {
		this.money += i;
	}

	public boolean hasRessource(Ressource ressource) {
		for (TitreExploitation titre : this.mesTitres) {
			if (titre.getRessource().equals(ressource)) {
				return true;
			}
		}
		return false;
	}
	
	
}
