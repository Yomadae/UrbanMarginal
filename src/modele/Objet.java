package modele;
/**
 * Informations(joueurs, murs, boules)
 * pour mémoriser la position de l'objet et eviter les collisions
 *
 */
public abstract class Objet {

	/**
	 * position X de l'objet
	 */
	protected Integer posX ;
	/**
	 * position Y de l'objet
	 */
	protected Integer posY ;
	
	/**
	 * controle si l'objet touche un autre objet
	 * @param objet contient l'objet
	 * @return true si les objets se touchent
	 */
	public Boolean toucheObjet (Objet objet) {
		return null;
	}
	
}
