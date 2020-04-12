package game;

import java.util.ArrayList;

import game.ressources.Ressource;
import game.ressources.TitreExploitation;
import server.ClientProcessor;

public class PlayerServer implements ReserveArgent {
	private String name;
	private int actualMoney;
	private ArrayList<TitreExploitation> mesTitres;
	private ClientProcessor dialogClient;
	
	public PlayerServer (ClientProcessor dialogClient, String name) {
		this.dialogClient = dialogClient;
		
		this.name = name;
		this.actualMoney = 0;
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

	public String getName() {
		return this.name;
	}

	public String getNameClient(Thread threadToSleeping) {
		this.dialogClient.askName (threadToSleeping);
		return "";
	}

}
