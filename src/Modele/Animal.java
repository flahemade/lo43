package Modele;

import java.util.Random;


public class Animal extends Element {

  
  protected int Vitesse;
  protected int Direction;
  protected int RangChaineAlimentaire;
  protected int Age;
  protected int AgeMax;
  protected int PV;
  protected Boolean sexe;
//  protected int idCase; //Se trouve dans Element
 // protected int modifierVie; //Se trouve dans Element
 // protected int champVision; //Se trouve dans Element
  
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
	  super();
	  init();    
 
  }
 
  
public Animal(int idcase){
	super(idcase);
	init();


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
	


		
  //------------------------------Autres M�thodes----------------------------------------//

	 private void init(){
		 setAge(0);
		  setDirection(0);
	 }
  public Position seDeplacer(Position p)
  { 
	  Integer case_cible=0;
	  Position nouvelle = new Position();
	  Random rand = new Random();
	  int valeur = rand.nextInt(8-1+1) + 1;
	  switch (valeur)
	  {
	  	case 1: nouvelle.setX(p.getX()-1);
	  			nouvelle.setY(p.getY()-1);
	  			break;
	  	case 2: nouvelle.setX(p.getX());
				nouvelle.setY(p.getY()-1);
				break;
	  	case 3: nouvelle.setX(p.getX()+1);
				nouvelle.setY(p.getY()-1);
				break;
	  	case 4: nouvelle.setX(p.getX()+1);
				nouvelle.setY(p.getY());
				break;
	  	case 5: nouvelle.setX(p.getX()+1);
				nouvelle.setY(p.getY()+1);
				break;
	  	case 6: nouvelle.setX(p.getX());
				nouvelle.setY(p.getY()+1);
				break;
	  	case 7: nouvelle.setX(p.getX()-1);
				nouvelle.setY(p.getY()+1);
				break;
	  	case 8: nouvelle.setX(p.getX()-1);
				nouvelle.setY(p.getY());
				break;
	  	default:break;
	}
	  return nouvelle;
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
  
  public void live(){
	  System.out.println(this.getClass()+" ID"+this.getId()+ " Position");
  }
}
  
 