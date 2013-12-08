package Vue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
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
public class FenetreAccueil extends JFrame implements ActionListener{

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
		this.setSize(new Dimension(325,225));
		this.setLocationRelativeTo(null);
		creerComposants();
		placerComposants();
	}


/*_______________________________________________________________*/
/**
 */
	private void creerComposants() 
	  {
		  btn_jouer = new JButton("Jouer");
		  btn_jouer.setPreferredSize(new Dimension(100,30));
		  btn_jouer.addActionListener(this);
		  messageAccueil = new JLabel("Bienvenue sur Savane Yolo !!!");
		  
	  }
	
	  /*_______________________________________________________________*/
	/**
	 */
	private void placerComposants() 
	{
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2,1));
		jp1.setAlignmentX(CENTER_ALIGNMENT);
		jp1.setAlignmentY(CENTER_ALIGNMENT);
		JPanel jpIntermediaire = new JPanel();
		jpIntermediaire.add(messageAccueil);
		JPanel jpIntermediaire2 = new JPanel();
		jpIntermediaire2.add(btn_jouer);
		jp1.add(jpIntermediaire);
		jp1.add(jpIntermediaire2);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jp1, BorderLayout.CENTER);
		
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


	/*_______________________________________________________________*/
	/**
	 *@param e
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== btn_jouer)
		{
			Plateau fen_plateau = new Plateau("Le jeu de la mort qui tue !!");
			fen_plateau.setVisible(true);
		}
		
	}

}