package Convertisseur;

public class Distance
{
	private double valeur;
	private String [] uniteConversion = {"Kilomètre", "Hectomètre", "Décamètre", "Mètre", "Décimètre", "Centimètre", "Millimètre", "Pouce", "Pied", "Yard"};
	
	public Distance(double valeur)
	{
		this.valeur = valeur;
	}
	
	public Distance()
	{
		this.uniteConversion = uniteConversion;
	}
	
	public String [] getUniteConversion()
	{
		return uniteConversion;
	}	
	//----------------------- CONVERSION KILOMETRE -----------------------	
	public double kilometreToKilometre()
	{
		return valeur;
	}
	
	public double kilometreToHectometre()
	{
		double resultat = this.metreToHectometre()*1000;
		return resultat;
	}
	
	public double kilometreToDecametre()
	{
		double resultat = this.metreToDecametre()*1000;
		return resultat;
	}
	
	public double kilometreToMetre()
	{
		double conversion = valeur * 1000;
		return conversion;
	}
	
	public double kilometreToDecimetre()
	{
		double resultat = this.metreToDecimetre()*1000;
		return resultat;
	}
	
	public double kilometreToCentimetre()
	{
		double resultat = this.metreToCentimetre()*1000;
		return resultat;
	}
	
	public double kilometreToMillimetre()
	{
		double resultat = this.metreToMillimetre()*1000;
		return resultat;
	}
	
	public double kilometreToPouce()
	{
		double resultat = this.metreToPouce()*1000;
		return resultat;
	}
	
	public double kilometreToPied()
	{
		double resultat = this.metreToPied()*1000;
		return resultat;
	}
	
	public double kilometreToYard()
	{
		double resultat = this.metreToYard()*1000;
		return resultat;
	}
	//----------------------- CONVERSION KILOMETRE -----------------------
	
	//----------------------- CONVERSION HECTOMETRE -----------------------
	public double hectometreToKilometre()
	{
		double resultat = this.metreToKilometre()*100;
		return resultat;
	}
	
	public double hectometreToHectometre()
	{
		return valeur;
	}
	
	public double hectometreToDecametre()
	{
		double resultat = this.metreToDecametre()*100;
		return resultat;
	}
	
	public double hectometreToMetre()
	{
		double conversion = valeur * 100;
		return conversion;
	}
	
	public double hectometreToDecimetre()
	{
		double resultat = this.metreToDecimetre()*100;
		return resultat;
	}
	
	public double hectometreToCentimetre()
	{
		double resultat = this.metreToCentimetre()*100;
		return resultat;
	}
	
	public double hectometreToMillimetre()
	{
		double resultat = this.metreToMillimetre()*100;
		return resultat;
	}
	
	public double hectometreToPouce()
	{
		double resultat = this.metreToPouce()*100;
		return resultat;
	}
	
	public double hectometreToPied()
	{
		double resultat = this.metreToPied()*100;
		return resultat;
	}
	
	public double hectometreToYard()
	{
		double resultat = this.metreToYard()*100;
		return resultat;
	}
	//----------------------- CONVERSION HECTOMETRE -----------------------
		
	//----------------------- CONVERSION DECAMETRE -----------------------
	public double decametreToKilometre()
	{
		double resultat = this.metreToKilometre()*10;
		return resultat;
	}
	
	public double decametreToHectometre()
	{
		double resultat = this.metreToHectometre()*10;
		return resultat;
	}
	
	public double decametreToDecametre()
	{
		return valeur;
	}
	
	public double decametreToMetre()
	{
		double conversion = valeur * 10;
		return conversion;
	}
	
	public double decametreToDecimetre()
	{
		double resultat = this.metreToDecimetre()*10;
		return resultat;
	}
	
	public double decametreToCentimetre()
	{
		double resultat = this.metreToCentimetre()*10;
		return resultat;
	}
	
	public double decametreToMillimetre()
	{
		double resultat = this.metreToMillimetre()*10;
		return resultat;
	}
	
	public double decametreToPouce()
	{
		double resultat = this.metreToPouce()*10;
		return resultat;
	}
	
	public double decametreToPied()
	{
		double resultat = this.metreToPied()*10;
		return resultat;
	}
	
	public double decametreToYard()
	{
		double resultat = this.metreToYard()*10;
		return resultat;
	}
	//----------------------- CONVERSION DECAMETRE -----------------------
		
	//----------------------- CONVERSION METRE -----------------------
	public double metreToKilometre()
	{
		double conversion = valeur / 1000;
		return conversion;
	}
	
	public double metreToHectometre()
	{
		double conversion = valeur / 100;
		return conversion;
	}
	
	public double metreToDecametre()
	{
		double conversion = valeur / 10;
		return conversion;
	}
	
	public double metreToDecimetre()
	{
		double conversion = valeur * 10;
		return conversion;
	}
	
	public double metreToMetre()
	{
		return valeur;
	}
	
	public double metreToCentimetre()
	{
		double conversion = valeur * 100;
		return conversion;
	}
	
	public double metreToMillimetre()
	{
		double conversion = valeur * 1000;
		return conversion;
	}
	
	public double metreToPouce()
	{
		double conversion = valeur * 39.37;
		return conversion;
	}
	
	public double metreToPied()
	{
		double conversion = valeur * 3.2808;
		return conversion;
	}
	
	public double metreToYard()
	{
		double conversion = valeur * 1.093613;
		return conversion;
	}
	//----------------------- CONVERSION METRE -----------------------
	
	//----------------------- CONVERSION DECIMETRE -----------------------
	public double decimetreToKilometre()
	{
		double resultat = this.metreToKilometre()/10;
		return resultat;
	}
	
	public double decimetreToHectometre()
	{
		double resultat = this.metreToHectometre()/10;
		return resultat;
	}
	
	public double decimetreToDecametre()
	{
		double resultat = this.metreToDecametre()/10;
		return resultat;
	}
	
	public double decimetreToMetre()
	{
		double conversion = valeur /10;
		return conversion;
	}
	
	public double decimetreToDecimetre()
	{
		return valeur;
	}
	
	public double decimetreToCentimetre()
	{
		double resultat = this.metreToCentimetre()/10;
		return resultat;
	}
	
	public double decimetreToMillimetre()
	{
		double resultat = this.metreToMillimetre()/10;
		return resultat;
	}
	
	public double decimetreToPouce()
	{
		double resultat = this.metreToPouce()/10;
		return resultat;
	}
	
	public double decimetreToPied()
	{
		double resultat = this.metreToPied()/10;
		return resultat;
	}
	
	public double decimetreToYard()
	{
		double resultat = this.metreToYard()/10;
		return resultat;
	}
	//----------------------- CONVERSION DECIMETRE -----------------------
	
	//----------------------- CONVERSION CENTIMETRE -----------------------
	public double centimetreToKilometre()
	{
		double resultat = this.metreToKilometre()/100;
		return resultat;
	}
	
	public double centimetreToHectometre()
	{
		double resultat = this.metreToHectometre()/100;
		return resultat;
	}
	
	public double centimetreToDecametre()
	{
		double resultat = this.metreToDecametre()/100;
		return resultat;
	}
	
	public double centimetreToMetre()
	{
		double conversion = valeur /100;
		return conversion;
	}
	
	public double centimetreToDecimetre()
	{
		double resultat = this.metreToDecimetre()/100;
		return resultat;
	}
	
	public double centimetreToCentimetre()
	{
		return valeur;
	}

	public double centimetreToMillimetre()
	{
		double resultat = this.metreToMillimetre()/100;
		return resultat;
	}
	
	public double centimetreToPouce()
	{
		double resultat = this.metreToPouce()/100;
		return resultat;
	}
	
	public double centimetreToPied()
	{
		double resultat = this.metreToPied()/100;
		return resultat;
	}
	
	public double centimetreToYard()
	{
		double resultat = this.metreToYard()/100;
		return resultat;
	}
	//----------------------- CONVERSION CENTIMETRE -----------------------
	
	//----------------------- CONVERSION MILLIMETRE -----------------------
	public double millimetreToKilometre()
	{
		double resultat = this.metreToKilometre()/1000;
		return resultat;
	}
	
	public double millimetreToHectometre()
	{
		double resultat = this.metreToHectometre()/1000;
		return resultat;
	}
	
	public double millimetreToDecametre()
	{
		double resultat = this.metreToDecametre()/1000;
		return resultat;
	}
	
	public double millimetreToMetre()
	{
		double conversion = valeur /1000;
		return conversion;
	}
	
	public double millimetreToDecimetre()
	{
		double resultat = this.metreToDecimetre()/1000;
		return resultat;
	}
	
	public double millimetreToCentimetre()
	{
		double resultat = this.metreToCentimetre()/1000;
		return resultat;
	}
	
	public double millimetreToMillimetre()
	{
		return valeur;
	}
	
	public double millimetreToPouce()
	{
		double resultat = this.metreToPouce()/1000;
		return resultat;
	}
	
	public double millimetreToPied()
	{
		double resultat = this.metreToPied()/1000;
		return resultat;
	}
	
	public double millimetreToYard()
	{
		double resultat = this.metreToYard()/1000;
		return resultat;
	}
	//----------------------- CONVERSION CENTIMETRE -----------------------
	
	//----------------------- CONVERSION POUCE (INCH) -----------------------
	public double pouceToKilometre()
	{
		double resultat = pouceToMetre()/1000;
		return resultat;
	}
	
	public double pouceToHectometre()
	{
		double resultat = pouceToMetre()/100;
		return resultat;
	}
	
	public double pouceToDecametre()
	{
		double resultat = pouceToMetre()/10;
		return resultat;
	}
	
	public double pouceToMetre()
	{
		double resultat = valeur * 0.0254;
		return resultat;
	}
	
	public double pouceToDecimetre()
	{
		double resultat = pouceToMetre()*10;
		return resultat;
	}
	
	public double pouceToCentimetre()
	{
		double resultat = pouceToMetre()*100;
		return resultat;
	}
	
	public double pouceToMillimetre()
	{
		double resultat = pouceToMetre()*1000;
		return resultat;
	}
	
	public double pouceToPied()
	{
		double resultat = valeur * 0.0833333;
		return resultat;
	}
	
	public double pouceToPouce()
	{
		return valeur;
	}
	
	public double pouceToYard()
	{
		double resultat = valeur * 0.0277778;
		return resultat;
	}
	//----------------------- CONVERSION POUCE (INCH) -----------------------
	
	//----------------------- CONVERSION PIED (FOOT) -----------------------
	public double piedToKilometre()
	{
		double resultat = piedToMetre()/1000;
		return resultat;
	}
	
	public double piedToHectometre()
	{
		double resultat = piedToMetre()/100;
		return resultat;
	}
	
	public double piedToDecametre()
	{
		double resultat = piedToMetre()/10;
		return resultat;
	}
	
	public double piedToMetre()
	{
		double resultat = valeur * 0.3048;
		return resultat;
	}
	
	public double piedToDecimetre()
	{
		double resultat = piedToMetre()*10;
		return resultat;
	}
	
	public double piedToCentimetre()
	{
		double resultat = piedToMetre()*100;
		return resultat;
	}
	
	public double piedToMillimetre()
	{
		double resultat = piedToMetre()*1000;
		return resultat;
	}
	
	public double piedToPouce()
	{
		double resultat = valeur * 12;
		return resultat;
	}
	
	public double piedToPied()
	{
		return valeur;
	}
	
	public double piedToYard()
	{
		double resultat = valeur * 0.333333;
		return resultat;
	}
	//----------------------- CONVERSION PIED (FOOT) -----------------------
	
	//----------------------- CONVERSION YARD (VERGE) -----------------------
	public double yardToKilometre()
	{
		double resultat = yardToMetre()/1000;
		return resultat;
	}
	
	public double yardToHectometre()
	{
		double resultat = yardToMetre()/100;
		return resultat;
	}
	
	public double yardToDecametre()
	{
		double resultat = yardToMetre()/10;
		return resultat;
	}
	
	public double yardToMetre()
	{
		double resultat = valeur * 0.9144;
		return resultat;
	}
	
	public double yardToDecimetre()
	{
		double resultat = yardToMetre()*10;
		return resultat;
	}
	
	public double yardToCentimetre()
	{
		double resultat = yardToMetre()*100;
		return resultat;
	}
	
	public double yardToMillimetre()
	{
		double resultat = yardToMetre()*1000;
		return resultat;
	}
	
	public double yardToPouce()
	{
		double resultat = valeur * 36;
		return resultat;
	}
	
	public double yardToPied()
	{
		double resultat = valeur * 3;
		return resultat;
	}
	
	public double yardToYard()
	{
		return valeur;
	}
	//----------------------- CONVERSION YARD (VERGE) -----------------------
}