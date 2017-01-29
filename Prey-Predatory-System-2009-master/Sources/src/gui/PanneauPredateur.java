package gui;

import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

@SuppressWarnings("serial")
class PanneauPredateur extends JPanel
{
	PanneauPredateur(int largeur, int hauteur, JComboBox listeVitessePredateur, JComboBox listeZoneDInfluence, JSlider tauxDeMort, JSlider tauxAgmentationDeReproduction)
	{	
		this.setPreferredSize(new Dimension(largeur, hauteur));
		this.setLayout(null);
		
		RecepteurPredateur eventPredateur = new RecepteurPredateur();

		//vitesse
		JLabel textListeVitessePredateur = new JLabel();
		textListeVitessePredateur.setText("Vitesse :");
		textListeVitessePredateur.setBounds(15, 20, 100, 20);
		this.add(textListeVitessePredateur);
		listeVitessePredateur.setBounds(185, 15, 130, 30);
		listeVitessePredateur.setSelectedIndex(4);
		listeVitessePredateur.addActionListener(eventPredateur);
		this.add(listeVitessePredateur);
		
		//Zone d'influence
		JLabel textListeZoneDInfluence = new JLabel();
		textListeZoneDInfluence.setText("Zone d'influence :");
		textListeZoneDInfluence.setBounds(15, 60, 170, 20);
		this.add(textListeZoneDInfluence);
		listeZoneDInfluence.setBounds(185, 55, 150, 30);
		listeZoneDInfluence.setSelectedIndex(1);
		listeZoneDInfluence.addActionListener(eventPredateur);
		this.add(listeZoneDInfluence);

		//taux de mort
		JLabel textTauxDeMort = new JLabel();
		textTauxDeMort.setText("Taux de mort :");
		textTauxDeMort.setBounds(15, 125, 170, 20);
		this.add(textTauxDeMort);
		tauxDeMort.setBounds(185, 105, 170, 70);
		tauxDeMort.setValue(83);
		tauxDeMort.addChangeListener(eventPredateur);
		this.add(tauxDeMort);

		//taux d'augmentation de reproduction
		JLabel textTauxAgmentationDeReproduction1 = new JLabel();
		JLabel textTauxAgmentationDeReproduction2 = new JLabel();
		textTauxAgmentationDeReproduction1.setText("Taux d'augmentation");
		textTauxAgmentationDeReproduction2.setText(" de reproduction :");
		textTauxAgmentationDeReproduction1.setBounds(15, 185, 170, 50);
		textTauxAgmentationDeReproduction2.setBounds(15, 200, 170, 50);
		this.add(textTauxAgmentationDeReproduction1);
		this.add(textTauxAgmentationDeReproduction2);
		tauxAgmentationDeReproduction.setBounds(185, 185, 170, 70);
		tauxAgmentationDeReproduction.setValue(33);
		tauxAgmentationDeReproduction.addChangeListener(eventPredateur);
		this.add(tauxAgmentationDeReproduction);
	}
}