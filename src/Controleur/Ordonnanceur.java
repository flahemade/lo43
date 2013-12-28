package Controleur;

import java.util.ArrayList;

import Modele.*;

import Modele.Map;
import Vue.ActionUtilisateur;
import Vue.FenetreAccueil;
import Vue.Plateau;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Ordonnanceur {
	
	/** boolean qui indique si le jeu est en pause ou pas */
	public Boolean pause;
	/** la map */
	private Map map;
	/** le parseur */
	private XMLParser monXML;
	/** liste de tous les éléments du jeu */
	private ArrayList<Element> listeElement;
	/** partie utilisateur */
	private ActionUtilisateur utilisateur;
	

	//-------------------------------------------CONSTRUCTEUR---------------------------//
	/*_______________________________________________________________*/
	/**
	 * 
	 */
	public Ordonnanceur(){
		/*FenetreAccueil fen = new FenetreAccueil("Le jeu de la savane");
		fen.setVisible(true);*/
		Plateau fen_plateau = new Plateau("Le jeu de la savane");
		fen_plateau.setVisible(true);
		monXML = new XMLParser("./res/8x8_simple.xml");
		ArrayList<Case> mesCases;
		mesCases= monXML.parseXML();
		map = new Map("Savane", mesCases);
		fen_plateau.setMyMap(getMap());
		listeElement = new ArrayList<Element>();
		fen_plateau.afficherMap(getMap());
		/*for (int i = 0; i< getMap().getListeCases().size(); i++)
		{
			for(int j=0; j< getMap().getListeCases().get(i).getListeElements().size(); j++)
			{
				listeElement.add(getMap().getListeCases().get(i).getListeElements().get(j));
			}
		}*/
		//Position p = getMap().getListeCases().get(12).getListeElements().get(0).seDeplacer(getMap().getListeCases().get(12).getPosition());
		
		
		
	}
	//-------------------------------------------GETTERS AND SETTERS---------------------//
	/*_______________________________________________________________*/
	/**
	 * @return vrai ou faux
	 */
	public Boolean getPause() {
		return pause;
	}
	/*_______________________________________________________________*/
	/**
	 * @return la map
	 */
	public Map getMap(){
		return map;
	}
	/*_______________________________________________________________*/
	/**
	 * @param map
	 */
	public void setMap(Map map){
		this.map=map;
	}
	/*_______________________________________________________________*/
	/**
	 * @param pause
	 */
	public void setPause(Boolean pause) {
		this.pause = pause;
	}
	
	/*_______________________________________________________________*/
	/** Permet d'obtenir la valeur du champ monXML.
	 * @return la valeur du champ monXML.
	 */
	public XMLParser getMonXML()
	{
		return monXML;
	}
	/*_______________________________________________________________*/
	/** Modifie la valeur du champ monXML.
	 * @param monXML la nouvelle valeur du champ monXML.
	 */
	public void setMonXML(XMLParser monXML)
	{
		this.monXML = monXML;
	}
	
	/*_______________________________________________________________*/
	/** Permet d'obtenir la valeur du champ listeElement.
	 * @return la valeur du champ listeElement.
	 */
	public ArrayList<Element> getListeElement()
	{
		return listeElement;
	}
	/*_______________________________________________________________*/
	/** Modifie la valeur du champ listeElement.
	 * @param listeElement la nouvelle valeur du champ listeElement.
	 */
	public void setListeElement(ArrayList<Element> listeElement)
	{
		this.listeElement = listeElement;
	}
	//-------------------------------------------AUTRES METHODES-------------------------//
	
	
	/*_______________________________________________________________*/
	/**
	 */
	public void run() {
		  while(this.pause==false){
			  // Jouer...
			  //Fais jouer la map :
			  //	-R�cup�rer tous les animaux vivants
			  /*ArrayList<Animal> listeAnimaux=this.map.getListeAnimaux();
			  for(Integer i=0;listeAnimaux.size()<=i;i++){
				  
				  Animal animal=listeAnimaux.get(i);
				  Integer caseCible=null;
				  //V�rification �ge
				  Boolean vivant=animal.verifierAge();
				  if(vivant==false){
					  animal.mourir();
				  }
				  //D�finir case cible
				  Integer vitesse=animal.getVitesse();
				  for(Integer j=0;j<=vitesse;j++){
					  Integer direction=(int)(Math.random()*3)+1;
					  caseCible=animal.getIdCase();
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
//					-Boucle activit� pour chacun  
				  ArrayList<Element> attributsCase=caseCible.getListeElements();
				  Element attrRessource=attributsCase.get(0);
				  Element attrAnimal=attributsCase.get(1);
				  Element attrObstacle=attributsCase.get(2);
				  if(attrAnimal==null&&attrRessource==null){
					  //On peut aller sur la case sans consequence.
				  }else{
					  //Cons�quence
					  		//Animal
					  		//Ressource
					  		//Obstacle
				  }
			  }
			  // To be completed.
			  */
		  }
	}
	/*_______________________________________________________________*/
	/**met le jeu sur pause 
	 */
	public void stop(){
		  setPause(true);
	}
	
	  /*_______________________________________________________________*/
		/**
		 * @param args
		 */
		public static void main(String[] args) 
		  {
				Ordonnanceur ordonnanceur = new Ordonnanceur();
								
		  }

}