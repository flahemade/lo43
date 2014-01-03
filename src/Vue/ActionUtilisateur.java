/*_______________________________________________________________*/
/**
 * Fichier : ActionUtilisateur.java
 *
 * créé le 26 déc. 2013 à 21:02:01
 *
 * Auteur : Olivier BUCAILLE gr3
 * 
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class ActionUtilisateur extends JInternalFrame implements Runnable, ActionListener, MouseListener
{
	/**  */
	private static final long serialVersionUID = 1L;
	/**  */
	private ArrayList<JLabel> images;
	/**  */
	private JPanel pan_image;
	/**  */
	//private ArrayList<JButton> listeBouton;
	private JPanel pan_ensemble;
	
	private boolean arret;
	
	private ArrayList<ImageIcon> icones;
	
	private int action;

	/*_______________________________________________________________*/
	/**Constructeur
	 */
	public ActionUtilisateur()
	{
		super("Action utilisateur", true, false);
		this.setVisible(true);
		this.setArret(true);
		this.setAction(-1);
	
	}
	
	/*_______________________________________________________________*/
	/** Permet d'obtenir la valeur du champ arret.
	 * @return la valeur du champ arret.
	 */
	public boolean getArret()
	{
		return arret;
	}

	/*_______________________________________________________________*/
	/** Modifie la valeur du champ arret.
	 * @param arret la nouvelle valeur du champ arret.
	 */
	public void setArret(boolean arret)
	{
		this.arret = arret;
	}

	/*_______________________________________________________________*/
	/** Permet d'obtenir la valeur du champ action.
	 * @return la valeur du champ action.
	 */
	public int getAction()
	{
		return action;
	}

	/*_______________________________________________________________*/
	/** Modifie la valeur du champ action.
	 * @param action la nouvelle valeur du champ action.
	 */
	public void setAction(int action)
	{
		this.action = action;
	}

	/*_______________________________________________________________*/
	/**Creer les composants
	 */
	private void creerComposants()
	{
		
		JLabel label_haut_haut = new JLabel("Sélectionnez votre élément");
		JLabel label_haut = new JLabel(" puis votre case.");
		label_haut.setPreferredSize(new Dimension(20, 20));
		label_haut_haut.setPreferredSize(new Dimension(20, 20));
		JPanel pan_label_haut = new JPanel();
		pan_label_haut.setLayout(new GridLayout(2, 1));
		pan_label_haut.add(label_haut_haut);
		pan_label_haut.add(label_haut);
		pan_ensemble = new JPanel(new BorderLayout());
		pan_ensemble.add(pan_label_haut, BorderLayout.NORTH);
		pan_image = new JPanel();
		pan_image.setLayout(new GridLayout(3,3));
		pan_image.setMinimumSize(new Dimension(400,500));
		pan_image.setPreferredSize(new Dimension(250, 400));
		
		icones = new ArrayList<ImageIcon>();
		icones.add(new ImageIcon("./res/animaux/gazelle/gazelle.png"));
		icones.add(new ImageIcon("./res/animaux/girafe/girafe.png"));
		icones.add(new ImageIcon("./res/animaux/hyene/hyene.png"));
		icones.add(new ImageIcon("./res/animaux/lion/lion1.png"));
		icones.add(new ImageIcon("./res/obstacles/obstacle1.png"));
		icones.add(new ImageIcon("./res/ressource/plante/plante1.png"));
		icones.add(new ImageIcon("./res/ressource/viande/viande1.png"));
		
		images = new ArrayList<JLabel>();
		
		for(int i = 0 ; i< icones.size(); i++)
		{
			images.add(new JLabel(icones.get(i)));
			images.get(i).addMouseListener(this);
			pan_image.add(images.get(i));
		}
		
		
		pan_ensemble.add(pan_image, BorderLayout.CENTER);
		
			
	}
	
	/*_______________________________________________________________*/
	/**Placer les composants
	 */
	private void placerComposants()
	{
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(pan_ensemble, BorderLayout.WEST);
	}
	

	/*_______________________________________________________________*/
	/**
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		creerComposants();
		placerComposants();
		while(arret)
		{
			
		}
		
	}

	/*_______________________________________________________________*/
	/**
	 *@param e
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e)
	{
		
	}

	
	/*_______________________________________________________________*/
	/**
	 *@param e
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e)
	{
		for(int i=0; i<images.size(); i++)
		{
			if(e.getSource() == images.get(i))
			{
				this.setAction(i);
			}
		}
		
		
	}

	/*_______________________________________________________________*/
	/**
	 *@param e
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e)
	{
		// PENSER à IMPLEMENTER Auto-generated method stub
		
	}

	/*_______________________________________________________________*/
	/**
	 *@param e
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e)
	{
		// PENSER à IMPLEMENTER Auto-generated method stub
		
	}

	/*_______________________________________________________________*/
	/**
	 *@param e
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e)
	{
		// PENSER à IMPLEMENTER Auto-generated method stub
		
	}

	/*_______________________________________________________________*/
	/**
	 *@param e
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e)
	{
		// PENSER à IMPLEMENTER Auto-generated method stub
		
	}

	
}

/*_______________________________________________________________*/
/* Fin du fichier ActionUtilisateur.java
/*_______________________________________________________________*/
