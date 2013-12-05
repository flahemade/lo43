package Modele;
import java.util.ArrayList;

import Vue.Plateau;

public class Map {

	private String Nom;
    private ParseurXML myParseurXML;
    private Plateau myPlateau;
    /**
   * 
   * @element-type Case
   */
    private ArrayList<Case>  listeCases;

  public void charger(Map map) {
  }

  public void enregistrer(Map map) {
  }

  public Map rafraichir(Map map){
	  return map;
  }

}