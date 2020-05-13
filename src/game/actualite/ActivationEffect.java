package game.actualite;

import game.Game;
import server.Player;

public interface ActivationEffect {
	public void activateEffect (Player playerAppelant, Game gameEnCours);
}
