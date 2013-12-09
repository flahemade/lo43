package Controleur;

import Modele.*;

public class Ordonnanceur {
	private Boolean pause;
	private Map map;
	//-------------------------------------------CONSTRUCTEUR---------------------------//
	public Ordonnanceur(Map map){
		setPause(true);
		setMap(map);
	}
	//-------------------------------------------GETTERS AND SETTERS---------------------//
	public Boolean getPause() {
		return pause;
	}
	public Map getMap(){
		return map;
	}
	public void setMap(Map map){
		this.map=map;
	}
	public void setPause(Boolean pause) {
		this.pause = pause;
	}
	//-------------------------------------------AUTRES METHODES-------------------------//
	public void run() {
		  while(this.pause==false){
			  // Jouer...
			  //Fais jouer la map :
			  //	-Récupérer tous les animaux vivants
			  //		-Boucle activité pour chacun
		  }
	}
	public void stop(){
		  setPause(true);
	}

}