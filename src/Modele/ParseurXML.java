package Modele;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


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


public class ParseurXML{

/** -----attributes definitions-----*/
	
  private String path; /* Chemin relatif vers le fichier XML*/
  private Document document;

/** 
 * Initializes the parser using String Chemin 
 * to get to the file to parse
 * @param chemin
 */
  public ParseurXML(String chemin){
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

/**------------ Methods ------------*/

/**
 * Méthode copiée/collée du site http://java.developpez.com/faq/xml/?page=dom
 * L'objéctif etait de voir que le fichier mapxml était fonctionnel */
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


public void parseXML(){

	
	NodeList list = document.getDocumentElement().getChildNodes(); //On recupere le premier niveau de Node (map & espece)
	int i;
	
	Dimension dimensionmap;
	ArrayList<Case> listecase = new ArrayList<Case>();
	ArrayList<Animal> listeanimaux = new ArrayList<Animal>();
	ArrayList<Obstacle> listeobstacle = new ArrayList<Obstacle>();
	ArrayList<Ressource> listeressource = new ArrayList<Ressource>();
	Case casedefaut;
	System.out.println("Debut du parcours du XML"); //DEBUG
	for (i = 0; i<list.getLength();i++){ 							
		//System.out.println(list.item(i).getNodeName()); //DEBUG
		
		
		/**
		 * /Fonction enumBourrin() à remplacer par quelque chose de propre
		 *  Retourne un entier correspondant au nom de la node lue (format string)
		 *  switch n'accepte pas de comparer des strings avant jre 1.7
		 */
			switch(enumBourrin(list.item(i).getNodeName())){ 

			case 1 : //Cas où la node "map" est detectee, on lance la fonction mapParser(NodeListe l)
			dimensionmap = getDimension(list.item(i));
			listecase = parseMap(list.item(i).getChildNodes());
			casedefaut = getCaseDefaut(list.item(i));
			System.out.println("CaseDefaut : id "+casedefaut.getId()+
					" , Taille "+casedefaut.getTaille()+
					" , Type "+casedefaut.getType()+
					" , Position "+casedefaut.getPosition().getX()+" , "+casedefaut.getPosition().getY());
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
			/**
			 * Une fois que l'on a obtenu les differente cases, les espece à placer ainsi que les ressources et obstacles,
			 * il faut génrer les case manquantes grace au attributs default puis
			 * il faut assembler le tout (placer les animaux, ressources et obstacle dans les case)
			 * enfin il faut vérifier que la list generee est cohérente (pas d'animaux ou de ressource là où il y a un obstacle)
			 * des obstacle sur les bords de la carte,
			 * qu'il y ai une case pour chaque id possible selon la taille de la map
			 * qu'il n'y ai aucun element avec un id ou une taile =-1
			 */
		} 
	}
/**
 * Fonction qui retourne un entier en fonction de la String pris en attribut afin de faire fonctionner les switch case
 * devrait pouvoir etre remplace par un enum
 * Si la String n'est pas une node contenue dans le .XML, la fonction retourne 0;
 * @param node
 * @return
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
	int id =-1, taille =-1;
	Position position=new Position();
	String type="terre";
	Case casedefaut;
	
	if(n.hasAttributes()){	

		if(n.getAttributes().getNamedItem("defaut_taille_case")!=null){
			try{
				taille =Integer.parseInt(n.getAttributes().getNamedItem("defaut_taille_case").getNodeValue().trim());
			}
			catch(Exception e){
				//TODO gerer l'exception
			}
		}
		if(n.getAttributes().getNamedItem("defaut_type_case")!=null){
			try{
				type =n.getAttributes().getNamedItem("defaut_type_case").getNodeValue().toLowerCase().trim();
			}
			catch(Exception e){
				//TODO gerer l'exception
			}
		}
	}
	 casedefaut =new Case(id,position,taille,type);
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
private String getType(NodeList l){ //TODO Ajouter une gestion de l'attribut "default"
	int i;
	String type="";
	for(i=0;i<l.getLength();i++)
	{
		if(l.item(i).getNodeName().toLowerCase()=="type")
		{
			type = l.item(i).getTextContent().toLowerCase().trim();
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
		if(l.item(i).getNodeName().toLowerCase()=="position")
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
	Integer taille;
	Position position;
	String type;
	ArrayList<Case> listecase = new ArrayList<Case>();
	
	for(i=0;i<l.getLength();i++){
		switch (enumBourrin(l.item(i).getNodeName())){
		
		case 3: 
		taille =getTaille(l.item(i).getChildNodes());
		type= getType(l.item(i).getChildNodes());
		position = getPosition(l.item(i).getChildNodes());
		id = getId(l.item(i));
		listecase.add(new Case(id,position,taille,type)); //TODO A FINIR
		
		
		System.out.println("Case : id : "+id +
				", Taille : "+taille +
				", Type : "+type+
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
	Integer id, caseid;
	String nomclass;
	Boolean sexe;
	for(i=0;i<l.getLength();i++){
		switch (enumBourrin(l.item(i).getNodeName())){
		
		case 9 :
		id = getId(l.item(i));
		caseid = getCaseId(l.item(i).getChildNodes());
		nomclass = getType(l.item(i).getChildNodes());
		sexe = getSexe(l.item(i).getChildNodes());
			switch(enumBourrin(nomclass)){
			case 15 : break; //Creation d'une classe Lion & ajout dans listeanimaux
			case 16 : break; //Creation classe Gazelle & ajout dans listeanimaux
			default : break;
			}
		
		System.out.println("Animal : id :"+id+
				", type : "+nomclass+
				", caseID : "+caseid+
				", sexe : "+sexe);
		break;
		}
	}
	return listeanimaux;
}


private ArrayList<Obstacle> parseObstacle(NodeList l){
	int i;
	Integer id =-1,caseid=-1;
	ArrayList<Obstacle> listeobstacle = new ArrayList<Obstacle>();
	
	for(i=0;i<l.getLength();i++){
		
		if(l.item(i).getNodeName().toLowerCase().trim()=="obstacle"){
			id = getId(l.item(i));
			caseid = getCaseId(l.item(i).getChildNodes());
			listeobstacle.add(new Obstacle(20, caseid));   //Ajout d'un obstacle à la listeobstacle
			System.out.println("Obstacle "+id+ //DEBUG
					" caseID : "+caseid);
		}
		
	}
	return listeobstacle;
}

private ArrayList<Ressource> parseRessource(NodeList l){
	int i;
	Integer id=-1, caseid=-1;
	String type="";
	ArrayList<Ressource> listeressource = new ArrayList<Ressource>();
	

	for(i=0;i<l.getLength();i++){
		
		if(l.item(i).getNodeName().toLowerCase().trim()=="ressource"){
			id = getId(l.item(i));
			caseid = getCaseId(l.item(i).getChildNodes());
			type = getType(l.item(i).getChildNodes());
			//Ajout d'un obstacle à la liste
			System.out.println("Ressource "+id+
					" Type : "+type+
					" CaseId : "+caseid);
		}
		
	}
	return listeressource;
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
/** --------DEBUG -------------*/

/*public static void main(String[] args) {
	
System.out.println("XMLParser debugger");
ParseurXML parser = new ParseurXML("./res/map.xml"); //Création d'une instance de Parser, attention à bien spécifier une adresse correcte
//parser.printDOMInfos();
parser.parseXML(); //Debut du parsing
}
*/
}



