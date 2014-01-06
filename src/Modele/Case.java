package Modele;
import java.util.ArrayList;

import javax.swing.JComponent;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
@SuppressWarnings("serial")
public class Case extends JComponent{

  
  /**  */
private int id;		
  /**  */
private Position position;//vectmath2d
  /**  */
private TypeTerrain type;// enum TypeTerrain
  /**  */
private ArrayList<Element> listeElements;
  /**  */
private ArrayList<Case>  listeCasesAdjacentes;
  
//-----------------------------CONSTRUCTEURS--------------------------------------------//

  /*_______________________________________________________________*/
/**Constructeur complet
 * @param id
 * @param p
 * @param type
 * @param listeElements
 * @param listeCaseAdjacentes
 */
public Case(int id, Position p,TypeTerrain type,ArrayList<Element> listeElements, ArrayList<Case> listeCaseAdjacentes){ 
	  
	  position = new Position();
	  this.listeElements = new ArrayList<Element>();
	  listeCasesAdjacentes = new ArrayList<Case>();
	  setId(id);
	  setPosition(p); 
	  setType(type);
	  setListeElements(listeElements);
	  setListeCasesAdjacentes(listeCaseAdjacentes);
  }
  
  /*_______________________________________________________________*/
/**Constructeur sans ListeCaseAdjacentes
 * @param id
 * @param p
 * @param type
 * @param listeElements
 */
public Case(int id, Position p,TypeTerrain type,ArrayList<Element> listeElements){ 
	  position = new Position();
	  this.listeElements = new ArrayList<Element>();
	  listeCasesAdjacentes = new ArrayList<Case>();
	  setId(id);
	  setPosition(p); 
	  setType(type);
	  setListeElements(listeElements);
  }
  
  /*_______________________________________________________________*/
/**Constructeur sans ListeCaseAdjacentes et sans listeElement
 * @param id
 * @param p
 * @param type
 */
public Case(int id, Position p,TypeTerrain type){
	 
	  position = new Position();
	  this.listeElements = new ArrayList<Element>();
	  listeCasesAdjacentes = new ArrayList<Case>();
	  setId(id);
	  setPosition(p); 
	  setType(type);

  }
//-----------------------------GETTERS AND SETTERS-------------------------------------//
 
    /*_______________________________________________________________*/
    /**
     * @return l'id
     */
    public int getId() {
		return id;
	}
    
	/*_______________________________________________________________*/
	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
  	/*_______________________________________________________________*/
  	/**
  	 * @return la position
  	 */
  	public Position getPosition(){
  		return position;
  	}
  	
  	/*_______________________________________________________________*/
  	/**
  	 * @param p
  	 */
  	public void setPosition(Position p){
  		
  	position.setX(p.getX());
  	position.setY(p.getY());
  	}
  	

	/*_______________________________________________________________*/
	/**
	 * @return liste d'éléments
	 */
	public ArrayList<Element> getListeElements() {
		return listeElements;
	}

	/*_______________________________________________________________*/
	/**
	 * @param listeElements
	 */
	public void setListeElements(ArrayList<Element> listeElements) {
		this.listeElements = listeElements;
	}
	
	/*_______________________________________________________________*/
	/**
	 * @return liste des cases adjacentes
	 */
	public ArrayList<Case> getListeCasesAdjacentes() {
		return listeCasesAdjacentes;
	}
	
	/*_______________________________________________________________*/
	/**
	 * @param listeCasesAdjacentes
	 */
	public void setListeCasesAdjacentes(ArrayList<Case> listeCasesAdjacentes) {
		this.listeCasesAdjacentes = listeCasesAdjacentes;
	}
	
	/*_______________________________________________________________*/
	/**
	 * @return le type
	 */
	public TypeTerrain getType() {
		return type;
	}

	/*_______________________________________________________________*/
	/**
	 * @param type
	 */
	public void setType(TypeTerrain type) {
		this.type = type;
	}

	
//-----------------------------AUTRES METHODES-----------------------------------------//
  /*_______________________________________________________________*/
/**Fonction qui ajoute un obstacle � la liste d'�l�ments de la case.
 * @param obstacle
 */
public void addObstacle(Obstacle obstacle){
		try{
		  listeElements.add(obstacle);
	  }catch(Exception e)
	  {
		 //
	  }
	  
  }
  
  /*_______________________________________________________________*/
/**Fonction qui ajoute une ressource � la liste d'�l�ments de la case.
 * @param ressource
 */
public void addRessource(Ressource ressource){
	  listeElements.add(ressource);
  }
  
  /*_______________________________________________________________*/
/**Fonction qui ajoute un animal � la liste d'�l�ments de la case.
 * @param animal
 */
public void addAnimal(Animal animal){
	  listeElements.add(animal);
  }
  
  /*_______________________________________________________________*/
/**Fonction qui retire un obstacle de la liste d'�l�ments de la case.
 * @param obstacle
 */
public void supprimerObstacle(Obstacle obstacle)
  {
	  for(int i = 0; i< listeElements.size(); i++)
	  {
		 if (obstacle.getId() == listeElements.get(i).getId())
		 {
			 listeElements.remove(i);
		 }
			 
	  }
  }
  
  /*_______________________________________________________________*/
/**Fonction qui retire une ressource de la liste d'�l�ments de la case.
 * @param ressoucre
 */
public void supprimerRessource(Ressource ressource)
  {
	for(int i = 0; i< listeElements.size(); i++)
	  {
		 if (ressource.getId() == listeElements.get(i).getId())
		 {
			 listeElements.remove(i);
		 }
			 
	  }
  }
  
  /*_______________________________________________________________*/
/**Fonction qui retire un animal de la liste d'�l�ments de la case.
 * @param animal
 */
public void supprimerAnimal(Animal animal)
  {
	for(int i = 0; i< listeElements.size(); i++)
	  {
		 if (animal.getId() == listeElements.get(i).getId())
		 {
			 listeElements.remove(i);
			 
		 }
			 
	  }  
  }
  
  /**Fonction qui attribue une position � un �l�ment.
   * 
   */
  public void genererPositionElement(){ //TODO l'inserer à la bonne place dans le code
	  int i;
	  for(i=0;i<listeElements.size();i++){
		  listeElements.get(i).setPosition(this.position);
	  }
  }
  
  

}
