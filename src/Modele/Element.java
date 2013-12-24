package Modele;


/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Element  {

	/** Image de l'élément  */
	protected String image;
	/** Nom de l'élément */
	protected String nom;
	/**  */
	protected int modifierVie;
	/**  */
	protected int champVision;
	

    
    /*_______________________________________________________________*/
    /**Constructeur avec paramètre
     * @param image
     * @param nom
     */
    public Element(String image, String nom, int modifierVie, int champVision)
    {
    	setImage(image);
    	setNom(nom);
    	setModifierVie(modifierVie);
    	setChampVision(champVision);
    }
    
    /*_______________________________________________________________*/
	/** Permet d'obtenir la valeur du champ image.
	 * @return la valeur du champ image.
	 */
	public String getImage()
	{
		return image;
	}

	/*_______________________________________________________________*/
	/**
	 * @return
	 */
	public int getModifierVie(){
		return modifierVie;
	}



	/*_______________________________________________________________*/
	/** Modifie la valeur du champ image.
	 * @param image la nouvelle valeur du champ image.
	 */
	public void setImage(String image)
	{
		this.image = image;
	}

	/*_______________________________________________________________*/
	/**
	 * @param modifier
	 */
	public void setModifierVie(Integer modifier){
		this.modifierVie=modifier;
	}


	/*_______________________________________________________________*/
	/** Permet d'obtenir la valeur du champ nom.
	 * @return la valeur du champ nom.
	 */
	public String getNom()
	{
		return nom;
	}




	/*_______________________________________________________________*/
	/** Modifie la valeur du champ nom.
	 * @param nom la nouvelle valeur du champ nom.
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/*_______________________________________________________________*/
	/** Permet d'obtenir la valeur du champ champVision.
	 * @return la valeur du champ champVision.
	 */
	public int getChampVision()
	{
		return champVision;
	}

	/*_______________________________________________________________*/
	/** Modifie la valeur du champ champVision.
	 * @param champVision la nouvelle valeur du champ champVision.
	 */
	public void setChampVision(int champVision)
	{
		this.champVision = champVision;
	}

	/*_______________________________________________________________*/
	/**Retourne la position de l'élément
	 * @param maCase la case de l'élément
	 */
	public void getPosition(Case maCase) {
		maCase.getPosition();
    }

    /*_______________________________________________________________*/
    /**Affiche l'élément
     */
    public void afficherElement() {
    }
	
    

}