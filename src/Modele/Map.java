package Modele;
import java.util.ArrayList;

import Vue.Plateau;

public class Map {

	private String Nom;
    private XMLParser myParseurXML;
    private Plateau myPlateau;
    private ArrayList<Case>  listeCases;
    private ArrayList<Animal> listeAnimaux;
//-------------------------------- CONSTRUCTEUR --------------------------------//   
    public Map(String nom,Plateau plateau){
    	setNom(nom);
    	setMyPlateau(plateau);
    }
//-------------------------------- SETTERS AND GETTERS --------------------------------//
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public XMLParser getMyParseurXML() {
		return myParseurXML;
	}
	public void setMyParseurXML(XMLParser myParseurXML) {
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
	public ArrayList<Animal> getListeAnimaux() {
		return listeAnimaux;
	}
	public void setListeAnimaux(ArrayList<Animal> listeAnimaux) {
		this.listeAnimaux = listeAnimaux;
	}
//---------------------------------------Autres m�thodes-------------------------------//
	  public void charger(Map map) {
	  }
	  public void enregistrer(Map map) {
	  }
	  public Map rafraichir(Map map){
		  return map;
	  }
}