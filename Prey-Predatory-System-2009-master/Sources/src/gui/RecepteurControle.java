package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextField;

import moteur.Monde;

class RecepteurControle implements ActionListener, Runnable
{
	private Monde leMonde;
	private PanneauVisualisation pVisualisation;
	private PanneauGraphe pGraphe;
	private ExecutorService es;
	static int nbProies = 0;
	static int nbPredateurs = 0;
	private boolean bool= true;
	//Les paramètre et boutons
	private JComboBox listeVitesseProie, listeVitessePredateur, listeZoneDePonte, listeZoneDInfluence, listeTaille;
	private JSlider tauxDeReproduction, tauxAgmentationDeReproduction, tauxDeMort;
	private JTextField boiteNbPredateurs, boiteNbProies;
	private JButton valider;
	
	RecepteurControle(Monde leMonde, PanneauVisualisation pVisualisation, PanneauGraphe pGraphe, JComboBox listeVitesseProie, JComboBox listeVitessePredateur, JComboBox listeZoneDePonte, JComboBox listeZoneDInfluence, JSlider tauxDeReproduction, JSlider tauxDeMort, JSlider tauxAgmentationDeReproduction, JComboBox listeTaille, JTextField boiteNbPredateurs, JTextField boiteNbProies, JButton valider)
	{
		this.es = Executors.newFixedThreadPool(1);
		this.leMonde = leMonde;
		this.pVisualisation = pVisualisation;
		this.pGraphe = pGraphe;
		
		this.listeTaille = listeTaille;
		this.listeVitessePredateur = listeVitessePredateur;
		this.listeVitesseProie = listeVitesseProie;
		this.listeZoneDePonte = listeZoneDePonte;
		this.listeZoneDInfluence = listeZoneDInfluence;
		
		this.tauxAgmentationDeReproduction = tauxAgmentationDeReproduction;
		this.tauxDeMort = tauxDeMort;
		this.tauxDeReproduction = tauxDeReproduction;
		
		this.boiteNbPredateurs = boiteNbPredateurs;
		this.boiteNbProies = boiteNbProies;
		
		this.valider = valider;
	}
	
	/**
	 * recéptionne les actions sur les boutons
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand() == "valider")
		{
			try
			{
				//On récupére les valeurs des JTextFields
				RecepteurControle.nbPredateurs = Integer.parseInt(this.boiteNbPredateurs.getText());
				RecepteurControle.nbProies = Integer.parseInt(this.boiteNbProies.getText());
				PanneauMonde.textErreur.setVisible(false);
				
				//On crée le monde puis initialise toutes les vues.
				this.leMonde = new Monde(RecepteurControle.nbProies, RecepteurControle.nbPredateurs);
				this.pVisualisation.setMonde(this.leMonde);
				this.pGraphe.setMonde(this.leMonde);
				this.pGraphe.ajoutPointPredateurs();
				this.pGraphe.ajoutPointProies();
				this.pVisualisation.repaint();
				this.pGraphe.repaint();
			}
			catch (NumberFormatException x)
			{
				//Si ce n'est pas un nombre qui est rentré on affiche une erreur
				PanneauMonde.textErreur.setVisible(true);
			}
		}
		else if (e.getActionCommand() == "play")
		{
			//On désactive tous les paramètres
			this.valider.setEnabled(false);
			this.listeTaille.setEnabled(false);
			this.listeVitessePredateur.setEnabled(false);
			this.listeVitesseProie.setEnabled(false);
			this.listeZoneDePonte.setEnabled(false);
			this.listeZoneDInfluence.setEnabled(false);
			this.tauxAgmentationDeReproduction.setEnabled(false);
			this.tauxDeMort.setEnabled(false);
			this.tauxDeReproduction.setEnabled(false);
			this.boiteNbPredateurs.setEnabled(false);
			this.boiteNbProies.setEnabled(false);
			//On lance la tâche
			bool = true;
			es.execute(this);
		}
		else if (e.getActionCommand() == "pause")
		{
			//On arrête la tâche
			bool = false;
			//On réactive certains paramètres
			this.listeVitessePredateur.setEnabled(true);
			this.listeVitesseProie.setEnabled(true);
			this.listeZoneDePonte.setEnabled(true);
			this.listeZoneDInfluence.setEnabled(true);
			this.tauxAgmentationDeReproduction.setEnabled(true);
			this.tauxDeMort.setEnabled(true);
			this.tauxDeReproduction.setEnabled(true);
		}
		else if (e.getActionCommand() == "reinit")
		{
			//On désactive la tâche
			bool = false;
			//On réactive tous les paramètres
			this.valider.setEnabled(true);
			this.listeTaille.setEnabled(true);
			this.listeVitessePredateur.setEnabled(true);
			this.listeVitesseProie.setEnabled(true);
			this.listeZoneDePonte.setEnabled(true);
			this.listeZoneDInfluence.setEnabled(true);
			this.tauxAgmentationDeReproduction.setEnabled(true);
			this.tauxDeMort.setEnabled(true);
			this.tauxDeReproduction.setEnabled(true);
			this.boiteNbPredateurs.setEnabled(true);
			this.boiteNbProies.setEnabled(true);
			//On réinitialise le monde
			this.leMonde = new Monde(0, 0);
			this.pVisualisation.setMonde(this.leMonde);
			this.pGraphe.setMonde(this.leMonde);
			this.pVisualisation.repaint();
			this.pGraphe.repaint();
		}
	}
	
	/**
	 * @action
	 * 	permet l'évolution continue des être-vivants
	 */
	public void run() 
	{
		while (bool)
		{
			this.leMonde.evolution();
			this.pGraphe.ajoutPointPredateurs();
			this.pGraphe.ajoutPointProies();
			this.pVisualisation.repaint();
			this.pGraphe.repaint();
			
			try 
			{
				Thread.sleep(100);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

}
