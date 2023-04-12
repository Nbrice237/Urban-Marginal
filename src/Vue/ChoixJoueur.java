package Vue;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JTextField;

public class ChoixJoueur extends JFrame {

	private JPanel contentPane;
	private JTextField txtPseudo;

	/**
	 * Clic sur la fleche "precedent" pour afficher le personnage precedent
	 */
	private void lblPrecedent_clic() {
		System.out.println("precedent");
	}

	/**
	 * Clic sur la fl�che "suivant" pour afficher le personnage suivant
	 */
	private void lblSuivant_clic() {
		System.out.println("suivant");
	}

	/**
	 * Clic sur GO pour envoyer les informations
	 */
	private void lblGo_clic() {
		(new Arene()).setVisible(true);
		this.dispose();
	}

	/**
	 * Create the frame.
	 */
	public ChoixJoueur() {
		// Dimension de la frame en fonction de son contenu
		this.getContentPane().setPreferredSize(new Dimension(500, 300));
		this.pack();
		// interdiction de changer la taille
		this.setResizable(false);
		
		setTitle("Choix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 472, 355);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		});
		lblPrecedent.setBounds(84, 159, 31, 50);
		contentPane.add(lblPrecedent);

		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
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
		});
		lblGo.setBounds(330, 215, 63, 61);
		contentPane.add(lblGo);

		txtPseudo = new JTextField();
		txtPseudo.setBounds(162, 265, 119, 20);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
	}

}
