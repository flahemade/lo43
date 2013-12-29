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

  private void init(){
		setAgeMax(100);
		setChampVision(2);
		setRangChaineAlimentaire(9);
		setPV(100);
		setModifierVie(100);
		setImage("./res/animaux/lion/lion1.png");
  }
}
