package moteur;

abstract class EtreVivant 
{
	private int x, y; //coordonnées
	private double dateDeReproduction;
	private double dateDeNaissance;
	
	EtreVivant(int x, int y, double date) 
	{
		this.x=x;
		this.y=y;
		this.dateDeNaissance=date;
	}
	
	/**
	 * @return
	 * 	retourne la coordonnée x.
	 */
	int getX()
	{
		return this.x;
	}
	
	/**
	 * @return
	 * 	retourne la coordonnée y.
	 */
	int getY()
	{
		return this.y;
	}
	
	/**
	 * @return
	 * 	retourne la date de naissance.
	 */
	double getDateDeNaissance()
	{
		return this.dateDeNaissance;
	}
	
	/**
	 * @return
	 * 	retourne la date de reproduction.
	 */
	double getDateDeReproduction()
	{
		return this.dateDeReproduction;
	}

	/**
	 * @param l
	 * @action
	 * 	crée une nouvelle date de reproduction.
	 */
	void setDateDeReproduction(double lambda, double date)
	{
		this.dateDeReproduction = date+this.horloge(lambda);
	}
	
	/**
	 * @param vitesse
	 * @action
	 * 	change les coordonnées suivant une vitesse donnée et un sens choisi aléatoirement.
	 */
	void seDeplacer(int vitesse)
	{
		double r = Math.random();
		int i = this.x;
		int j = this.y;
		if (r < 0.125) //en haut à gauche
		{
			i = i - vitesse;
			j = j - vitesse;
		}
		else if (r < 0.25) //en haut
		{
			i = i - vitesse;
		}
		else if (r < 0.375) //en haut à droite
		{
			i = i - vitesse;
			j = j + vitesse;
		}
		else if (r < 0.5) //à gauche
		{
			j = j - vitesse;
		}
		else if (r < 0.625) //à droite
		{
			j = j + vitesse;
		}
		else if (r < 0.75) //en bas à gauche
		{
			i = i + vitesse;
			j = j - vitesse;
		}
		else if (r < 0.875) //en bas
		{
			i = i + vitesse;
		}
		else //en bas à droite
		{
			i = i + vitesse;
			j = j + vitesse;
		}
		
		this.x = (this.coordonneeDansLeMonde(i));
		this.y = (this.coordonneeDansLeMonde(j));
	}

	/**
	 * @param lambda
	 * @return
	 * 	retourne un nombre aléatoire qui dépend de lambda, plus lambda est grand plus celui-ci à de chances d'être proche de zéro.
	 */
	double horloge(double lambda)
	{
		double u = Math.random();
		return (-1/lambda)*Math.log(1-u);
	}
	
	/**
	 * @param n
	 * @return
	 * 	Si l'entier n n'est pas inclu entre 0 et la taille du monde -1 alors on l'ajuste pour qu'il y soit inclue.
	 */
	int coordonneeDansLeMonde(int n)
	{
		while (n < 0)
		{
			n = n+Monde.taille;
		}
		while (n >= Monde.taille)
		{
			n = n-Monde.taille;
		}
		return n;
	}
}
