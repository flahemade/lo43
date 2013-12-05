package Modele;


public class ParseurXML{

/** Definition des attributs */
  private String path; /* Chemin relatif vers le fichier XML*/


  public ParseurXML(String chemin){
  
  }
  
  public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}


public void write(String chemin, Map map) {
  }

  public Map read(String chemin) {
	  Map map = new Map();
	  return map;
  }

  public void save(String chemin, Map map ) {
  }

}