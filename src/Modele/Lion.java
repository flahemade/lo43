package Modele;

public class Lion extends Animal {

	public Lion(){
		super();
		init();
		
	}
	public Lion(int caseid, Boolean sexe){
		super(caseid);
		init();
		setSexe(sexe);
		//setCaseId(caseid);
	}
  public void seBattre() {
  }
  
  public void consommerRessource(Element ressource)
  {
	  if (ressource instanceof Viande)
	  {
		   this.modifierVie = 5;
	  }
		  
  }

  public Lion seReproduire(int caseid, boolean sexe)
  {
	  return new Lion(caseid, sexe);
  }
  private void init(){
		setAgeMax(100);
		setChampVision(1);
		setRangChaineAlimentaire(9);
		setPV(100);
		setModifierVie(100);
		setImage("./res/animaux/lion/lion1.png");
  }
}
