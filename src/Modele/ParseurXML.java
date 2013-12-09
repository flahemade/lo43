package Modele;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
	
	System.out.println("Debut du parcours du XML"); //DEBUG
	for (i = 0; i<list.getLength();i++){ 							
		//System.out.println(list.item(i).getNodeName()); //DEBUG
		
		
		/**
		 * /Fonction enumBourrin() à remplacer par quelque chose de propre
		 *  Retourne un entier correspondant au nom de la node lue (format string)
		 *  switch n'accepte pas de comparer des strings avant jre 1.7
		 */
			switch(enumBourrin(list.item(i).getNodeName())){ 

			case 1 : mapParser(list.item(i).getChildNodes());  //Cas où la node "map" est detectée, on lance la fonction mapParser(NodeListe l)
			//System.out.println("map"); //DEBUG
			break;
			
			case 2 : //System.out.println("espece"); //DEBUG   //Cas où la node "espece" est detectée, on lance la fonction ? pas implémentée
			break;
			
			default :break ; //Si autre chose que "map" ou "espece" on ne fait rien
			
			}
			} 
	}
/**
 * Fonction qui retourne un entier en fonction de la String pris en attribut afin de faire fonctionner les switch case
 * Sera remplacé par un enum dans un avenir proche
 * Si la String n'est pas une node contenue dans le .XML, la fonction retourne 0;
 * @param node
 * @return
 */
//TODO Remplacer enumBourrin par quelque chose de propre
private int enumBourrin (String node){
	int i = 0;
	if(node == "map"){
		i = 1;
	}
	if(node == "espece"){
		i = 2;
	}
	if(node == "case"){
		i = 3;
	}
	if(node == "taille"){
		i = 4;
	}
	if(node == "position"){
		i = 5;
	}
	if(node == "x"){
		i = 6;
	}
	if(node == "y"){
		i = 7;
	}
	if(node == "type"){
		i = 8;
	}
	if(node == "class"){
		i = 9;
	}
	if(node == "nom"){
		i = 10;
	}
	if(node == "element"){
		i = 11;
	}
	if(node == "id"){
		i = 12;
	}
	if(node == "obstacle"){
		i = 13;
	}
	if(node == "ressourcej"){
		i = 11;
	}
	return i;
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
		if(l.item(i).getNodeName()=="taille")
		{
			try{
			taille = Integer.parseInt(l.item(i).getTextContent());
			}
			catch(Exception e){
				taille = 20;
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
		if(l.item(i).getNodeName()=="type")
		{
			type = l.item(i).getTextContent();
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
		if(l.item(i).getNodeName()=="position")
		{
			NodeList enfant = l.item(i).getChildNodes();
			for(j=0;j<enfant.getLength();j++){
				switch(enumBourrin(enfant.item(j).getNodeName())){
				case 6: 
						try{
						position.setX(Integer.parseInt(enfant.item(j).getTextContent()));
					}
					catch(Exception e){
						position.setX(-1);
					}
					break;
				case 7: 
						try{
						position.setY(Integer.parseInt(enfant.item(j).getTextContent()));
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
				id = Integer.parseInt(n.getAttributes().getNamedItem("id").getNodeValue());	
			}catch (Exception e){
				//TODO Gerer l'exception
			}
			
			
		}
	}	
			
	return id;
}
/**
 * Recupere les differente case definient dans le XML et creer une liste de case qui sera ensuite retournée
 * @param l
 * @return
 */
public List <Case> mapParser(NodeList l){
	int i;
	Integer taille;
	Integer id;
	Position position;
	String type;
	List<Case> listecase = new ArrayList<Case>();
	for(i=0;i<l.getLength();i++){
		switch (enumBourrin(l.item(i).getNodeName())){
		
		case 3: 
		taille =getTaille(l.item(i).getChildNodes());
		type= getType(l.item(i).getChildNodes());
		position = getPosition(l.item(i).getChildNodes());
		id = getId(l.item(i));
		listecase.add(new Case(id,position,taille,new ArrayList<Modele.Element>())); //TODO A FINIR
		
		
		System.out.println("\t Case : id : "+id +
				"\tTaille : "+taille +
				", Type : "+type+
				", Position : "+position.getX()+ 				//DEBUG
				" , "+position.getY());
				
		break;
		default : break;
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
/** --------DEBUG -------------*/

/*public static void main(String[] args) {
	
System.out.println("XMLParser debugger");
ParseurXML parser = new ParseurXML("./res/map.xml"); //Création d'une instance de Parser, attention à bien spécifier une adresse correcte
//parser.printDOMInfos();
parser.parseXML(); //Debut du parsing
}
*/
}



