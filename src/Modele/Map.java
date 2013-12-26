package Modele;
import java.util.ArrayList;


/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Map {

	/** nom de la map */
	private String Nom;
    /**  */
    private ArrayList<Case>  listeCases;
//-------------------------------- CONSTRUCTEUR --------------------------------//   
    /*_______________________________________________________________*/
    /**Constructeur
     * @param nom
     */
    public Map(String nom){
    	setNom(nom);
    	listeCases = new ArrayList<Case>();
    	
    }
    
    /*_______________________________________________________________*/
    /**Constructeur complet
     * @param nom
     * @param lesCases
     */
    public Map(String nom, ArrayList<Case> lesCases)
    {
    	setNom(nom);
    	setListeCases(lesCases);
    	
    }
//-------------------------------- SETTERS AND GETTERS --------------------------------//
	/*_______________________________________________________________*/
	/**
	 * @return le nom
	 */
	public String getNom() {
		return Nom;
	}
	/*_______________________________________________________________*/
	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		Nom = nom;
	}
	/*_______________________________________________________________*/
	/**
	 * @return la liste de case
	 */
	public ArrayList<Case> getListeCases() {
		return listeCases;
	}
	/*_______________________________________________________________*/
	/**
	 * @param listeCases
	 */
	public void setListeCases(ArrayList<Case> listeCases) {
		this.listeCases = listeCases;
	}
	

	  /*_______________________________________________________________*/
	/**
	 * @param map
	 * @return la map
	 */
	public Map rafraichir(Map map){
		  return map;
	  }
}