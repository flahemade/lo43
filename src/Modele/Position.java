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
	
	
	/* -------------Constructor------------- */
	
	public Position(){
		x = 0;
		y = 0;	
	}
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Position(int z){
		this.x=z;
		this.y=z;
	}
	/* ---------getters & Setters----------- */
	public Integer getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
