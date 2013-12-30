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
public class ActionUtilisateur extends JInternalFrame implements Runnable, ActionListener, MouseListener
{
	/**  */
	private static final long serialVersionUID = 1L;
	/**  */
	private ArrayList<JLabel> listeImages;
	/**  */
	private JPanel pan_image;
	/**  */
	//private ArrayList<JButton> listeBouton;
	private JPanel pan_ensemble;

	/*_______________________________________________________________*/
	/**Constructeur
	 */
	public ActionUtilisateur()
	{
		super("Action utilisateur", true, false);
		this.setVisible(true);
	
	}
	
	/*_______________________________________________________________*/
	/**Creer les composants
	 */
	private void creerComposants()
	{
		JLabel label_haut = new JLabel("Sélectionnez votre élément");
		label_haut.setPreferredSize(new Dimension(20, 20));
		pan_ensemble = new JPanel(new BorderLayout());
		pan_ensemble.add(label_haut, BorderLayout.NORTH);
		pan_image = new JPanel();
		pan_image.setLayout(new GridLayout(3,3));
		pan_image.setMinimumSize(new Dimension(400,500));
		pan_image.setPreferredSize(new Dimension(250, 400));
		listeImages = new ArrayList<JLabel>();
	
		for(int i=0; i<7; i++)
		{
			
			switch (i)
			{
			case 0: listeImages.add(new JLabel());
					ImageIcon icone = new ImageIcon("./res/animaux/gazelle/gazelle.png");
					JLabel image = new JLabel(icone);
					image.addMouseListener(this);
					pan_image.add(image);
				break;
			case 1: listeImages.add(new JLabel());
					ImageIcon icone2 = new ImageIcon("./res/animaux/girafe/girafe.png");
					JLabel image2 = new JLabel(icone2);
					image2.addMouseListener(this);
					pan_image.add(image2);
				break;	
			case 2: listeImages.add(new JLabel());
					ImageIcon icone3 = new ImageIcon("./res/animaux/hyene/hyene.png");
					JLabel image3 = new JLabel(icone3);
					image3.addMouseListener(this);
					pan_image.add(image3);
				break;
			case 3: listeImages.add(new JLabel());
					ImageIcon icone4 = new ImageIcon("./res/animaux/lion/lion1.png");
					JLabel image4 = new JLabel(icone4);
					image4.addMouseListener(this);
					pan_image.add(image4);
				break;	
			case 4: listeImages.add(new JLabel());
					ImageIcon icone5 = new ImageIcon("./res/obstacles/obstacle1.png");
					JLabel image5 = new JLabel(icone5);
					image5.addMouseListener(this);
					pan_image.add(image5);
				break;	
			case 5: listeImages.add(new JLabel());
					ImageIcon icone6 = new ImageIcon("./res/ressource/plante/plante1.png");
					JLabel image6 = new JLabel(icone6);
					image6.addMouseListener(this);
					pan_image.add(image6);
					
				break;	
			case 6: listeImages.add(new JLabel());
					ImageIcon icone7 = new ImageIcon("./res/ressource/viande/viande1.png");
					JLabel image7 = new JLabel(icone7);
					image7.addMouseListener(this);
					pan_image.add(image7);
				
			default:
				break;
			}
				
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
		System.out.println("coucou");
		if(e.getSource() == listeImages)
		{
			System.out.println("hey");
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
