package game.actualite;

import game.Game;
import game.PlayerServer;

public interface ActivationEffect {
	public void activateEffect (PlayerServer playerAppelant, Game gameEnCours);
}
