package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import moteur.Monde;

class RecepteurMonde implements ActionListener
{
	/**
	 * réceptionne les actions sur les JComboBox
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand() == "taille")
		{
			JComboBox source = (JComboBox)e.getSource();
			String s = (String)source.getSelectedItem();
			if (s == "Petit")
			{
				Monde.taille = 1*100;
			}
			else if (s == "Moyen")
			{
				Monde.taille = 2*100;
			}
			else if (s == "Grand")
			{
				Monde.taille = 4*100;
			}
		}
	}
}
