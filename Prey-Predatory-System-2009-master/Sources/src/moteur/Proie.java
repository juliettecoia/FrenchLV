package moteur;

public class Proie extends EtreVivant
{
	public static int vitesse = 3; //1
	public static int zonePonte = 1; //2
	public static double lambdaReproduction = 88/100; //0.001
	
	Proie(int x, int y, double n)
	{
		super(x,y,n);
		this.setDateDeReproduction(Proie.lambdaReproduction, n);
	}
	
	/**
	 * @return
	 * 	retourne une proie dont les coordonnées sont comprises dans la zone de ponte et dont la date de naissance correspond à la date actuelle.
	 */
	Proie progeniture(double date)
	{
		this.setDateDeReproduction(Proie.lambdaReproduction, date);
		int higher = Proie.zonePonte+1;
		int lower = -Proie.zonePonte;
		int i = (int)(Math.random()*(higher-lower)) + lower;
		int j = (int)(Math.random()*(higher-lower)) + lower;
		return new Proie(this.coordonneeDansLeMonde(this.getX()+i), this.coordonneeDansLeMonde(this.getY()+j), date);
	}
	
}
