package Vue;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.Global;

import javax.swing.JLabel;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Arene extends JFrame implements Global{

	/**
	 * Panel general
	 */
	private JPanel contentPane;
	/**
	 * Zone de saisie du tchat
	 */
	private JTextField txtSaisie;
	/**
	 * Zone d'affichage du t'chat
	 */
	private JTextArea txtChat;
	/**
	 * zone de l'image de l'arene
	 */
	private JLabel lblFond;
	/**
	 * panel des murs
	 */
	private JPanel jpnMurs;
	/**
	 * @return the jpnMurs
	 */
	public JPanel getJpnMurs() {
		return jpnMurs;
	}

	/**
	 * @param jpnMurs the jpnMurs to set
	 */
	public void setJpnMurs(JPanel jpnMurs) {
		this.jpnMurs.add(jpnMurs);
		this.jpnMurs.repaint();
	}

	/**
	 * permet d'ajouter les murs dans l'arene
	 */
	public void ajoutMurs(Object unMur) {
		this.jpnMurs.add((JLabel)unMur);
		this.jpnMurs.repaint();
		
	}

	/**
	 * Create the frame.
	 */
	public Arene() {
		// Dimension de la frame en fonction de son contenu
		this.getContentPane().setPreferredSize(new Dimension(largeurArene, hauteurArene + 25 + 140));
		this.pack();
		// interdiction de changer la taille
		this.setResizable(false);

		setTitle("Arene");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 515, 519);
		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
         
		jpnMurs = new JPanel();
		jpnMurs.setBounds(0, 0, largeurArene, hauteurArene);
		jpnMurs.setOpaque(false);
		jpnMurs.setLayout(null);		
		contentPane.add(jpnMurs);
		
		txtSaisie = new JTextField();
		txtSaisie.setBounds(0, 600, 800, 25);
		contentPane.add(txtSaisie);
		txtSaisie.setColumns(10);

		JScrollPane jspChat = new JScrollPane();
		jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspChat.setBounds(0, 625, 800, 140);
		contentPane.add(jspChat);

		txtChat = new JTextArea();
		jspChat.setViewportView(txtChat);

		lblFond = new JLabel("");
		String chemin = CheminArene;
		URL ressource = getClass().getClassLoader().getResource(chemin);
		lblFond.setIcon(new ImageIcon(ressource));
		lblFond.setBounds(0, 0, 800, 600);
		contentPane.add(lblFond);

	}
}
