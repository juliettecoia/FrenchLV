package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import moteur.Monde;

@SuppressWarnings("serial")
class PanneauUtilisateur extends JPanel
{
	private Monde leMonde;
	
	PanneauUtilisateur(Monde leMonde, PanneauGraphe pGraphe)
	{
		this.leMonde = leMonde;
		this.setPreferredSize(new Dimension(800,420));
		
		PanneauVisualisation pVisualisation = new PanneauVisualisation(this.leMonde);		
		PanneauParametre pParametre = new PanneauParametre(this.leMonde, pVisualisation, pGraphe);

		this.add(pVisualisation,BorderLayout.WEST);
		this.add(pParametre,BorderLayout.EAST);
	}
}
