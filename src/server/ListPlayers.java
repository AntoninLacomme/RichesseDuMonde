package server;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Semaphore;

public class ListPlayers {
	private final Semaphore semaphore;
	private List<Player> mesPlayers;
	
	public ListPlayers () {
		this.mesPlayers = Collections.synchronizedList(new ArrayList());
		semaphore = new Semaphore (1);
	}
	
	public boolean add (Player p) throws InterruptedException {
		boolean added = false;
		semaphore.acquire();
		try {
			added = mesPlayers.add(p);
			semaphore.release();
			return added;
		} finally {
			return added;
		}
	}
	
	public boolean remove(Player p) throws InterruptedException {
		semaphore.acquire();
		boolean wasRemoved = mesPlayers.remove(p);
		semaphore.release();
		return wasRemoved;
	}
	
	public ArrayList<Player> getPlayers () throws InterruptedException {
		ArrayList<Player> players = new ArrayList<Player> ();
		semaphore.acquire();
		for (int i=0; i<mesPlayers.size(); i++) {
			players.add(mesPlayers.get(i));
		}
		semaphore.release();
		return players;
	}
}
