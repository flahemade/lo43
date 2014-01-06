package Modele;

/*_______________________________________________________________*/
/**Ressource viande
 * @author anaelle
 *
 */
public class Viande extends Ressource{

	
	/*_______________________________________________________________*/
	/**constructeur 
	 * @param idcase
	 */
	public Viande (int idcase){
		super(idcase);
	}
	
	
	/*_______________________________________________________________*/
	/**initialise la viande
	 * @see Modele.Ressource#init()
	 */
	public void init(){
		setModifierVie(25);
		setImage("./res/ressource/viande/viande1.png");
		
	}
	
}
