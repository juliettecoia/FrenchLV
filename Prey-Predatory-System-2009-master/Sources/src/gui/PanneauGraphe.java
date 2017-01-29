package gui;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import moteur.Monde;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

@SuppressWarnings("serial")
class PanneauGraphe extends JPanel 
{
	Monde leMonde;
	//les series à représenter
	XYSeriesCollection dataset;
	//la série des predateurs
	XYSeries predateurs;
	//la série des proies
	XYSeries proies;
	
	PanneauGraphe(Monde leMonde)
	{	
		this.leMonde = leMonde;
		this.setPreferredSize(new Dimension(800,300));
		
		//création des données
		this.dataset = new XYSeriesCollection();
		this.predateurs = new XYSeries("Predateurs");
		this.proies = new XYSeries("Proies");
		this.dataset.addSeries(this.predateurs);
		this.dataset.addSeries(this.proies);
		
		//création du graphique
		JFreeChart Graphique = ChartFactory.createXYLineChart(null, "temps", "nb", dataset, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel pGraphique = new ChartPanel(Graphique);
		pGraphique.setPreferredSize(new Dimension(798, 280));
        pGraphique.setPopupMenu(null);
        JScrollPane scrollPane = new JScrollPane(pGraphique);
        this.add(scrollPane);
		this.add(pGraphique);	
	}
	
	/**
	 * @action
	 * 	Ajoute à la liste predateurs la nouvelle valeur du nombre de predateurs pour la date actuelle.
	 */
	public void ajoutPointPredateurs()
	{
		 this.predateurs.add((double) this.leMonde.getDateActuelle(), (double) this.leMonde.tailleTotalePred());
	}
	
	/**
	 * @action
	 * 	Ajoute à la liste proies la nouvelle valeur du nombre de proies pour la date actuelle.
	 */
	public void ajoutPointProies()
	{
		 this.proies.add((double) this.leMonde.getDateActuelle(), (double) this.leMonde.tailleTotaleProie());
	}
	
	/**
	 * @param leMonde
	 * @action
	 * 	Remplace le monde existant par le nouveau monde.
	 */
	void setMonde(Monde leMonde)
	{
		this.leMonde = leMonde;
		this.dataset.removeAllSeries();
		this.predateurs = new XYSeries("Predateurs");
		this.proies = new XYSeries("Proies");
		this.dataset.addSeries(this.predateurs);
		this.dataset.addSeries(this.proies);
	}
	
	/**
	 * permet de redessiner les lignes à chaque raffraichissement de la fenêtre.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawLine(0, 5, 800, 5);
		g.drawLine(0, 10, 800, 10);
		g.drawLine(0, 5, 0, 292);
		g.drawLine(0, 292, 800, 292);
		g.drawLine(799, 5, 799, 292);
	}
}
