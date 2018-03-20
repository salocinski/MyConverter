package Extension;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumTextField extends PlainDocument{
    private static final long    serialVersionUID    = -2202805707064799711L;
    private int negatif = 0, separateur = 0;
    
    public NumTextField() {
        super();
    }
   
    /**
     * redefinition de la methode d'insertion
     */
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
    {
        if (str == null)//pour eviter les NullPointerException (juste par precaution)
            return;
        
        String digit = "";
        
        for (char c : str.toCharArray())
        {        	
			if(c == '-')
			{
				if (negatif != 1)
				{
					negatif += 1;
					digit += c;
				}			
			}
			else if (Character.isDigit(c))
			{
				digit += c;
			}
			else if(c == '.')
			{
				if (separateur != 1)
				{
					separateur += 1;
					digit += c;
				}			
			}
        }
        //on retourne notre chaine
        super.insertString(offs, digit, a);
    }
}