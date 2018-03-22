package Convertisseur;

public class Poids
{
	private double valeur;
	private String [] uniteConversion = {"Tonne", "Quintal", "Kilogramme", "Hectogramme", "Décagramme", "Gramme", "Décigramme", "Centigramme", "Milligramme", "Livre", "Once"};
	
	public Poids(double valeur)
	{
		this.valeur = valeur;
	}
	
	public Poids()
	{
		this.uniteConversion = uniteConversion;
	}
	
	public String [] getUniteConversion()
	{
		return uniteConversion;
	}
	
	//----------------------- CONVERSION TONNE ------------------------
	public double tonneToTonne()
	{
		return valeur;
	}
	
	public double tonneToQuintal()
	{
		double resultat = this.grammeToQuintal()*1000000;
		return resultat;
	}
	
	public double tonneToKilogramme()
	{
		double resultat = this.grammeToKilogramme()*1000000;
		return resultat;
	}
	
	public double tonneToHectogramme()
	{
		double resultat = this.grammeToHectogramme()*1000000;
		return resultat;
	}
	
	public double tonneToDecagramme()
	{
		double resultat = this.grammeToDecagramme()*1000000;
		return resultat;
	}
	
	public double tonneToGramme()
	{
		double conversion = valeur * 1000000;
		return conversion;
	}
	
	public double tonneToDecigramme()
	{
		double resultat = this.grammeToDecigramme()/1000000;
		return resultat;
	}
	
	public double tonneToCentigramme()
	{
		double resultat = this.grammeToCentigramme()/1000;
		return resultat;
	}
	
	public double tonneToMilligramme()
	{
		double resultat = this.grammeToMilligramme()/1000000;
		return resultat;
	}
	
	public double tonneToLivre()
	{
		double resultat = this.grammeToLivre()/1000000;
		return resultat;
	}
	
	public double tonneToOnce()
	{
		double resultat = this.grammeToOnce()/1000000;
		return resultat;
	}
	//----------------------- CONVERSION TONNE ------------------------
		
	//----------------------- CONVERSION QUINTAL ------------------------
	public double quintalToTonne()
	{
		double resultat = this.grammeToTonne()*100000;
		return resultat;
	}
	
	public double quintalToQuintal()
	{
		return valeur;
	}
	
	public double quintalToKilogramme()
	{
		double resultat = this.grammeToKilogramme()*100000;
		return resultat;
	}
	
	public double quintalToHectogramme()
	{
		double resultat = this.grammeToHectogramme()*100000;
		return resultat;
	}
	
	public double quintalToDecagramme()
	{
		double resultat = this.grammeToDecagramme()*100000;
		return resultat;
	}
	
	public double quintalToGramme()
	{
		double conversion = valeur * 100000;
		return conversion;
	}
	
	public double quintalToDecigramme()
	{
		double resultat = this.grammeToDecigramme()/100000;
		return resultat;
	}
	
	public double quintalToCentigramme()
	{
		double resultat = this.grammeToCentigramme()/100000;
		return resultat;
	}
	
	public double quintalToMilligramme()
	{
		double resultat = this.grammeToMilligramme()/100000;
		return resultat;
	}
	
	public double quintalToLivre()
	{
		double resultat = this.grammeToLivre()/100000;
		return resultat;
	}
	
	public double quintalToOnce()
	{
		double resultat = this.grammeToOnce()/100000;
		return resultat;
	}
	//----------------------- CONVERSION QUINTAL ------------------------
		
	//----------------------- CONVERSION KILOGRAMME ------------------------
	public double kilogrammeToTonne()
	{
		double resultat = this.grammeToTonne()*1000;
		return resultat;
	}
	
	public double kilogrammeToQuintal()
	{
		double resultat = this.grammeToQuintal()*1000;
		return resultat;
	}
	
	public double kilogrammeToKilogramme()
	{
		return valeur;
	}
	
	public double kilogrammeToHectogramme()
	{
		double resultat = this.grammeToHectogramme()*1000;
		return resultat;
	}
	
	public double kilogrammeToDecagramme()
	{
		double resultat = this.grammeToDecagramme()*1000;
		return resultat;
	}
	
	public double kilogrammeToGramme()
	{
		double conversion = valeur * 1000;
		return conversion;
	}
	
	public double kilogrammeToDecigramme()
	{
		double resultat = this.grammeToDecigramme()*1000;
		return resultat;
	}
	
	public double kilogrammeToCentigramme()
	{
		double resultat = this.grammeToCentigramme()*1000;
		return resultat;
	}
	
	public double kilogrammeToMilligramme()
	{
		double resultat = this.grammeToMilligramme()*1000;
		return resultat;
	}
	
	public double kilogrammeToLivre()
	{
		double resultat = this.grammeToLivre()*1000;
		return resultat;
	}
	
	public double kilogrammeToOnce()
	{
		double resultat = this.grammeToOnce()*1000;
		return resultat;
	}
	//----------------------- CONVERSION KILOGRAMME ------------------------
		
	//----------------------- CONVERSION HECTOGRAMME -----------------------
	public double hectogrammeToTonne()
	{
		double resultat = this.grammeToTonne()*100;
		return resultat;
	}
	
	public double hectogrammeToQuintal()
	{
		double resultat = this.grammeToQuintal()*100;
		return resultat;
	}
	
	public double hectogrammeToKilogramme()
	{
		double resultat = this.grammeToKilogramme()*100;
		return resultat;
	}
	
	public double hectogrammeToHectogramme()
	{
		return valeur;
	}
	
	public double hectogrammeToDecagramme()
	{
		double resultat = this.grammeToDecagramme()*100;
		return resultat;
	}
	
	public double hectogrammeToGramme()
	{
		double conversion = valeur * 100;
		return conversion;
	}
	
	public double hectogrammeToDecigramme()
	{
		double resultat = this.grammeToDecigramme()*100;
		return resultat;
	}
	
	public double hectogrammeToCentigramme()
	{
		double resultat = this.grammeToCentigramme()*100;
		return resultat;
	}
	
	public double hectogrammeToMilligramme()
	{
		double resultat = this.grammeToMilligramme()*100;
		return resultat;
	}
	
	public double hectogrammeToLivre()
	{
		double resultat = this.grammeToLivre()*100;
		return resultat;
	}
	
	public double hectogrammeToOnce()
	{
		double resultat = this.grammeToOnce()*100;
		return resultat;
	}
	//----------------------- CONVERSION HECTOGRAMME -----------------------
		
	//----------------------- CONVERSION DECAGRAMME ------------------------
	public double decagrammeToTonne()
	{
		double resultat = this.grammeToTonne()*10;
		return resultat;
	}
	
	public double decagrammeToQuintal()
	{
		double resultat = this.grammeToQuintal()*10;
		return resultat;
	}
	
	public double decagrammeToKilogramme()
	{
		double resultat = this.grammeToKilogramme()*10;
		return resultat;
	}
	
	public double decagrammeToHectogramme()
	{
		double resultat = this.grammeToHectogramme()*10;
		return resultat;
	}
	
	public double decagrammeToDecagramme()
	{
		return valeur;
	}
	
	public double decagrammeToGramme()
	{
		double conversion = valeur * 10;
		return conversion;
	}
	
	public double decagrammeToDecigramme()
	{
		double resultat = this.grammeToDecigramme()*10;
		return resultat;
	}
	
	public double decagrammeToCentigramme()
	{
		double resultat = this.grammeToCentigramme()*10;
		return resultat;
	}
	
	public double decagrammeToMilligramme()
	{
		double resultat = this.grammeToMilligramme()*10;
		return resultat;
	}
	
	public double decagrammeToLivre()
	{
		double resultat = this.grammeToLivre()*10;
		return resultat;
	}
	
	public double decagrammeToOnce()
	{
		double resultat = this.grammeToOnce()*10;
		return resultat;
	}
	//----------------------- CONVERSION DECAGRAMME -----------------------
		
	//----------------------- CONVERSION GRAMME ---------------------------
	public double grammeToTonne()
	{
		double conversion = valeur / 1000000;
		return conversion;
	}
	
	public double grammeToQuintal()
	{
		double conversion = valeur / 100000;
		return conversion;
	}
	
	public double grammeToKilogramme()
	{
		double conversion = valeur / 1000;
		return conversion;
	}
	
	public double grammeToHectogramme()
	{
		double conversion = valeur / 100;
		return conversion;
	}
	
	public double grammeToDecagramme()
	{
		double conversion = valeur / 10;
		return conversion;
	}
	
	public double grammeToGramme()
	{
		return valeur;
	}
	
	public double grammeToDecigramme()
	{
		double conversion = valeur * 10;
		return conversion;
	}
	
	public double grammeToCentigramme()
	{
		double conversion = valeur * 100;
		return conversion;
	}
	
	public double grammeToMilligramme()
	{
		double conversion = valeur * 1000;
		return conversion;
	}
	
	public double grammeToLivre()
	{
		double conversion = valeur * 0.00220462;
		return conversion;
	}
	
	public double grammeToOnce()
	{
		double conversion = valeur * 0.035274;
		return conversion;
	}
	//----------------------- CONVERSION GRAMME ---------------------------
	
	//----------------------- CONVERSION DECIGRAMME ------------------------
	public double decigrammeToTonne()
	{
		double resultat = this.grammeToTonne()/10;
		return resultat;
	}
	
	public double decigrammeToQuintal()
	{
		double resultat = this.grammeToQuintal()/10;
		return resultat;
	}
	
	public double decigrammeToKilogramme()
	{
		double resultat = this.grammeToKilogramme()/10;
		return resultat;
	}
	
	public double decigrammeToHectogramme()
	{
		double resultat = this.grammeToHectogramme()/10;
		return resultat;
	}
	
	public double decigrammeToDecagramme()
	{
		double resultat = this.grammeToDecagramme()/10;
		return resultat;
	}
	
	public double decigrammeToGramme()
	{
		double conversion = valeur / 10;
		return conversion;
	}
	
	public double decigrammeToDecigramme()
	{
		return valeur;
	}
	
	public double decigrammeToCentigramme()
	{
		double resultat = this.grammeToCentigramme()/10;
		return resultat;
	}
	
	public double decigrammeToMilligramme()
	{
		double resultat = this.grammeToMilligramme()/10;
		return resultat;
	}
	
	public double decigrammeToLivre()
	{
		double resultat = this.grammeToLivre()/10;
		return resultat;
	}
	
	public double decigrammeToOnce()
	{
		double resultat = this.grammeToOnce()/10;
		return resultat;
	}
	//----------------------- CONVERSION DECIGRAMME -----------------------
	
	//----------------------- CONVERSION CENTIGRAMME ------------------------
	public double centigrammeToTonne()
	{
		double resultat = this.grammeToTonne()/100;
		return resultat;
	}
	
	public double centigrammeToQuintal()
	{
		double resultat = this.grammeToQuintal()/100;
		return resultat;
	}
	
	public double centigrammeToKilogramme()
	{
		double resultat = this.grammeToKilogramme()/100;
		return resultat;
	}
	
	public double centigrammeToHectogramme()
	{
		double resultat = this.grammeToHectogramme()/100;
		return resultat;
	}
	
	public double centigrammeToDecagramme()
	{
		double resultat = this.grammeToDecagramme()/100;
		return resultat;
	}
	
	public double centigrammeToGramme()
	{
		double conversion = valeur / 100;
		return conversion;
	}
	
	public double centigrammeToDecigramme()
	{
		double resultat = this.grammeToDecigramme()/100;
		return resultat;
	}
	
	public double centigrammeToCentigramme()
	{
		return valeur;
	}
	
	public double centigrammeToMilligramme()
	{
		double resultat = this.grammeToMilligramme()/100;
		return resultat;
	}
	
	public double centigrammeToLivre()
	{
		double resultat = this.grammeToLivre()/100;
		return resultat;
	}
	
	public double centigrammeToOnce()
	{
		double resultat = this.grammeToOnce()/100;
		return resultat;
	}
	//----------------------- CONVERSION CENTIGRAMME -----------------------
	
	//----------------------- CONVERSION MILLIGRAMME ------------------------
	public double milligrammeToTonne()
	{
		double resultat = this.grammeToTonne()/1000;
		return resultat;
	}
	
	public double milligrammeToQuintal()
	{
		double resultat = this.grammeToQuintal()/1000;
		return resultat;
	}
	
	public double milligrammeToKilogramme()
	{
		double resultat = this.grammeToKilogramme()/1000;
		return resultat;
	}
	
	public double milligrammeToHectogramme()
	{
		double resultat = this.grammeToHectogramme()/1000;
		return resultat;
	}
	
	public double milligrammeToDecagramme()
	{
		double resultat = this.grammeToDecagramme()/1000;
		return resultat;
	}
	
	public double milligrammeToGramme()
	{
		double conversion = valeur / 1000;
		return conversion;
	}
	
	public double milligrammeToDecigramme()
	{
		double resultat = this.grammeToDecigramme()/1000;
		return resultat;
	}
	
	public double milligrammeToCentigramme()
	{
		double resultat = this.grammeToCentigramme()/1000;
		return resultat;
	}
	
	public double milligrammeToMilligramme()
	{
		return valeur;
	}
	
	public double milligrammeToLivre()
	{
		double resultat = this.grammeToLivre()/1000;
		return resultat;
	}
	
	public double milligrammeToOnce()
	{
		double resultat = this.grammeToOnce()/1000;
		return resultat;
	}
	//----------------------- CONVERSION MILLIGRAMME -----------------------
	
	//----------------------- CONVERSION LIVRE -----------------------
	public double livreToTonne()
	{
		double resultat = this.livreToGramme()/1000000;
		return resultat;
	}
	
	public double livreToQuintal()
	{
		double resultat = this.livreToGramme()/100000;
		return resultat;
	}
	
	public double livreToKilogramme()
	{
		double conversion = this.livreToGramme()/1000;
		return conversion;
	}
	
	public double livreToHectogramme()
	{
		double conversion = this.livreToGramme()/100;
		return conversion;
	}
	
	public double livreToDecagramme()
	{
		double conversion = this.livreToGramme()/10;
		return conversion;
	}
	
	public double livreToGramme()
	{
		double conversion = valeur * 453.592;
		return conversion;
	}
	
	public double livreToDecigramme()
	{
		double conversion = this.livreToGramme()*10;
		return conversion;
	}
	
	public double livreToCentigramme()
	{
		double conversion = this.livreToGramme()*100;
		return conversion;
	}
	
	public double livreToMilligramme()
	{
		double conversion = this.livreToGramme()*1000;
		return conversion;
	}
	
	public double livreToLivre()
	{
		return valeur;
	}
	
	public double livreToOnce()
	{
		double conversion = valeur * 16;
		return conversion;
	}
	//----------------------- CONVERSION LIVRE -----------------------
	
	//----------------------- CONVERSION ONCE -----------------------
	public double onceToTonne()
	{
		double resultat = this.onceToGramme()/1000000;
		return resultat;
	}
	
	public double onceToQuintal()
	{
		double resultat = this.onceToGramme()/100000;
		return resultat;
	}
	
	public double onceToKilogramme()
	{
		double conversion = this.onceToGramme()/1000;
		return conversion;
	}
	
	public double onceToHectogramme()
	{
		double conversion = this.onceToGramme()/100;
		return conversion;
	}
	
	public double onceToDecagramme()
	{
		double conversion = this.onceToGramme()/10;
		return conversion;
	}
	
	public double onceToGramme()
	{
		double conversion = valeur * 28.24;
		return conversion;
	}
	
	public double onceToDecigramme()
	{
		double conversion = this.onceToGramme()*10;
		return conversion;
	}
	
	public double onceToCentigramme()
	{
		double conversion = this.onceToGramme()*100;
		return conversion;
	}
	
	public double onceToMilligramme()
	{
		double conversion = this.onceToGramme()*1000;
		return conversion;
	}
	
	public double onceToLivre()
	{
		double conversion = valeur * 0.0625;
		return conversion;
	}
	
	public double onceToOnce()
	{
		return valeur;
	}
	//----------------------- CONVERSION ONCE -----------------------
}
