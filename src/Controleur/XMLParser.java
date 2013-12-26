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
import Modele.Position;
import Modele.Ressource;
import Modele.TypeAnimal;
import Modele.TypeTerrain;


/*_______________________________________________________________*/
/**
 * @author nicolas
 *
 */

/**
 * This class is used to load the map and its content (obstacles and species) described
 * in the XML file.
 *  
 * @author nicolas
 *
 */


public class XMLParser{

/** -----attributes definitions-----*/
	
  private String path; /* Chemin relatif vers le fichier XML*/
  private Document document;

/** 
 * Initializes the parser using String Chemin 
 * to get to the file to parse
 * @param chemin
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
	  

  
/**-------- Getters & setters ------*/
  
 public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}

/*------------ Methods ------------*/

/*
public void printDOMInfos(){
	System.out.println("INFORMATIONS GENERALES");
	
	String uri = document.getDocumentURI();
	System.out.println("URI = "+uri);
	
	String xVersion = document.getXmlVersion(); 
	System.out.println("Version XML = "+xVersion);
	
	String xEncoding = document.getXmlEncoding();
	System.out.println("XML encoding = "+xEncoding);
	
	String iEncoding = document.getInputEncoding();
	System.out.println("Input encoding = "+iEncoding);
	
	boolean standalone = document.getXmlStandalone();
	System.out.println("XML standalone = "+standalone);
	
	boolean strictError = document.getStrictErrorChecking();
	System.out.println("Strict error checking = "+strictError+"\n");
	
	}

*/
/**
 *Parse le XML et retourne une ArrayListe<Case> d'une map fonctionnelle. 
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
	System.out.println("Debut du parcours du XML"); //DEBUG
	
		//System.out.println(list.item(i).getNodeName()); //DEBUG

		
		/**
		 * /Fonction enumBourrin() à remplacer par quelque chose de propre
		 *  Retourne un entier correspondant au nom de la node lue (format string)
		 *  switch n'accepte pas de comparer des strings avant jre 1.7
		 */
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
			//System.out.println("dimensionmap "+dimensionmap.getLength()+" "+dimensionmap.getWidth()); //DEBUG
			break;
			
			case 2 :
				parseEspece(list.item(i).getChildNodes());
			//System.out.println("espece"); //DEBUG   //Cas où la node "espece" est detectee, on lance la fonction parseEspece(NodeList l)
			break;
			
			case 17 : parseObstacle(list.item(i).getChildNodes());     //Cas où la node objet est detectee
						parseRessource(list.item(i).getChildNodes());
				break;
			default :break ; //Si autre chose que "map" ou "espece" on ne fait rien
			
			}
			/*listefinale=reparerListe(listecase, casedefaut, dimensionmap);
			for(i=0;i<listefinale.size();i++){
				System.out.println("aff "+listefinale.get(i).getId());
			}
			*/
			
			
			/*DEBUG*/
			
			/*
			 * Une fois que l'on a obtenu les differente cases, les espece à placer ainsi que les ressources et obstacles,
			 * il faut génrer les case manquantes grace au attributs default puis
			 * il faut assembler le tout (placer les animaux, ressources et obstacle dans les case)
			 * enfin il faut vérifier que la list generee est cohérente (pas d'animaux ou de ressource là où il y a un obstacle)
			 * des obstacle sur les bords de la carte,
			 * qu'il y ai une case pour chaque id possible selon la taille de la map
			 * qu'il n'y ai aucun element avec un id ou une taile =-1
			 */
		} 
			
			/*for(i=0;i<listefinale.size();i++){
				System.out.println("ListeFinale : ID_Case "+listefinale.get(i).getId());
			}
			*/
			listefinale=assemblerCaseObstacle(listecase, listeobstacle);
			listefinale=assemblerCaseAnimal(listecase, listeanimaux);
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

private Case getCaseDefaut(org.w3c.dom.Node n){
	int id =-1;
	Position position=new Position();
	TypeTerrain type = TypeTerrain.TERRE;
	Case casedefaut;
	
	if(n.hasAttributes()){	

	/*	INUTILE
	 * if(n.getAttributes().getNamedItem("defaut_taille_case")!=null){
			try{
				taille =Integer.parseInt(n.getAttributes().getNamedItem("defaut_taille_case").getNodeValue().trim());
			}
			catch(Exception e){
				//TODO gerer l'exception
			}
		}
		
	*/
		if(n.getAttributes().getNamedItem("defaut_type_case")!=null){
			try{
				//type =n.getAttributes().getNamedItem("defaut_type_case").getNodeValue().toLowerCase().trim();
			//TODO TERMINER
			}
			
			catch(Exception e){
				//TODO gerer l'exception
			}
		}
	}
	 casedefaut =new Case(id,position,type);
	 return casedefaut;
}

/**
 * Recupere l'attribut taille de la classe Case contenue dans le XML
 * Si la node <case> ne contient pas d'enfant <taille> (cf XML) alors la fonction retourne -1
 * Sinon retourne la taille contenue entre <taille></taille>  au format Integer
 * @param l
 * @return
 */
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
 * Recupere l'attribut Type (TERRE, EAU, HERBE ...) de la classe (Case ?) à partir du XMl et le retourne au format String
 * @param l
 * @return
 */
private TypeTerrain getTypeTerrain(NodeList l){
	int i;
	TypeTerrain type = TypeTerrain.TERRE;
	for(i=0;i<l.getLength();i++)
	{
		if(l.item(i).getNodeName().toLowerCase().trim()=="type")
		{
			/* Ne veut pas entrer dans ce if*/
			if(l.item(i).getTextContent().trim().toLowerCase().equals("eau")){
				
				System.out.println("PASSED");
				type = TypeTerrain.EAU;
			}
		}
		

	}
	return type;
}

private TypeAnimal getTypeAnimal(NodeList l){
	int i;
	TypeAnimal type = TypeAnimal.GAZELLE;
	for(i=0;i<l.getLength();i++)
	{
		
		if(l.item(i).getNodeName().toLowerCase()=="type")
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
 * Recupere les attribution position x et y de la classe Case à partir du XML et les retourne au format Position
 * @param l
 * @return
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

private String getNomClass(NodeList l){ //n'est plus utilisé
	
	int i;
	String nomclass="test";
	
	for(i=0;i<l.getLength();i++)
	{
		if(l.item(i).getNodeName().toLowerCase()=="nomclass")
		{
			nomclass = l.item(i).getTextContent().toLowerCase().trim();
		}
	}
	return nomclass;
}

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
 * Recupere les differente case definient dans le XML et creer une liste de case qui sera ensuite retournée
 * @param l
 * @return
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

		System.out.println("Case : id : "+id +
				", Type : "+type.name()+
				", Position : "+position.getX()+ 				//DEBUG
				" , "+position.getY());
				
		break;
		default : break;
		}
		
	}
	
	return listecase;
	
}

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
		//id = getId(l.item(i));
		caseid = getCaseId(l.item(i).getChildNodes());
		//nomclass = getType(l.item(i).getChildNodes());
		//TODO Faire un GetType animal
		type = getTypeAnimal(l.item(i).getChildNodes());
		sexe = getSexe(l.item(i).getChildNodes());
			switch(type){
			case LION : listeanimaux.add(new Lion(caseid, sexe));break; //Creation d'une classe Lion & ajout dans listeanimaux
			case GAZELLE : listeanimaux.add(new Gazelle(caseid, sexe)); break; //Creation classe Gazelle & ajout dans listeanima
			case GIRAFE : listeanimaux.add(new Girafe(caseid, sexe));break;
			case HYENE: listeanimaux.add(new Hyene(caseid, sexe)); break;
			default : break;
			}
		
		System.out.println("Animal : "+
				", type : "+type.toString()+
				", caseID : "+caseid+
				", sexe : "+sexe);
				
		break;
		}
	}
	return listeanimaux;
}


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
			System.out.println("Obstacle "+ //DEBUG
					" caseID : "+caseid);
		}
		
	}

	return listeobstacle;
}

private ArrayList<Ressource> parseRessource(NodeList l){
	int i;
	Integer id=-1;
	int caseid=-1;
	String type="";
	ArrayList<Ressource> listeressource = new ArrayList<Ressource>();
	

	for(i=0;i<l.getLength();i++){
		
		if(l.item(i).getNodeName().toLowerCase().trim()=="ressource"){
			id = getId(l.item(i));
			caseid = getCaseId(l.item(i).getChildNodes());
			//type = getType(l.item(i).getChildNodes());
			//Ajout d'un obstacle à la liste
			System.out.println("Ressource "+id+
					" Type : "+type+
					" CaseId : "+caseid);
		}
		
	}
	return listeressource;
}

/**
 * Retourne une liste de case valide (liste triée, possedant le bon nombre d'element, avec des id valides);
 * @param l
 * @param casedefaut
 * @param dimensionmap
 * @return
 */
/*private ArrayList<Case> reparerListe (ArrayList<Case> l, Case casedefaut, Dimension dimensionmap){
	
	Case casedef = new Case(casedefaut.getId(),casedefaut.getPosition(),casedefaut.getTaille(),casedefaut.getType());
	int i;
	int nbcasemax = dimensionmap.getLength()*dimensionmap.getWidth();
	ArrayList<Case> listereparee=new ArrayList<Case>();
	//listereparee.ensureCapacity(nbcasemax);
	
	for(i=0;i<l.size();i++){
		if(l.get(i).getId()>=0){
			listereparee.add(i, l.get(i)); //si l'id de la case est valide (superieur a 0), on ajoute la case à la liste
		}
		else{
			casedef.setId(i);
			listereparee.add(i, casedef);
		}
	}

	for(i = listereparee.size() ;i < nbcasemax ; i++){
			System.out.println("i "+i);
			casedef.setId(i);
			System.out.println("casedef "+casedef.getId());
			listereparee.add(i,casedef);
			System.out.println("liste "+listereparee.get(i).getId());
			System.out.println();		
	}
	
	return listereparee;
}
*/

private ArrayList<Case> assemblerCaseObstacle(ArrayList<Case> listecase, ArrayList<Obstacle>listeobstacle){
	int i,j;
	ArrayList<Case>lcase = listecase;
	
	for(i=0;i<listeobstacle.size();i++){
		for(j=0;j<lcase.size();j++){
			if(lcase.get(j).getId()==listeobstacle.get(i).getIdcase()){
				listecase.get(j).addObstacle(listeobstacle.get(i));
			}
		}
	}
	return listecase;
}

private ArrayList<Case> assemblerCaseAnimal(ArrayList<Case> listecase, ArrayList<Animal>listeanimaux){
	int i,j;
	ArrayList<Case>lcase = listecase;
	
	for(i=0;i<listeanimaux.size();i++){
		for(j=0;j<lcase.size();j++){
			if(lcase.get(j).getId()==listeanimaux.get(i).getIdCase()){
				listecase.get(j).addAnimal(listeanimaux.get(i));
			}
		}
	}
	return listecase;
}
//TODO Ajouter la taille de la carte dans le XML et une case par defaut
//TODO completer carte la liste de case par des case par deffaut
//TODO Creer fonction pour verifier l'intégrité de la carte avant de la retourner
/*
public void write(String chemin, Map map) {
  }

  public Map read(String chemin) {
	  	
	  
  }

  public void save(String chemin, Map map ) {
  }
*/
/* --------DEBUG -------------*/

public static void main(String[] args) {
	
System.out.println("XMLParser debugger");
XMLParser parser = new XMLParser("./res/8x8_simple.xml"); //Création d'une instance de Parser, attention à bien spécifier une adresse correcte
//XMLParser parser = new XMLParser("./res/map.xml");
parser.parseXML(); //Debut du parsing
}

}



