package Modele;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Obstacle extends Element {

	  /** taille de l'obstacle*/
	private int taille;
	private int idcase;
	  /** Id de l'obstacle */
	private static int ID=0;
	  
	  /*_______________________________________________________________*/
	/** constructeur de l'obstacle
	 */
	public Obstacle(int Taille)
	  {
		  super("Test", "Obstacle"+ID++);
		  setTaille(Taille);
	  }
	  
	public Obstacle(int Taille, int idcase)
	  {
		  super("Test", "Obstacle"+ID++);
		  setTaille(Taille);
		  setIdcase(idcase);
	  }
	  /*_______________________________________________________________*/
	/** getter de taille
	 * @return la taille
	 */
	public int getTaille()
	  {
		  return taille;
	  }
	  
	  /*_______________________________________________________________*/
	/**setter de taille
	 * @param Taille
	 */
	public void setTaille(int Taille)
	  {
		  taille = Taille;
	  }
	 
	  /*_______________________________________________________________*/
	/** getter de l'ID
	 * @return lID
	 */
	public int getId()
	  {
		  return ID;
	  }
	
	 /*_______________________________________________________________*/
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

	

}