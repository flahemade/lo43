package Modele;
import java.util.ArrayList;

public class Case {

  //private Integer rang;
  private Integer id;		
  private Position position;//vectmath2d
  private TypeTerrain type;// enum TypeTerrain
  private ArrayList<Element> listeElements;
  private ArrayList<Case>  listeCasesAdjacentes;
  
//-----------------------------CONSTRUCTEURS--------------------------------------------//
//-------------------------Constructeur complet ----------------------------------------//
  public Case(Integer id, Position p,TypeTerrain type,ArrayList<Element> listeElements, ArrayList<Case> listeCaseAdjacentes){ 
	  
	  position = new Position();
	  this.listeElements = new ArrayList<Element>();
	  listeCasesAdjacentes = new ArrayList<Case>();
	  setId(id);
	  setPosition(p); 
	  setType(type);
	  setListeElements(listeElements);
	  setListeCasesAdjacentes(listeCaseAdjacentes);
  }
  //-------------------Constructeur sans ListeCaseAdjacentes ---------------------------//
  public Case(Integer id, Position p,TypeTerrain type,ArrayList<Element> listeElements){ 
	  //setRang(rang);
	  position = new Position();
	  this.listeElements = new ArrayList<Element>();
	  listeCasesAdjacentes = new ArrayList<Case>();
	  setId(id);
	  setPosition(p); 
	  setType(type);
	  setListeElements(listeElements);
  }
  //---------------Constructeur sans ListeCaseAdjacentes et sans listeElement ---------//
  public Case(Integer id, Position p,TypeTerrain type){
	  //setRang(rang);
	  position = new Position();
	  this.listeElements = new ArrayList<Element>();
	  listeCasesAdjacentes = new ArrayList<Case>();
	  setId(id);
	  setPosition(p); 
	  setType(type);

  }
//-----------------------------GETTERS AND SETTERS-------------------------------------//
  /*
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
	
	public TypeTerrain getType() {
		return type;
	}

	public void setType(TypeTerrain type) {
		this.type = type;
	}

	
//-----------------------------AUTRES METHODES-----------------------------------------//
  public void addObstacle(Obstacle obstacle){
  }
  
  public void addRessource(Ressource ressource){
  }
  
  public void addAnimal(Animal animal){
  }

}