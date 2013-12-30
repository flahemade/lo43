package Controleur;

import java.util.ArrayList;

import Modele.*;
import Vue.ActionUtilisateur;
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
	
	private Plateau fen_plateau;
	

	//-------------------------------------------CONSTRUCTEUR---------------------------//
	/*_______________________________________________________________*/
	/**
	 * 
	 */
	public Ordonnanceur(){
		
		
		
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
	/**Initialise le plateau
	 */
	public void initPlateau()
	{
		/*FenetreAccueil fen = new FenetreAccueil("Le jeu de la savane");
		fen.setVisible(true);*/
		fen_plateau = new Plateau("Le jeu de la savane");
		fen_plateau.setVisible(true);
		//monXML = new XMLParser("./res/8x8_simple.xml");
		monXML = new XMLParser("./res/8x8_test.xml");
		ArrayList<Case> mesCases;
		mesCases= monXML.parseXML();
		map = new Map("Savane", mesCases);
		fen_plateau.setMyMap(getMap());
		listeElement = new ArrayList<Element>();
		fen_plateau.afficherMap(getMap());
		getListeAnimaux();
		getListeElement();
		getListeObstacles();
		getListeRessource();
		fen_plateau.afficherStat(getListeAnimaux().size(), getListeObstacles().size(), getListeRessource().size());
	}
	/*_______________________________________________________________*/
	/**
	 */
	public void run() {
		  if(this.pause=!false){
			  // Execute la m�thode live() de chaque animal.
			 ArrayList<Animal> listeAnimaux=this.getListeAnimaux();
			  for(Integer i=0; i<listeAnimaux.size();i++){
				  Position p = new Position();
				  for(int j=0; j< getMap().getListeCases().size(); j++)
				  {
					  if(getMap().getListeCases().get(j).getId()== listeAnimaux.get(i).getId())
					  {
						  p = getMap().getListeCases().get(j).getPosition();
						 //reste à enlever l'animal de la liste de la case
					  }
				  }
				  listeAnimaux.get(i).live(p);
				  //reste à rajouter l'animal dans la liste des éléments de la case
			  }
			// Essai de faire un rafraichissement à modifier bien sur !
			/*	Animal simba = new Animal();
				int indexNewCase=0;
				simba = (Animal) getMap().getListeCases().get(12).getListeElements().get(0);
				Position p = getMap().getListeCases().get(12).getListeElements().get(0).seDeplacer(getMap().getListeCases().get(12).getPosition());
				getMap().getListeCases().get(12).supprimerAnimal((Animal) getMap().getListeCases().get(12).getListeElements().get(0));
				for(int i=0; i<getMap().getListeCases().size(); i++)
				{
					if(getMap().getListeCases().get(i).getPosition().getX() == p.getX() && getMap().getListeCases().get(i).getPosition().getY() == p.getY())
					{
						getMap().getListeCases().get(i).addAnimal(simba);
						indexNewCase = i;
						System.out.println("ça rentre");
					}
				}
				System.out.println("nouvelle case: " + getMap().getListeCases().get(indexNewCase).getListeElements().size());
				try
				{
					Thread.sleep(5000);
				} catch (InterruptedException e)
				{
					// PENSER à IMPLEMENTER Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("coucou");*/
				fen_plateau.afficherMap(getMap());
				
			  // To be completed.
		  }
	}
	/*_______________________________________________________________*/
	/**met le jeu sur pause 
	 */
	public void stop(){
		  setPause(true);
	}
	/*_______________________________________________________________*/
	/**Sort les listes d'�l�ments
	 * @return la liste d'animaux
	**/
	
	public ArrayList<Animal> getListeAnimaux(){
		ArrayList<Animal> listeAnimaux=new ArrayList<Animal>();
		ArrayList<Case> listeCases=map.getListeCases();
		for(int i=0; i<listeCases.size(); i++){
			Case parcourir=listeCases.get(i);
			ArrayList<Element> listeElements=parcourir.getListeElements();
			for(int j=0; j<listeElements.size(); j++){
				Element element_temporaire=listeElements.get(j);
				if(element_temporaire instanceof Animal){
					Animal pouet=(Animal)(element_temporaire);
					listeAnimaux.add(pouet);
				}
			}
		}
		return listeAnimaux;
	}
	
	/*_______________________________________________________________*/
	/**
	 * @return une liste d'obstacle
	 */
	public ArrayList<Obstacle> getListeObstacles(){
		ArrayList<Obstacle> listeObstacles=new ArrayList<Obstacle>();
		ArrayList<Case> listeCases=map.getListeCases();
		for(int i=0; i<listeCases.size(); i++){
			Case parcourir=listeCases.get(i);
			ArrayList<Element> listeElements=parcourir.getListeElements();
			for(int j=0; j<listeElements.size(); j++){
				Element element_temporaire=listeElements.get(j);
				if(element_temporaire instanceof Obstacle){
					Obstacle pouet=(Obstacle)(element_temporaire);
					listeObstacles.add(pouet);
				}
			}
		}
		return listeObstacles;
	}
	
	/*_______________________________________________________________*/
	/**
	 * @return la liste des ressources
	 */
	public ArrayList<Ressource> getListeRessource(){
		ArrayList<Ressource> listeRessource=new ArrayList<Ressource>();
		ArrayList<Case> listeCases=map.getListeCases();
		for(int i=0; i<listeCases.size(); i++){
			Case parcourir=listeCases.get(i);
			ArrayList<Element> listeElements=parcourir.getListeElements();
			for(int j=0; j<listeElements.size(); j++){
				Element element_temporaire=listeElements.get(j);
				if(element_temporaire instanceof Ressource){
					Ressource pouet=(Ressource)(element_temporaire);
					listeRessource.add(pouet);
				}
			}
		}
		return listeRessource;
	}
	
	  /*_______________________________________________________________*/
		/**
		 * @param args
		 */
		public static void main(String[] args) 
		  {
				Ordonnanceur ordonnanceur = new Ordonnanceur();
				ordonnanceur.initPlateau();
				ordonnanceur.run();
		  }

}
