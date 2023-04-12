/**
 * 
 */
package Controleur;

import Vue.EntreeJeu;

/**
 * Contr�leur et point d'entr�e de l'applicaton 
 * @author makebel noel brice
 *
 */
public class Controle {
	
	private EntreeJeu frmEntreeJeu ;

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
		this.frmEntreeJeu = new EntreeJeu() ;
		this.frmEntreeJeu.setVisible(true);
	}

}
