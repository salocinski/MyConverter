package Convertisseur;

public class Temperature
{
	private double valeur;
	private String [] uniteConversion = {"Celsius", "Fahrenheit", "Kelvin", "Rankine"};
	
	public Temperature(double valeur)
	{
		this.valeur = valeur;
	}
	public Temperature()
	{
		this.uniteConversion = uniteConversion;
	}
	
	public String [] getUniteConversion()
	{
		return uniteConversion;
	}
	//----------------------- CONVERSION CELSIUS -----------------------
	public double celsiusToCelsius()
	{
		return valeur;
	}
	
	public double celsiusToFahrenheit()
	{
		double conversion = this.valeur * 9/5 + 32;
		return conversion;
	}
	
	public double celsiusToKelvin()
	{
		double conversion = this.valeur + 273.15;
		return conversion;
	}
	
	public double celsiusToRankine()
	{
		double conversion = (this.valeur + 273.15) * 9/5;
		return conversion;
	}
	//----------------------- CONVERSION CELSIUS -----------------------
	
	//----------------------- CONVERSION FAHRENHEIT -----------------------
	public double fahrenheitToCelsius()
	{
		double conversion = (this.valeur - 32) * 5/9;
		return conversion;
	}
	
	public double fahrenheitToFahrenheit()
	{
		return valeur;
	}
	
	public double fahrenheitToKelvin()
	{
		double conversion = (this.valeur +459.67) * 5/9;
		return conversion;
	}
	
	public double fahrenheitToRankine()
	{
		double conversion = this.valeur +459.67;
		return conversion;
	}
	//----------------------- CONVERSION FAHRENHEIT -----------------------
	
	//----------------------- CONVERSION KELVIN -----------------------
	public double kelvinToFahrenheit()
	{
		double conversion = this.valeur * 9/5 - 459.67;
		return conversion;
	}
	
	public double kelvinToCelsius()
	{
		double conversion = this.valeur - 273.15;
		return conversion;
	}
	
	public double kelvinToKelvin()
	{
		return valeur;
	}
	
	public double kelvinToRankine()
	{
		double conversion = this.valeur * 9/5;
		return conversion;
	}
	//----------------------- CONVERSION KELVIN -----------------------
	
	//----------------------- CONVERSION RANKINE -----------------------
	public double rankineToFahrenheit()
	{
		double conversion = this.valeur - 459.67;
		return conversion;
	}
	
	public double rankineToCelsius()
	{
		double conversion = (this.valeur - 491.67) * 5/9;
		return conversion;
	}
	
	public double rankineToKelvin()
	{
		double conversion = this.valeur * 5/9;
		return conversion;
	}
	
	public double rankineToRankine()
	{
		return valeur;
	}
	//----------------------- CONVERSION RANKINE -----------------------
}
