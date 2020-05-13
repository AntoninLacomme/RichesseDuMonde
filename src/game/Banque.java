package game;

import server.Player;

public class Banque implements ReserveArgent {
	
	private int actualMoney;

	public Banque () {
		this.actualMoney = 10000000;
	}
	
	

	public void payToPlayer(Player player, int money) {
		player.addMoney (money);
		this.payMoney (money);
	}
	
	public void playerPayToBank(Player player, int money) {
		player.payMoney(money);
		this.addMoney(money);
	}
	
	public void payPlayerFromPlayer(Player playerReceveur, Player playerPayeur, int money) {
		playerPayeur.payMoney(money);
		playerReceveur.addMoney(money);
	}



	@Override
	public void addMoney(int money) {
		this.actualMoney += money;
	}

	@Override
	public void payMoney(int money) {
		this.actualMoney -= money;
	}

	
}
