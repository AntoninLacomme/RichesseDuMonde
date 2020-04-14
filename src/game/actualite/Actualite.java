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
		description = "Splendides récoltes de blé. Recevez 7 millions si vous en possédez. Sinon, recevez 5 millions.";
		
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchWinRessource(playerAppelant, gameEnCours, Ressource.Ble, 7000000, 5000000);
			}		
		}));
		
		description = "A la suite d'encombrements sur l'autoroute, vous étiez en retard pour prendre votre avion.\nDans votre précipitation, vous avez égaré votre serviette contenant 3 millions. Payez à la banque.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.payToBanque(playerAppelant, gameEnCours, 3000000);
			}
		}));
		
		description = "Tension internationnale - stop - bon en  avant de la très fluctuante extraction des oxydes d'uranium - stop - Recevez 6 millions si vous en possédez. Sinon recevez 4 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchWinRessource(playerAppelant, gameEnCours, Ressource.Uranium, 6000000, 4000000);
			}
		}));
		
		description = "Vous héritez d'un oncle d'Amérique qui a découvert du pétrole dans son champs du Texas. Vous recevez 6 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.winMoney(playerAppelant, gameEnCours, 6000000);
			}
		}));
		
		description = "Un tremblement de terre détruit les chantiers navals d'OZAKA-KOBE et de YOKOHAMA.\nPayez 5 millions si vous possédez des constructions navales. Sinon, payez 3 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchLoseRessource(playerAppelant, gameEnCours, Ressource.ConstructionNavale, 5000000, 3000000);
			}
		}));
		
		description = "\"Extended Boom\" - stop - la BETHLEEM STEEL et la UNITED STEEL sont bénéficiaires - stop - Recevez 9 millions si vous possédez de l'acier. Sinon recevez 7 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchWinRessource(playerAppelant, gameEnCours, Ressource.Acier, 9000000, 7000000);
			}
		}));
		
		description = "Vous fêtez vos noces de diamant. Chaque joueur est un ami qui vous donne 1 million.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.allOthersPlayersPay(playerAppelant, gameEnCours, 1000000);
			}
		}));
		
		description = "Votre entreprise de plongée sous-marine découvre une galère antique contenant un important trésor. Cela vous rapporte 3 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.winMoney(playerAppelant, gameEnCours, 3000000);
			}
		}));
		
		description = "Grand succès de courses automobiles.\nVotre marque est toujours en tête. Recevez 6 millions si vous possédez des constructions automobiles. Sinon, recevez 4 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchWinRessource(playerAppelant, gameEnCours, Ressource.ConstructionAutomobile, 6000000, 4000000);
			}
		}));
		
		description = "Surproduction de café - stop - payez 4 millions si vous possédez du café, sinon payez 2 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchLoseRessource(playerAppelant, gameEnCours, Ressource.Cafe, 4000000, 2000000);
			}
		}));
		
		description = "Incidents au R.D.Congo - stop - les réserves de cuivre du KATANGA sont inexploitées - stop - Payez 6 millions si vous possédez du cuivre, sinon payez 4 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchLoseRessource(playerAppelant, gameEnCours, Ressource.Cuivre, 6000000, 4000000);
			}
		}));
		
		description = "Excellente réconte de caoutchouc naturel. Recevez 4 millions si vous possédez du caoutchouc, sinon recevez 2 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchWinRessource(playerAppelant, gameEnCours, Ressource.CaoutchoucNaturel, 4000000, 2000000);
			}
		}));
		
		description = "Votre dernier livre est couronné d'un prix littéraire. Le public se l'arrache. Vos droits d'auteur vous rapportent 4 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.winMoney(playerAppelant, gameEnCours, 4000000);
			}
		}));
		
		description = "Une de vos usines brûle. Vous étiez mal assuré. Vous devez payer 1 million pour la rééquiper.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.payToBanque(playerAppelant, gameEnCours, 1000000);
			}
		}));
		
		description = "Un violent cyclone fait rage dans le sud des Etats-Unis - stop - des champs de coton et de blé brûlent. Payez 5 millions si vous possédez du coton ou du blé, sinon payez 3 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.switchLoseRessource(playerAppelant, gameEnCours, new ArrayList<Ressource> () {{
					add(Ressource.CotonBrut);
					add(Ressource.Ble);
				}}, 4000000, 2000000);
			}
		}));
		
		description = "Afflux de capitaux en Europe - stop - l'or s'affaisse - stop - payez 7 millions si vous possédez de l'or, sinon payez 5 millions.";
		listActu.add(new Actualite (description, new EffectActualite () {
			@Override
			public void activateEffect(PlayerServer playerAppelant, Game gameEnCours) {
				this.payToBanqueIfHasRessource(playerAppelant, gameEnCours, Ressource.Fer, 7000000);
			}
		}));
		
		description = "Vous revendez vos terrains d'Afrique du Sud sur lesquels on a découvert un gisement d'uranium. Encaissez 5 millions.";
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
