package Convertisseur;

public class Temperature
{
	private double valeur;
	private String [] uniteConversion = {"Celsius", "Fahrenheit", "Kelvin", "Rankine"};
	private String uniteBase = "Celsius";

	public Temperature()
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
	
	//----------------------- CONVERSION uniteDepart => uniteBase -----------------------
	public double fahrenheitTOcelsius()
	{
		double conversion = (this.valeur - 32) * 5/9;
		return conversion;
	}
	
	public double kelvinTOcelsius()
	{
		double conversion = this.valeur - 273.15;
		return conversion;
	}
	
	public double rankineTOcelsius()
	{
		double conversion = (this.valeur - 491.67) * 5/9;
		return conversion;
	}
	//----------------------- CONVERSION uniteDepart => uniteBase -----------------------
	
	//----------------------- CONVERSION uniteBase => uniteConversion -----------------------
	public double celsiusTOcelsius()
	{
		return valeur;
	}
	
	public double celsiusTOfahrenheit()
	{
		double conversion = (this.valeur * 9/5) + 32;
		return conversion;
	}
	
	public double celsiusTOkelvin()
	{
		double conversion = this.valeur + 273.15;
		return conversion;
	}
	
	public double celsiusTOrankine()
	{
		double conversion = (this.valeur + 273.15) * 9/5;
		return conversion;
	}
	//----------------------- CONVERSION uniteBase => uniteConversion -----------------------
}