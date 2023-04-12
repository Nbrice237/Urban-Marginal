package Vue;

import java.awt.EventQueue;
import Controleur.Controle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;
import java.awt.event.ActionEvent;

public class EntreeJeu extends JFrame {

	private JPanel contentPane;
	/**
	 * saisie de l'ip adresse serveur
	 */
	private JTextField txtServer;
	
	/**
	 * propriété controle de type Controle
	 */
	private Controle controle;

	/**
	 * clic sur le bouton ferme l'application
	 */
	private void BtnExit() {
		System.exit(0);
	}

	/**
	 * Le clic sur le bouton ouvre la fenêtre "Arene".
	 */
	private void BtnStart() {
		/**Arene arene = new Arene();
		arene.setVisible(true);
		this.dispose();*/
		
		this.controle.evenementEntreeJeu("serveur");
	}

	/**
	 * Le clic sur le bouton ouvre la fenêtre "ChoixJoueur".
	 */
	private void BtnConnect() {
		/**ChoixJoueur choix = new ChoixJoueur();
		choix.setVisible(true);
		this.dispose();*/
		this.controle.evenementEntreeJeu(this.txtServer.getText());
	}

	/**
	 * Create the frame.
	 */
	public EntreeJeu(Controle controle) {
		setResizable(false);
		setTitle("Urban Marginal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 280);
		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblStart = new JLabel("Start a server :");
		lblStart.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblStart.setBounds(24, 31, 186, 36);
		contentPane.add(lblStart);

		JLabel lblConnect = new JLabel("Connect an existing server :");
		lblConnect.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblConnect.setBounds(23, 84, 299, 44);
		contentPane.add(lblConnect);

		JLabel lblIPserver = new JLabel("IP server :");
		lblIPserver.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblIPserver.setBounds(24, 149, 147, 36);
		contentPane.add(lblIPserver);

		JButton btnStart = new JButton("Start\r\n");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnStart();
			}
		});
		btnStart.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnStart.setBounds(323, 34, 147, 36);
		contentPane.add(btnStart);

		JButton btnExit = new JButton("Exit\r\n");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnExit();
			}
		});
		btnExit.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnExit.setBounds(323, 205, 147, 34);
		contentPane.add(btnExit);

		txtServer = new JTextField();
		txtServer.setFont(new Font("Arial Black", Font.BOLD, 18));
		txtServer.setText("127.0.0.1");
		txtServer.setBounds(141, 144, 168, 36);
		contentPane.add(txtServer);
		txtServer.setColumns(10);

		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnConnect();
			}
		});
		btnConnect.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnConnect.setBounds(323, 141, 147, 36);
		contentPane.add(btnConnect);
		
		/**
		 * valorisons la propriété
		 */
		this.controle = controle;
	}
}
