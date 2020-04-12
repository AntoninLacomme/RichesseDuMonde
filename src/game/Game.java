package game;

import java.util.ArrayList;

import game.actualite.Actualite;

public class Game {

	private Banque banque;
	private Plateau plateau;
	
	public Game () {
		this.banque = new Banque ();
		this.plateau = new Plateau ();
		
		
		System.out.println(this.plateau.toString());
		
		for (Actualite a: this.plateau.getAllActualite ()) {
			System.out.println(a.getDescription () + "\n");
		}
	}
	
	
	
	public Banque getBanque() {
		return this.banque;
	}

	public ArrayList<PlayerServer> getAllPlayers() {
		return null;
	}

}
