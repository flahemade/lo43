package Controleur;

import java.util.ArrayList;
import java.util.Random;

import Modele.Animal;
import Modele.Case;
import Modele.Element;
import Modele.Gazelle;
import Modele.Girafe;
import Modele.Hyene;
import Modele.Lion;
import Modele.Map;
import Modele.Obstacle;
import Modele.Plante;
import Modele.Ressource;
import Modele.Viande;
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
	/** le plateau du jeu */
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
	
	/*_______________________________________________________________*/
	/** Permet d'obtenir la valeur du champ utilisateur.
	 * @return la valeur du champ utilisateur.
	 */
	public ActionUtilisateur getUtilisateur()
	{
		return utilisateur;
	}
	/*_______________________________________________________________*/
	/** Modifie la valeur du champ utilisateur.
	 * @param utilisateur la nouvelle valeur du champ utilisateur.
	 */
	public void setUtilisateur(ActionUtilisateur utilisateur)
	{
		this.utilisateur = utilisateur;
	}
	
	//-------------------------------------------AUTRES METHODES-------------------------//
	
	
	/*_______________________________________________________________*/
	/**Initialise le plateau
	 */
	public void initPlateau()
	{
		utilisateur = new ActionUtilisateur();
		(new Thread(utilisateur)).start();	
		
		/*FenetreAccueil fen = new FenetreAccueil("Le jeu de la savane");
		fen.setVisible(true);*/
		fen_plateau = new Plateau("Le jeu de la savane", getUtilisateur());
		fen_plateau.setVisible(true);
		//monXML = new XMLParser("./res/8x8_simple.xml");
		monXML = new XMLParser("./res/16x16_presentation.xml");
		ArrayList<Case> mesCases;
		mesCases= monXML.parseXML();
		map = new Map("Savane", mesCases);
		fen_plateau.setMyMap(getMap());
		listeElement = new ArrayList<Element>();
		fen_plateau.afficherMap(getMap());
		fen_plateau.afficherStat(getListeAnimaux().size(), getListeObstacles().size(), getListeRessource().size());

	}
	/*_______________________________________________________________*/
	/**
	 */
	public void run() 
	{
		int i,j,k;
		ArrayList<Element> listeElementASupprimer = new ArrayList<Element>();
		faireActionUtilisateur();
		if(this.pause=!false)
		{
			map.rafraichirPositionElement();
			for(i=0;i<map.getListeCases().size();i++)
			{
				map.getListeCases().get(i).setListeCasesAdjacentes(genererListeCaseAdjacentes(map.getListeCases().get(i)));
			}
			for(i=0;i<map.getListeCases().size();i++)
			{
				/*for(j=0;j<map.getListeCases().get(i).getListeCasesAdjacentes().size();j++)
				{
					System.out.println(map.getListeCases().get(i).getListeCasesAdjacentes().get(j).getId());
				}
				*/
			}
			// Execute la m�thode live() de chaque animal.
			ArrayList<Animal> listeAnimaux=this.getListeAnimaux();
			Case c=null;
			for( i=0; i<listeAnimaux.size();i++)
			{
				for(j=0; j< map.getListeCases().size(); j++)
				{
					Case temp=map.getListeCases().get(j);
					for(k=0; k<temp.getListeElements().size(); k++)
					{
						if(listeAnimaux.get(i).getId()==temp.getListeElements().get(k).getId())
						{
							c = getMap().getListeCases().get(j);
							//reste à enlever l'animal de la liste de la case
						}
					}
				}
				Element e = listeAnimaux.get(i).live(c);
				if(e!= null)
					listeElementASupprimer.add(e); // ajoute à la liste les éléments à supprimer de la map
				e = null;
				if(listeElementASupprimer.size()!=0)
					supprimerElements(listeElementASupprimer); // supprimer les éléments "mangés" de la map
				
				
				  //reste à rajouter l'animal dans la liste des éléments de la case
			}
			
			fen_plateau.afficherMap(map);
				
		}
	}
	/*_______________________________________________________________*/
	/**
	 */
	private void faireActionUtilisateur()
	{
		if(utilisateur.getAction()!= -1 && fen_plateau.getActionCase()!= -1) //si l'utilisateur a appuyer sur un des éléments
		{
			System.out.println("actionUtilisateur : " + utilisateur.getAction());
			for(int num=0; num<map.getListeCases().size(); num++)
			{
				if(map.getListeCases().get(num).getId() == fen_plateau.getActionCase())
				{
					for(int i=0; i<map.getListeCases().get(num).getListeElements().size(); i++)
					{
						if(map.getListeCases().get(num).getListeElements().get(i) instanceof Obstacle)
							map.getListeCases().get(num).supprimerObstacle((Obstacle) map.getListeCases().get(num).getListeElements().get(i));
					}
					Random rand = new Random();
					int valeur = rand.nextInt(2);
					boolean sexeAnimal;
					if (valeur == 1)
						sexeAnimal = true;
					else sexeAnimal = false;
					switch (utilisateur.getAction())
					{
						case 0: map.getListeCases().get(num).addAnimal(new Gazelle(fen_plateau.getActionCase(), sexeAnimal)); 
								break;
						case 1: map.getListeCases().get(num).addAnimal(new Girafe(fen_plateau.getActionCase(), sexeAnimal)); 
								break;
						case 2: map.getListeCases().get(num).addAnimal(new Hyene(fen_plateau.getActionCase(), sexeAnimal)); 
								break;
						case 3: map.getListeCases().get(num).addAnimal(new Lion(fen_plateau.getActionCase(), sexeAnimal)); 
								break;
						case 4: map.getListeCases().get(num).addObstacle(new Obstacle(fen_plateau.getActionCase())); 
								break;
						case 5: map.getListeCases().get(num).addRessource(new Plante(fen_plateau.getActionCase())); 
								break;
						case 6: map.getListeCases().get(num).addRessource(new Viande(fen_plateau.getActionCase())); 
								break;
						case 7 : 
							
								System.out.println("toto");
								supprimerElements(map.getListeCases().get(num).getListeElements());
							
							break;
						default:
							break;
					}
					
				}
			}
			fen_plateau.setActionCase(-1);
			fen_plateau.afficherMap(getMap());
		}
		
	}
	
	
	/*_______________________________________________________________*/
	/**Suppression des élements par l'utilisateur
	 */
	private void supprimerElementDeCase()
	{
		if(utilisateur.getBtn_supprimer().isSelected() && fen_plateau.getActionCase()!=-1)
		{
			System.out.println("toto");
			for(int num=0; num<map.getListeCases().size(); num++)
			{
				if(map.getListeCases().get(num).getId() == fen_plateau.getActionCase())
				{
					/*for(int i=0; i<map.getListeCases().get(num).getListeElements().size(); i++)
					{
						if(map.getListeCases().get(num).getListeElements().get(i) instanceof Obstacle)
							map.getListeCases().get(num).supprimerObstacle((Obstacle) map.getListeCases().get(num).getListeElements().get(i));
					}*/
					supprimerElements(map.getListeCases().get(num).getListeElements());
				}
			}	
		}
		fen_plateau.setActionCase(-1);
		fen_plateau.afficherMap(getMap());
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
	 * @param c
	 * @return la liste des cases adjacentes
	 */
	public ArrayList<Case> genererListeCaseAdjacentes (Case c)
	{
		int i,j;
		//ArrayList<Animal>lanimaux = getListeAnimaux();
		int xanimal,yanimal;
		int xcase,ycase;
		int champvision;
		ArrayList<Case>lcase = map.getListeCases();
		ArrayList<Case> listecasesadjacentes = new ArrayList<Case>();
		
		for(i=0;i<c.getListeElements().size();i++)
		{
			if(c.getListeElements().get(i)instanceof Animal)
			{
				xanimal = c.getListeElements().get(i).getPosition().getX();
				yanimal = c.getListeElements().get(i).getPosition().getY();
				champvision = c.getListeElements().get(i).getChampVision();
				System.out.println("Animal Position "+xanimal +" , "+yanimal);
				for(j=0;j<lcase.size();j++)
				{
					xcase = lcase.get(j).getPosition().getX();
					ycase = lcase.get(j).getPosition().getY();
					if((xcase >= (xanimal-champvision)) && (xcase <= (xanimal+champvision)))
					{ //Condition de limite de champ de vision en x
						if((ycase >= (yanimal-champvision))&& (ycase <= (yanimal+champvision)))
						{ //condition de limite de champ de vision en y
							if((xcase == xanimal) && (ycase==yanimal))
							{
							}
							else
							{
								listecasesadjacentes.add(lcase.get(j));						
								//System.out.println("\tAjout case adjac Position "+xcase+" , "+ycase);
							}
						}
					}
				
					
				}
			}
		}
		
		return listecasesadjacentes;
	}
	
	/**
	 * Permet de trier la liste par ordre de position croissante
	 * 
	 * @param l ArrayList<Element> liste d'Element non-triee
	 * @return ArrayList<Element> liste d'Element triee
	 */
	@SuppressWarnings("unused")
	private ArrayList<Element> trierListeParPosition (ArrayList<Element> l){
		
		
		int i;
		Boolean permut;
		//Trier la liste par ordre croissant d'id de case
		do {
			// hypothèse : la liste est triée
			permut = false;
			for ( i = 0; i < l.size() - 1; i++) {
				// Teste si 2 éléments successifs sont dans le bon ordre ou non
				
				if (l.get(i).getPosition().getX() > l.get(i+1).getPosition().getX() || (l.get(i).getPosition().getX() <= l.get(i+1).getPosition().getX() && l.get(i).getPosition().getY() <= l.get(i+1).getPosition().getY())) {
					// s'ils ne le sont pas, on échange leurs positions
					l.add(i, l.get(i+1));
					l.remove(i+2);
					permut = true;
					
				}
				
			}
		} while (permut);

	return l;
	}
	
	/*_______________________________________________________________*/
	/**
	 * Permet de supprimer du jeu les Element contenus dans la liste
	 * @param listeElements ArrayList<Element> liste des Element a supprimer
	 */
	private void supprimerElements(ArrayList<Element> listeElements)
	{
		for(int i = 0; i<getMap().getListeCases().size(); i++)
		{
			for(int j = 0; j< listeElements.size(); j++)
			{
				
				if(getMap().getListeCases().get(i).getPosition().getX() == listeElements.get(j).getPosition().getX() && getMap().getListeCases().get(i).getPosition().getY() == listeElements.get(j).getPosition().getY())
				{
					//System.out.println(listeElements.get(j).getId());
					if(listeElements.get(j) instanceof Animal)
						getMap().getListeCases().get(i).supprimerAnimal((Animal)listeElements.get(j));
					if(listeElements.get(j) instanceof Obstacle)
						getMap().getListeCases().get(i).supprimerObstacle((Obstacle)listeElements.get(j));
					if(listeElements.get(j) instanceof Ressource)
						getMap().getListeCases().get(i).supprimerRessource((Ressource)listeElements.get(j));
				}
			}
		}
	}
	
	
	/*_______________________________________________________________*/
	/**
	 */
	public void updateGUI()
	{
		fen_plateau.afficherStat(getListeAnimaux().size(), getListeObstacles().size(), getListeRessource().size());
		fen_plateau.afficherMap(getMap());
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// PENSER à IMPLEMENTER Auto-generated catch block
			e.printStackTrace();
		}
	}
	  /*_______________________________________________________________*/
		/**
		 * @param args
		 */
		public static void main(String[] args) 
		  {
				Ordonnanceur ordonnanceur = new Ordonnanceur();
				ordonnanceur.initPlateau();
				for(;;){
				ordonnanceur.run();
				ordonnanceur.updateGUI();
				
				}
		  }

}
