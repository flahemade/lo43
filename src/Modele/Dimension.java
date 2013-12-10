package Modele;

public class Dimension {

	private Integer width ;
	private Integer length;
	
	//--------------CONSTRCUTEURS ---------------//
	
	public Dimension (){
		width =0;
		length =0;
	}
	
	public Dimension(int d){
		width = d;
		length = d;
	}
	
	public Dimension (int wi, int le){
		width = wi;
		length = le;
	}
	//-----------GETTERS & SETTERS --------------//
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	
}
