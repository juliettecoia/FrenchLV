package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import moteur.Predateur;

class RecepteurPredateur implements ActionListener, ChangeListener
{
	/**
	 * réceptionne les actions sur les JSlider
	 */
	public void stateChanged(ChangeEvent evt) 
	{
		JSlider source = (JSlider)evt.getSource();

		if(source.getName() == "taux de mort" && !source.getValueIsAdjusting())
		{
			double val = (double)source.getValue();
			Predateur.lambdaMort = val/100;
		}
		else if(source.getName() == "taux d'augmentation de reproduction" && !source.getValueIsAdjusting())
		{
			double val = (double)source.getValue();
			Predateur.tauxAugmentationReproduction = val/100;
		}
	}

	/**
	 * réceptionne les actions sur JComboBox
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand() == "vitesse predateur")
		{
			JComboBox source = (JComboBox)e.getSource();
			String s = (String)source.getSelectedItem();
			if (s == "Très lent")
			{
				Predateur.vitesse = 1;
			}
			else if (s == "Lent")
			{
				Predateur.vitesse = 2;
			}
			else if (s == "Moyen")
			{
				Predateur.vitesse = 3;
			}
			else if (s == "Rapide")
			{
				Predateur.vitesse = 4;
			}
			else if (s == "Très rapide")
			{
				Predateur.vitesse = 5;
			}
		}
		else if (e.getActionCommand() == "zone d'influence")
		{
			JComboBox source = (JComboBox)e.getSource();
			String s = (String)source.getSelectedItem();
			if (s == "Très petite")
			{
				Predateur.zoneInfluence = 1;
			}
			else if (s == "Petite")
			{
				Predateur.zoneInfluence = 2;
			}
			else if (s == "Moyenne")
			{
				Predateur.zoneInfluence = 3;
			}
			else if (s == "Grande")
			{
				Predateur.zoneInfluence = 4;
			}
			else if (s == "Très grande")
			{
				Predateur.zoneInfluence = 5*10;
			}
		}
	}
}
