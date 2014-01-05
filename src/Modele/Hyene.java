package Modele;

import java.util.ArrayList;

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
	
	 public Element consommerRessource(Element ressource)
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
				  
				  if(listecaseadj.get(i).getListeElements().get(j) instanceof Viande){
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
