package Modele;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Obstacle extends Element {

	
	/*_______________________________________________________________*/
	/**constructeur simple
	 * @param idcase
	 */
	public Obstacle(int idcase){
		super("./res/obstacles/obstacle1.png","Obstacle"+(ID+1),0,0, idcase);
		
	}
	/*_______________________________________________________________*/
	/**constructeur complet
	 * @param modifierVie
	 * @param champVision
	 * @param nom
	 * @param image
	 * @param idcase
	 */
	public Obstacle(int modifierVie, int champVision, String nom, String image, int idcase)
	{
		super("./res/obstacles/obstacle1.png", "Obstacle"+(ID+1), modifierVie, champVision, idcase);
		
	}
	  /*_______________________________________________________________*/
	/** constructeur de l'obstacle
	 * @param modifierVie 
	 * @param champVision 
	 * @param nom 
	 * @param image 
	 */
	public Obstacle(int modifierVie, int champVision, String nom, String image)
	  {
		  super(image, "Obstacle"+(ID+1), modifierVie, champVision);
		  
		  
	  }
	
	 /*_______________________________________________________________*/
	/**constructeur simple
	 */
	public Obstacle(){
		 
		 super("./res/obstacles/obstacle1.png","Obstacle"+(ID+1),0,0);
		 
	 }

	

	/*_______________________________________________________________*/
	/** Permet d'obtenir la valeur du champ modifierVie.
	 * @return la valeur du champ modifierVie.
	 */
	public int getModifierVie()
	{
		return modifierVie;
	}

	/*_______________________________________________________________*/
	/** Modifie la valeur du champ modifierVie.
	 * @param modifierVie la nouvelle valeur du champ modifierVie.
	 */
	public void setModifierVie(int modifierVie)
	{
		this.modifierVie = modifierVie;
	}



}