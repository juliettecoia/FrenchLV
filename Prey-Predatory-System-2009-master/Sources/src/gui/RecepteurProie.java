package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import moteur.Proie;

class RecepteurProie implements ChangeListener, ActionListener
{
	/**
	 * réceptionne les événements sur les JSlider
	 */
	public void stateChanged(ChangeEvent evt) 
	{
		JSlider source = (JSlider)evt.getSource();
		if(source.getName() == "taux de reproduction" && !source.getValueIsAdjusting())
		{
			double val = (double)source.getValue();
			Proie.lambdaReproduction = val/100;
		}
	}

	/**
	 * réceptionne les événements sur les JComboBox
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand() == "vitesse proie")
		{
			JComboBox source = (JComboBox)e.getSource();
			String s = (String)source.getSelectedItem();
			if (s == "Très lent")
			{
				Proie.vitesse = 1;
			}
			else if (s == "Lent")
			{
				Proie.vitesse = 2;
			}
			else if (s == "Moyen")
			{
				Proie.vitesse = 3;
			}
			else if (s == "Rapide")
			{
				Proie.vitesse = 4;
			}
			else if (s == "Très rapide")
			{
				Proie.vitesse = 5;
			}
		}
		else if (e.getActionCommand() == "zone de ponte")
		{
			JComboBox source = (JComboBox)e.getSource();
			String s = (String)source.getSelectedItem();
			if (s == "Très petite")
			{
				Proie.zonePonte = 1;
			}
			else if (s == "Petite")
			{
				Proie.zonePonte = 2;
			}
			else if (s == "Moyenne")
			{
				Proie.zonePonte = 3;
			}
			else if (s == "Grande")
			{
				Proie.zonePonte = 4;
			}
			else if (s == "Très grande")
			{
				Proie.zonePonte = 25;
			}
		}
	}
}
