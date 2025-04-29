package modele;

import controleur.Controle;
import outils.connexion.Connection;

/**
 * Gestion du jeu côté client
 *
 */
public class JeuClient extends Jeu {
	/**
	 * communication avec le serveur
	 */
	private Connection connection;
	public Connection getConnection() {
	    return this.connection; // Renvoie la connexion stockée
	}
	/**
	 * Controler
	 * * @param controle pour contrôler les échanges
	 */
	public JeuClient(Controle controle) {
		super.controle = controle;
	}
	/**
	 * connexion
	 */
	@Override
	public void connexion(Connection connection) {
		this.connection = connection;
	}
	/**
	 * reception
	 */
	@Override
	public void reception(Connection connection, Object info) {
	}
	/**
	 * deconnexion
	 */
	@Override
	public void deconnexion() {
	    System.out.println("Déconnexion effectuée !");
	}
	
	/**
	 * Envoi d'une information vers le serveur
	 * fais appel une fois à l'envoi dans la classe Jeu
	 * @param info information à envoyer au serveur
	 */
	public void envoienvoi(String info) {
		super.envoi(this.connection, info);
	}

}
