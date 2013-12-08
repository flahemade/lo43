package Modele;

import java.io.File;

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
  Document document;

/** 
 * Initializes the parser using String Chemin 
 * to get to the file to parse
 * @param chemin
 */
  public ParseurXML(String chemin){
	  try {
	  
	  DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance(); //
	  DocumentBuilder constructeur = fabrique.newDocumentBuilder();
	  File xml = new File(chemin);
	  document = constructeur.parse(xml);
	  
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

/*
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

	
	NodeList list = document.getDocumentElement().getChildNodes();
	int i;
	
	System.out.println("Debut du parcours du XML"); //DEBUG
	for (i = 0; i<list.getLength();i++){ 							
		//System.out.println(list.item(i).getNodeName()); //DEBUG
		
			//System.out.println(l.item(i).getNodeName());
			switch(enumBourrin(list.item(i).getNodeName())){
			case 0 : break;
			case 1 : System.out.println("map");mapParser(list.item(i).getChildNodes());break;
			case 2 : System.out.println("espece");break;
			default :break ;
			
			
			}
			} 
	}
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
	if(node == "nombre"){
		i = 11;
	}
	return i;
}

private int getTaille(NodeList l){
	int taille = -1;
	int i;
	for(i=0;i<l.getLength();i++)
	{
		if(l.item(i).getNodeName()=="taille")
		{
			taille = Integer.parseInt(l.item(i).getTextContent());
		}
	}
	return taille;
}
private String getType(NodeList l){
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

public Position getPosition(NodeList l){
	int i,j;
	Position position=new Position();
	for(i=0;i<l.getLength();i++)
	{
		if(l.item(i).getNodeName()=="position")
		{
			NodeList enfant = l.item(i).getChildNodes();
			for(j=0;j<enfant.getLength();j++){
				switch(enumBourrin(enfant.item(j).getNodeName())){
				case 6: position.setX(Integer.parseInt(enfant.item(j).getTextContent()));break;
				case 7: position.setY(Integer.parseInt(enfant.item(j).getTextContent()));break;
				default : break;
				}
			}
		}
	}
	return position;
}
public void mapParser(NodeList l){
	int i;
	int taille;
	Position position;
	String type;
	
	for(i=0;i<l.getLength();i++){
		switch (enumBourrin(l.item(i).getNodeName())){
		
		case 3: System.out.println("\tCase");
		taille =getTaille(l.item(i).getChildNodes());
		type= getType(l.item(i).getChildNodes());
		position = getPosition(l.item(i).getChildNodes());
		
		System.out.println("\t\tTaille : "+taille +
				", Type : "+type+
				", Position "+position.getX()+ 
				" , "+position.getY());
		break;
		default : break;
		}
	}
	
	
}

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
ParseurXML parser = new ParseurXML("./res/map.xml");
parser.printDOMInfos();
parser.parseXML();
}
*/
}



