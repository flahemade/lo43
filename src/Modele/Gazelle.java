package Modele;

public class Gazelle extends Animal {
	
	public Gazelle(){
		super();
		init();
}
	
	public Gazelle(int caseid, Boolean sexe){
		super(caseid);
		init();
		//setCaseId(caseid);
		setSexe(sexe);
		
	}
	
	private void init(){
		setAgeMax(100);
		setChampVision(1);
		setRangChaineAlimentaire(1);
		setPV(10);
		setModifierVie(5);
		setImage("./res/animaux/gazelle/gazelle.png");
  }
	
	 public void consommerRessource(Element ressource)
	  {
		  if (ressource instanceof Plante)
		  {
			   this.modifierVie = 5;
		  }
			  
	  }
	
}