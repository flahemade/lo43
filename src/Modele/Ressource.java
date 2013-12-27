package Modele;

public class Ressource extends Element {

	private int idcase;
	private int modifierVie;
	private int champVision;
	private String image;
  
  public Ressource(String nom, String image, int modifierVie, int champVision){
	  super(image, nom , modifierVie, champVision );
	  
  }
  
  public Ressource (int idcase){
	  
  }

  public void init(){
	  setChampVision(0);
	  
  }
  public void disparaitre() {
  }
}