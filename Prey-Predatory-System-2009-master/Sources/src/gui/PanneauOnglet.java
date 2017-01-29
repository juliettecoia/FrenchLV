package gui;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import moteur.Monde;

@SuppressWarnings("serial")
class PanneauOnglet extends JPanel
{
	private JTabbedPane tp;
	private PanneauMonde pMonde;
	private PanneauProie pProie;
	private PanneauPredateur pPredateur;
	
	PanneauOnglet(int largeur, int hauteur, Monde leMonde, PanneauVisualisation pVisualisation, PanneauGraphe pGraphe, JComboBox listeVitesseProie, JComboBox listeVitessePredateur, JComboBox listeZoneDePonte, JComboBox listeZoneDInfluence, JSlider tauxDeReproduction, JSlider tauxDeMort, JSlider tauxAgmentationDeReproduction, JComboBox listeTaille, JTextField boiteNbPredateurs, JTextField boiteNbProies)
	{
		this.setPreferredSize(new Dimension(largeur, hauteur));
		
		this.pMonde = new PanneauMonde(largeur-20,hauteur, leMonde, pVisualisation, pGraphe,listeTaille, boiteNbPredateurs, boiteNbProies);
		this.pProie = new PanneauProie(largeur-20,hauteur, listeVitesseProie, listeZoneDePonte,tauxDeReproduction);
		this.pPredateur = new PanneauPredateur(largeur-20,hauteur, listeVitessePredateur, listeZoneDInfluence, tauxDeMort, tauxAgmentationDeReproduction);
		
		this.tp = new JTabbedPane();
		this.tp.setPreferredSize(new Dimension(largeur, hauteur-10));
		this.tp.addTab("Monde", null, this.pMonde, "monde");
		this.tp.addTab("Predateurs", null, this.pPredateur, "predateurs");
		this.tp.addTab("Proies", null, this.pProie, "proies");
		this.add(tp);
	}
}
