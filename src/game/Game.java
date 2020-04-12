package game;

import java.util.ArrayList;

public class Game {

	private Banque banque;
	
	public Game () {
		this.banque = new Banque ();
	}
	
	
	
	public Banque getBanque() {
		return this.banque;
	}

	public ArrayList<PlayerServer> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}



	public void payPlayerFromPlayer(PlayerServer playerReceveur, PlayerServer playerPayeur, int money) {
		playerPayeur.payMoney(money);
		playerReceveur.addMoney(money);
	}

}
