package Modele;

import java.util.ArrayList;

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
	public Element consommerRessource(Element ressource)
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
			return ressource;
		  }	
			return null;  
	  }
	@Override
	  protected Position choixDeplacement (ArrayList<Case> listecaseadj){
		  Position nouvelleposition;
		  int i,j ,choix;
		  for(i =0; i< listecaseadj.size();i++){
			  for(j=0;j<listecaseadj.get(i).getListeElements().size();j++){
				  
				  if(listecaseadj.get(i).getListeElements().get(j) instanceof Plante){
					  return  listecaseadj.get(i).getListeElements().get(j).getPosition();
				  }
				  if(listecaseadj.get(i).getListeElements().get(j) instanceof Animal){
					  Animal tmp = (Animal) listecaseadj.get(i).getListeElements().get(j);
					  if(tmp.getRangChaineAlimentaire()<this.getRangChaineAlimentaire()){
						  return listecaseadj.get(i).getListeElements().get(j).getPosition();
					  }
				  }
			  }
		  }
		  
	  
	  return seDeplacer(getPosition(), listecaseadj);
	  }
}