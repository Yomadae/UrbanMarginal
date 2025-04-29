package controleur;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
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
public class Controle implements AsyncResponse,Global {

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
	 * déclaration jeu
	 */
	private Jeu leJeu;
	public Jeu getLeJeu() {
	    return this.leJeu;
	}
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
	 * Demande de la vue EntreeJeu
	 * @param info information à traiter
	 */
	public void evenementEntreeJeu(String info) {
		if(info.equals("serveur")) {			
			new ServeurSocket(this, PORT);
			this.leJeu = new JeuServeur(this);			
			this.frmEntreeJeu.dispose();
			this.frmArene = new Arene();
			this.frmArene.setVisible(true);
		} else {
			new ClientSocket(this, info, PORT);
		}
	}	
	/**
	 * Informations de la vue ChoixJoueur
	 * @param pseudo le pseudo du joueur
	 * @param numPerso le numéro du personnage choisi par le joueur
	 * @param connection 
	 */
	public void evenementChoixJoueur(String pseudo, int numPerso, Connection connection) {
		this.frmChoixJoueur.dispose();
		this.frmArene.setVisible(true);
	    ((JeuClient)this.leJeu).envoi(connection, PSEUDO+STRINGSEPARE+pseudo+STRINGSEPARE+numPerso);
	}
	/**
	 * Envoi d'informations vers l'ordinateur distant
 	 * @param connection connexion pour envoi vers l'ordinateur distant
 	 * @param info information à envoyer
 	 */
 	public void envoi(Connection connection, Object info) {
 		connection.envoi(info);
 	}

	@Override
	public void reception(Connection connection, String ordre, Object info) {
		switch(ordre) {
		case CONNEXION :
			if(!(this.leJeu instanceof JeuServeur)) {
 				this.leJeu = new JeuClient(this);
				this.leJeu.connexion(connection);
				this.frmEntreeJeu.dispose();
				this.frmArene = new Arene();
				this.frmChoixJoueur = new ChoixJoueur(this);
				this.frmChoixJoueur.setVisible(true);
			} else {
				this.leJeu.connexion(connection);
			}
			break;
		case RECEPTION :
				this.leJeu.reception(connection, info);
			break;
		case DECONNEXION :
			break;
		}
		
	}
}