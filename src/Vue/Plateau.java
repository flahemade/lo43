package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

import Modele.Case;
import Modele.Map;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Plateau extends JFrame implements ActionListener, MouseListener{

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
    
    private JPanel jpDroit;
    
    private JPanel jp_gaucheBas;
    
    private JPanel jpGauche;
    
    private JPanel jpBas;
    
    private JPanel jp_gaucheHaut;
    /**  */
    private ActionUtilisateur utilisateur;
    
    private int actionCase;
    
    private ArrayList<JPanel> panel_case;
    
 
	
	/*_______________________________________________________________*/
	/**le constructeur de la fenêtre
	 * @param titre le titre de la fenêtre
	 */
	public Plateau(String titre, ActionUtilisateur utilisateur) 
	{
		super(titre);
		setActionCase(-1);
		this.utilisateur = utilisateur;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(900,700));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
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
		jp_gaucheBas = new JPanel();
		jpGauche = new JPanel();
		jpBas = new JPanel();
		jp_gaucheHaut = new JPanel();
		panel_case = new ArrayList<JPanel>();
		 
		
	}

	/*_______________________________________________________________*/
	/**Méthode qui place les composants
	 */
	private void placerComposants()
	{
		jpBas.setLayout(new FlowLayout());
		jpBas.add(btn_pause);
		jpBas.add(btn_aide);
		jpBas.add(btn_quitter);
		jpDroit.setLayout(new BorderLayout());
		jpDroit.add(jpBas, BorderLayout.SOUTH);
		jpGauche.setLayout(new BorderLayout());
	//	jpGauche.setPreferredSize(new Dimension(250, this.getHeight()));
		jpGauche.setPreferredSize(new Dimension(250, 4*40)); //Pas adaptatif
	//	jp_gaucheHaut.setPreferredSize(new Dimension(250, this.getHeight()/2));
		jp_gaucheHaut.setPreferredSize(new Dimension(250, 6*40)); //C'est moche
		jp_gaucheHaut.setLayout(new BorderLayout());
		jp_gaucheHaut.add(utilisateur, BorderLayout.CENTER);
		jp_gaucheBas.setLayout(new BorderLayout());
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
			utilisateur.setArret(false);
			
			System.exit(0);
			
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
	/** Permet d'obtenir la valeur du champ actionCase.
	 * @return la valeur du champ actionCase.
	 */
	public int getActionCase()
	{
		return actionCase;
	}

	/*_______________________________________________________________*/
	/** Modifie la valeur du champ actionCase.
	 * @param actionCase la nouvelle valeur du champ actionCase.
	 */
	public void setActionCase(int actionCase)
	{
		this.actionCase = actionCase;
	}

	/*_______________________________________________________________*/
 	/**
 	 * @param maMap
 	 */
 	public void afficherMap(Map maMap)
 	{
 		//this.repaint();	
 		ArrayList<Case> mesCases = maMap.getListeCases();
 		JPanel pan = new JPanel(new GridLayout(16,16));
		Border blackline = BorderFactory.createLineBorder(Color.black,1);
 		for(int i=0; i<mesCases.size(); i++)
 		{
 			JPanel ptest = new JPanel();
 			panel_case.add(ptest);
 			ptest.addMouseListener(this);
 			ptest.setLayout(new BorderLayout());
 			ptest.setPreferredSize(new Dimension(40,40));
 			ptest.setMinimumSize(new Dimension(40, 40));
 			ptest.add(mesCases.get(i), BorderLayout.CENTER);
 			ptest.setBorder(blackline);
 			pan.add(ptest);
 			for(int j=0; j< mesCases.get(i).getListeElements().size(); j++)
 			{
 				ImageIcon icone = new ImageIcon(mesCases.get(i).getListeElements().get(j).getImage());
 				JLabel image = new JLabel(icone);
 				image.setLayout(new BorderLayout());
 				image.addMouseListener(this);
 				ptest.add(image, BorderLayout.CENTER);
 			}
 		}
 		pan.setBorder(blackline);
 		//jpDroit.removeAll();
 		jpDroit.add(pan, BorderLayout.CENTER);
 		//this.pack();//nicolas : avec ca j'aiplus besoin de mettre la fenetre en plein ecran pour avoir un affichage
 		this.paintAll(getGraphics());
 		
 	}
 	
 	/*_______________________________________________________________*/
 	/**Afficher les statistiques
 	 * @param obstacle le nombre d'obstacle présent sur la carte
 	 * @param ressource le nombre de ressource présent sur la carte
 	 */
 	public void afficherStat(int animal, int obstacle, int ressource)
 	{
 		ArrayList<JLabel> labels = new ArrayList<JLabel>();
 		labels.add(new JLabel("Statistique du jeu:"));
 		labels.add(new JLabel("Nombre d'Animal :" + animal));
 		labels.add(new JLabel("Nombre d'Obstacles :" + obstacle));
 		labels.add(new JLabel("Nombre de Ressources :" + ressource));
 		JPanel pan = new JPanel();
 		pan.setLayout(new GridLayout(7,1));
 		for (int i = 0; i < labels.size(); i++)
		{
			pan.add(labels.get(i));
		}
 		jp_gaucheBas.add(pan, BorderLayout.NORTH);
 	}

	/*_______________________________________________________________*/
	/**
	 *@param e
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e)
	{
		for(int i=0; i<panel_case.size(); i++)
		{
			if(e.getSource()==panel_case.get(i))
			{
				this.setActionCase(i);
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