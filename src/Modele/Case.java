package Modele;
import java.util.ArrayList;

import javax.swing.JComponent;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
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
/**
 * @param obstacle
 */
public void addObstacle(Obstacle obstacle){
		try{
		  listeElements.add(obstacle);
	  }catch(Exception e)
	  {
		  System.out.println("coucou");
	  }
	  
  }
  
  /*_______________________________________________________________*/
/**
 * @param ressource
 */
public void addRessource(Ressource ressource){
	  listeElements.add(ressource);
  }
  
  /*_______________________________________________________________*/
/**
 * @param animal
 */
public void addAnimal(Animal animal){
	  listeElements.add(animal);
  }
  
  /*_______________________________________________________________*/
/**
 * @param obstacle
 */
public void supprimerObstacle(Obstacle obstacle)
  {
	  
  }
  
  /*_______________________________________________________________*/
/**
 * @param ressoucre
 */
public void supprimerRessource(Ressource ressoucre)
  {
	  
  }
  
  /*_______________________________________________________________*/
/**
 * @param animal
 */
public void supprimerAnimal(Animal animal)
  {
	  
  }
  
  
  
  
  

}