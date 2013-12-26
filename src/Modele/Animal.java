package Modele;


public class Animal extends Element {

  
  protected int Vitesse;
  protected int Direction;
  protected int RangChaineAlimentaire;
  protected int Age;
  protected int AgeMax;
  protected int PV;
  protected Boolean sexe;
  protected int idCase;
  protected int modifierVie;
  protected int champVision;
  
  //------------------------------CONSTRUCTEUR-------------------------------------------//
  public Animal(String image, String nom,int Vitesse,int RCA,int AgeMax,int PV,Boolean sexe, int modifierVie, int champVision){
	  super(image, "nom"+(ID+1), modifierVie, champVision);
	 init();
	  setVitesse(Vitesse);

	  setRangChaineAlimentaire(RCA);

	  setAgeMax(AgeMax);
	  setPV(PV);
	  setSexe(sexe);
	 
  }
  
  public Animal(){
	init();    
  
  }
public Animal(int idcase){
	init();
	setIdCase(idcase);

	
}
//------------------------------GETTERS AND SETTERS------------------------------------//


	public Integer getVitesse() {
		return Vitesse;
	}

	public void setVitesse(Integer vitesse) {
		Vitesse = vitesse;
	}

	public Integer getDirection() {
		return Direction;
	}

	public void setDirection(Integer direction) {
		Direction = direction;
	}

	public Integer getRangChaineAlimentaire() {
		return RangChaineAlimentaire;
	}

	public void setRangChaineAlimentaire(Integer rangChaineAlimentaire) {
		RangChaineAlimentaire = rangChaineAlimentaire;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public Integer getAgeMax() {
		return AgeMax;
	}

	public void setAgeMax(Integer ageMax) {
		AgeMax = ageMax;
	}

	public Integer getPV() {
		return PV;
	}

	public void setPV(Integer pV) {
		PV = pV;
	}


	public Boolean getSexe() {
		return sexe;
	}

	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}
	
	public Integer getIdCase(){
		return idCase;
	}
	public void setIdCase(int idcase){
		this.idCase = idcase;
	}
	public void setCaseLocation(Integer idCase){
		this.idCase=idCase;
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
	
	
	
	
	
	
  //------------------------------Autres M�thodes----------------------------------------//

	 private void init(){
		 ID++;
		 setAge(0);
		  setDirection(0);
	 }
  public int seDeplacer(Integer direction){ //TODO A TERMINER
	  Integer case_cible=0;
	  return case_cible;
  }

public int seNourrir(Element element){ //TODO A TERMINER
	  Integer result=0;
	  return result;
  }

  public Boolean seReproduire(Animal animal){
	  Boolean reproduction;
	  if(animal.sexe!=this.sexe){
		  reproduction=true;
	  }else{
		  reproduction=false;
	  }
	  return reproduction;
  }
  
  public Boolean verifierAge(){
	  Boolean vivant;
	  if(this.Age<=this.AgeMax){
		  vivant=true;
	  }else{
		  vivant=false;
	  }
	  return vivant;
  }

  public void mourir(){
	  
  }

}