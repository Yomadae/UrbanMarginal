package vues;

import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Arene extends JFrame {

	/**
	 * général
	 */
	private JPanel contentPane;
	/**
	 * saisie chat
	 */
	private JTextField txtChat;
	/**
	 * affichage chat
	 */
	private JTextArea txtAreaChat ;

	/**
	 * Create the frame.
	 */
	public Arene() {
		// Dimension selon contenu
		this.getContentPane().setPreferredSize(new Dimension(800, 600 + 25 + 140));
	    this.pack();
	    // interdiction de modifier la taille
		this.setResizable(false);
		
		setTitle("Arena");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		txtChat = new JTextField();
		txtChat.setBounds(0, 600, 800, 25);
		contentPane.add(txtChat);
		txtChat.setColumns(10);
		
		JScrollPane jspChat = new JScrollPane();
		jspChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspChat.setBounds(0, 625, 800, 140);
		contentPane.add(jspChat);
		
		txtAreaChat = new JTextArea();
		jspChat.setViewportView(txtAreaChat);		
		
		JLabel lblFond = new JLabel("");
		lblFond.setIcon(new ImageIcon("C:\\projet\\UrbanMarginal\\medias\\fond\\fondarene.jpg"));
		//String chemin = "fonds/fondarene.jpg";
		//URL resource = getClass().getClassLoader().getResource(chemin);
		//lblFond.setIcon(new ImageIcon(Arene.class.getResource("/fond/fondarene.jpg")));		
		lblFond.setBounds(0, 0, 800, 600);
		contentPane.add(lblFond);
		
	}
}