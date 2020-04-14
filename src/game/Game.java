package game;

import java.util.ArrayList;

import game.actualite.Actualite;
import server.ClientProcessor;
import server.PlayerServer;

import java.util.concurrent.Semaphore;

public class Game {

	private Banque banque;
	private Plateau plateau;
	private ArrayList<PlayerServer> listPlayers;
	private Semaphore mySem;
	
	public Game (Semaphore sem) {
		this.mySem = sem;
		
		this.banque = new Banque ();
		this.plateau = new Plateau ();
		this.listPlayers = new ArrayList<PlayerServer> ();
		
		
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
	
	public boolean linkNewPlayer (ClientProcessor clientProcess, String name) throws InterruptedException {
		mySem.acquire();
		this.listPlayers.add (new PlayerServer (clientProcess, name));
		
		System.out.println("Liste des joueurs actuellements connectés :");
		int acc = 0;
		for (PlayerServer p: this.listPlayers) {
			acc++;
			System.out.println("Joueur " + acc + " :\t" + p.getName ());
		}
		
		String tmp = this.listPlayers.get(this.listPlayers.size() - 1).getNameClient (Thread.currentThread());
		System.out.println("Le nom du client est : " + tmp);
		mySem.release();
		return true;
	}

}
