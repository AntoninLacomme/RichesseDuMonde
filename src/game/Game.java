package game;

import java.util.ArrayList;

import game.actualite.Actualite;
import server.MainServerUDP;
import server.Player;

public class Game implements Runnable {
	private MainServerUDP main;
	private boolean runGame = true;

	private Banque banque;
	private Plateau plateau;
	
	public Game (MainServerUDP main) {
		this.main = main;
		this.banque = new Banque ();
		this.plateau = new Plateau ();
		
		
		// System.out.println(this.plateau.toString());
		
		for (Actualite a: this.plateau.getAllActualite ()) {
			System.out.println(a.getDescription () + "\n");
		}
	}	
	
	public Banque getBanque() {
		return this.banque;
	}
	
	@Override
	public void run() {
		while (runGame) {
			// todo
		}
	}
	
	public void shutdown () {
		runGame = false;
	}

	public ArrayList<Player> getAllPlayers() {
		return main.getAllPlayers();
	}

	public Plateau getPlateau () {
		return this.plateau;
	}
	
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

}
