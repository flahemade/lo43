package Modele;

import java.util.ArrayList;
import java.util.Random;


/*_______________________________________________________________*/
/**
 * @author 
 *
 */
public class Animal extends Element {

  
		/** vitesse de l'animal */
	protected int Vitesse;
	  /** direction de l'animal*/
	protected int Direction;
	  /** rang dans la chaine alimentaire */
	protected int RangChaineAlimentaire;
	  /** age de l'animal */
	protected int Age;
	  /** age max de l'espèce */
	protected int AgeMax;
	  /** pv de l'animal */
	protected int PV;
	  /** sexe de l'animal */
	protected Boolean sexe;

//  protected int idCase; //Se trouve dans Element
 // protected int modifierVie; //Se trouve dans Element
 // protected int champVision; //Se trouve dans Element
  
  //------------------------------CONSTRUCTEUR-------------------------------------------//
	/*_______________________________________________________________*/
	/**constructeur complet
	 * @param image
	 * @param nom
	 * @param Vitesse
	 * @param RCA
	 * @param AgeMax
	 * @param PV
	 * @param sexe
	 * @param modifierVie
	 * @param champVision
	 */
	public Animal(String image, String nom,int Vitesse,int RCA,int AgeMax,int PV,Boolean sexe, int modifierVie, int champVision){
	  super(image, "nom"+(ID+1), modifierVie, champVision);
	  init();
	  setVitesse(Vitesse);
	  setRangChaineAlimentaire(RCA);
	  setAgeMax(AgeMax);
	  setPV(PV);
	  setSexe(sexe);
  }
  
 /*_______________________________________________________________*/
/**constructeur simple
 */
public Animal(){
	  super();
	  init();    
 
  }
 
  
/*_______________________________________________________________*/
/**constructeur avec id de case
 * @param idcase
 */
public Animal(int idcase){
	super(idcase);
	init();


}
//------------------------------GETTERS AND SETTERS------------------------------------//


	/*_______________________________________________________________*/
	/**getter de vitesse
	 * @return la vitesse
	 */
	public Integer getVitesse() {
		return Vitesse;
	}

	/*_______________________________________________________________*/
	/**setter de vitesse
	 * @param vitesse
	 */
	public void setVitesse(Integer vitesse) {
		Vitesse = vitesse;
	}

	/*_______________________________________________________________*/
	/**getter
	 * @return direction
	 */
	public Integer getDirection() {
		return Direction;
	}

	/*_______________________________________________________________*/
	/**setter
	 * @param direction
	 */
	public void setDirection(Integer direction) {
		Direction = direction;
	}

	/*_______________________________________________________________*/
	/**getter
	 * @return le rang
	 */
	public Integer getRangChaineAlimentaire() {
		return RangChaineAlimentaire;
	}

	/*_______________________________________________________________*/
	/**setter
	 * @param rangChaineAlimentaire
	 */
	public void setRangChaineAlimentaire(Integer rangChaineAlimentaire) {
		RangChaineAlimentaire = rangChaineAlimentaire;
	}

	/*_______________________________________________________________*/
	/**getter age
	 * @return l'age
	 */
	public Integer getAge() {
		return Age;
	}

	/*_______________________________________________________________*/
	/**setter age
	 * @param age
	 */
	public void setAge(Integer age) {
		Age = age;
	}

	/*_______________________________________________________________*/
	/**getter
	 * @return l'age max de l'espèce
	 */
	public Integer getAgeMax() {
		return AgeMax;
	}

	/*_______________________________________________________________*/
	/**setter age max
	 * @param ageMax
	 */
	public void setAgeMax(Integer ageMax) {
		AgeMax = ageMax;
	}

	/*_______________________________________________________________*/
	/**getter pv 
	 * @return les pv de l'animal
	 */
	public Integer getPV() {
		return PV;
	}

	/*_______________________________________________________________*/
	/**setter pv
	 * @param pV
	 */
	public void setPV(Integer pV) {
		PV = pV;
	}


	/*_______________________________________________________________*/
	/**getter sexe de l'animal
	 * @return le sexe de l'animal
	 */
	public Boolean getSexe() {
		return sexe;
	}

	/*_______________________________________________________________*/
	/**setter sexe de l'animal
	 * @param sexe
	 */
	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}
	


		
  //------------------------------Autres M�thodes----------------------------------------//

	 /*_______________________________________________________________*/
	/**fonction qui initialise un animal
	 */
	private void init(){
		 setAge(0);
		  setDirection(0);
	 }
  /*_______________________________________________________________*/
	
	private ArrayList<Case> getCaseDispo (ArrayList<Case> listecaseadj){
		int i,j;
		Boolean obstacle = false;
		ArrayList<Case> listecasedispo = new ArrayList<Case>();
		for(i=0;i<listecaseadj.size();i++){
			for(j=0;j<listecaseadj.get(i).getListeElements().size();j++){
				if(listecaseadj.get(i).getListeElements().get(j) instanceof Obstacle){
					obstacle = true;
				}
			}
			if(!obstacle){
				listecasedispo.add(listecaseadj.get(i));
			}
			obstacle = false;
		}
		return listecasedispo;
	}
/** va permettre à l'animal de choisir une nouvelle position sur la map
 *@param p
 *@return la nouvelle position
 * @see Modele.Element#seDeplacer(Modele.Position)
 */
public Position seDeplacer(Position p, ArrayList<Case> listecaseadj)
  { 
	  //Integer case_cible=0;
	  Position nouvelle = p;
	  Random rand = new Random();
	  int valeur;
	/*Nouveau*/
	  ArrayList<Case> listecasedispo = getCaseDispo(listecaseadj);
	  if(listecasedispo.size()==0){
		  return nouvelle;
	  }
	  valeur = rand.nextInt(listecasedispo.size());
	  nouvelle = listecasedispo.get(valeur).getPosition();
	  return nouvelle;
	  
	  
	  
	  /*// ANCIEN
	   valeur = rand.nextInt(8-1+1) + 1;
	 
	  
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
	  */
  }



  /*_______________________________________________________________*/
/**
 * @param animal
 * @return si la reproduction a eu lieu
 */
public Boolean seReproduire(Animal animal){
	  Boolean reproduction;
	  if(animal.sexe!=this.sexe){
		  reproduction=true;
		  
	  }else{
		  reproduction=false;
	  }
	  return reproduction;
  }
  
  /*_______________________________________________________________*/
/**
 * @return
 */
public Boolean verifierAge(){
	  Boolean vivant;
	  if(this.Age<=this.AgeMax){
		  vivant=true;
	  }else{
		  vivant=false;
	  }
	  return vivant;
  }

  /*_______________________________________________________________*/
/**
 */
public void mourir(){
	  
  }
  
  /*_______________________________________________________________*/
/**
 * @param c
 */
public Element live(Case c){
	  int i,j;
	  Element supprime =null;
	  System.out.println(this.getClass().getSimpleName()+"\tID "+this.getId()+"\t live()");
	  //Position positionCible=seDeplacer(c.getPosition()); //Affectation position initiale
	  Position positionCible = choixDeplacement(c.getListeCasesAdjacentes());
	  Case ancienne=c;
	  Case nouvelle=c;
	  ArrayList<Case> listeCases=c.getListeCasesAdjacentes();
	  for(i=0; i<listeCases.size(); i++){
		  if(listeCases.get(i).getPosition().getX()==positionCible.getX() && listeCases.get(i).getPosition().getY() == positionCible.getY()){
			  nouvelle=listeCases.get(i);
			  ArrayList<Element> listeElementsCible=nouvelle.getListeElements();
			  for(j=0; j<listeElementsCible.size(); j++){
				  Element element_temp=listeElementsCible.get(j);
				  //Animal sur la case cible
				  
				  if(element_temp instanceof Animal){
					  System.out.println("Animal sur la case cible.");
					  Animal animalCible=(Animal)element_temp;
					  if(this.getClass()==element_temp.getClass()){
						  
						  //Gestion de la reproduction
						  
						  System.out.println("Reproduction ?");
						  if(this.seReproduire(animalCible)){
							  System.out.println("Cr�ation d'un nouvel animal.");
						  }else{
							  System.out.println("Il ne se passe rien.");
							 
						  }
					  }else{
						  System.out.println("Baston !");
						  if(this.getRangChaineAlimentaire()>=animalCible.getRangChaineAlimentaire()){
							  System.out.println("Victoire");
							  this.consommerRessource(animalCible);
							  animalCible.mourir();
						  }else{
							  System.out.println("D�faite");
							  animalCible.consommerRessource(this);
							  this.mourir();
						  }
					  }
				  }
				  //Ressource sur la case cible
				  
				  if(element_temp instanceof Ressource){
					  System.out.println("Ressource sur la case cible.");
					 supprime = consommerRessource(element_temp);
					  this.setPV(getPV() + getModifierVie());
					  
					  //Ici la question est de savoir quels animaux peuvent consommer quelle ressource
					  //Pas tr�s long � impl�menter.
				  }
				  if(element_temp instanceof Obstacle){
					  System.out.println("Obstacle sur la case cible.");
					  this.live(ancienne);
				  }
			  }
		  }
	  }
	  //Gestion du d�placement.
	  nouvelle.addAnimal(this);
	  System.out.println("Nouvelle :"+nouvelle.getId());
	  ancienne.supprimerAnimal(this);
	  System.out.println("Ancienne :"+ancienne.getId());
	  Age++;
	  return supprime;
  }

  protected Position choixDeplacement (ArrayList<Case> listecaseadj){
	  System.out.println("Pas la bonne méthode");
	  return position;
  }

  /*_______________________________________________________________*/
/**fonction redéfinie dans les classes filles
 * @param ressource
 */
protected Element consommerRessource(Element ressource){
	return null;
  }
  
}
  
 
