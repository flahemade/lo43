package Modele;
/**
 * Class permettant de représenter 
 * simplement une position
 * @author nicolas
 *
 */
public class Position { 
	private Integer x;
	private Integer y;
	
	public Position(){
		x = 0;
		y = 0;
		
	}
	/* Constructor */
	public Position(Integer x, Integer y){
		this.x = x;
		this.y = y;
	}
	
	public Position(Integer z){
		this.x=z;
		this.y=z;
	}
	/* getters & Setters */
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}

}
