package Modele;

public class Viande extends Ressource{

	
	public Viande (int idcase){
		super(idcase);
	}
	
	
	public void init(){
		setModifierVie(25);
		setImage("./res/ressource/viande/viande1.png");
		
	}
	
}
