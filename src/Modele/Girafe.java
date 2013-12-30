package Modele;

public class Girafe extends Animal{

	public Girafe(){
		super();
		init();
}
	
	public Girafe(int caseid, Boolean sexe){
		super(caseid);
		init();
		//setCaseId(caseid);
		setSexe(sexe);
		
	}
	
	private void init(){
		setAgeMax(100);
		setChampVision(1);
		setRangChaineAlimentaire(1);
		setPV(75);
		setModifierVie(20);
		setImage("./res/animaux/girafe/girafe.png");
  }
	
}
