package Modele;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Obstacle extends Element {

	  /** taille de l'obstacle*/
	private int taille;
	  
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
	/**
	 * @see Modele.Element#afficherElement()
	 */
	public void afficherElement()
	{
		super.afficherElement();
	}
  

}