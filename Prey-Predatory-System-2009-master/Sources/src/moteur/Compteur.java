package moteur;
class Compteur 
{
	private double dateActuelle;
	
	Compteur()
	{
		this.dateActuelle=0;
	}

	void jourSuivant()
	{
		this.dateActuelle = this.dateActuelle+0.1;
	}
	
	double getDate()
	{
		return this.dateActuelle;
	}
}
