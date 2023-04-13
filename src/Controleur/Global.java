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
	/**
	 * taille de la zonne de combat arene
	 */
	int largeurArene = 800;
	int hauteurArene = 600;

	/**
	 * taille zone de combat du murs
	 */
	int largeurMur = 40;
	int hauteurMur = 35;
	/**
	 * chemin de l'image des murs
	 */
	String MURS = "murs//mur" + EXTENSION;
	/**
	 * nombre de mur dans l'arene
	 */
	int nbMur = 20;
	/**
	 * permet de controler l'ajout des murs dans l'arene
	 */
	String AjoutMur = "ajout mur";
	/**
	 * permet d'ajouter les murs dans l'arene cote client
	 */
	String AjoutPanelMur = "ajout panel murs";
	/**
	 * chemin du fond de l'arene
	 */
	String CheminArene = "fonds\\fondarene.jpg";
}
