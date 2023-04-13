package Modele;
import java.util.ArrayList;
import java.util.Hashtable;

import Controleur.Controle;
import Controleur.Global;
import outils.connexion.Connection;

/**
 * Gestion du jeu c�t� serveur
 *
 */
public class JeuServeur extends Jeu implements Global{

	/**
	 * Collection de murs
	 */
	private ArrayList<Mur> lesMurs = new ArrayList<Mur>() ;
	/**
	 * Collection de joueurs
	 */
	private Hashtable<Connection, Joueur> lesJoueurs = new Hashtable<Connection, Joueur>() ;
	
	/**
	 * Constructeur
	 */
	public JeuServeur(Controle controle) {
		super.controle = controle;
	}
	
	@Override
	public void connexion(Connection connection) {
		this.lesJoueurs.put(connection, new Joueur());
	}

	@Override
	public void reception(Connection connection, Object info) {
		String[] infos = ((String)info).split(SEPARATEUR);
		String message = infos[0];
		switch(message) {
		case PSEUDO:
			controle.evenementJeuServeur(AjoutPanelMur, connection);
			String pseudo = infos[1];
			int numPerso = Integer.parseInt(infos[2]);
			this.lesJoueurs.get(connection).initPerso(pseudo, numPerso);
			break;
		}
	}
	
	@Override
	public void deconnexion() {
	}

	/**
	 * Envoi d'une information vers tous les clients
	 * fais appel plusieurs fois � l'envoi de la classe Jeu
	 */
	public void envoi() {
	}

	/**
	 * G�n�ration des murs
	 */
	public void constructionMurs() {
		for(int i = 0; i < nbMur; i++) {
			this.lesMurs.add(new Mur());
			this.controle.evenementJeuServeur(AjoutMur, lesMurs.get(lesMurs.size()-1).getJlabel());
		}
	}
	
}
