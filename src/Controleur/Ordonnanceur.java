package Controleur;

import java.util.ArrayList;

import Modele.Animal;
import Modele.Case;
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
				  //Vérification âge
				  Boolean vivant=animal.verifierAge();
				  if(vivant==false){
					  animal.mourir();
				  }
				  //Définir case cible
				  Integer vitesse=animal.getVitesse();
				  for(Integer j=0;j<=vitesse;j++){
					  Integer direction=(int)(Math.random()*3)+1;
					  Case caseCible=animal.getCaseLocation();
					  Integer numeroCase=caseCible.getId();
					  Integer largeurMap=0;
					  switch(direction){
					  	case 1: numeroCase=numeroCase-largeurMap;break;
					  	case 2: numeroCase=numeroCase+1;break;
					  	case 3: numeroCase=numeroCase+largeurMap;break;
					  	case 4: numeroCase=numeroCase-1;break;
					  }
					  caseCible.setId(numeroCase);
				  }
				  //-----------------------
				  
			  }
			  //		-Boucle activité pour chacun
		  }
	}
	public void stop(){
		  setPause(true);
	}

}