package Modele;


import javax.xml.parsers.*; 

import org.w3c.dom.*; 
import org.xml.sax.*; 

import java.io.*; 


/**
 * This class is used to load the map and its content (obstacles and species) described
 * in the XML file
 *  
 * @author nicolas
 *
 */

public class ParseurXML{

/** -----attributes definitions-----*/
	
  private String path; /* Chemin relatif vers le fichier XML*/

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
	  Document document = constructeur.parse(xml);
	  
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
public void write(String chemin, Map map) {
  }

  public Map read(String chemin) {
	  	
	  
  }

  public void save(String chemin, Map map ) {
  }
*/
}

