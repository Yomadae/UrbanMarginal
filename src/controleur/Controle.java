package controleur;

import outils.connexion.AsyncResponse;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;
import vues.Arene;
import vues.ChoixJoueur;
import vues.EntreeJeu;

/**
 * Contrôleur et point d'entrée de l'applicaton 
 */
public class Controle implements AsyncResponse {

	/**
	 * N° du port d'écoute du serveur
	 */
	private static final int PORT = 6666;
	/**
	 * frame EntreeJeu
	 */
	private EntreeJeu frmEntreeJeu ;
	/**
	 * frame Arene
	 */
	private Arene frmArene;
	/**
	 * frame ChoixJoueur
	 */
	private ChoixJoueur frmChoixJoueur;
	/**
	 * type du jeu : client ou serveur
	 */
	private String typeJeu;

	/**
	 * Méthode de démarrage
	 * @param args non utilisé
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
	 * Demande provenant de la vue EntreeJeu
	 * @param info information à traiter
	 */
	public void evenementEntreeJeu(String info) {
		if(info.equals("serveur")) {
			this.typeJeu = "serveur";
			new ServeurSocket(this, PORT);
			this.frmEntreeJeu.dispose();
			this.frmArene = new Arene();
			this.frmArene.setVisible(true);
		} else {
			this.typeJeu = "client";
			new ClientSocket(this, info, PORT);
		}
	}
	
	/**
	 * Informations provenant de la vue ChoixJoueur
	 * @param pseudo le pseudo du joueur
	 * @param numPerso le numéro du personnage choisi par le joueur
	 */
	public void evenementChoixJoueur(String pseudo, int numPerso) {
		this.frmChoixJoueur.dispose();
		this.frmArene.setVisible(true);
	}

	@Override
	public void reception(Connection connection, String ordre, Object info) {
		switch(ordre) {
		case "connexion" :
			if(this.typeJeu.equals("client")) {
				this.frmEntreeJeu.dispose();
				this.frmArene = new Arene();
				this.frmChoixJoueur = new ChoixJoueur(this);
				this.frmChoixJoueur.setVisible(true);
			}
			break;
		case "reception" :
			break;
		case "deconnexion" :
			break;
		}
		
	}

}