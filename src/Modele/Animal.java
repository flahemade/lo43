package Modele;


public class Animal extends Element {

  protected Integer Taille;
  protected Integer Vitesse;
  protected Integer Direction;
  protected Integer RangChaineAlimentaire;
  protected Integer Age;
  protected Integer AgeMax;
  protected Integer PV;
  protected Integer Id;
  protected Boolean sexe;
  
  //------------------------------CONSTRUCTEUR-------------------------------------------//
  public Animal(Integer taille,Integer Vitesse,Integer RCA,Integer AgeMax,Integer PV,Integer Id,Boolean sexe){
	  setTaille(taille);
	  setVitesse(Vitesse);
	  setDirection(0);
	  setRangChaineAlimentaire(RCA);
	  setAge(1);
	  setAgeMax(AgeMax);
	  setPV(PV);
	  setId(Id);
	  setSexe(sexe);
  }
  
  //------------------------------GETTERS AND SETTERS------------------------------------//
  public Integer getTaille() {
		return Taille;
	}

	public void setTaille(Integer taille) {
		Taille = taille;
	}

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

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Boolean getSexe() {
		return sexe;
	}

	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}
  //------------------------------Autres Méthodes----------------------------------------//

  public Integer seDeplacer(Integer direction){
	  Integer case_cible=0;
	  return case_cible;
  }

public Integer seNourrir(Element element){
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