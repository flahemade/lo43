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
	protected Integer modifierVie;
	/*_______________________________________________________________*/
	/**Constructeur par defaut
	 */
	public Element()
	{
		
	}
    
    /*_______________________________________________________________*/
    /**Constructeur avec paramètre
     * @param image
     * @param nom
     */
    public Element(String image, String nom)
    {
    	setImage(image);
    	setNom(nom);
    }
    
    /*_______________________________________________________________*/
	/** Permet d'obtenir la valeur du champ image.
	 * @return la valeur du champ image.
	 */
	public String getImage()
	{
		return image;
	}

	public Integer getModifierVie(){
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
	/**Retourne la position de l'élément
	 */
	public void getPosition() {
		
    }

    /*_______________________________________________________________*/
    /**Affiche l'élément
     */
    public void afficherElement() {
    }
	
    /*_______________________________________________________________*/
    /**
     */
    public void move() {
	}

}