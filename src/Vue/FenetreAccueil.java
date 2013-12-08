package Vue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class FenetreAccueil extends JFrame{

  /**  */
	private static final long serialVersionUID = 1L;
	
/** Bouton jouer */
	private JButton btn_jouer;

	private JLabel messageAccueil;

	/*_______________________________________________________________*/
	/**Contructeur
	 * @param titre titre de la fenêtre
	 */
	public FenetreAccueil(String titre) 
	{
		super(titre);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(500,300));
		creerComposants();
		placerComposants();
	}


/*_______________________________________________________________*/
/**
 */
	public void creerComposants() 
	  {
		  btn_jouer = new JButton("Jouer");
		  btn_jouer.setPreferredSize(new Dimension(100,30));
		  messageAccueil = new JLabel("Bienvenue sur Savane Yolo !!!");
		  
	  }
	
	  /*_______________________________________________________________*/
	/**
	 */
	public void placerComposants() 
	{
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(3, 1));
		
		jp1.add(btn_jouer);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jp1, BorderLayout.EAST);
		this.getContentPane().add(messageAccueil, BorderLayout.CENTER);
	}
	  
	  /*_______________________________________________________________*/
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	  {
			FenetreAccueil fen = new FenetreAccueil("Le jeu de la savane");
			fen.setVisible(true);
			
	  }

}