package Convertisseur;

public class Distance
{
	private double valeur;
	private String [] uniteConversion = {"Kilomètre", "Hectomètre", "Décamètre", "Mètre", "Décimètre", "Centimètre", "Millimètre", "Inch (pouce)", "Foot (pied)", "Yard (verge)"};
	
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
	public double kmToHm()
	{
		double resultat = this.mToHm()*1000;
		return resultat;
	}
	
	public double kmToDam()
	{
		double resultat = this.mToDam()*1000;
		return resultat;
	}
	
	public double kmToM()
	{
		double conversion = valeur * 1000;
		return conversion;
	}
	
	public double kmToDm()
	{
		double resultat = this.mToDm()*1000;
		return resultat;
	}
	
	public double kmToCm()
	{
		double resultat = this.mToCm()*1000;
		return resultat;
	}
	
	public double kmToMm()
	{
		double resultat = this.mToMm()*1000;
		return resultat;
	}
	
	public double kmToIn()
	{
		double resultat = this.mToIn()*1000;
		return resultat;
	}
	
	public double kmToFt()
	{
		double resultat = this.mToFt()*1000;
		return resultat;
	}
	
	public double kmToYd()
	{
		double resultat = this.mToYd()*1000;
		return resultat;
	}
	//----------------------- CONVERSION KILOMETRE -----------------------
	
	//----------------------- CONVERSION HECTOMETRE -----------------------
	public double hmToKm()
	{
		double resultat = this.mToKm()*100;
		return resultat;
	}
	
	public double hmToDam()
	{
		double resultat = this.mToDam()*100;
		return resultat;
	}
	
	public double hmToM()
	{
		double conversion = valeur * 100;
		return conversion;
	}
	
	public double hmToDm()
	{
		double resultat = this.mToDm()*100;
		return resultat;
	}
	
	public double hmToCm()
	{
		double resultat = this.mToCm()*100;
		return resultat;
	}
	
	public double hmToMm()
	{
		double resultat = this.mToMm()*100;
		return resultat;
	}
	
	public double hmToIn()
	{
		double resultat = this.mToIn()*100;
		return resultat;
	}
	
	public double hmToFt()
	{
		double resultat = this.mToFt()*100;
		return resultat;
	}
	
	public double hmToYd()
	{
		double resultat = this.mToYd()*100;
		return resultat;
	}
	//----------------------- CONVERSION HECTOMETRE -----------------------
		
	//----------------------- CONVERSION DECAMETRE -----------------------
	public double damToKm()
	{
		double resultat = this.mToKm()*10;
		return resultat;
	}
	
	public double damToHm()
	{
		double resultat = this.mToHm()*10;
		return resultat;
	}
	
	public double damToM()
	{
		double conversion = valeur * 10;
		return conversion;
	}
	
	public double damToDm()
	{
		double resultat = this.mToDm()*10;
		return resultat;
	}
	
	public double damToCm()
	{
		double resultat = this.mToCm()*10;
		return resultat;
	}
	
	public double damToMm()
	{
		double resultat = this.mToMm()*10;
		return resultat;
	}
	
	public double damToIn()
	{
		double resultat = this.mToIn()*10;
		return resultat;
	}
	
	public double damToFt()
	{
		double resultat = this.mToFt()*10;
		return resultat;
	}
	
	public double damToYd()
	{
		double resultat = this.mToYd()*10;
		return resultat;
	}
	//----------------------- CONVERSION DECAMETRE -----------------------
		
	//----------------------- CONVERSION METRE -----------------------
	public double mToKm()
	{
		double conversion = valeur / 1000;
		return conversion;
	}
	
	public double mToHm()
	{
		double conversion = valeur / 100;
		return conversion;
	}
	
	public double mToDam()
	{
		double conversion = valeur / 10;
		return conversion;
	}
	
	public double mToDm()
	{
		double conversion = valeur * 10;
		return conversion;
	}
	
	public double mToCm()
	{
		double conversion = valeur * 100;
		return conversion;
	}
	
	public double mToMm()
	{
		double conversion = valeur * 1000;
		return conversion;
	}
	
	public double mToIn()
	{
		double conversion = valeur * 39.37;
		return conversion;
	}
	
	public double mToFt()
	{
		double conversion = valeur * 3.2808;
		return conversion;
	}
	
	public double mToYd()
	{
		double conversion = valeur * 1.093613;
		return conversion;
	}
	//----------------------- CONVERSION METRE -----------------------
	
	//----------------------- CONVERSION DECIMETRE -----------------------
	public double dmToKm()
	{
		double resultat = this.mToKm()/10;
		return resultat;
	}
	
	public double dmToHm()
	{
		double resultat = this.mToHm()/10;
		return resultat;
	}
	
	public double dmToDam()
	{
		double resultat = this.mToDam()/10;
		return resultat;
	}
	
	public double dmToM()
	{
		double conversion = valeur /10;
		return conversion;
	}
	
	public double dmToDm()
	{
		double resultat = this.mToDm()/10;
		return resultat;
	}
	
	public double dmToCm()
	{
		double resultat = this.mToCm()/10;
		return resultat;
	}
	
	public double dmToMm()
	{
		double resultat = this.mToMm()/10;
		return resultat;
	}
	
	public double dmToIn()
	{
		double resultat = this.mToIn()/10;
		return resultat;
	}
	
	public double dmToFt()
	{
		double resultat = this.mToFt()/10;
		return resultat;
	}
	
	public double dmToYd()
	{
		double resultat = this.mToYd()/10;
		return resultat;
	}
	//----------------------- CONVERSION DECIMETRE -----------------------
	
	//----------------------- CONVERSION CENTIMETRE -----------------------
	public double cmToKm()
	{
		double resultat = this.mToKm()/100;
		return resultat;
	}
	
	public double cmToHm()
	{
		double resultat = this.mToHm()/100;
		return resultat;
	}
	
	public double cmToDam()
	{
		double resultat = this.mToDam()/100;
		return resultat;
	}
	
	public double cmToM()
	{
		double conversion = valeur /100;
		return conversion;
	}
	
	public double cmToDm()
	{
		double resultat = this.mToDm()/100;
		return resultat;
	}

	public double cmToMm()
	{
		double resultat = this.mToMm()/100;
		return resultat;
	}
	
	public double cmToIn()
	{
		double resultat = this.mToIn()/100;
		return resultat;
	}
	
	public double cmToFt()
	{
		double resultat = this.mToFt()/100;
		return resultat;
	}
	
	public double cmToYd()
	{
		double resultat = this.mToYd()/100;
		return resultat;
	}
	//----------------------- CONVERSION CENTIMETRE -----------------------
	
	//----------------------- CONVERSION MILLIMETRE -----------------------
	public double mmToKm()
	{
		double resultat = this.mToKm()/1000;
		return resultat;
	}
	
	public double mmToHm()
	{
		double resultat = this.mToHm()/1000;
		return resultat;
	}
	
	public double mmToDam()
	{
		double resultat = this.mToDam()/1000;
		return resultat;
	}
	
	public double mmToM()
	{
		double conversion = valeur /1000;
		return conversion;
	}
	
	public double mmToDm()
	{
		double resultat = this.mToDm()/1000;
		return resultat;
	}
	
	public double mmToCm()
	{
		double resultat = this.mToCm()/1000;
		return resultat;
	}
	
	public double mmToIn()
	{
		double resultat = this.mToIn()/1000;
		return resultat;
	}
	
	public double mmToFt()
	{
		double resultat = this.mToFt()/1000;
		return resultat;
	}
	
	public double mmToYd()
	{
		double resultat = this.mToYd()/1000;
		return resultat;
	}
	//----------------------- CONVERSION CENTIMETRE -----------------------
	
	//----------------------- CONVERSION POUCE (INCH) -----------------------
	public double inToKm()
	{
		double resultat = inToM()/1000;
		return resultat;
	}
	
	public double inToHm()
	{
		double resultat = inToM()/100;
		return resultat;
	}
	
	public double inToDam()
	{
		double resultat = inToM()/10;
		return resultat;
	}
	
	public double inToM()
	{
		double resultat = valeur * 0.0254;
		return resultat;
	}
	
	public double inToDm()
	{
		double resultat = inToM()*10;
		return resultat;
	}
	
	public double inToCm()
	{
		double resultat = inToM()*100;
		return resultat;
	}
	
	public double inToMm()
	{
		double resultat = inToM()*1000;
		return resultat;
	}
	
	public double inToFt()
	{
		double resultat = valeur * 0.0833333;
		return resultat;
	}
	
	public double inToYd()
	{
		double resultat = valeur * 0.0277778;
		return resultat;
	}
	//----------------------- CONVERSION POUCE (INCH) -----------------------
	
	//----------------------- CONVERSION PIED (FOOT) -----------------------
	public double ftToKm()
	{
		double resultat = inToM()/1000;
		return resultat;
	}
	
	public double ftToHm()
	{
		double resultat = inToM()/100;
		return resultat;
	}
	
	public double ftToDam()
	{
		double resultat = inToM()/10;
		return resultat;
	}
	
	public double ftToM()
	{
		double resultat = valeur * 0.3048;
		return resultat;
	}
	
	public double ftToDm()
	{
		double resultat = inToM()*10;
		return resultat;
	}
	
	public double ftToCm()
	{
		double resultat = inToM()*100;
		return resultat;
	}
	
	public double ftToMm()
	{
		double resultat = inToM()*1000;
		return resultat;
	}
	
	public double ftToIn()
	{
		double resultat = valeur * 12;
		return resultat;
	}
	
	public double ftToYd()
	{
		double resultat = valeur * 0.333333;
		return resultat;
	}
	//----------------------- CONVERSION PIED (FOOT) -----------------------
	
	//----------------------- CONVERSION YARD (VERGE) -----------------------
	public double ydToKm()
	{
		double resultat = inToM()/1000;
		return resultat;
	}
	
	public double ydToHm()
	{
		double resultat = inToM()/100;
		return resultat;
	}
	
	public double ydToDam()
	{
		double resultat = inToM()/10;
		return resultat;
	}
	
	public double ydToM()
	{
		double resultat = valeur * 0.9144;
		return resultat;
	}
	
	public double ydToDm()
	{
		double resultat = inToM()*10;
		return resultat;
	}
	
	public double ydToCm()
	{
		double resultat = inToM()*100;
		return resultat;
	}
	
	public double ydToMm()
	{
		double resultat = inToM()*1000;
		return resultat;
	}
	
	public double ydToIn()
	{
		double resultat = valeur * 36;
		return resultat;
	}
	
	public double ydToFt()
	{
		double resultat = valeur * 3;
		return resultat;
	}
	//----------------------- CONVERSION YARD (VERGE) -----------------------
}