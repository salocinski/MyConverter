package Extension;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Convertisseur.Distance;
import Convertisseur.Poids;
import Convertisseur.Temperature;

public class Onglets
{
	public void creerOnglets(JTabbedPane onglet, String nomSelection)
	{
		JPanel contenu = new JPanel();
		contenu.setLayout(new BoxLayout(contenu, BoxLayout.LINE_AXIS));
		
		//On applique le format de saisie au JtextField formaté selon ce modèle
		JTextField saisieValeur = new JTextField();
		saisieValeur.setPreferredSize(new Dimension(75, 20));
		saisieValeur.setMinimumSize(new Dimension(75,20));
		saisieValeur.setMaximumSize(new Dimension(75,20));
		
		JTextField resultat = new JTextField();
		resultat.setPreferredSize(new Dimension(75, 20));
		resultat.setMinimumSize(new Dimension(75,20));
		resultat.setMaximumSize(new Dimension(75,20));
		
		JComboBox uniteDepart = new JComboBox();
		uniteDepart.setPreferredSize(new Dimension(100, 20));
		uniteDepart.setMinimumSize(new Dimension(100,20));
		uniteDepart.setMaximumSize(new Dimension(100,20));
		
		JComboBox uniteConversion = new JComboBox();
		uniteConversion.setPreferredSize(new Dimension(100, 20));
		uniteConversion.setMinimumSize(new Dimension(100,20));
		uniteConversion.setMaximumSize(new Dimension(100,20));
		
		//---------------------------- GESTION OUVERTURE AUTOMATIQUE ONGLET ----------------------------
		//L'ouverture d'un nouvel onglet de conversion se fera si le package "Convertisseur" dispose
		//de la classe de conversion.
		ArrayList <Class> listeConversion = new ArrayList <Class> ();
		RechercheClasse classe = new RechercheClasse();
		
		try
		{
			listeConversion = (ArrayList<Class>) classe.getClasses("Convertisseur");
		}
		catch (ClassNotFoundException e){e.printStackTrace();}
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
		
		//---------------------------- TEMPERATURE ----------------------------
		//--------------------------------------------------------
		//--------------------------------------------
		//----------------------------------
		//------------------------
		//-------------
		//-----
		if (nomSelection.equals("Temperature"))
		{
			Temperature valeur = new Temperature();
			//On récupère le tableau de valeur de conversion de l'on jet de type "Température" pour calculer le nombre
			//max d'unité de conversion
			String [] unite = valeur.getUniteConversion();
			int maxUnite = unite.length;
			
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
					
					DecimalFormat decimal = new DecimalFormat("#.##");
					decimal.setRoundingMode(RoundingMode.HALF_UP);
					
					String resultatConversion = "";
					Temperature aConvertir = new Temperature(valeur);
					
					StringSimplifier selectionDepartSimple = new StringSimplifier();
					selectionDepart = selectionDepartSimple.netttoyerChaine(selectionDepart).toLowerCase();
					
					StringSimplifier selectionConversionSimple = new StringSimplifier();
					selectionConversion = selectionDepartSimple.netttoyerChaine(selectionConversion);
					
					String nomFonction = selectionDepart+"To"+selectionConversion;
					
					String nom = Distance.class.getName();
					Class nomClasse = null;
					
					try 
					{
						nomClasse = nomClasse.forName(nom);
					} 
					catch (ClassNotFoundException e){e.printStackTrace();}
							
					if(nomClasse != null)
					{
						Method methode = null;
						try 
						{
							methode = aConvertir.getClass().getMethod(nomFonction);
						}
						catch (NoSuchMethodException e1) {e1.printStackTrace();} 
						catch (SecurityException e1) {e1.printStackTrace();}

						try 
						{
							resultat.setText(""+methode.invoke(aConvertir));
						} 
						catch (IllegalAccessException e){e.printStackTrace();} 
						catch (IllegalArgumentException e){e.printStackTrace();} 
						catch (InvocationTargetException e){e.printStackTrace();}
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
					
					DecimalFormat decimal = new DecimalFormat("#.##");
					decimal.setRoundingMode(RoundingMode.HALF_UP);
					
					String resultatConversion = "";
					Temperature aConvertir = new Temperature(valeur);
					
					StringSimplifier selectionDepartSimple = new StringSimplifier();
					selectionDepart = selectionDepartSimple.netttoyerChaine(selectionDepart).toLowerCase();
					
					StringSimplifier selectionConversionSimple = new StringSimplifier();
					selectionConversion = selectionDepartSimple.netttoyerChaine(selectionConversion);
					
					String nomFonction = selectionDepart+"To"+selectionConversion;
					
					String nom = Distance.class.getName();
					Class nomClasse = null;
					
					try 
					{
						nomClasse = nomClasse.forName(nom);
					} 
					catch (ClassNotFoundException e){e.printStackTrace();}
							
					if(nomClasse != null)
					{
						Method methode = null;
						try 
						{
							methode = aConvertir.getClass().getMethod(nomFonction);
						}
						catch (NoSuchMethodException e1) {e1.printStackTrace();} 
						catch (SecurityException e1) {e1.printStackTrace();}

						try 
						{
							resultat.setText(""+methode.invoke(aConvertir));
						} 
						catch (IllegalAccessException e){e.printStackTrace();} 
						catch (IllegalArgumentException e){e.printStackTrace();} 
						catch (InvocationTargetException e){e.printStackTrace();}
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
					
					DecimalFormat decimal = new DecimalFormat("#.##");
					decimal.setRoundingMode(RoundingMode.HALF_UP);
					
					String resultatConversion = "";
					Temperature aConvertir = new Temperature(valeur);
					
					StringSimplifier selectionDepartSimple = new StringSimplifier();
					selectionDepart = selectionDepartSimple.netttoyerChaine(selectionDepart).toLowerCase();
					
					StringSimplifier selectionConversionSimple = new StringSimplifier();
					selectionConversion = selectionDepartSimple.netttoyerChaine(selectionConversion);
					
					String nomFonction = selectionDepart+"To"+selectionConversion;
					
					String nom = Distance.class.getName();
					Class nomClasse = null;
					
					try 
					{
						nomClasse = nomClasse.forName(nom);
					} 
					catch (ClassNotFoundException e){e.printStackTrace();}
							
					if(nomClasse != null)
					{
						Method methode = null;
						try 
						{
							methode = aConvertir.getClass().getMethod(nomFonction);
						}
						catch (NoSuchMethodException e1) {e1.printStackTrace();} 
						catch (SecurityException e1) {e1.printStackTrace();}

						try 
						{
							resultat.setText(""+methode.invoke(aConvertir));
						} 
						catch (IllegalAccessException e){e.printStackTrace();} 
						catch (IllegalArgumentException e){e.printStackTrace();} 
						catch (InvocationTargetException e){e.printStackTrace();}
					}
				}
			});
		}
		//---------------------------- DISTANCE ----------------------------
		//--------------------------------------------------------
		//--------------------------------------------
		//----------------------------------
		//------------------------
		//-------------
		//-----
		else if (nomSelection.equals("Distance"))
		{
			Distance valeur = new Distance();
			//On récupère le tableau de valeur de conversion de l'on jet de type "Température" pour calculer le nombre
			//max d'unité de conversion
			String [] unite = valeur.getUniteConversion();
			int maxUnite = unite.length;
			
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
			
			uniteConversion.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent action)
				{
					String selectionDepart = uniteDepart.getSelectedItem().toString();
					String selectionConversion = uniteConversion.getSelectedItem().toString();
					
					double valeur = Double.parseDouble(saisieValeur.getText());

					DecimalFormat decimal = new DecimalFormat("#.#####");
					decimal.setRoundingMode(RoundingMode.HALF_UP);
					
					String resultatConversion = "";
					Distance aConvertir = new Distance(valeur);

					StringSimplifier selectionDepartSimple = new StringSimplifier();
					selectionDepart = selectionDepartSimple.netttoyerChaine(selectionDepart).toLowerCase();
					
					StringSimplifier selectionConversionSimple = new StringSimplifier();
					selectionConversion = selectionDepartSimple.netttoyerChaine(selectionConversion);
					
					String nomFonction = selectionDepart+"To"+selectionConversion;
					
					String nom = Distance.class.getName();
					Class nomClasse = null;
					
					try 
					{
						nomClasse = nomClasse.forName(nom);
					} 
					catch (ClassNotFoundException e){e.printStackTrace();}
							
					if(nomClasse != null)
					{
						Method methode = null;
						try 
						{
							methode = aConvertir.getClass().getMethod(nomFonction);
						}
						catch (NoSuchMethodException e1) {e1.printStackTrace();} 
						catch (SecurityException e1) {e1.printStackTrace();}

						try 
						{
							resultat.setText(""+methode.invoke(aConvertir));
						} 
						catch (IllegalAccessException e){e.printStackTrace();} 
						catch (IllegalArgumentException e){e.printStackTrace();} 
						catch (InvocationTargetException e){e.printStackTrace();}
					}
				}
			});
			//Listener sur la ComboBox de l'unité de départ
			uniteDepart.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent action)
				{
					String selectionDepart = uniteDepart.getSelectedItem().toString();
					String selectionConversion = uniteConversion.getSelectedItem().toString();
					
					double valeur = Double.parseDouble(saisieValeur.getText());

					DecimalFormat decimal = new DecimalFormat("#.#####");
					decimal.setRoundingMode(RoundingMode.HALF_UP);
					
					String resultatConversion = "";
					Distance aConvertir = new Distance(valeur);

					StringSimplifier selectionDepartSimple = new StringSimplifier();
					selectionDepart = selectionDepartSimple.netttoyerChaine(selectionDepart).toLowerCase();
					
					StringSimplifier selectionConversionSimple = new StringSimplifier();
					selectionConversion = selectionDepartSimple.netttoyerChaine(selectionConversion);
					
					String nomFonction = selectionDepart+"To"+selectionConversion;
					
					String nom = Distance.class.getName();
					Class nomClasse = null;
					
					try 
					{
						nomClasse = nomClasse.forName(nom);
					} 
					catch (ClassNotFoundException e){e.printStackTrace();}
							
					if(nomClasse != null)
					{
						Method methode = null;
						try 
						{
							methode = aConvertir.getClass().getMethod(nomFonction);
						}
						catch (NoSuchMethodException e1) {e1.printStackTrace();} 
						catch (SecurityException e1) {e1.printStackTrace();}

						try 
						{
							resultat.setText(""+methode.invoke(aConvertir));
						} 
						catch (IllegalAccessException e){e.printStackTrace();} 
						catch (IllegalArgumentException e){e.printStackTrace();} 
						catch (InvocationTargetException e){e.printStackTrace();}
					}
				}
			});
			
			saisieValeur.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent action)
				{
					String selectionDepart = uniteDepart.getSelectedItem().toString();
					String selectionConversion = uniteConversion.getSelectedItem().toString();
					
					double valeur = Double.parseDouble(saisieValeur.getText());

					DecimalFormat decimal = new DecimalFormat("#.#####");
					decimal.setRoundingMode(RoundingMode.HALF_UP);
					
					String resultatConversion = "";
					Distance aConvertir = new Distance(valeur);
					
					StringSimplifier selectionDepartSimple = new StringSimplifier();
					selectionDepart = selectionDepartSimple.netttoyerChaine(selectionDepart).toLowerCase();
					
					StringSimplifier selectionConversionSimple = new StringSimplifier();
					selectionConversion = selectionDepartSimple.netttoyerChaine(selectionConversion);
					
					String nomFonction = selectionDepart+"To"+selectionConversion;
					
					String nom = Distance.class.getName();
					Class nomClasse = null;
					
					try 
					{
						nomClasse = nomClasse.forName(nom);
					} 
					catch (ClassNotFoundException e){e.printStackTrace();}
							
					if(nomClasse != null)
					{
						Method methode = null;
						try 
						{
							methode = aConvertir.getClass().getMethod(nomFonction);
						}
						catch (NoSuchMethodException e1) {e1.printStackTrace();} 
						catch (SecurityException e1) {e1.printStackTrace();}

						try 
						{
							resultat.setText(""+methode.invoke(aConvertir));
						} 
						catch (IllegalAccessException e){e.printStackTrace();} 
						catch (IllegalArgumentException e){e.printStackTrace();} 
						catch (InvocationTargetException e){e.printStackTrace();}
					}
				}
			});
		}
		//---------------------------- POIDS ----------------------------
		//--------------------------------------------------------
		//--------------------------------------------
		//----------------------------------
		//------------------------
		//-------------
		//-----
		else if (nomSelection.equals("Poids"))
		{
			Poids valeur = new Poids();
			//On récupère le tableau de valeur de conversion de l'on jet de type "Température" pour calculer le nombre
			//max d'unité de conversion
			String [] unite = valeur.getUniteConversion();
			int maxUnite = unite.length;
			
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
			
			uniteConversion.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent action)
				{
					String selectionDepart = uniteDepart.getSelectedItem().toString();
					String selectionConversion = uniteConversion.getSelectedItem().toString();
					
					double valeur = Double.parseDouble(saisieValeur.getText());

					DecimalFormat decimal = new DecimalFormat("#.#####");
					decimal.setRoundingMode(RoundingMode.HALF_UP);
					
					String resultatConversion = "";
					Poids aConvertir = new Poids(valeur);
					
					StringSimplifier selectionDepartSimple = new StringSimplifier();
					selectionDepart = selectionDepartSimple.netttoyerChaine(selectionDepart).toLowerCase();
					
					StringSimplifier selectionConversionSimple = new StringSimplifier();
					selectionConversion = selectionDepartSimple.netttoyerChaine(selectionConversion);
					
					String nomFonction = selectionDepart+"To"+selectionConversion;
					
					String nom = Distance.class.getName();
					Class nomClasse = null;
					
					try 
					{
						nomClasse = nomClasse.forName(nom);
					} 
					catch (ClassNotFoundException e){e.printStackTrace();}
							
					if(nomClasse != null)
					{
						Method methode = null;
						try 
						{
							methode = aConvertir.getClass().getMethod(nomFonction);
						}
						catch (NoSuchMethodException e1) {e1.printStackTrace();} 
						catch (SecurityException e1) {e1.printStackTrace();}

						try 
						{
							resultat.setText(""+methode.invoke(aConvertir));
						} 
						catch (IllegalAccessException e){e.printStackTrace();} 
						catch (IllegalArgumentException e){e.printStackTrace();} 
						catch (InvocationTargetException e){e.printStackTrace();}
					}
				}
			});
			//Listener sur la ComboBox de l'unité de départ
			uniteConversion.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent action)
				{
					String selectionDepart = uniteDepart.getSelectedItem().toString();
					String selectionConversion = uniteConversion.getSelectedItem().toString();
					
					double valeur = Double.parseDouble(saisieValeur.getText());

					DecimalFormat decimal = new DecimalFormat("#.#####");
					decimal.setRoundingMode(RoundingMode.HALF_UP);
					
					String resultatConversion = "";
					Poids aConvertir = new Poids(valeur);
					
					StringSimplifier selectionDepartSimple = new StringSimplifier();
					selectionDepart = selectionDepartSimple.netttoyerChaine(selectionDepart).toLowerCase();
					
					StringSimplifier selectionConversionSimple = new StringSimplifier();
					selectionConversion = selectionDepartSimple.netttoyerChaine(selectionConversion);
					
					String nomFonction = selectionDepart+"To"+selectionConversion;
					
					String nom = Distance.class.getName();
					Class nomClasse = null;
					
					try 
					{
						nomClasse = nomClasse.forName(nom);
					} 
					catch (ClassNotFoundException e){e.printStackTrace();}
							
					if(nomClasse != null)
					{
						Method methode = null;
						try 
						{
							methode = aConvertir.getClass().getMethod(nomFonction);
						}
						catch (NoSuchMethodException e1) {e1.printStackTrace();} 
						catch (SecurityException e1) {e1.printStackTrace();}

						try 
						{
							resultat.setText(""+methode.invoke(aConvertir));
						} 
						catch (IllegalAccessException e){e.printStackTrace();} 
						catch (IllegalArgumentException e){e.printStackTrace();} 
						catch (InvocationTargetException e){e.printStackTrace();}
					}
				}
			});
			
			uniteConversion.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent action)
				{
					String selectionDepart = uniteDepart.getSelectedItem().toString();
					String selectionConversion = uniteConversion.getSelectedItem().toString();
					
					double valeur = Double.parseDouble(saisieValeur.getText());

					DecimalFormat decimal = new DecimalFormat("#.#####");
					decimal.setRoundingMode(RoundingMode.HALF_UP);
					
					String resultatConversion = "";
					Poids aConvertir = new Poids(valeur);
					
					StringSimplifier selectionDepartSimple = new StringSimplifier();
					selectionDepart = selectionDepartSimple.netttoyerChaine(selectionDepart).toLowerCase();
					
					StringSimplifier selectionConversionSimple = new StringSimplifier();
					selectionConversion = selectionDepartSimple.netttoyerChaine(selectionConversion);
					
					String nomFonction = selectionDepart+"To"+selectionConversion;
					
					String nom = Distance.class.getName();
					Class nomClasse = null;
					
					try 
					{
						nomClasse = nomClasse.forName(nom);
					} 
					catch (ClassNotFoundException e){e.printStackTrace();}
							
					if(nomClasse != null)
					{
						Method methode = null;
						try 
						{
							methode = aConvertir.getClass().getMethod(nomFonction);
						}
						catch (NoSuchMethodException e1) {e1.printStackTrace();} 
						catch (SecurityException e1) {e1.printStackTrace();}

						try 
						{
							resultat.setText(""+methode.invoke(aConvertir));
						} 
						catch (IllegalAccessException e){e.printStackTrace();} 
						catch (IllegalArgumentException e){e.printStackTrace();} 
						catch (InvocationTargetException e){e.printStackTrace();}
					}
				}
			});
		}
		//else if(nomSelection.equals("nomNouvelObjetConvertisseur"))
		//{...}
	}
}