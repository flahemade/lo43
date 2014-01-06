package Modele;

/*_______________________________________________________________*/
/**Ressource plante
 * @author anaelle
 *
 */
public class Plante extends Ressource {

	/*_______________________________________________________________*/
	/**constructeur 
	 * @param idcase
	 */
	public Plante (int idcase){
		super(idcase);
	}
	
	
	/*_______________________________________________________________*/
	/**initialise la plante
	 * @see Modele.Ressource#init()
	 */
	public void init(){
		setModifierVie(25);
		setImage("./res/ressource/plante/plante1.png");
		
	}
	
}
