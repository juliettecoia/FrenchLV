package gui;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import moteur.Monde;

@SuppressWarnings("serial")
class PanneauControle extends JPanel
{	
	PanneauControle(int largeur, int hauteur, Monde leMonde, PanneauVisualisation pVisualisation, PanneauGraphe pGraphe, JComboBox listeVitesseProie, JComboBox listeVitessePredateur, JComboBox listeZoneDePonte, JComboBox listeZoneDInfluence, JSlider tauxDeReproduction, JSlider tauxDeMort, JSlider tauxAgmentationDeReproduction, JComboBox listeTaille, JTextField boiteNbPredateurs, JTextField boiteNbProies)
	{	
		this.setPreferredSize(new Dimension(largeur, hauteur));
		
		//bouton valider
		JButton valider = new JButton("Valider");
		valider.setActionCommand("valider");
		
		//création du récepteur
		RecepteurControle eventControle = new RecepteurControle(leMonde, pVisualisation, pGraphe, listeVitesseProie, listeVitessePredateur, listeZoneDePonte, listeZoneDInfluence, tauxDeReproduction, tauxDeMort, tauxAgmentationDeReproduction, listeTaille, boiteNbPredateurs, boiteNbProies, valider);

		valider.addActionListener(eventControle);
		this.add(valider);
		
		//bouton de lecture
		JButton lecture = new JButton();
		lecture.setActionCommand("play");
		java.net.URL aboutUrl = PanneauControle.class.getResource("pics/lecture.gif");
		lecture.setIcon(new ImageIcon(aboutUrl));
		lecture.addActionListener(eventControle);
		this.add(lecture);
		
		//bouton de pause
		JButton pause = new JButton();
		pause.setActionCommand("pause");
		java.net.URL aboutUrl2 = PanneauControle.class.getResource("pics/pause.gif");
		pause.setIcon(new ImageIcon(aboutUrl2));
		pause.addActionListener(eventControle);
		this.add(pause);
		
		//bouton de réinitialisation
		JButton reinit = new JButton();
		reinit.setActionCommand("reinit");
		java.net.URL aboutUrl3 = PanneauControle.class.getResource("pics/reinitialiser.gif");
		reinit.setIcon(new ImageIcon(aboutUrl3));
		reinit.addActionListener(eventControle);
		this.add(reinit);
	}
}
