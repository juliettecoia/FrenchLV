package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import moteur.Monde;

@SuppressWarnings("serial")
class PanneauMonde extends JPanel
{
	static JLabel textErreur;
	
	PanneauMonde(int largeur,int hauteur, Monde leMonde, PanneauVisualisation pVisualisation, PanneauGraphe pGraphe, JComboBox listeTaille, JTextField boiteNbPredateurs, JTextField boiteNbProies)
	{
		RecepteurMonde eventMonde = new RecepteurMonde();
		this.setPreferredSize(new Dimension(largeur, hauteur));
		this.setLayout(null);
		
		//taille du monde
		JLabel textListeTaille = new JLabel();
		textListeTaille.setBounds(15, 20, 100, 20);
		textListeTaille.setText("Taille : ");
		this.add(textListeTaille);
		listeTaille.setBounds(135, 15, 100, 30);
		listeTaille.addActionListener(eventMonde);
		this.add(listeTaille);
		
		//Nombres de predateurs
		JLabel textBoiteNbPredateurs = new JLabel("Nombres de predateurs :  ");
		textBoiteNbPredateurs.setBounds(15, 60, 170, 20);
		this.add(textBoiteNbPredateurs);
		boiteNbPredateurs.setBounds(185, 55, 50, 30);
		boiteNbPredateurs.setText("1000");
		boiteNbPredateurs.addActionListener(eventMonde);
		this.add(boiteNbPredateurs);
		
		//Nombres de proies
		JLabel textBoiteNbProies = new JLabel("Nombres de proies :  ");
		textBoiteNbProies.setBounds(15, 95, 170, 20);
		this.add(textBoiteNbProies);
		boiteNbProies.setBounds(185, 90, 50, 30);
		boiteNbProies.setText("2000");
		boiteNbProies.addActionListener(eventMonde);
		this.add(boiteNbProies);
		
		PanneauMonde.textErreur = new JLabel("ERREUR !! Veuillez rentrez un nombre.");
		PanneauMonde.textErreur.setForeground(Color.RED);
		PanneauMonde.textErreur.setBounds(15, 125, 300, 20);
		PanneauMonde.textErreur.setVisible(false);
		this.add(PanneauMonde.textErreur);
	}
}