package modele;
import controleur.Global;

/**
 * Gestion des joueurs
 *
 */ 
public class Joueur extends Objet implements Global {
	
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
	 */
	public Joueur() {
	}
	/**
	 * Initialisation d'un joueur (pseudo et numéro, calcul de la 1ère position, affichage, création de la boule)
	 */
	public void initPerso(String pseudo, int numPerso) {
		this.pseudo = pseudo;
		this.numPerso = numPerso;
		System.out.println("joueur "+pseudo+" - num perso "+numPerso+" créé");
	}

	/**
	 * première position aléatoire du joueur (sans toucher un autre joueur ou un mur)
	 */
	private void premierePosition() {
	}
	
	/**
	 * Affiche le personnage et son message
	 */
	public void affiche() {
	}

	/**
	 * affichage action et action (déplacement, tire de boule...)
	 */
	public void action() {
	}

	/**
	 * déplacement du personnage
	 */
	private void deplace() { 
	}
	/**
	 * Contrôle si le joueur touche un des autres joueurs
	 * @return true si deux joueurs se touchent
	 */
	private Boolean toucheJoueur() {
		return null; 
	}
	/** 
	* Contrôle si le joueur touche un des murs
	* @return true si un joueur touche un mur
	*/
	private Boolean toucheMur() {
		return null;
	}
	/**
	 * Gain de points de vie
	 */
	public void gainVie() {
	}
	
	/**
	 * Perte de points de vie
	 */
	public void perteVie() {
	}
	/**
	 * mort si la vie est à 0
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