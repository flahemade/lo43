package Modele;
import java.util.ArrayList;

public class Case {

  //private Integer rang;
  private Integer id;
  private Position position;
  private Integer taille;
  private ArrayList<Element> listeElements;
  private ArrayList<Case>  listeCasesAdjacentes;
//-----------------------------CONSTRUCTEUR--------------------------------------------//
  public Case(Integer id, Position p,Integer taille,ArrayList<Element> listeElements){ //08/12/13 : Integer rang changé en Position position
	  //setRang(rang);
	  position = new Position();
	  this.listeElements = new ArrayList<Element>();
	  listeCasesAdjacentes = new ArrayList<Case>();
	  setId(id);
	  setPosition(p); 
	  setTaille(taille);
	  setListeElements(listeElements);
  }

//-----------------------------GETTERS AND SETTERS-------------------------------------//
  /**
  public Integer getRang() {
		return rang;
	}

	public void setRang(Integer rang) {
		this.rang = rang;
	}
*/
    public Integer getId() {
		return id;
	}
    
	public void setId(Integer id) {
		this.id = id;
	}
  	public Position getPosition(){
  		return position;
  	}
  	
  	public void setPosition(Position p){
  		
  	position.setX(p.getX());
  	position.setY(p.getY());
  	}
  	
	public Integer getTaille() {
		return taille;
	}

	public void setTaille(Integer taille) {
		this.taille = taille;
	}

	public ArrayList<Element> getListeElements() {
		return listeElements;
	}

	public void setListeElements(ArrayList<Element> listeElements) {
		this.listeElements = listeElements;
	}
	
	public ArrayList<Case> getListeCasesAdjacentes() {
		return listeCasesAdjacentes;
	}
	
	public void setListeCasesAdjacentes(ArrayList<Case> listeCasesAdjacentes) {
		this.listeCasesAdjacentes = listeCasesAdjacentes;
	}
//-----------------------------AUTRES METHODES-----------------------------------------//
  public void addObstacle(Obstacle obstacle){
  }
  
  public void addRessource(Ressource ressource){
  }
  
  public void addAnimal(Animal animal){
  }

}