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

/**
 * Contr�leur et point d'entr�e de l'applicaton 
 * @author makebel noel brice
 *
 */
public class Controle implements AsyncResponse{
	
	private EntreeJeu frmEntreeJeu ;
	private Arene frmArene;
	private ChoixJoueur frmChoixJoueur;
	private String typeJeu;

	/**
	 *  Methode de demarrage
	 * @param args non utilise
	 */
	public static void main(String[] args) {
		
       new Controle();
	}
	
	/**
	 * Constructeur
	 */
	private Controle() {
		this.frmEntreeJeu = new EntreeJeu(this) ;
		this.frmEntreeJeu.setVisible(true);
	}
	
	/**
	 * 
	 */
	public void evenementEntreeJeu(String info) {
		if(info.equals("serveur")) {
			this.typeJeu = "serveur";
			new ServeurSocket(this, 6666);
			this.frmEntreeJeu.dispose();
			this.frmArene = new Arene();
			this.frmArene.setVisible(true);
			
		}
		else {
			this.typeJeu = "client";
			new ClientSocket(this, info, 6666);
		}
	}

	@Override
	public void reception(Connection connection, String ordre, Object info) {
		switch(ordre) {
		case "connexion":
			if(this.typeJeu.equals("client")) {
				this.frmEntreeJeu.dispose();
				this.frmArene = new Arene();
				this.frmChoixJoueur = new ChoixJoueur();
				this.frmChoixJoueur.setVisible(true);
			}
			break;
		case "réception":
			break;
		case "déconnexion":
			break;
		}
		
	}

}
