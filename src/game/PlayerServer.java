package game;

import java.util.ArrayList;

import game.ressources.Ressource;
import game.ressources.TitreExploitation;

public class PlayerServer implements ReserveArgent {
	private String name;
	private int actualMoney;
	private ArrayList<TitreExploitation> mesTitres;
	
	public PlayerServer (String name, int money) {
		this.name = name;
		this.actualMoney = money;
		this.mesTitres = new ArrayList<TitreExploitation>();
	}

	@Override
	public void addMoney(int money) {
		this.actualMoney += money;
	}

	@Override
	public void payMoney(int money) {
		this.actualMoney -= money;
	}

	public boolean hasRessource(Ressource ressource) {
		for (TitreExploitation titre: this.mesTitres) {
			if (titre.getRessource().isEqual(ressource)) {
				return true;
			}
		}
		return false;
	}

}
