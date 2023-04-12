/**
 * 
 */
package Controleur;

/**
 * @author pc
 *
 */
public interface Global {

	/**
	 * vie de d�part pour tous les joueurs
	 */
	static final int MAXVIE = 10;
	/**
	 * gain de points de vie lors d'une attaque
	 */
	static final int GAIN = 1;
	/**
	 * perte de points de vie lors d'une attaque
	 */
	static final int PERTE = 2;
	/**
	 * cas d'un pseudo
	 */
	String PSEUDO = "pseudo";

	/**
	 * string de separation
	 */
	String SEPARATEUR = "~";
	/**
	 * ip adresse
	 */
	static final int port = 6666;
	/**
	 * type de jeu serveur
	 */
	String SERVEUR = "serveur";
	/**
	 * cas d'une connexion
	 */
	String CONNEXION = "connexion";
	/**
	 * cas d'une réception
	 */
	String RECEPTION = "réception";
	/**
	 * cas d'une déconnexion
	 */
	String DECONNEXION = "déconnexion";
	/**
	 * numbre de personnage
	 */
	int num_perso = 3;

	/**
	 * Etat du personnage
	 */
	String MARCHE = "marche";

	/**
	 * numero étape d'état du personnage
	 */
	int NB_ETAT_PERSONNAGE = 1;
	/**
	 * direction du personnage
	 */
	int DIRECTION = 1;

	/**
	 * extension de l'image des personnages
	 */
	String EXTENSION = ".gif";
}
