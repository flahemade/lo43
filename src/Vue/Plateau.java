package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

import Controleur.Ordonnanceur;
import Modele.Case;
import Modele.Map;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Plateau extends JFrame implements ActionListener{

	/**  */
	private JButton btn_pause;

	/**  */
	private JButton btn_quitter;
	
	/**  */
	private JButton btn_aide;

    /**  */
    private Map myMap;
    
    /**  */
    private JSplitPane monSplitPane;
    
    /**  */
    private JSplitPane monSplitPane2;
    
    private ActionUtilisateur utilisateur;
    
    private JPanel jpDroit;
    
   
	
	/*_______________________________________________________________*/
	/**le constructeur de la fenêtre
	 * @param titre le titre de la fenêtre
	 */
	public Plateau(String titre) 
	{
		super(titre);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(900,700));
		this.setLocationRelativeTo(null);
		creerComposants();
		placerComposants();
		
 	}

	/*_______________________________________________________________*/
	/**
	 */
	private void creerComposants() 
	{
		btn_quitter = new JButton("Quitter");
		btn_quitter.setPreferredSize(new Dimension(100, 30));
		btn_pause = new JButton("Pause");
		btn_pause.setPreferredSize(new Dimension(100, 30));
		btn_pause.addActionListener(this);
		btn_aide = new JButton("Aide");
		btn_aide.setPreferredSize(new Dimension(100, 30));
		btn_quitter.addActionListener(this);
		jpDroit = new JPanel();
		utilisateur = new ActionUtilisateur();
		
	}

	/*_______________________________________________________________*/
	/**Méthode qui place les composants
	 */
	private void placerComposants()
	{
		JPanel jpBas = new JPanel();
		jpBas.setLayout(new FlowLayout());
		jpBas.add(btn_pause);
		jpBas.add(btn_aide);
		jpBas.add(btn_quitter);
		jpDroit.setLayout(new BorderLayout());
		jpDroit.add(jpBas, BorderLayout.SOUTH);
		JPanel jpGauche = new JPanel();
		jpGauche.setLayout(new BorderLayout());
	//	jpGauche.setPreferredSize(new Dimension(250, this.getHeight()));
		jpGauche.setPreferredSize(new Dimension(250, 4*40)); //Pas adaptatif
		JPanel jp_gaucheHaut = new JPanel();
	//	jp_gaucheHaut.setPreferredSize(new Dimension(250, this.getHeight()/2));
		jp_gaucheHaut.setPreferredSize(new Dimension(250, 4*40)); //C'est moche
		jp_gaucheHaut.setLayout(new BorderLayout());
		jp_gaucheHaut.add(utilisateur);
		JPanel jp_gaucheBas = new JPanel();
		monSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jp_gaucheHaut, jp_gaucheBas);
		monSplitPane2.setDividerSize(15);
		jpGauche.add(monSplitPane2);
		monSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jpGauche, jpDroit);
		monSplitPane.setDividerSize(20);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(monSplitPane);
		
	}

	/*_______________________________________________________________*/
	/**
	 *@param e
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()== btn_quitter)
		{
			//JOptionPane fen_quitter = new JOptionPane("Voulez-vous quitter?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
			//fen_quitter.setVisible(true);
			this.dispose();
			
		}
		if(e.getSource()== btn_pause)
		{
			//this.afficherMap(getMyMap());
		}
		
	}

	/*_______________________________________________________________*/
	/** Permet d'obtenir la valeur du champ myMap.
	 * @return la valeur du champ myMap.
	 */
	public Map getMyMap()
	{
		return myMap;
	}

	/*_______________________________________________________________*/
	/** Modifie la valeur du champ myMap.
	 * @param myMap la nouvelle valeur du champ myMap.
	 */
	public void setMyMap(Map myMap)
	{
		this.myMap = myMap;
	}

 	/*_______________________________________________________________*/
 	/**
 	 * @param maMap
 	 */
 	public void afficherMap(Map maMap)
 	{
 		this.repaint();
 		ArrayList<Case> mesCases = maMap.getListeCases();
 		
 		JPanel pan = new JPanel(new GridLayout(8,8));
		Border blackline = BorderFactory.createLineBorder(Color.black,1);
 		for(int i=0; i<mesCases.size(); i++)
 		{
 			JPanel ptest = new JPanel();
 			ptest.setLayout(new BorderLayout());
 			ptest.setPreferredSize(new Dimension(40,40));
 			ptest.setMinimumSize(new Dimension(40, 40));
 			ptest.add(mesCases.get(i), BorderLayout.CENTER);
 			ptest.setBorder(blackline);
 			/*int id = mesCases.get(i).getId();
 			pan.add(new JLabel(Integer.toString(id))); DEBUG*/
 			pan.add(ptest);
 			
 			/*for(int j=0; j<mesCases.get(i).getListeElements().size(); j++)
 				System.out.println(mesCases.get(i).getListeElements().get(j).getCaseId());*/
 				
 			for(int j=0; j< mesCases.get(i).getListeElements().size(); j++)
 			{
 				
 				/*String nom = mesCases.get(i).getListeElements().get(j).getImage();
 				ptest.add(new JLabel(nom));*/
 				ImageIcon icone = new ImageIcon(mesCases.get(i).getListeElements().get(j).getImage());
 				JLabel image = new JLabel(icone);
 				image.setLayout(new BorderLayout());
 				ptest.add(image, BorderLayout.CENTER);
 				
 			}
 			
 				
 			//System.out.println("num case : " + mesCases.get(i).getId()+ " " + mesCases.get(i).getPosition().getX()+ " " + mesCases.get(i).getPosition().getY());
 		}
 		pan.setBorder(blackline);
 		jpDroit.add(pan, BorderLayout.CENTER);
 		this.pack();//nicolas : avec ca j'aiplus besoin de mettre la fenetre en plein ecran pour avoir un affichage
 	}

}