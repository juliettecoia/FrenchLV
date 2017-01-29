package gui;

import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

@SuppressWarnings("serial")
class PanneauProie extends JPanel
{
	PanneauProie(int largeur, int hauteur, JComboBox listeVitesseProie, JComboBox listeZoneDePonte, JSlider tauxDeReproduction)
	{
		this.setPreferredSize(new Dimension(largeur, hauteur));
		this.setLayout(null);

		RecepteurProie eventProie = new RecepteurProie();
		
		//vitesse
		JLabel textListeVitesseProie = new JLabel();
		textListeVitesseProie.setText("Vitesse : ");
		textListeVitesseProie.setBounds(15, 20, 100, 20);
		this.add(textListeVitesseProie);
		listeVitesseProie.setBounds(185, 15, 130, 30);
		listeVitesseProie.setSelectedIndex(2);
		listeVitesseProie.addActionListener(eventProie);
		this.add(listeVitesseProie);
		
		//Zone de ponte
		JLabel textListeZoneDePonte = new JLabel();
		textListeZoneDePonte.setText("Zone de ponte : ");
		textListeZoneDePonte.setBounds(15, 60, 170, 20);
		this.add(textListeZoneDePonte);
		listeZoneDePonte.setBounds(185, 55, 150, 30);
		listeZoneDePonte.setSelectedIndex(0);
		listeZoneDePonte.addActionListener(eventProie);
		this.add(listeZoneDePonte);
		
		//taux de reproduction
		JLabel textTauxDeReproduction = new JLabel();
		textTauxDeReproduction.setText("Taux de reproduction : ");
		textTauxDeReproduction.setBounds(15, 125, 170, 20);
		this.add(textTauxDeReproduction);
		tauxDeReproduction.setBounds(185, 105, 170, 70);
		tauxDeReproduction.addChangeListener(eventProie);
		tauxDeReproduction.setValue(88);
		this.add(tauxDeReproduction);

	}
}
