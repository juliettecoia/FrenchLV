package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import moteur.Monde;

@SuppressWarnings("serial")
class PanneauVisualisation extends JPanel 
{
	private static int nbpixels=400;
	private static int tailleCelulle=nbpixels/Monde.taille;
	private Monde m;
	
	PanneauVisualisation(Monde m)
	{
		this.m = m;
		this.setPreferredSize(new Dimension(PanneauVisualisation.nbpixels+10, PanneauVisualisation.nbpixels+10));
	}
	
	/**
	 * dessine la grille avec les proies et les prédateurs
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		PanneauVisualisation.tailleCelulle = nbpixels/Monde.taille;
		//affichage des être-vivants
		for (int i=0; i<this.m.getProies().length; i++)
		{
			for (int j=0; j<this.m.getProies()[i].length; j++)
			{
				if (this.m.getProies()[i][j].size() != 0)
				{
					g.setColor(Color.BLUE);
					g.fillRect(i*tailleCelulle+5, j*tailleCelulle+5, tailleCelulle, tailleCelulle);
				}
				if (this.m.getPredateurs()[i][j].size() != 0)
				{
					g.setColor(Color.RED);
					g.fillRect(i*tailleCelulle+5, j*tailleCelulle+5, tailleCelulle, tailleCelulle);
				}
			}
		}
		
		g.setColor(Color.BLACK);
		g.drawLine(5, 5, 5, 405);
		g.drawLine(5, 5, 405, 5);
		g.drawLine(405, 5, 405, 405);
		g.drawLine(5, 405, 405, 405);
	}

	/**
	 * @param m
	 * remplace le monde par m
	 */
	void setMonde(Monde m)
	{
		this.m = m;
	}

}
