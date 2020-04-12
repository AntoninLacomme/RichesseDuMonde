package game;

public class Banque implements ReserveArgent {
	
	private int actualMoney;

	public Banque () {
		this.actualMoney = 10000000;
	}
	
	

	public void payToPlayer(PlayerServer player, int money) {
		player.addMoney (money);
		this.payMoney (money);
	}
	
	public void playerPayToBank(PlayerServer player, int money) {
		player.payMoney(money);
		this.addMoney(money);
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
