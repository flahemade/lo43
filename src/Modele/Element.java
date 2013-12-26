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
	/**  */
	protected int caseId;
protected static int ID=0;
    /*_______________________________________________________________*/
    /**Constructeur par defaut
     */
    public Element(int caseId)
    {
    	ID++;
    	setCaseId(caseId);
    }
   public Element(){
	   ID++;
   }
	/*_______________________________________________________________*/
    /**Constructeur avec paramètre
     * @param image
     * @param nom
     */
    public Element(String image, String nom, int modifierVie, int champVision)
    {
    	ID++;
    	setImage(image);
    	setNom(nom);
    	setModifierVie(modifierVie);
    	setChampVision(champVision);
    }
    public Element(String image, String nom, int modifierVie, int champVision, int idcase)
    {
    	ID++;
    	setImage(image);
    	setNom(nom);
    	setModifierVie(modifierVie);
    	setChampVision(champVision);
    	setCaseId(idcase);
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
		/** Permet d'obtenir la valeur du champ caseId.
		 * @return la valeur du champ caseId.
		 */
		public int getCaseId()
		{
			return caseId;
		}
		/*_______________________________________________________________*/
		/** Modifie la valeur du champ caseId.
		 * @param caseId la nouvelle valeur du champ caseId.
		 */
		public void setCaseId(int caseId)
		{
			this.caseId = caseId;
		}

    /*_______________________________________________________________*/
    /**Affiche l'élément
     */
    public void afficherElement() {
    }

    

}