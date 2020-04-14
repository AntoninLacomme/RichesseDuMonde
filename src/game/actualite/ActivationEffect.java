package game.actualite;

import game.Game;
import server.PlayerServer;

public interface ActivationEffect {
	public void activateEffect (PlayerServer playerAppelant, Game gameEnCours);
}
