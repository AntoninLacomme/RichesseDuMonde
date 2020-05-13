package game.actualite;

import java.util.ArrayList;

import game.Game;
import game.ressources.Ressource;
import server.Player;

abstract public class EffectActualite implements ActivationEffect {
	
	public void payToBanque (Player playerAppelant, Game gameEnCours, int money) {
		gameEnCours.getBanque().playerPayToBank(playerAppelant, money);
	}
	
	public void payToBanqueIfHasRessource (Player playerAppelant, Game gameEnCours, Ressource ressource, int money) {
		if (playerAppelant.hasRessource(ressource)) {
			gameEnCours.getBanque().playerPayToBank(playerAppelant, money);
		}
	}
	
	public void winMoney (Player playerAppelant, Game gameEnCours, int money) {
		gameEnCours.getBanque().payToPlayer(playerAppelant, money);
	}
	
	public void switchWinRessource (Player playerAppelant, Game gameEnCours, Ressource ressource, int moneyWithin, int moneyWithout) {
		if (playerAppelant.hasRessource(ressource)) {
			gameEnCours.getBanque().payToPlayer(playerAppelant, moneyWithin);
		}
		else {
			gameEnCours.getBanque().payToPlayer(playerAppelant, moneyWithout);
		}
	}
	
	public void switchWinRessource (Player playerAppelant, Game gameEnCours, ArrayList<Ressource> ressource, int moneyWithin, int moneyWithout) {
		boolean hasR = false;
		for (Ressource r: ressource) {
			if (!hasR) {
				hasR = playerAppelant.hasRessource(r);
			}
		}
		
		if (hasR) {		
			gameEnCours.getBanque().payToPlayer(playerAppelant, moneyWithin);
		}
		else {
			gameEnCours.getBanque().payToPlayer(playerAppelant, moneyWithout);
		}
	}
	
	public void switchLoseRessource (Player playerAppelant, Game gameEnCours, Ressource ressource, int moneyWithin, int moneyWithout) {
		if (playerAppelant.hasRessource(ressource)) {
			gameEnCours.getBanque().playerPayToBank(playerAppelant, moneyWithin);
		}
		else {
			gameEnCours.getBanque().playerPayToBank(playerAppelant, moneyWithout);
		}
	}
	
	public void switchLoseRessource (Player playerAppelant, Game gameEnCours, ArrayList<Ressource> ressource, int moneyWithin, int moneyWithout) {
		boolean hasR = false;
		for (Ressource r: ressource) {
			if (!hasR) {
				hasR = playerAppelant.hasRessource(r);
			}
		}
		
		if (hasR) {		
			gameEnCours.getBanque().playerPayToBank(playerAppelant, moneyWithin);
		}
		else {
			gameEnCours.getBanque().playerPayToBank(playerAppelant, moneyWithout);
		}
	}
	
	public void allOthersPlayersPay (Player playerAppelant, Game gameEnCours, int money) {
		for (Player p: gameEnCours.getAllPlayers ()) {
			if (!p.equals(playerAppelant)) {
				gameEnCours.getBanque().payPlayerFromPlayer (playerAppelant, p, money);
			}
		}
	}
}
