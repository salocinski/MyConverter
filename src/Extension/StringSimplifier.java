package Extension;

public class StringSimplifier
{

	public String nettoyerChaine(String phrase)
	{
		phrase = phrase.replaceAll("[èéêë]","e");
		phrase = phrase.replaceAll("[àáâãäå]","a");
		phrase = phrase.replaceAll("[òóôõöø]","o");
		phrase = phrase.replaceAll("[ìíîï]","i");
		phrase = phrase.replaceAll("[ùúûü]","u");
		phrase = phrase.replaceAll("[ÿ]","y");
		phrase = phrase.replaceAll("[ç]","c");
		phrase = phrase.replaceAll("[Ç]","c");
		phrase = phrase.replaceAll("[°]","-");
		phrase = phrase.replaceAll("[Ñ]","n");
		phrase = phrase.replaceAll("[ÙÚÛÜ]","u");
		phrase = phrase.replaceAll("[ÌÍÎÏ]","i");
		phrase = phrase.replaceAll("[ÈÉÊË]","e");
		phrase = phrase.replaceAll("[ÒÓÔÕÖØ]","o");
		phrase = phrase.replaceAll("[ÀÁÂÃÄÅ]","a");
		
		return phrase;
	}
}
