package Controleur;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Ordonnanceur {
	private Boolean pause;
	//-------------------------------------------CONSTRUCETEUR---------------------------//
	public Ordonnanceur(){
		setPause(true);
	}
	//-------------------------------------------GETTERS AND SETTERS---------------------//
	public Boolean getPause() {
		return pause;
	}
	public void setPause(Boolean pause) {
		this.pause = pause;
	}
	//-------------------------------------------AUTRES METHODES-------------------------//
	public void run() {
		  while(this.pause==false){
			  // Jouer...
		  }
	}
	public void stop(){
		  setPause(true);
	}

}