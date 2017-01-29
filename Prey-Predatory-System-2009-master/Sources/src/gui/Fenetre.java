package gui;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import moteur.Monde;

@SuppressWarnings("serial")
public class Fenetre extends JFrame
{
	static final int LARGEUR = 810;
	static final int HAUTEUR = 750;
	private PanneauGeneral panneauGeneral;
	private Monde leMonde;

	public Fenetre()
	{
		//configuration de la fenêtre
		this.setIconImage(new ImageIcon("pics/lion.gif").getImage());
		this.setLocation(100, 100);
		this.setSize(Fenetre.LARGEUR, Fenetre.HAUTEUR);
		this.setResizable(false);
		this.setTitle("Système Proie-Prédateur");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//initialisation du monde
		this.leMonde = new Monde(0,0);
		
		this.panneauGeneral = new PanneauGeneral(this.leMonde);
		this.add(this.panneauGeneral);
		
		//Permet d'utiliser la charte graphique de l'environnement dans lequel est lançé l'application
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
	}
}
