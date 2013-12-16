package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

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

    private Map myMap;
    
    /**  */
    private JSplitPane monSplitPane;
    
    /**  */
    private JSplitPane monSplitPane2;
    
   
	
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
		btn_quitter.setPreferredSize(new Dimension(150, 30));
		btn_pause = new JButton("Pause");
		btn_pause.setPreferredSize(new Dimension(150, 30));
		btn_aide = new JButton("Aide");
		btn_aide.setPreferredSize(new Dimension(150, 30));
		btn_quitter.addActionListener(this);
		
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
		
	}

 	

}