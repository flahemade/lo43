package Controleur;

import java.util.ArrayList;
import Modele.Animal;
import Modele.Map;

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
			  ArrayList<Animal> listeAnimaux=this.map.getListeAnimaux();
			  for(Integer i=0;listeAnimaux.size()<=i;i++){
				  
				  Animal animal=listeAnimaux.get(i);
				  
			  }
			  //		-Boucle activité pour chacun
		  }
	}
	public void stop(){
		  setPause(true);
	}

}