package modele;

/**
 * Gestion des joueurs
 *
 */ 
public class Joueur extends Objet {
	/**
	 * vie de départ pour tous les joueurs
	 */
	private static final int MAXVIE = 10 ;
	/**
	 * gain de points de vie lors d'une attaque
	 */
	private static final int GAIN = 1 ; 
	/**
	 * perte de points de vie lors d'une attaque
	 */ 
	private static final int PERTE = 2 ; 
	/**
	 * pseudo saisi
	 */
	private String pseudo ;
	/**
	 * n° correspondant au personnage (avatar) pour le fichier correspondant
	 */
	private int numPerso ; 
	/**
	 * instance de JeuServeur pour communiquer avec lui
	 */
	private JeuServeur jeuServeur ;
	/**
	 * etape de l'animation (marche, touché ou mort)
	 */
	private int etape ;
	/**
	 * la boule du joueur 
	 */ 
	private Boule boule ;
	/**
	* vie restante du joueur
	*/
	private int vie ; 
	/**
	* tourné vers la gauche (0) ou vers la droite (1)
	*/
	private int orientation ; 
	/**
	 * Constructeur
	public void perteVie() {
	}
	/** 
	* Contrôle si le joueur touche un des murs
	* @return true si un joueur touche un mur
	*/
	private Boolean toucheMur() {
		return null;
	}
	/**
	 * vrai si la vie est à 0
	 * @return true si vie = 0
	 */
	public Boolean estMort() {
 		return null;
	}
 	/**
 	 * Le joueur se déconnecte et disparait
 	 */
 	public void departJoueur() {
 	} 
}