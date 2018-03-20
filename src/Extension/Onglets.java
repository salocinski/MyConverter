package Extension;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Convertisseur.Temperature;

public class Onglets
{
	public void creerOnglets(JTabbedPane onglet, int idListe, String nomSelection)
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
		
		if (nomSelection.equals("Temperature"))
		{
			onglet.addTab("Température",  null, contenu, "Double cliquer pour fermer l'onglet");
			this.creerContenu(onglet, contenu, saisieValeur, uniteDepart, uniteConversion, nomSelection, resultat);
		}
		else if (nomSelection.equals("Distance"))
		{
			onglet.addTab("Distance",  null, contenu, "Double cliquer pour fermer l'onglet");
			this.creerContenu(onglet, contenu, saisieValeur, uniteDepart, uniteConversion, nomSelection, resultat);
		}
		else if (nomSelection.equals("Poids"))
			onglet.addTab("Poids",  null, contenu, "Double cliquer pour fermer l'onglet");
	}
	
	public void creerContenu(JTabbedPane onglet, JPanel contenu, JTextField saisieValeur, JComboBox uniteDepart, JComboBox uniteConversion, String nomSelection, JTextField resultat)
	{
		contenu.add(Box.createRigidArea(new Dimension(10, 0)));
		contenu.add(saisieValeur);
		saisieValeur.setDocument(new NumTextField());
		
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
					
					switch(selectionDepart)
					{
						case "Celsius":
							switch(selectionConversion)
							{
								case "Celsius" :
									break;
								case "Fahrenheit":
									resultatConversion = decimal.format(aConvertir.celsiusToFahrenheit());
									resultat.setText(""+resultatConversion);
									break;
								case "Kelvin":
									resultatConversion = decimal.format(aConvertir.celsiusToKelvin());
									resultat.setText(""+resultatConversion);
									break;
								case "Rankine":
									resultatConversion = decimal.format(aConvertir.celsiusToRankine());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Fahrenheit":
							switch(selectionConversion)
							{
								case "Celsius" :
									resultatConversion = decimal.format(aConvertir.fahrenheitToCelsius());
									resultat.setText(""+resultatConversion);
									break;
								case "Fahrenheit":
									break;
								case "Kelvin":
									resultatConversion = decimal.format(aConvertir.fahrenheitToKelvin());
									resultat.setText(""+resultatConversion);
									break;
								case "Rankine":
									resultatConversion = decimal.format(aConvertir.fahrenheitToRankine());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Kelvin":
							switch(selectionConversion)
							{
								case "Celsius" :
									resultatConversion = decimal.format(aConvertir.kelvinToCelsius());
									resultat.setText(""+resultatConversion);
									break;
								case "Fahrenheit":
									resultatConversion = decimal.format(aConvertir.kelvinToFahrenheit());
									resultat.setText(""+resultatConversion);
									break;
								case "Kelvin":
									break;
								case "Rankine":
									resultatConversion = decimal.format(aConvertir.kelvinToRankine());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Rankine":
							switch(selectionConversion)
							{
								case "Celsius" :

									resultatConversion = decimal.format(aConvertir.rankineToCelsius());
									resultat.setText(""+resultatConversion);
									break;
								case "Fahrenheit":
									resultatConversion = decimal.format(aConvertir.rankineToFahrenheit());
									resultat.setText(""+resultatConversion);
									break;
								case "Kelvin":
									resultatConversion = decimal.format(aConvertir.rankineToKelvin());
									resultat.setText(""+resultatConversion);
									break;
								case "Rankine":
									break;
							}
							break;
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
					
					switch(selectionDepart)
					{
						case "Celsius":
							switch(selectionConversion)
							{
								case "Celsius" :
									break;
								case "Fahrenheit":
									resultatConversion = decimal.format(aConvertir.celsiusToFahrenheit());
									resultat.setText(""+resultatConversion);
									break;
								case "Kelvin":
									resultatConversion = decimal.format(aConvertir.celsiusToKelvin());
									resultat.setText(""+resultatConversion);
									break;
								case "Rankine":
									resultatConversion = decimal.format(aConvertir.celsiusToRankine());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Fahrenheit":
							switch(selectionConversion)
							{
								case "Celsius" :
									resultatConversion = decimal.format(aConvertir.fahrenheitToCelsius());
									resultat.setText(""+resultatConversion);
									break;
								case "Fahrenheit":
									break;
								case "Kelvin":
									resultatConversion = decimal.format(aConvertir.fahrenheitToKelvin());
									resultat.setText(""+resultatConversion);
									break;
								case "Rankine":
									resultatConversion = decimal.format(aConvertir.fahrenheitToRankine());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Kelvin":
							switch(selectionConversion)
							{
								case "Celsius" :
									resultatConversion = decimal.format(aConvertir.kelvinToCelsius());
									resultat.setText(""+resultatConversion);
									break;
								case "Fahrenheit":
									resultatConversion = decimal.format(aConvertir.kelvinToFahrenheit());
									resultat.setText(""+resultatConversion);
									break;
								case "Kelvin":
									break;
								case "Rankine":
									resultatConversion = decimal.format(aConvertir.kelvinToRankine());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Rankine":
							switch(selectionConversion)
							{
								case "Celsius" :

									resultatConversion = decimal.format(aConvertir.rankineToCelsius());
									resultat.setText(""+resultatConversion);
									break;
								case "Fahrenheit":
									resultatConversion = decimal.format(aConvertir.rankineToFahrenheit());
									resultat.setText(""+resultatConversion);
									break;
								case "Kelvin":
									resultatConversion = decimal.format(aConvertir.rankineToKelvin());
									resultat.setText(""+resultatConversion);
									break;
								case "Rankine":
									break;
							}
							break;
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
					
					switch(selectionDepart)
					{
						case "Celsius":
							switch(selectionConversion)
							{
								case "Celsius" :
									break;
								case "Fahrenheit":
									resultatConversion = decimal.format(aConvertir.celsiusToFahrenheit());
									resultat.setText(""+resultatConversion);
									break;
								case "Kelvin":
									resultatConversion = decimal.format(aConvertir.celsiusToKelvin());
									resultat.setText(""+resultatConversion);
									break;
								case "Rankine":
									resultatConversion = decimal.format(aConvertir.celsiusToRankine());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Fahrenheit":
							switch(selectionConversion)
							{
								case "Celsius" :
									resultatConversion = decimal.format(aConvertir.fahrenheitToCelsius());
									resultat.setText(""+resultatConversion);
									break;
								case "Fahrenheit":
									break;
								case "Kelvin":
									resultatConversion = decimal.format(aConvertir.fahrenheitToKelvin());
									resultat.setText(""+resultatConversion);
									break;
								case "Rankine":
									resultatConversion = decimal.format(aConvertir.fahrenheitToRankine());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Kelvin":
							switch(selectionConversion)
							{
								case "Celsius" :
									resultatConversion = decimal.format(aConvertir.kelvinToCelsius());
									resultat.setText(""+resultatConversion);
									break;
								case "Fahrenheit":
									resultatConversion = decimal.format(aConvertir.kelvinToFahrenheit());
									resultat.setText(""+resultatConversion);
									break;
								case "Kelvin":
									break;
								case "Rankine":
									resultatConversion = decimal.format(aConvertir.kelvinToRankine());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Rankine":
							switch(selectionConversion)
							{
								case "Celsius" :

									resultatConversion = decimal.format(aConvertir.rankineToCelsius());
									resultat.setText(""+resultatConversion);
									break;
								case "Fahrenheit":
									resultatConversion = decimal.format(aConvertir.rankineToFahrenheit());
									resultat.setText(""+resultatConversion);
									break;
								case "Kelvin":
									resultatConversion = decimal.format(aConvertir.rankineToKelvin());
									resultat.setText(""+resultatConversion);
									break;
								case "Rankine":
									break;
							}
							break;
					}
				}
			});
		}
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

					switch(selectionDepart)
					{
						case "Kilomètre":
							switch(selectionConversion)
							{
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.kmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.kmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.kmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.kmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.kmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.kmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.kmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.kmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.kmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Hectomètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.hmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.hmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.hmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.hmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.hmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.hmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.hmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.hmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.hmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Décamètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.damToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.damToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.damToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.damToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.damToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.damToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.damToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.damToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.damToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Mètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.mToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.mToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.mToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.mToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.mToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.mToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.mToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.mToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.mToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Décimètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.dmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.dmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.dmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.dmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.dmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.dmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.dmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.dmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.dmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Centimètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.cmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.cmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.cmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.cmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.cmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.cmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.cmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.cmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.cmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Millimètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.mmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.mmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.mmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.mmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.mmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.mmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.mmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.mmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.mmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Inch (pouce)":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.inToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.inToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.inToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.inToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.inToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.inToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.inToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.inToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.inToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Foot (pied)":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.ftToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.ftToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.ftToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.ftToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.ftToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.ftToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.ftToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.ftToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.ftToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Yard (verge)":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.ydToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.ydToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.ydToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.ydToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.ydToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.ydToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.ydToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.ydToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.ydToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									break;
							}
							break;
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

					switch(selectionDepart)
					{
						case "Kilomètre":
							switch(selectionConversion)
							{
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.kmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.kmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.kmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.kmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.kmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.kmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.kmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.kmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.kmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Hectomètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.hmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.hmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.hmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.hmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.hmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.hmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.hmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.hmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.hmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Décamètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.damToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.damToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.damToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.damToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.damToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.damToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.damToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.damToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.damToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Mètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.mToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.mToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.mToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.mToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.mToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.mToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.mToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.mToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.mToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Décimètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.dmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.dmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.dmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.dmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.dmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.dmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.dmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.dmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.dmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Centimètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.cmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.cmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.cmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.cmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.cmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.cmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.cmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.cmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.cmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Millimètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.mmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.mmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.mmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.mmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.mmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.mmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.mmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.mmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.mmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Inch (pouce)":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.inToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.inToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.inToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.inToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.inToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.inToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.inToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.inToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.inToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Foot (pied)":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.ftToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.ftToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.ftToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.ftToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.ftToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.ftToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.ftToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.ftToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.ftToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Yard (verge)":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.ydToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.ydToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.ydToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.ydToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.ydToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.ydToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.ydToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.ydToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.ydToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									break;
							}
							break;
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

					switch(selectionDepart)
					{
						case "Kilomètre":
							switch(selectionConversion)
							{
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.kmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.kmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.kmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.kmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.kmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.kmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.kmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.kmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.kmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Hectomètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.hmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.hmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.hmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.hmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.hmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.hmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.hmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.hmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.hmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Décamètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.damToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.damToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.damToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.damToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.damToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.damToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.damToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.damToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.damToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Mètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.mToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.mToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.mToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.mToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.mToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.mToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.mToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.mToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.mToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Décimètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.dmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.dmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.dmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.dmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.dmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.dmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.dmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.dmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.dmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Centimètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.cmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.cmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.cmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.cmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.cmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.cmToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.cmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.cmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.cmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Millimètre":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.mmToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.mmToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.mmToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.mmToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.mmToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.mmToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.mmToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.mmToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.mmToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Inch (pouce)":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.inToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.inToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.inToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.inToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.inToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.inToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.inToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.inToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.inToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Foot (pied)":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.ftToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.ftToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.ftToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.ftToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.ftToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.ftToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.ftToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.ftToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									break;
								case "Yard (verge)":
									resultatConversion = decimal.format(aConvertir.ftToYd());
									resultat.setText(""+resultatConversion);
									break;
							}
							break;
						case "Yard (verge)":
							switch(selectionConversion)
							{
								case "Kilomètre":
									resultatConversion = decimal.format(aConvertir.ydToKm());
									resultat.setText(""+resultatConversion);
									break;
								case "Hectomètre":
									resultatConversion = decimal.format(aConvertir.ydToHm());
									resultat.setText(""+resultatConversion);
									break;
								case "Décamètre":
									resultatConversion = decimal.format(aConvertir.ydToDam());
									resultat.setText(""+resultatConversion);
									break;
								case "Mètre":
									resultatConversion = decimal.format(aConvertir.ydToM());
									resultat.setText(""+resultatConversion);
									break;
								case "Décimètre":
									resultatConversion = decimal.format(aConvertir.ydToDm());
									resultat.setText(""+resultatConversion);
									break;
								case "Centimètre":
									resultatConversion = decimal.format(aConvertir.ydToCm());
									resultat.setText(""+resultatConversion);
									break;
								case "Millimètre":
									resultatConversion = decimal.format(aConvertir.ydToMm());
									resultat.setText(""+resultatConversion);
									break;
								case "Inch (pouce)":
									resultatConversion = decimal.format(aConvertir.ydToIn());
									resultat.setText(""+resultatConversion);
									break;
								case "Foot (pied)":
									resultatConversion = decimal.format(aConvertir.ydToFt());
									resultat.setText(""+resultatConversion);
									break;
								case "Yard (verge)":
									break;
							}
							break;
					}
				}
			});
		}
	}
}