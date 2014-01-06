package Modele;

/*_______________________________________________________________*/
/**classe Ressource
 * @author anaelle
 *
 */
public class Ressource extends Element {

	
  
	/*_______________________________________________________________*/
	/**constructeur complet
	 * @param nom
	 * @param image
	 * @param modifierVie
	 * @param champVision
	 */
  public Ressource(String nom, String image, int modifierVie, int champVision){
	  super(image, nom , modifierVie, champVision );    
  }

  /*_______________________________________________________________*/
/**constructeur simple
 * @param idcase
 */
public Ressource (int idcase){
	  
	super(idcase);
	init();
  }


/*----------AUTRES METHODES ----------*/

/*_______________________________________________________________*/
/**Initialise la ressource avec le champs de vision
 */
public void init(){
	
	  setChampVision(0);
	 
  }

}