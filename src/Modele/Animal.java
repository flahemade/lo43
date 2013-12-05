package Modele;

import java.util.Vector;


public class Animal extends Element {

  protected Integer Taille;

  protected Integer Vitesse;
  
  protected  Vector<Integer> Direction;

  protected String RegimeAlimentaire;

  protected Integer Age;

  protected Integer AgeMax;

  protected Integer PV;

  protected Integer Id;

  protected Boolean sexe;

  public void seDeplacer() {
  }

  public void seNourir() {
	  
  }

  public void seReproduire() {
  }

  public void mourir() {
  }

}