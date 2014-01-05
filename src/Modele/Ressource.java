package Modele;

public class Ressource extends Element {

	
  
	/*--------Constructeurs----------*/
  public Ressource(String nom, String image, int modifierVie, int champVision){
	  super(image, nom , modifierVie, champVision );    
  }

  public Ressource (int idcase){
	  
	super(idcase);
	init();
  }


/*----------AUTRES METHODES ----------*/

public void init(){
	
	  setChampVision(0);
	 
  }

}