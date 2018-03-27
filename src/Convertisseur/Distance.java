package Convertisseur;

public class Distance
{
	private double valeur;
	private String [] uniteConversion = {"Kilomètre", "Hectomètre", "Décamètre", "Mètre", "Décimètre", "Centimètre", "Millimètre", "Pouce", "Pied", "Yard", "Mile"};
	private String uniteBase = "Mètre";
	
	public Distance()
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
	
	public double getValeur()
	{
		return valeur;
	}
	//----------------------- CONVERSION Conversion => uniteBase -----------------------	
	public double kilometreTOmetre()
	{
		double conversion = this.valeur * 1000;
		return conversion;
	}
	
	public double hectometreTOmetre()
	{
		double conversion = valeur * 100;
		return conversion;
	}
	
	public double decametreTOmetre()
	{
		double conversion = valeur * 10;
		return conversion;
	}
	
	public double metreTOmetre()
	{
		double conversion = this.valeur;
		return conversion;
	}
	
	public double decimetreTOmetre()
	{
		double conversion = valeur *10;
		return conversion;
	}
	
	public double centimetreTOmetre()
	{
		double conversion = valeur *100;
		return conversion;
	}
	
	public double millimetreTOmetre()
	{
		double conversion = valeur *1000;
		return conversion;
	}
	
	public double pouceTOmetre()
	{
		double resultat = valeur * 0.0254;
		return resultat;
	}
	
	public double piedTOmetre()
	{
		double resultat = valeur * 0.3048;
		return resultat;
	}
	
	public double yardTOmetre()
	{
		double resultat = valeur * 0.9144;
		return resultat;
	}
	
	public double mileTOmetre()
	{
		double resultat = valeur * 1609.34;
		return resultat;
	}
	//----------------------- CONVERSION uniteDepart => uniteBase -----------------------
	
	
	//----------------------- CONVERSION uniteBase => uniteConversion -----------------------
	public double metreTOkilometre()
	{
		double conversion = valeur / 1000;
		return conversion;
	}
	
	public double metreTOhectometre()
	{
		double conversion = valeur / 100;
		return conversion;
	}
	
	public double metreTOdecametre()
	{
		double conversion = valeur / 10;
		return conversion;
	}
	
	public double metreTOdecimetre()
	{
		double conversion = valeur / 0.1;
		return conversion;
	}
	
	public double metreTOcentimetre()
	{
		double conversion = valeur / 0.01;
		return conversion;
	}
	
	public double metreTOmillimetre()
	{
		double conversion = valeur / 0.001;
		return conversion;
	}
	
	public double metreTOpouce()
	{
		double conversion = valeur * 39.37;
		return conversion;
	}
	
	public double metreTOpied()
	{
		double conversion = valeur * 3.2808;
		return conversion;
	}
	
	public double metreTOyard()
	{
		double conversion = valeur * 1.093613;
		return conversion;
	}
	
	public double metreTOmile()
	{
		double resultat = valeur * 0.000621371;
		return resultat;
	}
	//----------------------- CONVERSION uniteBase => uniteConversion -----------------------
}