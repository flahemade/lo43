package Modele;

public class Hyene extends Animal{

	public Hyene(){
		super();
		init();
}
	
	public Hyene(int caseid, Boolean sexe){
		super(caseid);
		init();
		//setCaseId(caseid);
		setSexe(sexe);
		
	}
	
	 public void consommerRessource(Element ressource)
	  {
		  if (ressource instanceof Viande)
		  {
			   this.modifierVie = 5;
		  }
			  
	  }
	
	public void seBattre(){
	
	}
	
	private void init(){
		setAgeMax(100);
		setChampVision(1);
		setRangChaineAlimentaire(8);
		setPV(80);
		setModifierVie(50);
		setImage("./res/animaux/hyene/hyene.png");
  }
	
}
