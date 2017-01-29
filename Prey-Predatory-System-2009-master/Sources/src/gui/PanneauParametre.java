package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import moteur.Monde;

@SuppressWarnings("serial")
class PanneauParametre extends JPanel
{
	private int largeur = 380;
	
	PanneauParametre(Monde leMonde, PanneauVisualisation pVisualisation, PanneauGraphe pGraphe)
	{
		super();
		this.setPreferredSize(new Dimension(this.largeur, 410));

		/** Création des composants **/
		
		//Liste déroulante pour la vitesse des proies
		Vector<String> valeursListeVitesse = new Vector<String>();
		valeursListeVitesse.add("Très lent");
		valeursListeVitesse.add("Lent");
		valeursListeVitesse.add("Moyen");
		valeursListeVitesse.add("Rapide");
		valeursListeVitesse.add("Très rapide");
		JComboBox listeVitesseProie = new JComboBox(valeursListeVitesse);
		listeVitesseProie.setActionCommand("vitesse proie");
		
		//Liste déroulante pour la vitesse des predateurs
		JComboBox listeVitessePredateur = new JComboBox(valeursListeVitesse);
		listeVitessePredateur.setActionCommand("vitesse predateur");
		
		//Liste déroulante pour la zone de ponte des proies
		Vector<String> valeursListeZone = new Vector<String>();
		valeursListeZone.add("Très petite");
		valeursListeZone.add("Petite");
		valeursListeZone.add("Moyenne");
		valeursListeZone.add("Grande");
		valeursListeZone.add("Très grande");
		JComboBox listeZoneDePonte = new JComboBox(valeursListeZone);
		listeZoneDePonte.setActionCommand("zone de ponte");
		
		//Liste déroulante pour la zone d'influence des predateurs
		JComboBox listeZoneDInfluence = new JComboBox(valeursListeZone);
		listeZoneDInfluence.setActionCommand("zone d'influence");
		
		//barre gradué pour le taux de reproduction des proies
		JSlider tauxDeReproduction = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		tauxDeReproduction.setName("taux de reproduction");
		tauxDeReproduction.setMajorTickSpacing(20);
		tauxDeReproduction.setPaintTicks(true);
		tauxDeReproduction.setPaintLabels(true);

		//barre gradué pour le taux de mort des predateurs
		JSlider tauxDeMort = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		tauxDeMort.setName("taux de mort");
		tauxDeMort.setMajorTickSpacing(20);
		tauxDeMort.setPaintTicks(true);
		tauxDeMort.setPaintLabels(true);
		
		//barre gradué pour le taux d'augmentation de reproduction des predateurs
		JSlider tauxAgmentationDeReproduction = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		tauxAgmentationDeReproduction.setName("taux d'augmentation de reproduction");
		tauxAgmentationDeReproduction.setMajorTickSpacing(20);
		tauxAgmentationDeReproduction.setPaintTicks(true);
		tauxAgmentationDeReproduction.setPaintLabels(true);
		
		//Liste déroulante pour la taille du monde
		Vector<String> valeursListeTaille = new Vector<String>();
		valeursListeTaille.add("Petit");
		valeursListeTaille.add("Moyen");
		valeursListeTaille.add("Grand");
		JComboBox listeTaille = new JComboBox(valeursListeTaille);
		listeTaille.setActionCommand("taille");
		
		//Boite d'éddition du nombre de predateurs initiaux
		JTextField boiteNbPredateurs = new JTextField(5);
		boiteNbPredateurs.setActionCommand("nbpredateurs");
		
		//Boite d'éddition du nombre de proies initial
		JTextField boiteNbProies = new JTextField(5);
		boiteNbProies.setActionCommand("nbproies");		
		
		PanneauOnglet pOnglet = new PanneauOnglet(largeur, 350, leMonde, pVisualisation, pGraphe, listeVitesseProie, listeVitessePredateur, listeZoneDePonte, listeZoneDInfluence, tauxDeReproduction, tauxDeMort, tauxAgmentationDeReproduction, listeTaille, boiteNbPredateurs, boiteNbProies);
		PanneauControle pControle = new PanneauControle(largeur, 50, leMonde, pVisualisation, pGraphe, listeVitesseProie, listeVitessePredateur, listeZoneDePonte, listeZoneDInfluence, tauxDeReproduction, tauxDeMort, tauxAgmentationDeReproduction, listeTaille, boiteNbPredateurs, boiteNbProies);		
		
		this.add(pOnglet,BorderLayout.NORTH);
		this.add(pControle,BorderLayout.CENTER);
	}
}
