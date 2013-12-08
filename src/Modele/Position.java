package Modele;
/**
 * Class permettant de représenter 
 * simplement une position
 * @author nicolas
 *
 */
public class Position { 
	private int x;
	private int y;
	
	public Position(){
		x = 0;
		y = 0;
	}
	/* Constructor */
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Position(int z){
		this.x=z;
		this.y=z;
	}
	/* getters & Setters */
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
