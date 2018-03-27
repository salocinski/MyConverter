package Extension;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Onglets
{
	private Class classe = null;
	private	Object objetPerso = null;
	private String [] unite = null;
	private String uniteBase = null;
	private int maxUnite = 0;
	
	public void creerOnglets(JTabbedPane onglet, String nomSelection)
	{
		JPanel contenu = new JPanel();
		contenu.setLayout(new BoxLayout(contenu, BoxLayout.LINE_AXIS));
		
		JTextField saisieValeur = new JTextField();
		saisieValeur.setPreferredSize(new Dimension(75, 20));
		saisieValeur.setMinimumSize(new Dimension(75,20));
		saisieValeur.setMaximumSize(new Dimension(75,20));
		
		JTextField resultat = new JTextField();
		resultat.setPreferredSize(new Dimension(75, 20));
		resultat.setMinimumSize(new Dimension(75,20));
		resultat.setMaximumSize(new Dimension(75,20));
		resultat.setEditable(false);
		resultat.setBorder(null);
		
		JComboBox uniteDepart = new JComboBox();
		uniteDepart.setPreferredSize(new Dimension(100, 20));
		uniteDepart.setMinimumSize(new Dimension(100,20));
		uniteDepart.setMaximumSize(new Dimension(100,20));
		
		JComboBox uniteConversion = new JComboBox();
		uniteConversion.setPreferredSize(new Dimension(100, 20));
		uniteConversion.setMinimumSize(new Dimension(100,20));
		uniteConversion.setMaximumSize(new Dimension(100,20));
		
		//---------------------------- GESTION OUVERTURE AUTOMATIQUE ONGLET ----------------------------
		//L'ouverture d'un nouvel onglet de conversion se fait si le package "Convertisseur" dispose
		//de la classe de conversion.
		ArrayList <Class> listeConversion = new ArrayList <Class> ();
		RechercheClasse classe = new RechercheClasse();
		
		//On essaye de récupérer la liste des fichiers .class présents dans le package "Convertisseur"
		//Sinon renvoi d'exception
		try
		{
			listeConversion = (ArrayList<Class>) classe.getClasses("Convertisseur");
		}
		catch (ClassNotFoundException e){e.printStackTrace();} //La Classe n'existe pas
		catch (IOException e){e.printStackTrace();}
		
		for (int i = 0; i < listeConversion.size(); i++)
		{
			String listeNom = listeConversion.get(i).toString();
			String[] tableauNomCourt = listeNom.split("\\.");

			if(nomSelection.equals(tableauNomCourt[1]))
			{
				onglet.addTab(nomSelection,  null, contenu, "Double cliquer pour fermer l'onglet");
				this.creerContenu(onglet, contenu, saisieValeur, uniteDepart, uniteConversion, nomSelection, resultat);
			}
		}	
		//---------------------------- GESTION OUVERTURE AUTOMATIQUE ONGLET ----------------------------
	}
	
	public void creerContenu(JTabbedPane onglet, JPanel contenu, JTextField saisieValeur, JComboBox uniteDepart, JComboBox uniteConversion, String nomSelection, JTextField resultat)
	{
		contenu.add(Box.createRigidArea(new Dimension(10, 0)));
		contenu.add(saisieValeur);
		saisieValeur.setDocument(new NumTextField());

		String nom = "Convertisseur."+nomSelection;
		Object objet = null;

		//On tente d'instancier dynamiquement la classe selon le choix de la combobox
		try
		{
			//On récupère le nom de la classe correspondant au convertisseur
			classe = Class.forName(nom);
			//On instancie un objet dynamiquement avec le nom de la classe récupérée
			objet = classe.newInstance();
			//On crée un tableau de String qui permettra d'enregistrer les paramètres à passer
			Class[] types = new Class[] {};
			//On appelle le constructeur de la classe par rapport aux paramètres enregistrés dans le tableau de String
			Constructor ct = classe.getConstructor(types);
			//On crée une nouvelle instance de l'objet grace au constructeur défini au dessus.
			objetPerso = ct.newInstance();
		}
		catch (SecurityException e) {e.printStackTrace();}
		catch (IllegalArgumentException e) {e.printStackTrace();} //Le type d'argument n'est pas bon
		catch (ClassNotFoundException e) {e.printStackTrace();} //La Classe n'existe pas
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (NoSuchMethodException e) {e.printStackTrace();} //La méthode n'existe pas
		catch (InvocationTargetException e) {e.printStackTrace();}
		
		//On recupère les informations du tableau d'unité et de l'unité de base
		try
		{
			Method methodeGetTableauConversion = objetPerso.getClass().getMethod("getUniteConversion");
			Method methodeGetUniteBase = objetPerso.getClass().getMethod("getUniteBase");
			try
			{
				unite = (String[]) methodeGetTableauConversion.invoke(objetPerso);
				maxUnite = unite.length;
				uniteBase = (String) methodeGetUniteBase.invoke(objetPerso);
			} 
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (IllegalArgumentException e) {e.printStackTrace();} //Le type d'argument n'est pas bon
			catch (InvocationTargetException e) {e.printStackTrace();}
		} 
		catch (NoSuchMethodException e2) {e2.printStackTrace();} //La méthode n'existe pas
		catch (SecurityException e2) {e2.printStackTrace();}
		
		for (int i = 0; i < maxUnite; i++)
		{
			uniteDepart.addItem(unite[i]);
			uniteConversion.addItem(unite[i]);
		}
			
		contenu.add(Box.createRigidArea(new Dimension(10, 0)));
		contenu.add(uniteDepart);
		contenu.add(Box.createRigidArea(new Dimension(10, 0)));
		JLabel signe = new JLabel("=>");
		contenu.add(signe);
		contenu.add(Box.createRigidArea(new Dimension(10, 0)));
		contenu.add(uniteConversion);
		contenu.add(Box.createRigidArea(new Dimension(10, 0)));
		contenu.add(resultat);
		
		saisieValeur.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent action)
			{
				String selectionDepart = uniteDepart.getSelectedItem().toString();
				String selectionConversion = uniteConversion.getSelectedItem().toString();
				
				double valeur = Double.parseDouble(saisieValeur.getText());
				String uniteTransfert = null;
				
				//On reformate le nom de l'unité de conversion pour nettoyer la chaine des caracteres speciaux
				//et on la diminue en LowerCase pour éviter les erreurs.
				StringSimplifier selectionDepartSimple = new StringSimplifier();
				selectionDepart = selectionDepartSimple.nettoyerChaine(selectionDepart).toLowerCase();
				
				StringSimplifier selectionConversionSimple = new StringSimplifier();
				selectionConversion = selectionDepartSimple.nettoyerChaine(selectionConversion).toLowerCase();
				
				StringSimplifier uniteTransfertSimplifier = new StringSimplifier();
				uniteTransfert = uniteTransfertSimplifier.nettoyerChaine(uniteBase).toLowerCase();
				
				StringSimplifier uniteBaseClasse = new StringSimplifier();
				uniteBase = uniteBaseClasse.nettoyerChaine(uniteBase).toLowerCase();
				
				//On concatène les unités de conversions pour créer le nom de fonction de manière dynamique
				String nomFonction = selectionDepart+"TO"+uniteTransfert;
				String nomFonctionConversion = uniteBase+"TO"+selectionConversion;
				
				//Si l'instance de la classe n'est pas null
				if(classe != null)
				{
					Method methode = null;
					Method methodeConversion = null;
					//On récupère la méthode en l'appelant avec le nom de la fonction généré dynamiquement
					try 
					{
						methode = objetPerso.getClass().getMethod(nomFonction);
						try
						{
							Object [] param = {double.class};
							//On recherche une méthode dans la classe instanciée dans objetPerso
							//On recherche le nom "setValeur" qui nécessite un paramètre double
							Method methodeSetValeur = objetPerso.getClass().getMethod("setValeur", double.class);
							methodeSetValeur.invoke(objetPerso, valeur);
							
							double intermediaire = (double) methode.invoke(objetPerso);
							//On met à jour la valeur de l'attribut "valeur" dans la classe instanciée par "objetPerso"
							methodeSetValeur.invoke(objetPerso, intermediaire);
						}
						catch (IllegalAccessException e) {e.printStackTrace();}
						catch (IllegalArgumentException e) {e.printStackTrace();}
						catch (InvocationTargetException e) {e.printStackTrace();}
					}
					catch (NoSuchMethodException e1) {e1.printStackTrace();} //Méthode n'existe pas
					catch (SecurityException e1) {e1.printStackTrace();}
					
					//On récupère la méthode en l'appelant avec le nom de la fonction généré dynamiquement
					// et on l'applique sur l'objet instancé de façon dynamique "objetPerso" (.invoke)
					//uniteBase => conversion
					try
					{
						methodeConversion = objetPerso.getClass().getMethod(nomFonctionConversion);
						//On édite le JtextField avec le retour fait par l'application de la méthode
						try
						{
							resultat.setText(""+methodeConversion.invoke(objetPerso));
							resultat.setCaretPosition(0);
						}
						catch (IllegalAccessException e) {e.printStackTrace();}
						catch (IllegalArgumentException e) {e.printStackTrace();} //Le type d'argument n'est pas bon
						catch (InvocationTargetException e) {e.printStackTrace();}
					}
					catch (NoSuchMethodException e) {e.printStackTrace();} //Méthode n'existe pas
					catch (SecurityException e) {e.printStackTrace();}
				}
			}
		});
		
		uniteDepart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent action)
			{
				String selectionDepart = uniteDepart.getSelectedItem().toString();
				String selectionConversion = uniteConversion.getSelectedItem().toString();
				
				double valeur = Double.parseDouble(saisieValeur.getText());
				String uniteTransfert = null;
				
				//On reformate le nom de l'unité de conversion pour nettoyer la chaine des caracteres speciaux
				//et on la diminue en LowerCase pour éviter les erreurs.
				StringSimplifier selectionDepartSimple = new StringSimplifier();
				selectionDepart = selectionDepartSimple.nettoyerChaine(selectionDepart).toLowerCase();
				
				StringSimplifier selectionConversionSimple = new StringSimplifier();
				selectionConversion = selectionDepartSimple.nettoyerChaine(selectionConversion).toLowerCase();
				
				StringSimplifier uniteTransfertSimplifier = new StringSimplifier();
				uniteTransfert = uniteTransfertSimplifier.nettoyerChaine(uniteBase).toLowerCase();
				
				StringSimplifier uniteBaseClasse = new StringSimplifier();
				uniteBase = uniteBaseClasse.nettoyerChaine(uniteBase).toLowerCase();
				
				//On concatène les unités de conversions pour créer le nom de fonction de manière dynamique
				String nomFonction = selectionDepart+"TO"+uniteTransfert;
				String nomFonctionConversion = uniteBase+"TO"+selectionConversion;
				
				//Si l'instance de la classe n'est pas null
				if(classe != null)
				{
					Method methode = null;
					Method methodeConversion = null;
					//On récupère la méthode en l'appelant avec le nom de la fonction généré dynamiquement
					try 
					{
						methode = objetPerso.getClass().getMethod(nomFonction);
						try
						{
							Object [] param = {double.class};
							//On recherche une méthode dans la classe instanciée dans objetPerso
							//On recherche le nom "setValeur" qui nécessite un paramètre double
							Method methodeSetValeur = objetPerso.getClass().getMethod("setValeur", double.class);
							methodeSetValeur.invoke(objetPerso, valeur);
							
							double intermediaire = (double) methode.invoke(objetPerso);
							//On met à jour la valeur de l'attribut "valeur" dans la classe instanciée par "objetPerso"
							methodeSetValeur.invoke(objetPerso, intermediaire);
						}
						catch (IllegalAccessException e) {e.printStackTrace();}
						catch (IllegalArgumentException e) {e.printStackTrace();}
						catch (InvocationTargetException e) {e.printStackTrace();}
					}
					catch (NoSuchMethodException e1) {e1.printStackTrace();} //Méthode n'existe pas
					catch (SecurityException e1) {e1.printStackTrace();}
					
					//On récupère la méthode en l'appelant avec le nom de la fonction généré dynamiquement
					// et on l'applique sur l'objet instancé de façon dynamique "objetPerso" (.invoke)
					//uniteBase => conversion
					try
					{
						methodeConversion = objetPerso.getClass().getMethod(nomFonctionConversion);
						//On édite le JtextField avec le retour fait par l'application de la méthode
						try
						{
							resultat.setText(""+methodeConversion.invoke(objetPerso));
							resultat.setCaretPosition(0);
						}
						catch (IllegalAccessException e) {e.printStackTrace();}
						catch (IllegalArgumentException e) {e.printStackTrace();} //Le type d'argument n'est pas bon
						catch (InvocationTargetException e) {e.printStackTrace();}
					}
					catch (NoSuchMethodException e) {e.printStackTrace();} //Méthode n'existe pas
					catch (SecurityException e) {e.printStackTrace();}
				}
			}
		});
		
		uniteConversion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent action)
			{
				String selectionDepart = uniteDepart.getSelectedItem().toString();
				String selectionConversion = uniteConversion.getSelectedItem().toString();
				
				double valeur = Double.parseDouble(saisieValeur.getText());
				String uniteTransfert = null;
				
				//On reformate le nom de l'unité de conversion pour nettoyer la chaine des caracteres speciaux
				//et on la diminue en LowerCase pour éviter les erreurs.
				StringSimplifier selectionDepartSimple = new StringSimplifier();
				selectionDepart = selectionDepartSimple.nettoyerChaine(selectionDepart).toLowerCase();
				
				StringSimplifier selectionConversionSimple = new StringSimplifier();
				selectionConversion = selectionDepartSimple.nettoyerChaine(selectionConversion).toLowerCase();
				
				StringSimplifier uniteTransfertSimplifier = new StringSimplifier();
				uniteTransfert = uniteTransfertSimplifier.nettoyerChaine(uniteBase).toLowerCase();
				
				StringSimplifier uniteBaseClasse = new StringSimplifier();
				uniteBase = uniteBaseClasse.nettoyerChaine(uniteBase).toLowerCase();
				
				//On concatène les unités de conversions pour créer le nom de fonction de manière dynamique
				String nomFonction = selectionDepart+"TO"+uniteTransfert;
				String nomFonctionConversion = uniteBase+"TO"+selectionConversion;
				
				//Si l'instance de la classe n'est pas null
				if(classe != null)
				{
					Method methode = null;
					Method methodeConversion = null;
					//On récupère la méthode en l'appelant avec le nom de la fonction généré dynamiquement
					try 
					{
						methode = objetPerso.getClass().getMethod(nomFonction);
						try
						{
							Object [] param = {double.class};
							//On recherche une méthode dans la classe instanciée dans objetPerso
							//On recherche le nom "setValeur" qui nécessite un paramètre double
							Method methodeSetValeur = objetPerso.getClass().getMethod("setValeur", double.class);
							methodeSetValeur.invoke(objetPerso, valeur);
							
							double intermediaire = (double) methode.invoke(objetPerso);
							//On met à jour la valeur de l'attribut "valeur" dans la classe instanciée par "objetPerso"
							methodeSetValeur.invoke(objetPerso, intermediaire);
						}
						catch (IllegalAccessException e) {e.printStackTrace();}
						catch (IllegalArgumentException e) {e.printStackTrace();}
						catch (InvocationTargetException e) {e.printStackTrace();}
					}
					catch (NoSuchMethodException e1) {e1.printStackTrace();} //Méthode n'existe pas
					catch (SecurityException e1) {e1.printStackTrace();}
					
					//On récupère la méthode en l'appelant avec le nom de la fonction généré dynamiquement
					// et on l'applique sur l'objet instancé de façon dynamique "objetPerso" (.invoke)
					//uniteBase => conversion
					try
					{
						methodeConversion = objetPerso.getClass().getMethod(nomFonctionConversion);
						//On édite le JtextField avec le retour fait par l'application de la méthode
						try
						{
							resultat.setText(""+methodeConversion.invoke(objetPerso));
							resultat.setCaretPosition(0);
						}
						catch (IllegalAccessException e) {e.printStackTrace();}
						catch (IllegalArgumentException e) {e.printStackTrace();} //Le type d'argument n'est pas bon
						catch (InvocationTargetException e) {e.printStackTrace();}
					}
					catch (NoSuchMethodException e) {e.printStackTrace();} //Méthode n'existe pas
					catch (SecurityException e) {e.printStackTrace();}
				}
			}
		});
	}
}