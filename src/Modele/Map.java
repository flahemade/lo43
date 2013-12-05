package Modele;
import java.util.ArrayList;

import Vue.Plateau;

public class Map {

	private String Nom;
    private ParseurXML myParseurXML;
    private Plateau myPlateau;
    private ArrayList<Case>  listeCases;
//-------------------------------- CONSTRUCTEUR --------------------------------//   
    public Map(String nom,Plateau plateau,ArrayList<Case> listeCases){
    	setNom(nom);
    	setMyPlateau(plateau);
    	setListeCases(listeCases);
    }

//-------------------------------- SETTERS AND GETTERS --------------------------------//
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public ParseurXML getMyParseurXML() {
		return myParseurXML;
	}
	public void setMyParseurXML(ParseurXML myParseurXML) {
		this.myParseurXML = myParseurXML;
	}
	public Plateau getMyPlateau() {
		return myPlateau;
	}
	public void setMyPlateau(Plateau myPlateau) {
		this.myPlateau = myPlateau;
	}
	public ArrayList<Case> getListeCases() {
		return listeCases;
	}
	public void setListeCases(ArrayList<Case> listeCases) {
		this.listeCases = listeCases;
	}
//---------------------------------------Autres méthodes-------------------------------//
	  public void charger(Map map) {
	  }
	  public void enregistrer(Map map) {
	  }
	  public Map rafraichir(Map map){
		  return map;
	  }

}