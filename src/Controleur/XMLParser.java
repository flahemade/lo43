package Controleur;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import Modele.Animal;
import Modele.Case;
import Modele.Dimension;
import Modele.Gazelle;
import Modele.Girafe;
import Modele.Hyene;
import Modele.Lion;
import Modele.Obstacle;
import Modele.Plante;
import Modele.Position;
import Modele.Ressource;
import Modele.TypeAnimal;
import Modele.TypeRessource;
import Modele.TypeTerrain;
import Modele.Viande;


/*_______________________________________________________________*/


/**
 * 
 * Cette classe permet de générer une ArrayList<Case> contenant la carte, les espèces,
 * obstacles ainsi que les ressource contenue dans un fichier XML
 * @author nicolas
 *
 */


public class XMLParser{

/** -----attributes definitions-----*/
	
  private String path; /* Chemin relatif vers le fichier XML*/
  private Document document;

/** 
 * Initialise le Parser et charge le document XML se trouvant à l'adresse chemin
 * 
 * @param chemin chemin relatif vers le fichier à parser
 */
  public XMLParser(String chemin){
	  try {
	  
	  DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance(); 
	  DocumentBuilder constructeur = fabrique.newDocumentBuilder();
	  File xml = new File(chemin);
	  document = constructeur.parse(xml); //On charge le XML dans document, tout le reste ce fera à partir de ce dernier
	  
	  }catch(Exception e){
		  //TODO Gerer l'exception
	  }
	  
  }
	  

  
/*-------- Getters & setters ------*/
  /**
   * Retourne la valeur du champ Path
   * @return String chemin relatif vers le fichier
   */
 public String getPath() {
	return path;
}

 /**
  * set le chemin relaif vers le fichier XML
  * @param path String  
  */
public void setPath(String path) {
	this.path = path;
}

/*------------ Methodes ------------*/


/**
 * Parse le fichier XML pour generer une liste des Cases de la map
 * @return Une liste de Case 
 */
public ArrayList<Case> parseXML(){
	
	NodeList list = document.getDocumentElement().getChildNodes(); //On recupere le premier niveau de Node (map & espece)
	int i;
	Dimension dimensionmap= new Dimension();
	ArrayList<Case>listefinale = new ArrayList<Case>();
	ArrayList<Case> listecase = new ArrayList<Case>();
	ArrayList<Animal> listeanimaux = new ArrayList<Animal>();
	ArrayList<Obstacle> listeobstacle = new ArrayList<Obstacle>();
	ArrayList<Ressource> listeressource = new ArrayList<Ressource>();
	Case casedefaut= new Case(0,new Position(),TypeTerrain.TERRE);
	//System.out.println("Debut du parcours du XML"); //DEBUG
	
		//System.out.println(list.item(i).getNodeName()); //DEBUG


			for (i = 0; i<list.getLength();i++){ 							
			switch(enumBourrin(list.item(i).getNodeName())){ 

			case 1 : //Cas où la node "map" est detectee, on lance la fonction mapParser(NodeListe l)
			dimensionmap = getDimension(list.item(i));
			listecase = parseMap(list.item(i).getChildNodes());
			casedefaut = getCaseDefaut(list.item(i));
			
		/*	System.out.println("CaseDefaut : id "+casedefaut.getId()+
					" , Taille "+casedefaut.getTaille()+
					" , Type "+casedefaut.getType()+
					" , Position "+casedefaut.getPosition().getX()+" , "+casedefaut.getPosition().getY());
		*/			
			break;
			
			case 2 :
			listeanimaux = parseEspece(list.item(i).getChildNodes());
			break;
			
			case 17 : 
			listeobstacle = parseObstacle(list.item(i).getChildNodes());     //Cas où la node objet est detectee
			listeressource = parseRessource(list.item(i).getChildNodes());
			break;
			
			default :break ; //Si autre chose que "map" ou "espece" on ne fait rien
			
			}
			}
					/*for(i=0;i<listefinale.size();i++){
						System.out.println("ListeFinale : ID_Case "+listefinale.get(i).getId());
					}
					*/
			listefinale=trierListe(listecase);
			listefinale=reparerListe(listefinale, dimensionmap, casedefaut);
					//listeobstacle=genererCeintureObstacle(listeobstacle, dimensionmap);
			listefinale=assemblerCaseObstacle(listecase, listeobstacle);
			listefinale=assemblerCaseAnimal(listecase, listeanimaux);
			listefinale=assemblerCaseRessource(listecase, listeressource);
					
					/*
					System.out.println("CPT "+cpt);
					for(i=0;i<listefinale.size();i++){
						System.out.println("CaseFinale id\t"+listefinale.get(i).getId()+"\ttype "+listefinale.get(i).getType()+"\tposition\t"+listefinale.get(i).getPosition().getX()+" , "+listefinale.get(i).getPosition().getY());
					}
					*/
					/*for(i=0;i<listeobstacle.size();i++)
						System.out.println("Obstacle"+listeobstacle.get(i).getId()+
								" CaseId "+listeobstacle.get(i).getCaseId());
					}
					*/
			return listefinale;
	}
/**
 * Fonction qui retourne un entier en fonction de la String pris en attribut afin de faire fonctionner les switch case
 * devrait pouvoir etre remplace par un enum
 * Si la String n'est pas une node contenue dans le .XML, la fonction retourne 0;
 * @param node Nom de la Node
 * @return Un entier propre à la chaine de caractere d'entrée si elle existe, sinon 0;
 */
//TODO Remplacer enumBourrin par quelque chose de propre
private int enumBourrin (String node){
	int i = 0;
	String node2 =node.toLowerCase().trim();
	if(node2 == "map"){
		i = 1;
	}
	if(node2 == "espece"){
		i = 2;
	}
	if(node2 == "case"){
		i = 3;
	}
	if(node2 == "taille"){
		i = 4;
	}
	if(node2 == "position"){
		i = 5;
	}
	if(node2 == "x"){
		i = 6;
	}
	if(node2 == "y"){
		i = 7;
	}
	if(node2 == "type"){
		i = 8;
	}
	if(node2 == "animal"){
		i = 9;
	}
	if(node2 == "nomclass"){
		i = 10;
	}
	if(node2 == "element"){
		i = 11;
	}
	if(node2 == "caseid"){
		i = 12;
	}
	if(node2 == "obstacle"){
		i = 13;
	}
	if(node2 == "ressource"){
		i = 14;
	}
	if(node2 == "lion"){
		i = 15;
	}
	if(node2 == "gazelle"){
		i = 16;
	}
	if(node2 == "objet"){
		i = 17;
	}
	return i;
}

/**
 * Génère une case par défaut à partir du fichier XML
 * @param n il doit s'agir de la node <map>
 * @return une Case dont la positiob et l'id doivent être mis à jour avant d'être utilisable
 */
private Case getCaseDefaut(org.w3c.dom.Node n){
	int id =-1;
	Position position=new Position();
	TypeTerrain type = TypeTerrain.TERRE;
	
	
	if(n.hasAttributes()){	

		if(n.getAttributes().getNamedItem("defaut_type_case")!=null){
			/* Si l'attribut "defaut_type_case" = "eau"*/
			if(n.getAttributes().getNamedItem("defaut_type_case").getNodeValue().toLowerCase().trim().equals("eau")){
				type = TypeTerrain.EAU; //Alors on set le type à EAU
			}
		}
	}
	 
	 return new Case(id,position,type); //Return de la case par defaut
}

/**
 * N'EST PLUS UTILISE
 * Recupere l'attribut taille de la classe Case contenue dans le XML
 * Si la node <case> ne contient pas d'enfant <taille> (cf XML) alors la fonction retourne -1
 * Sinon retourne la taille contenue entre <taille></taille>  au format Integer
 * @param l
 * @return Integer Taille
 */
@SuppressWarnings("unused")
private Integer getTaille(NodeList l){ //TODO Ajouter une gestion de l'attribut "default"
	Integer taille = -1;
	int i;
	for(i=0;i<l.getLength();i++)
	{
		if(l.item(i).getNodeName().toLowerCase()=="taille")
		{
			try{
			taille = Integer.parseInt(l.item(i).getTextContent().trim());
			}
			catch(Exception e){
				
			}
		}
	}
	return taille;
}
/**
 * Recupere l'attribut Type (TERRE, EAU...) de la Case
 * @param l NodeList 
 * @return Enum TypeTerrain
 */
private TypeTerrain getTypeTerrain(NodeList l){
	int i;
	TypeTerrain type = TypeTerrain.TERRE; //Terre par defaut
	for(i=0;i<l.getLength();i++) //Parcours de la liste
	{
		if(l.item(i).getNodeName().toLowerCase().trim()=="type")
		{
			
			if(l.item(i).getTextContent().trim().toLowerCase().equals("eau")){
				//System.out.println("PASSED");
				type = TypeTerrain.EAU; 
			}
		}
		

	}
	return type;
}

/**
 * Recupere le Type d'animal (Lion, Gazelle, Hyene, Girafe)
 * @param l NodeList 
 * @return Enum TypeAnimal
 */
private TypeAnimal getTypeAnimal(NodeList l){
	int i;
	TypeAnimal type = TypeAnimal.GAZELLE;
	for(i=0;i<l.getLength();i++)
	{
		
		if(l.item(i).getNodeName().toLowerCase().equals("type"))
		{
			if(l.item(i).getTextContent().trim().toLowerCase().equals("lion")){
				type = TypeAnimal.LION;
			}
			if(l.item(i).getTextContent().trim().toLowerCase().equals("hyene")){
				type = TypeAnimal.HYENE;
			}
			if(l.item(i).getTextContent().trim().toLowerCase().equals("girafe")){
				type = TypeAnimal.GIRAFE;
			}
		}
		

	}
	return type;
}

/**
 * Recupère le Type de ressource (Plante, Viande)
 * @param l NodeList
 * @return enum TypeRessource
 */
private TypeRessource getTypeRessource(NodeList l){
	
	int i;
	TypeRessource type = TypeRessource.PLANTE;
	for(i=0;i<l.getLength();i++){
		
		if(l.item(i).getTextContent().toLowerCase().trim().equals("plante")){
			type = TypeRessource.PLANTE;
		}
		if(l.item(i).getTextContent().toLowerCase().trim().equals("viande")){
			type = TypeRessource.VIANDE;
		}
	}
	return type;
}
/**
 * Recupere les attribution position x et y de la classe Case à partir du XML et les retourne au format Position
 * @param l NodeList
 * @return La Position de la case
 */
private Position getPosition(NodeList l){
	int i,j;
	Position position=new Position();
	for(i=0;i<l.getLength();i++)
	{
		if(l.item(i).getNodeName().toLowerCase().trim()=="position")
		{
			NodeList enfant = l.item(i).getChildNodes();
			for(j=0;j<enfant.getLength();j++){
				switch(enumBourrin(enfant.item(j).getNodeName())){
				case 6: 
						try{
						position.setX(Integer.parseInt(enfant.item(j).getTextContent().trim()));
					}
					catch(Exception e){
						position.setX(-1);
					}
					break;
				case 7: 
						try{
						position.setY(Integer.parseInt(enfant.item(j).getTextContent().trim()));
					}
					catch(Exception e){
						position.setY(-1);
					}
					break;
				default : break;
				}
			}
		}
	}
	return position;
}

/**
 * Retourne l'attribut id de la Node
 * @param n org.w3c.dom.Node
 * @return int id
 */
private Integer getId(org.w3c.dom.Node n){
	Integer id =-1;
	
	if(n.hasAttributes()){	

		if(n.getAttributes().getNamedItem("id")!=null){
			try{
				id = Integer.parseInt(n.getAttributes().getNamedItem("id").getNodeValue().trim());	
			}catch (Exception e){
				//TODO Gerer l'exception
				
			}
		}
	}		
	return id;
}

/**
 * Recupere la valeur du champ caseid et
 * @param l NodeList	
 * @return Integer caseid
 */
private Integer getCaseId(NodeList l){
	Integer id =-1;
	int i;
	for(i=0;i<l.getLength();i++)
	{
		if(l.item(i).getNodeName().toLowerCase()=="caseid")
		{
			try{
			id = Integer.parseInt(l.item(i).getTextContent().trim());
			}
			catch(Exception e){
				
			}
		}
	}
	return id;
}

/**
 * Recupere les attributs "length" et "width" de la node <map>
 * @param n org.w3c.dom.Node
 * @return Dimension La Dimension de la map
 */
private Dimension getDimension(org.w3c.dom.Node n){
	
	Dimension dimension=new Dimension();
	
	if(n.hasAttributes()){	

		if(n.getAttributes().getNamedItem("width")!=null){
			try{
				dimension.setWidth(Integer.parseInt(n.getAttributes().getNamedItem("width").getNodeValue().trim()));
			}catch (Exception e){
				//TODO Gerer l'exception
			}
		}
		
		if(n.getAttributes().getNamedItem("length")!=null){
			try{
				dimension.setLength(Integer.parseInt(n.getAttributes().getNamedItem("length").getNodeValue().trim()));
			}catch (Exception e){
				//TODO Gerer l'exception
			}
		}
	}	
	return dimension;
}
/*n'est plus utilisé*/
@SuppressWarnings("unused")
private String getNomClass(NodeList l){ 
	
	int i;
	String nomclass="";
	
	for(i=0;i<l.getLength();i++)
	{
		if(l.item(i).getNodeName().toLowerCase()=="nomclass")
		{
			nomclass = l.item(i).getTextContent().toLowerCase().trim();
		}
	}
	return nomclass;
}
/**
 * Recupere le sexe de l'animal
 * @param l NodeList
 * @return Boolean sexe (true = male, false = femelle)
 */
private Boolean getSexe(NodeList l){
	int i;
	Boolean sexe = true; //Par defaut male 
	
	for(i=0;i<l.getLength();i++)
	{
		if(l.item(i).getNodeName().toLowerCase()=="sexe")
		{
			if(l.item(i).getTextContent().toLowerCase().matches("femelle")){ //Pourquoi une simple comparaison ne fonctionne pas ?!
				sexe = false;
			}
			/*if(l.item(i).getTextContent().toLowerCase()=="femelle"){
				sexe=false;System.out.println("debug");
			}*/
		}
	}
	
	return sexe;
}
/**
 * Recupere les differentes case definies dans le XML et creer une liste de case qui sera ensuite retournée
 * @param l NodeList
 * @return ArrayList<Case> Liste de Case ne contenant aucun element
 */
private ArrayList <Case> parseMap(NodeList l){
	int i;
	Integer id;
	Position position;
	TypeTerrain type=TypeTerrain.TERRE;
	ArrayList<Case> listecase = new ArrayList<Case>();
	
	for(i=0;i<l.getLength();i++){
		switch (enumBourrin(l.item(i).getNodeName())){
		
		case 3: 
		type= getTypeTerrain(l.item(i).getChildNodes());
		position = getPosition(l.item(i).getChildNodes());
		id = getId(l.item(i));
		listecase.add(new Case(id,position,type)); 
				/*
				System.out.println("Case : id : "+id +
						", Type : "+type.name()+
						", Position : "+position.getX()+ 				//DEBUG
						" , "+position.getY());
				*/
				
		break;
		default : break;
		}
		
	}
	
	return listecase;
	
}

/**
 * Recupere les differentes animaux definies dans le XML et creer une liste d'animaux
 * @param l NodeList
 * @return ArrayList<animal> Liste des animaux présents dans le parser
 */
private ArrayList<Animal> parseEspece(NodeList l){
	
	int i;
	ArrayList<Animal> listeanimaux = new ArrayList<Animal>();
	//Integer id;
	Integer caseid;
	//String nomclass;
	Boolean sexe;
	TypeAnimal type = TypeAnimal.GAZELLE;
	for(i=0;i<l.getLength();i++){
		switch (enumBourrin(l.item(i).getNodeName())){
		
		case 9 :
		caseid = getCaseId(l.item(i).getChildNodes());
		//nomclass = getType(l.item(i).getChildNodes());
		type = getTypeAnimal(l.item(i).getChildNodes());
		sexe = getSexe(l.item(i).getChildNodes());
			switch(type){
			case LION : listeanimaux.add(new Lion(caseid, sexe));break; //Creation d'une classe Lion & ajout dans listeanimaux
			case GAZELLE : listeanimaux.add(new Gazelle(caseid, sexe)); break; //Creation classe Gazelle & ajout dans listeanima
			case GIRAFE : listeanimaux.add(new Girafe(caseid, sexe));break;
			case HYENE: listeanimaux.add(new Hyene(caseid, sexe)); break;
			default : break;
			}
				/*
				System.out.println("Animal : "+
						", type : "+type.toString()+
						", caseID : "+caseid+
						", sexe : "+sexe);
				*/		
		break;
		}
	}
	return listeanimaux;
}

/**
 * Recupere les differents obstacles definis dans le XML.
 * @param l NodeList
 * @return ArrayList<Obstacle> Liste d'obstacles
 */
private ArrayList<Obstacle> parseObstacle(NodeList l){
	int i;
	//Integer id =-1;
	Integer caseid=-1;
	ArrayList<Obstacle> listeobstacle = new ArrayList<Obstacle>();
	
	for(i=0;i<l.getLength();i++){
		
		if(l.item(i).getNodeName().toLowerCase().trim()=="obstacle"){
			//id = getId(l.item(i));
			caseid = getCaseId(l.item(i).getChildNodes());
			listeobstacle.add(new Obstacle(caseid));   //Ajout d'un obstacle à la listeobstacle
			/*System.out.println("Obstacle "+ //DEBUG
					" caseID : "+caseid);
			*/
		}
		
	}

	return listeobstacle;
}
/**
 * Recupere les differentes ressources definies dans le XML.
 * @param l NodeList
 * @return ArrayList<Ressource> Liste des ressources
 */
private ArrayList<Ressource> parseRessource(NodeList l){
	int i;
	int caseid=-1;
	TypeRessource type =null;
	ArrayList<Ressource> listeressource = new ArrayList<Ressource>();
	

	for(i=0;i<l.getLength();i++){
		
		if(l.item(i).getNodeName().toLowerCase().trim()=="ressource"){
			//id = getId(l.item(i));
			caseid = getCaseId(l.item(i).getChildNodes());
			//type = getType(l.item(i).getChildNodes());
			type = getTypeRessource(l.item(i).getChildNodes());
			switch(type){
			
				case PLANTE : listeressource.add(new Plante (caseid));break;
				case VIANDE : listeressource.add(new Viande (caseid));break;
				default : break;
			}
					/*
					System.out.println("Ressource "+
							" Type : "+type+
							" CaseId : "+caseid);
					*/
		}
		
	}
	return listeressource;
}

/**
 * Retourne une liste de cases triée par ordre d'id
 * @param l ArrayList<Case> Liste non-triée
 * @return ArrayList<Case> Liste triée
 */
private ArrayList<Case> trierListe (ArrayList<Case> l){
	
	
	int i;
	Boolean permut;
	//Trier la liste par ordre croissant d'id de case
	do {
		// hypothèse : la liste est triée
		permut = false;
		for ( i = 0; i < l.size() - 1; i++) {
			// Teste si 2 éléments successifs sont dans le bon ordre ou non
			if (l.get(i).getId() > l.get(i+1).getId()) {
				// s'ils ne le sont pas, on échange leurs positions
				l.add(i, l.get(i+1));
				l.remove(i+2);
				permut = true;
	
			}
			
		}
	} while (permut);


	return l;
	
	
}
/**
 * Remplace les eventuels "trous" de la liste par des cases par defaut
 * afin d'obtenir une liste de taille Longueur de map X Largeur de map
 * @param lcase ArrayList<Case> Liste non reparée
 * @param dmap Dimension Dimension de la map
 * @param casedef Case case par defaut
 * @return ArrayList<Case> Liste reparee
 */
private ArrayList<Case>	reparerListe (ArrayList<Case> lcase, Dimension dmap,Case casedef){
	int i;;
	int length = dmap.getLength();
	int width = dmap.getWidth();
	int nbcasemax = dmap.getLength()*dmap.getWidth();
	ArrayList<Case> listereparee = lcase;
	//System.out.println("Liste size "+listereparee.size());
	//Si la liste n'est pas nulle, on repare
	if(listereparee.size()!=0){ 
	for(i=0;i<listereparee.size();i++){//On parcourt la liste à la recherche de case manquante
		/*System.out.println("Id de la case analalysée "+listereparee.get(i).getId()+
				" i "+i);*/
		//Si la derniere case est manquante (situation particuliere), on l'ajoute
		if((i==listereparee.size()-1)&& (listereparee.get(i).getId()==nbcasemax-2)){
			listereparee.add(new Case(nbcasemax-1,new Position(length-1,width-1),casedef.getType()));
		}
		//Si l'id de la case actuelle est > à i, c'est qu'il manque une case (d'id = i) à cet endroit
		//On ajoute donc une case d'id = i à cet emplacement
		if(listereparee.get(i).getId()>i){
		listereparee.add(i,new Case(i,new Position(i%length,i/width),casedef.getType()));
		//System.out.println("Ajout Case ID "+i);
		}
	
	}
	}
	else{ //Le XML ne contient aucune case, on genère une liste par defaut
		for(i=0;i<nbcasemax;i++){
			listereparee.add(new Case(i,new Position(i%length,i/width),casedef.getType()));
		}
	}
	//System.out.println("Liste size "+listereparee.size());

	return listereparee;
}
/**
 * Genere une seinture d'obstacle autour de la Carte
 * @param listeobstacle Liste des obstacles déjà présents
 * @param dimensionmap Dimension de la map
 * @return ArrayList<Obstacle> Liste d'obstacle contenant les obstacles déjà présents et la ceinture d'obstacle
 */
@SuppressWarnings("unused")
private ArrayList<Obstacle> genererCeintureObstacle (ArrayList<Obstacle> listeobstacle,Dimension dimensionmap){
	
	int i;
	int length=dimensionmap.getLength();
	int width=dimensionmap.getWidth();
	int nbcase = length*width;
	//On genere la premiere ligne et la derniere
	for(i=0;i<length;i++){
		listeobstacle.add(new Obstacle(i));
		listeobstacle.add(new Obstacle((nbcase-1)-i));
	}
	//On genere la colone de gauche et la colone de droite
	for(i=0;i<width;i++){
		listeobstacle.add(new Obstacle(i*length));
		listeobstacle.add(new Obstacle(i*length+length-1));
	}
	return listeobstacle;
}

/**
 * Integre chaque obstacle dans la case qui lui correspond
 * @param listecase liste des cases
 * @param listeobstacle liste des obstacles
 * @return ArrayList<Case> la liste de Cases completee
 */
private ArrayList<Case> assemblerCaseObstacle(ArrayList<Case> listecase, ArrayList<Obstacle>listeobstacle){
	int i,j;
	//ArrayList<Case>lcase = listecase;
	
	for(i=0;i<listeobstacle.size();i++){
		for(j=0;j<listecase.size();j++){
			if(listecase.get(j).getId()==listeobstacle.get(i).getCaseId()){
				listecase.get(j).addObstacle(listeobstacle.get(i));
			}
		}
	}
	return listecase;
}

/**
 * Integre les animaux dans les cases correspondantes
 * @param listecase ArrayList<Case> liste des cases
 * @param listeanimaux ArrayList<Animal> liste des animaux
 * @return ArrayList<Case> la liste de Cases completees
 */
private ArrayList<Case> assemblerCaseAnimal(ArrayList<Case> listecase, ArrayList<Animal>listeanimaux){
	int i,j;
	//ArrayList<Case>lcase = listecase;
	
	for(i=0;i<listeanimaux.size();i++){
		for(j=0;j<listecase.size();j++){
			if(listecase.get(j).getId()==listeanimaux.get(i).getCaseId()){
				listecase.get(j).addAnimal(listeanimaux.get(i));
			}
		}
	}
	return listecase;
}

/**
 * Integre les Ressources dans les cases correspondantes
 * @param listecase ArrayList<Case>  la liste des cases
 * @param listeressources la liste des ressources
 * @return ArrayList<Case> la liste de cases completee
 */
private ArrayList<Case> assemblerCaseRessource(ArrayList<Case> listecase, ArrayList<Ressource>listeressources){
	int i,j;
	//ArrayList<Case>lcase = listecase;
	
	for(i=0;i<listeressources.size();i++){
		for(j=0;j<listecase.size();j++){
			if(listecase.get(j).getId()==listeressources.get(i).getCaseId()){
				listecase.get(j).addRessource(listeressources.get(i));
			}
		}
	}
	return listecase;
}
}



