package Modele;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
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
	
	/*System.out.println("DOCTYPE");
	printDoctype(document.getDoctype());
	
	System.out.println("CONFIGURATION");
	printDOMConfiguration(document.getDomConfig());*/
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

}

}*/



