package Modele;

public class Ressource extends Element {

	//private int idcase;
	//private int modifierVie;
	//private int champVision;
	//private String image;
  
	/*--------Constructeurs----------*/
  public Ressource(String nom, String image, int modifierVie, int champVision){
	  super(image, nom , modifierVie, champVision );    
  }
  
  public Ressource (int idcase){
	  
	super(idcase);
	
	init();
  }
/*-----------SETTERS & GETTERS--------*/

  
/*  public int getIdcase() {
	return idcase;
}

public void setIdcase(int idcase) {
	this.idcase = idcase;
}
*/
public int getModifierVie() {
	return modifierVie;
}

public void setModifierVie(int modifierVie) {
	this.modifierVie = modifierVie;
}

public int getChampVision() {
	return champVision;
}

public void setChampVision(int champVision) {
	this.champVision = champVision;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}


/*----------AUTRES METHODES ----------*/

public void init(){
	  setChampVision(0);
	  
  }
  public void disparaitre() {
  }
}