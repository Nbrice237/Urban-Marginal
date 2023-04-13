package Modele;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controleur.Global;

/**
 * Gestion des murs
 *
 */
public class Mur extends Objet implements Global{

	/**
	 * Constructeur
	 */
	public Mur() {
		/**
		 * calcule position aleatoire du mur
		 */
		int posX = (int)Math.round(Math.random() * (largeurArene - largeurMur));
		int posY = (int)Math.round(Math.random() * (hauteurArene - hauteurMur));
		/**
		 * creation du jlabel pour ce mur
		 */
		jlabel = new JLabel();
		/**
		 * caracteristiques du mur et insertion de l'image
		 */
		jlabel.setBounds(posX, posY, largeurMur, hauteurMur);
		String chemin = MURS;
		URL ressource = getClass().getClassLoader().getResource(chemin);
		jlabel.setIcon(new ImageIcon(ressource));
	}
	
}
