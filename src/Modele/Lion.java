package Modele;

import java.util.ArrayList;

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
  
  
  @Override
  protected Element consommerRessource(Element ressource)
  {
	  if (ressource instanceof Viande || ressource instanceof Animal)
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

	  int i,j;
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
	  
  
  return seDeplacer(getPosition(), listecaseadj );
  }
  private void init(){
		setAgeMax(20);
		setChampVision(1);
		setRangChaineAlimentaire(9);
		setPV(100);
		setModifierVie(100);
		setImage("./res/animaux/lion/lion1.png");
  }
  
}
