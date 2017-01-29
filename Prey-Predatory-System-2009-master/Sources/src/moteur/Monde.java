package moteur;
import java.util.ArrayList;

public class Monde
{
	public static int taille = 100; //la taille du monde
	private Compteur cpt =new Compteur(); //le compteur pour gérer le temps
	private ArrayList<Predateur>[][] lesPredateurs;
	private ArrayList<Proie>[][] lesProies;
	
	@SuppressWarnings("unchecked")
	public Monde(int nbProies, int nbPredateurs)
	{	
		//initialisation des matrices
		this.lesPredateurs = new ArrayList[Monde.taille][Monde.taille];
		this.lesProies = new ArrayList[Monde.taille][Monde.taille];

		for (int i=0; i<Monde.taille; i++)
		{
			for (int j=0; j<Monde.taille; j++)
			{
				this.lesPredateurs[i][j] = new ArrayList<Predateur>();
				this.lesProies[i][j] = new ArrayList<Proie>();
			}
		}
		
		//génération des predateurs
		for (int i=0; i<nbPredateurs; i++)
		{
			int x = genereEntier();
			int y = genereEntier();
			this.lesPredateurs[x][y].add(new Predateur(x, y, cpt.getDate()));
		}
		
		//génération des proies
		for (int i=0; i<nbProies; i++)
		{
			int x = genereEntier();
			int y = genereEntier();
			this.lesProies[x][y].add(new Proie(x, y, cpt.getDate()));
		}
	}
	
	/**
	 * @return
	 * 	retourne lesProies.
	 */
	public ArrayList<Proie>[][] getProies()
	{
		return this.lesProies;
	}
	
	/**
	 * @return
	 * 	retourne lesPredateurs
	 */
	public ArrayList<Predateur>[][] getPredateurs()
	{
		return this.lesPredateurs;
	}
	
	/**
	 * @return
	 * 	retourne un entier entre 0 et la taille du monde -1 aléatoirement.
	 */
	int genereEntier()
	{	
		int r = (int)(Math.random()*Monde.taille);
		return r;
	}
	
	/**
	 * @action
	 * 	Permet de faire évoluer le monde donc de faire se déplacer, manger, se reproduire et mourir les predateurs.
	 * 	Ensuite de faire se déplacer et se reproduirent les proies.
	 */
	public void evolution()
	{
		//periode suivante
		cpt.jourSuivant();
		
		for (int i=0; i<this.lesPredateurs.length; i++)
		{
			for (int j=0; j<this.lesPredateurs[i].length; j++)
			{
				for (int k=this.lesPredateurs[i][j].size()-1; k>=0; k--)
				{
					Predateur p = lesPredateurs[i][j].get(k);
					
					//soit il meurt
					if(cpt.getDate() >= p.getDateDeMort())
					{
						this.lesPredateurs[i][j].remove(k);
					}
					else //sinon il vit
					{
						//il se déplace
						p.seDeplacer(Predateur.vitesse);
						
						//il mange
						this.predation(p);
						
						//se reproduit
						if (cpt.getDate() >= p.getDateDeReproduction())
						{
							this.lesPredateurs[p.getX()][p.getY()].add(p.progeniture(cpt.getDate()));
						}
					}
				}
			}
		}

		//les proies
		for (int i=0; i<this.lesProies.length; i++)
		{
			for (int j=0; j<this.lesProies[i].length; j++)
			{
				for (int k=this.lesProies[i][j].size()-1; k>=0; k--)
				{
					Proie o = lesProies[i][j].get(k);
					
					//elle se déplace
					o.seDeplacer(Proie.vitesse);
					
					//et se reproduit
					if (cpt.getDate() >= o.getDateDeReproduction())
					{
						this.lesProies[o.progeniture(cpt.getDate()).getX()][o.progeniture(cpt.getDate()).getY()].add(o.progeniture(cpt.getDate()));
					}
				}
			}
		}
		
		//On les met à leur places réelle dans la matrice
		for (int i=0; i<this.lesPredateurs.length; i++)
		{
			for (int j=0; j<this.lesPredateurs[i].length; j++)
			{
				for (int k=this.lesPredateurs[i][j].size()-1; k>=0; k--)
				{
					//les prédateurs se déplacent
					Predateur p = lesPredateurs[i][j].get(k);
					lesPredateurs[i][j].remove(k);
					lesPredateurs[p.getX()][p.getY()].add(p);
				}
				for (int k=this.lesProies[i][j].size()-1; k>=0; k--)
				{
					//les proies se déplacent
					Proie p = lesProies[i][j].get(k);
					lesProies[i][j].remove(k);
					lesProies[p.getX()][p.getY()].add(p);
				}
			}
		}
	}
	
	/**
	 * @param lesProies
	 * @return
	 * 	supprime les proies que le predateur à manger.
	 */
	void predation(Predateur p)
	{
		int x = p.getX()-Predateur.zoneInfluence;
		int x2 = p.getX()+Predateur.zoneInfluence;
		int n = 0;

		while (x <= x2 && n!=1)
		{
			int y = p.getY()-Predateur.zoneInfluence;
			int y2 = p.getY()+Predateur.zoneInfluence;
			while (y <= y2 && n!=1)
			{
				if (lesProies[p.coordonneeDansLeMonde(x)][p.coordonneeDansLeMonde(y)].size() !=0)
				{
					n++;
					lesProies[p.coordonneeDansLeMonde(x)][p.coordonneeDansLeMonde(y)].remove(0);
				}
				y++;
			}
			x++;
		}
		if (n!=0)
		{
			p.augmenterCapacitesReproductrice(n);
		}
	}

	/**
	 * @return
	 * 	retourne le nombre total de prédateurs
	 */
	public int tailleTotalePred()
	{
		int n = 0;
		for (int i=0; i<this.lesPredateurs.length; i++)
		{
			for (int j=0; j<this.lesPredateurs[i].length; j++)
			{
				n += this.lesPredateurs[i][j].size();
			}
		}
		return n;
	}
	
	/**
	 * @return
	 * 	retourne le nombre total de proies
	 */
	public int tailleTotaleProie()
	{
		int n = 0;
		for (int i=0; i<this.lesProies.length; i++)
		{
			for (int j=0; j<this.lesProies[i].length; j++)
			{
				n += this.lesProies[i][j].size();
			}
		}
		return n;
	}
	
	/**
	 * @return
	 * 	accesseur en lecture sur la date actuelle
	 */
	public double getDateActuelle()
	{
		return cpt.getDate();
	}
}
