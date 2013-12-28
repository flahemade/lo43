package Modele;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Obstacle extends Element {


	/** id de la case */
	private int idcase;
	//private int modifierVie;
	//private int champVision;
	//private String image;
	 
	public Obstacle(int idcase){
		super("./res/obstacles/obstacle1.png","Obstacle"+(ID+1),0,0, idcase);
		setIdcase(idcase);
		
	}
	public Obstacle(int modifierVie, int champVision, String nom, String image, int idcase)
	{
		super("./res/obstacles/obstacle1.png", "Obstacle"+(ID+1), modifierVie, champVision, idcase);
		
	}
	  /*_______________________________________________________________*/
	/** constructeur de l'obstacle
	 */
	public Obstacle(int modifierVie, int champVision, String nom, String image)
	  {
		  super(image, "Obstacle"+(ID+1), modifierVie, champVision);
		  
		  
	  }
	 public Obstacle(){
		 
		 super("./res/obstacles/obstacle1.png","Obstacle"+(ID+1),0,0);
		 
	 }

	  /*_______________________________________________________________*/
	/** getter de l'ID
	 * @return lID
	 */
	public int getId()
	  {
		  return ID;
	  }
	
/*_____________________________________________________________*/
		/** getter de l'idcase
		 * @return idcase
		 */
	public int getIdcase() {
		return idcase;
	}

	/*_______________________________________________________________*/
	/** setter de l'idcase
	 * @param idcase
	 */
	public void setIdcase(int idcase) {
		this.idcase = idcase;
	}
  
	/*_______________________________________________________________*/
	/**
	 * @see Modele.Element#afficherElement()
	 */
	public void afficherElement()
	{
		super.afficherElement();
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