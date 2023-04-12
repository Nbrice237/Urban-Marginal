package Vue;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.Controle;
import Controleur.Global;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChoixJoueur extends JFrame implements Global{

	private JPanel contentPane;

	/**
	 * zone de saisie du pseudo
	 */
	private JTextField txtPseudo;
	/**
	 * zone d'affichage des personnages
	 */
	private JLabel lblPersonnage;

	/**
	 * propriété controle de type Controle
	 */
	private Controle controle;

	
	/**
	 * numero du personnage selectionner
	 */
	private int nbPerso;

	/**
	 * Clic sur la fleche "precedent" pour afficher le personnage precedent
	 */
	private void lblPrecedent_clic() {
		nbPerso = ((nbPerso + 1) % num_perso) + 1;
		affichePerso();
	}

	/**
	 * Clic sur la fl�che "suivant" pour afficher le personnage suivant
	 */
	private void lblSuivant_clic() {
		nbPerso = (nbPerso % num_perso) + 1;
		affichePerso();
	}

	/**
	 * Clic sur GO pour envoyer les informations
	 */
	private void lblGo_clic() {
		if(this.txtPseudo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "La saisie du pseudo est obligatoire");
            this.txtPseudo.requestFocus();
		}
		else {
			this.controle.evenementChoixJoueur(this.txtPseudo.getText(), nbPerso);
		}
	}

	/**
	 * methode d'affichage les personnage
	 */
	private void affichePerso() {
		String nomFichier = "personnages//perso" + this.nbPerso + MARCHE +NB_ETAT_PERSONNAGE+"d"+DIRECTION+ EXTENSION;
		URL ressource = getClass().getClassLoader().getResource(nomFichier);
		lblPersonnage.setIcon(new ImageIcon(ressource));

	}
	/**
	 * change le curceur de la souris en normal
	 */
	private void sourisNormale() {
		contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	/**
	 *  Change le curseur de la souris en forme de doigt pointe
	 */
	private void sourisDoigt() {
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Create the frame.
	 */
	public ChoixJoueur(	Controle controle) {

		// Dimension de la frame en fonction de son contenu
		this.getContentPane().setPreferredSize(new Dimension(500, 300));
		this.pack();
		// interdiction de changer la taille
		this.setResizable(false);

		setTitle("Choix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 472, 355);
		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPersonnage = new JLabel("");
		lblPersonnage.setBounds(185, 168, 73, 61);
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPersonnage);

		JLabel lblChoixJoueur = new JLabel("");
		String chemin = "fonds\\fondchoix.jpg";
		URL ressource = getClass().getClassLoader().getResource(chemin);
		lblChoixJoueur.setIcon(new ImageIcon(ressource));
		lblChoixJoueur.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChoixJoueur.setBounds(20, 11, 414, 288);
		contentPane.add(lblChoixJoueur);

		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPrecedent_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		lblPrecedent.setBounds(84, 159, 31, 50);
		contentPane.add(lblPrecedent);

		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		lblSuivant.setBounds(320, 159, 23, 50);
		contentPane.add(lblSuivant);

		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		lblGo.setBounds(330, 215, 63, 61);
		contentPane.add(lblGo);

		txtPseudo = new JTextField();
		txtPseudo.setBounds(162, 265, 119, 20);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);

		/**
		 * valorisons la propriété
		 */
		this.controle = controle;

		this.nbPerso = 1;
		this.affichePerso();
		/**
		 * // positionnement sur la zone de saisie
		 */
		txtPseudo.requestFocus();
	}

}
