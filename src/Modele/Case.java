package Modele;
import java.util.ArrayList;

public class Case {

  private Integer rang;
  private Integer taille;
  private ArrayList<Element> listeElements;
  private ArrayList<Case>  listeCasesAdjacentes;
//-----------------------------CONSTRUCTEUR--------------------------------------------//
  public Case(Integer rang,Integer taille,ArrayList<Element> listeElements,ArrayList<Case>  listeCasesAdjacentes){
	  setRang(rang);
	  setTaille(taille);
	  setListeElements(listeElements);
	  setListeCasesAdjacentes(listeCasesAdjacentes);
	  
  }
//-----------------------------GETTERS AND SETTERS-------------------------------------//
  public Integer getRang() {
		return rang;
	}

	public void setRang(Integer rang) {
		this.rang = rang;
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
  public void addObstacle() {
  }

  public void addRessource() {
  }

  public void addAnimal() {
  }

}