package Convertisseur;

public class Poids
{
	private double valeur;
	private String [] uniteConversion = {"Tonne", "Quintal", "Kilogramme", "Hectogramme", "Décagramme", "Gramme", "Décigramme", "Centigramme", "Milligramme", "Livre", "Once"};
	private String uniteBase = "Gramme";

	public Poids()
	{
		this.uniteConversion = uniteConversion;
	}
	
	public String [] getUniteConversion()
	{
		return uniteConversion;
	}
	public String getUniteBase()
	{
		return uniteBase;
	}
	
	public void setValeur(double valeur)
	{
		this.valeur = valeur;
	}
	//----------------------- CONVERSION Conversion => uniteBase -----------------------
	public double tonneTOgramme()
	{
		double conversion = valeur * 1000000;
		return conversion;
	}
	
	public double quintalTOgramme()
	{
		double conversion = valeur * 100000;
		return conversion;
	}
	
	public double kilogrammeTOgramme()
	{
		double conversion = valeur * 1000;
		return conversion;
	}

	public double hectogrammeTOgramme()
	{
		double conversion = valeur * 100;
		return conversion;
	}

	public double decagrammeTOgramme()
	{
		double conversion = valeur * 10;
		return conversion;
	}

	public double grammeTOgramme()
	{
		return this.valeur;
	}

	public double decigrammeTOgramme()
	{
		double conversion = valeur * 10;
		return conversion;
	}
	
	public double centigrammeTOgramme()
	{
		double conversion = valeur * 100;
		return conversion;
	}
	
	public double milligrammeTOgramme()
	{
		double conversion = valeur * 1000;
		return conversion;
	}
	
	public double livreTOgramme()
	{
		double conversion = valeur * 453.592;
		return conversion;
	}
	
	public double onceTOgramme()
	{
		double conversion = valeur * 28.24;
		return conversion;
	}
	//----------------------- CONVERSION uniteBase => uniteConversion -----------------------
	public double grammeTOtonne()
	{
		double conversion = valeur / 1000000;
		return conversion;
	}
	
	public double grammeTOquintal()
	{
		double conversion = valeur / 100000;
		return conversion;
	}
	
	public double grammeTOkilogramme()
	{
		double conversion = valeur / 1000;
		return conversion;
	}
	
	public double grammeTOhectogramme()
	{
		double conversion = valeur / 100;
		return conversion;
	}
	
	public double grammeTOdecagramme()
	{
		double conversion = valeur / 10;
		return conversion;
	}
	
	public double grammeTOdecigramme()
	{
		double conversion = valeur / 0.1;
		return conversion;
	}
	
	public double grammeTOcentigramme()
	{
		double conversion = valeur / 0.01;
		return conversion;
	}
	
	public double grammeTOmilligramme()
	{
		double conversion = valeur / 0.001;
		return conversion;
	}
	
	public double grammeTOlivre()
	{
		double conversion = valeur * 0.00220462;
		return conversion;
	}
	
	public double grammeTOonce()
	{
		double conversion = valeur * 0.035274;
		return conversion;
	}
	//----------------------- CONVERSION uniteBase => uniteConversion -----------------------
}
