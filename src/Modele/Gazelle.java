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
	
	/*_______________________________________________________________*/
	/**
	 *@param ressource
	 * @see Modele.Animal#consommerRessource(Modele.Element)
	 */
	public void consommerRessource(Element ressource)
	  {
		 if (ressource instanceof Plante)
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
	
}