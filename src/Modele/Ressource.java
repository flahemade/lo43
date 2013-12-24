package Modele;

public class Ressource extends Element {

  private Integer Id;
  
  public Ressource(String nom, String image, int modifierVie, int champVision){
	  super(image, nom , modifierVie, champVision );
	  Id=0;
  }
  
  

  public void disparaitre() {
  }
}