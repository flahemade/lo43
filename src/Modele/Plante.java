package Modele;

public class Plante extends Ressource {

	public Plante (int idcase){
		super(idcase);
	}
	
	
	public void init(){
		setModifierVie(25);
		setImage("./res/ressource/plante/plante1.png");
		
	}
	
}
