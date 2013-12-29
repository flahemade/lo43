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
public class ActionUtilisateur extends JInternalFrame implements Runnable, ActionListener, MouseMotionListener
{
	/**  */
	private static final long serialVersionUID = 1L;
	/**  */
	private ArrayList<JLabel> listeImages;
	/**  */
	private JPanel pan_image;
	/**  */
	//private ArrayList<JButton> listeBouton;
	

	/*_______________________________________________________________*/
	/**Constructeur
	 */
	public ActionUtilisateur()
	{
		super("Action utilisateur", true, false);
		this.setVisible(true);
		this.addMouseMotionListener(this);
	
	}
	
	/*_______________________________________________________________*/
	/**Creer les composants
	 */
	private void creerComposants()
	{
		pan_image = new JPanel();
		pan_image.setLayout(new GridLayout(3,3));
		pan_image.setMinimumSize(new Dimension(400,500));
		pan_image.setPreferredSize(new Dimension(250, 400));
		listeImages = new ArrayList<JLabel>();
	//	listeBouton = new ArrayList<JButton>();
		for(int i=0; i<7; i++)
		{
			
			switch (i)
			{
			case 0: listeImages.add(new JLabel());
					//listeBouton.add(new JButton("+1"));
					ImageIcon icone = new ImageIcon("./res/animaux/gazelle/gazelle.png");
					JLabel image = new JLabel(icone);
					pan_image.add(image);
					//pan_image.add(listeBouton.get(0));
				break;
			case 1: listeImages.add(new JLabel());
					//listeBouton.add(new JButton("+1"));
					ImageIcon icone2 = new ImageIcon("./res/animaux/girafe/girafe.png");
					JLabel image2 = new JLabel(icone2);
					pan_image.add(image2);
					//pan_image.add(listeBouton.get(1));
				break;	
			case 2: listeImages.add(new JLabel());
					//listeBouton.add(new JButton("+1"));
					ImageIcon icone3 = new ImageIcon("./res/animaux/hyene/hyene.png");
					JLabel image3 = new JLabel(icone3);
					pan_image.add(image3);
					//pan_image.add(listeBouton.get(2));
				break;
			case 3: listeImages.add(new JLabel());
					//listeBouton.add(new JButton("+1"));
					ImageIcon icone4 = new ImageIcon("./res/animaux/lion/lion1.png");
					JLabel image4 = new JLabel(icone4);
					pan_image.add(image4);
					//pan_image.add(listeBouton.get(3));
				break;	
			case 4: listeImages.add(new JLabel());
					//listeBouton.add(new JButton("+1"));
					ImageIcon icone5 = new ImageIcon("./res/obstacles/obstacle1.png");
					JLabel image5 = new JLabel(icone5);
					pan_image.add(image5);
					//pan_image.add(listeBouton.get(4));
				break;	
			case 5: listeImages.add(new JLabel());
					//listeBouton.add(new JButton("+1"));
					ImageIcon icone6 = new ImageIcon("./res/ressource/plante/plante1.png");
					JLabel image6 = new JLabel(icone6);
					pan_image.add(image6);
					//pan_image.add(listeBouton.get(5));
					
				break;	
			case 6: listeImages.add(new JLabel());
					//listeBouton.add(new JButton("+1"));
					ImageIcon icone7 = new ImageIcon("./res/ressource/viande/viande1.png");
					JLabel image7 = new JLabel(icone7);
					pan_image.add(image7);
					//pan_image.add(listeBouton.get(6));
				
			default:
				break;
			}
				
		}
		for(int i=0; i<listeImages.size(); i++)
		{
			
		}
			
	}
	
	/*_______________________________________________________________*/
	/**Placer les composants
	 */
	private void placerComposants()
	{
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(pan_image, BorderLayout.WEST);
	}

	/*_______________________________________________________________*/
	/**
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		creerComposants();
		placerComposants();
		
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
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent e)
	{
		
		
	}

	/*_______________________________________________________________*/
	/**
	 *@param e
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent e)
	{
		// PENSER à IMPLEMENTER Auto-generated method stub
		
	}

	
}

/*_______________________________________________________________*/
/* Fin du fichier ActionUtilisateur.java
/*_______________________________________________________________*/
