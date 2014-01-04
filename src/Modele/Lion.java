package Modele;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

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

  public Lion seReproduire(int caseid, boolean sexe)
  {
	  return new Lion(caseid, sexe);
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
	  
  
  return seDeplacer(getPosition());
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
