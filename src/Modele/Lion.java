package Modele;

public class Lion extends Animal {

	public Lion(){
		super();
		init();
		
	}
  public void seBattre() {
  }

  private void init(){
		setAgeMax(100);
		setChampVision(2);
		setRangChaineAlimentaire(9);
		setImage("./res/animaux/lion/lion.png");
  }
}
