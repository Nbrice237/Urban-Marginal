/**
 * 
 */
package Controleur;

import Vue.EntreeJeu;
import Vue.Arene;
import Vue.ChoixJoueur;
import outils.connexion.ServeurSocket;
import outils.connexion.AsyncResponse;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import Modele.Jeu;
import Modele.JeuClient;
import Modele.JeuServeur;

/**
 * Contr�leur et point d'entr�e de l'applicaton
 * 
 * @author makebel noel brice
 *
 */
public class Controle implements AsyncResponse, Global {
	/**
	 * forme Entree de jeu
	 */
	private EntreeJeu frmEntreeJeu;
	/**
	 * forme Arene
	 */
	private Arene frmArene;
	/**
	 * forme choix Joueur
	 */
	private ChoixJoueur frmChoixJoueur;

	/**
	 * type de jeu
	 */
	private Jeu lejeu;

	/**
	 * Methode de demarrage
	 * 
	 * @param args non utilise
	 */
	public static void main(String[] args) {

		new Controle();
	}

	/**
	 * Constructeur
	 */
	private Controle() {
		this.frmEntreeJeu = new EntreeJeu(this);
		this.frmEntreeJeu.setVisible(true);
	}

	/**
	 * demarrage du serveur et client
	 */
	public void evenementEntreeJeu(String info) {
		if (info.equals(SERVEUR)) {
			new ServeurSocket(this, port);
			this.lejeu = new JeuServeur(this);
			this.frmEntreeJeu.dispose();
			this.frmArene = new Arene();
			this.frmArene.setVisible(true);

		} else {
			new ClientSocket(this, info, port);
		}
	}

	/**
	 * 
	 */
	public void evenementChoixJoueur(String pseudo, int numPerso) {
		this.frmChoixJoueur.dispose();
		this.frmArene.setVisible(true);
		((JeuClient) this.lejeu).envoi(PSEUDO + SEPARATEUR + pseudo + SEPARATEUR + numPerso);
	}

	/**
	 * 
	 */
	public void envoi(Connection connection, Object info) {
		connection.envoi(info);
	}

	@Override
	public void reception(Connection connection, String ordre, Object info) {
		switch (ordre) {
		case CONNEXION:
			if (!(this.lejeu instanceof JeuServeur)) {
				this.lejeu = new JeuClient(this);
				this.lejeu.connexion(connection);
				this.frmEntreeJeu.dispose();
				this.frmArene = new Arene();
				this.frmChoixJoueur = new ChoixJoueur(this);
				this.frmChoixJoueur.setVisible(true);
			} else {
				this.lejeu.connexion(connection);
			}
			break;

		case RECEPTION:
			this.lejeu.reception(connection, info);
			break;

		case DECONNEXION:
			break;
		}

	}

}
