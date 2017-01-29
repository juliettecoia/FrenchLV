package moteur;

public class Predateur extends EtreVivant
{
	public static int vitesse = 5;//1
	public static int zoneInfluence = 2;//2
	private double dateDeMort;
	public static double lambdaMort = 0.83;//0.2
	public double lambdaReproduction = 0.001;
	public static double tauxAugmentationReproduction = 0.33;//0.05
	private double dateDerniereProgeniture = 0;
	
	Predateur(int x, int y, double date)
	{
		super(x,y,date);
		this.dateDeMort = date+this.horloge(Predateur.lambdaMort);
		this.setDateDeReproduction(this.lambdaReproduction, this.getDateDeNaissance());
	}

	/**
	 * @return
	 * 	retourne un predateur avec les mêmes coordonnées et la date actuelle comme date de naissance.
	 */
	Predateur progeniture(double date)
	{
		this.dateDerniereProgeniture = date;
		this.setDateDeReproduction(this.lambdaReproduction, date);
		return new Predateur(this.getX(),this.getY(),date);
	}
	
	/**
	 * @return
	 * 	retourne la date de mort du predateur.
	 */
	double getDateDeMort()
	{
		return this.dateDeMort;
	}
	
	/**
	 * @action
	 * 	augmente lambdaReproduction et calcule une nouvelle horloge de reproduction.
	 */
	void augmenterCapacitesReproductrice(int n)
	{
		this.lambdaReproduction = this.lambdaReproduction + n*Predateur.tauxAugmentationReproduction;
		this.setDateDeReproduction(this.lambdaReproduction, this.dateDerniereProgeniture);
		if (this.lambdaReproduction > 0.3)
		{
			this.lambdaReproduction = 0.3;
		}
	}
}
