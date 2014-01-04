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
			   
			  this.setModifierVie(getPV() + ressource.getModifierVie());
			  if (this.getPV() > 100)
				  this.setPV(100);
			  if(this.getPV() <=0)
			  {
				try
				{
					finalize();
				} catch (Throwable e)
				{
					// PENSER à IMPLEMENTER Auto-generated catch block
					e.printStackTrace();
				}
			  }	
			ressource = null;
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
