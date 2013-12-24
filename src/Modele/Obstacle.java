package Modele;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Obstacle extends Element {

	/** taille de l'obstacle*/
	private int taille;
	
	/** id de la case */
	private int idcase;
	
	/** Id de l'obstacle */
	private static int ID=0;
	
	private int modifierVie;
	private int champVision;
	private String nom;
	private String image;
	  
	  /*_______________________________________________________________*/
	/** constructeur de l'obstacle
	 */
	public Obstacle(int Taille, int modifierVie, int champVision, String nom, String image)
	  {
		  super("Test", "Obstacle"+ID++, modifierVie, champVision);
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