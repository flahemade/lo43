package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Modele.Map;

/*_______________________________________________________________*/
/**
 * @author anaelle
 *
 */
public class Plateau extends JFrame{

	private JButton btn_pause;

	private JButton btn_enregistrer;
	
	private JButton btn_aide;

    private Map myMap;
    
    private JSplitPane monSplitPane;
    
    private JSplitPane monSplitPane2;
    
    private Vector rafraichir;
	
	public Plateau(String titre) 
	{
		super(titre);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(900,700));
		this.setLocationRelativeTo(null);
		creerComposants();
		placerComposants();
 	}

	private void creerComposants() 
	{
		btn_enregistrer = new JButton("Enregistrer");
		btn_enregistrer.setPreferredSize(new Dimension(150, 30));
		btn_pause = new JButton("Pause");
		btn_pause.setPreferredSize(new Dimension(150, 30));
		btn_aide = new JButton("Aide");
		btn_aide.setPreferredSize(new Dimension(150, 30));
		
	}

	private void placerComposants()
	{
		JPanel jpBas = new JPanel();
		jpBas.setLayout(new FlowLayout());
		jpBas.add(btn_pause);
		jpBas.add(btn_enregistrer);
		jpBas.add(btn_aide);
		JPanel jpDroit = new JPanel();
		jpDroit.setLayout(new BorderLayout());
		jpDroit.add(jpBas, BorderLayout.SOUTH);
		JPanel jpGauche = new JPanel();
		jpGauche.setLayout(new BorderLayout());
		jpGauche.setPreferredSize(new Dimension(250, this.getHeight()));
		JPanel jp_gaucheHaut = new JPanel();
		jp_gaucheHaut.setPreferredSize(new Dimension(250, this.getHeight()/2));
		JPanel jp_gaucheBas = new JPanel();
		monSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jp_gaucheHaut, jp_gaucheBas);
		monSplitPane2.setDividerSize(15);
		jpGauche.add(monSplitPane2);
		monSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jpGauche, jpDroit);
		monSplitPane.setDividerSize(20);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(monSplitPane);
	}

 	

}