package game.actualite;

import java.util.ArrayList;

import game.Game;
import game.ressources.Ressource;
import server.PlayerServer;

public class Actualite {

	private String description;
	private EffectActualite effect;

	public Actualite (String description, EffectActualite effect) {
		this.description = description;
		this.effect = effect;
	}

	public static ArrayList<Actualite> getAllActualite() {
		ArrayList<Actualite> listActu = new ArrayList<Actualite> ();
		
		String description;
		description = "Splendides r�coltes de bl�. Recevez 7 millions si vous en poss�dez. Sinon, recevez 5 millions.";
		
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchWinRessource(playerAppelant, gameEnCours, Ressource.Ble, 7000000, 5000000);
			}		
		}));
		
		description = "A la suite d'encombrements sur l'autoroute, vous �tiez en retard pour prendre votre avion.\nDans votre pr�cipitation, vous avez �gar� votre serviette contenant 3 millions. Payez � la banque.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.payToBanque(playerAppelant, gameEnCours, 3000000);
			}
		}));
		
		description = "Tension internationnale - stop - bon en  avant de la tr�s fluctuante extraction des oxydes d'uranium - stop - Recevez 6 millions si vous en poss�dez. Sinon recevez 4 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchWinRessource(playerAppelant, gameEnCours, Ressource.Uranium, 6000000, 4000000);
			}
		}));
		
		description = "Vous h�ritez d'un oncle d'Am�rique qui a d�couvert du p�trole dans son champs du Texas. Vous recevez 6 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.winMoney(playerAppelant, gameEnCours, 6000000);
			}
		}));
		
		description = "Un tremblement de terre d�truit les chantiers navals d'OZAKA-KOBE et de YOKOHAMA.\nPayez 5 millions si vous poss�dez des constructions navales. Sinon, payez 3 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchLoseRessource(playerAppelant, gameEnCours, Ressource.ConstructionNavale, 5000000, 3000000);
			}
		}));
		
		description = "\"Extended Boom\" - stop - la BETHLEEM STEEL et la UNITED STEEL sont b�n�ficiaires - stop - Recevez 9 millions si vous poss�dez de l'acier. Sinon recevez 7 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchWinRessource(playerAppelant, gameEnCours, Ressource.Acier, 9000000, 7000000);
			}
		}));
		
		description = "Vous f�tez vos noces de diamant. Chaque joueur est un ami qui vous donne 1 million.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.allOthersPlayersPay(playerAppelant, gameEnCours, 1000000);
			}
		}));
		
		description = "Votre entreprise de plong�e sous-marine d�couvre une gal�re antique contenant un important tr�sor. Cela vous rapporte 3 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.winMoney(playerAppelant, gameEnCours, 3000000);
			}
		}));
		
		description = "Grand succ�s de courses automobiles.\nVotre marque est toujours en t�te. Recevez 6 millions si vous poss�dez des constructions automobiles. Sinon, recevez 4 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchWinRessource(playerAppelant, gameEnCours, Ressource.ConstructionAutomobile, 6000000, 4000000);
			}
		}));
		
		description = "Surproduction de caf� - stop - payez 4 millions si vous poss�dez du caf�, sinon payez 2 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchLoseRessource(playerAppelant, gameEnCours, Ressource.Cafe, 4000000, 2000000);
			}
		}));
		
		description = "Incidents au R.D.Congo - stop - les r�serves de cuivre du KATANGA sont inexploit�es - stop - Payez 6 millions si vous poss�dez du cuivre, sinon payez 4 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchLoseRessource(playerAppelant, gameEnCours, Ressource.Cuivre, 6000000, 4000000);
			}
		}));
		
		description = "Excellente r�conte de caoutchouc naturel. Recevez 4 millions si vous poss�dez du caoutchouc, sinon recevez 2 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchWinRessource(playerAppelant, gameEnCours, Ressource.CaoutchoucNaturel, 4000000, 2000000);
			}
		}));
		
		description = "Votre dernier livre est couronn� d'un prix litt�raire. Le public se l'arrache. Vos droits d'auteur vous rapportent 4 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.winMoney(playerAppelant, gameEnCours, 4000000);
			}
		}));
		
		description = "Une de vos usines br�le. Vous �tiez mal assur�. Vous devez payer 1 million pour la r��quiper.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.payToBanque(playerAppelant, gameEnCours, 1000000);
			}
		}));
		
		description = "Un violent cyclone fait rage dans le sud des Etats-Unis - stop - des champs de coton et de bl� br�lent. Payez 5 millions si vous poss�dez du coton ou du bl�, sinon payez 3 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchLoseRessource(playerAppelant, gameEnCours, new ArrayList<Ressource> () {{
					add(Ressource.CotonBrut);
					add(Ressource.Ble);
				}}, 4000000, 2000000);
			}
		}));
		
		description = "Afflux de capitaux en Europe - stop - l'or s'affaisse - stop - payez 7 millions si vous poss�dez de l'or, sinon payez 5 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.payToBanqueIfHasRessource(playerAppelant, gameEnCours, Ressource.Fer, 7000000);
			}
		}));
		
		description = "Vous revendez vos terrains d'Afrique du Sud sur lesquels on a d�couvert un gisement d'uranium. Encaissez 5 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.winMoney(playerAppelant, gameEnCours, 5000000);
			}
		}));
		
		
		
		return listActu;
	}

	public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
		effect.activateEffect(playerAppelant, gameEnCours);
	}

	public String getDescription() {
		return this.description;
	}
}
