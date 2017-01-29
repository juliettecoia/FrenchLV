package gui;
import java.awt.BorderLayout;

import javax.swing.JPanel;

import moteur.Monde;

@SuppressWarnings("serial")
class PanneauGeneral extends JPanel
{
	PanneauGeneral(Monde leMonde)
	{
		super();
		PanneauGraphe pGraphe = new PanneauGraphe(leMonde);
		PanneauUtilisateur pUtilisateur = new PanneauUtilisateur(leMonde, pGraphe);
		this.add(pUtilisateur,BorderLayout.CENTER);
		this.add(pGraphe,BorderLayout.SOUTH);
	}
}
