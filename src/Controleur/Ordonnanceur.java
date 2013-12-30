package Controleur;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

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
		/*A quoi servent les 4 lignes au dessous ?*/
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
		int i,j,k;
		  if(this.pause=!false){
			  map.rafraichirPositionElement();
			  for(i=0;i<map.getListeCases().size();i++){
				  map.getListeCases().get(i).setListeCasesAdjacentes(genererListeCaseAdjacentes(map.getListeCases().get(i)));
			  }
				  for(i=0;i<map.getListeCases().size();i++){
					  for(j=0;j<map.getListeCases().get(i).getListeCasesAdjacentes().size();j++){
						  System.out.println(map.getListeCases().get(i).getListeCasesAdjacentes().get(j).getId());
					  }
				  }
				 
			  // Execute la m�thode live() de chaque animal.
			 ArrayList<Animal> listeAnimaux=this.getListeAnimaux();
			 Case c=null;
			  for( i=0; i<listeAnimaux.size();i++){
				  for(j=0; j< map.getListeCases().size(); j++){
					  Case temp=map.getListeCases().get(j);
					  for(k=0; k<temp.getListeElements().size(); k++){
						  if(listeAnimaux.get(i).getId()==temp.getListeElements().get(k).getId()){
							  c = getMap().getListeCases().get(j);
							 //reste à enlever l'animal de la liste de la case
						  }
					  }
				  }
				  listeAnimaux.get(i).live(c);
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
	
	public ArrayList<Case> genererListeCaseAdjacentes (Case c){
		int i,j;
		//ArrayList<Animal>lanimaux = getListeAnimaux();
		int xanimal,yanimal;
		int xcase,ycase;
		int champvision;
		int cpt=0;
		ArrayList<Case>lcase = map.getListeCases();
		ArrayList<Case> listecasesadjacentes = new ArrayList<Case>();
		
		for(i=0;i<c.getListeElements().size();i++){
			
		if(c.getListeElements().get(i)instanceof Animal){
			xanimal = c.getListeElements().get(i).getPosition().getX();
			yanimal = c.getListeElements().get(i).getPosition().getY();
			champvision = c.getListeElements().get(i).getChampVision();
			System.out.println("Animal Position "+xanimal +" , "+yanimal);
			for(j=0;j<lcase.size();j++){
				xcase = lcase.get(j).getPosition().getX();
				ycase = lcase.get(j).getPosition().getY();
				
				if((xcase >= (xanimal-champvision)) && (xcase <= (xanimal+champvision))){ //Condition de limite de champ de vision en x
					if((ycase >= (yanimal-champvision))&& (ycase <= (yanimal+champvision))){ //condition de limite de champ de vision en y
						if((xcase == xanimal) && (ycase==yanimal)){
						}
						else{
						listecasesadjacentes.add(lcase.get(j));						
						System.out.println("\tAjout case adjac Position "+xcase+" , "+ycase);
					}
					}
				}
			
				
			}
		}
	}
		/*
		for(i=0;i<lanimaux.size();i++){
			xanimal = lanimaux.get(i).getPosition().getX();
			yanimal = lanimaux.get(i).getPosition().getY();
			champvision = lanimaux.get(i).getChampVision();
			System.out.println("Animal Position "+xanimal +" , "+yanimal);
			for(j=0;j<lcase.size();j++){
				xelement = lcase.get(i).getPosition().getX();
				yelement = lcase.get(i).getPosition().getY();
				if((xelement >= (xanimal-champvision)) && (xelement <= (xanimal+champvision))){ //Condition de limite de champ de vision en x
					if((yelement >= (yanimal-champvision))&& (yelement <= (yanimal+champvision))){ //condition de limite de champ de vision en y
						listecasesadjacentes.add(lcase.get(j));
						System.out.println("\tAjout case adjac Position "+xelement+" , "+yelement);
					}
				}
			}
		}
		*/
		return listecasesadjacentes;
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
