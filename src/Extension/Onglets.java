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

import Class.Temperature;

public class Onglets
{
	public void creerOnglets(JTabbedPane onglet, int idListe)
	{
		JPanel contenu = new JPanel();
		contenu.setLayout(new BoxLayout(contenu, BoxLayout.LINE_AXIS));
		
		//On applique le format de saisie au JtextField formaté selon ce modèle
		JTextField saisieValeur = new JTextField();
		saisieValeur.setPreferredSize(new Dimension(100, 20));
		saisieValeur.setMinimumSize(new Dimension(100,20));
		saisieValeur.setMaximumSize(new Dimension(100,20));
		
		ArrayList <String> listeUniteTemperature = new ArrayList <String> ();
		listeUniteTemperature.add("Sélectionner la conversion");
		listeUniteTemperature.add("Celsius -> Farhenheit");
		listeUniteTemperature.add("Celsius -> Kelvin");
		listeUniteTemperature.add("Celsius -> Rankine");
		listeUniteTemperature.add("Farhenheit -> Celsius");
		listeUniteTemperature.add("Farhenheit -> Kelvin");
		listeUniteTemperature.add("Farhenheit -> Rankine");
		listeUniteTemperature.add("Kelvin -> Celsius");
		listeUniteTemperature.add("Kelvin -> Farhenheit");
		listeUniteTemperature.add("Kelvin -> Rankine");
		listeUniteTemperature.add("Rankine -> Celsius");
		listeUniteTemperature.add("Rankine -> Farhenheit");
		listeUniteTemperature.add("Rankine -> Kelvin");
		
		JComboBox listeUnite = new JComboBox();
		listeUnite.setPreferredSize(new Dimension(200, 20));
		listeUnite.setMinimumSize(new Dimension(200,20));
		listeUnite.setMaximumSize(new Dimension(200,20));
		
		JLabel resultat = new JLabel("");
		
		if (idListe == 0)
		{
			onglet.addTab("Température",  null, contenu, "Double cliquer pour fermer l'onglet");
			this.creerContenu(onglet, contenu, saisieValeur, listeUniteTemperature, listeUnite, resultat);
		}
		else if (idListe == 1)
			onglet.addTab("Distance",  null, contenu, "Double cliquer pour fermer l'onglet");
		else if (idListe == 2)
			onglet.addTab("Poids",  null, contenu, "Double cliquer pour fermer l'onglet");
	}
	
	public void creerContenu(JTabbedPane onglet, JPanel contenu, JTextField saisieValeur, ArrayList <String> listeUniteTemperature, JComboBox listeUnite, JLabel resultat)
	{
		contenu.add(saisieValeur);
		saisieValeur.setDocument(new NumTextField());
		for (int i = 0; i < listeUniteTemperature.size(); i++)
		{
			listeUnite.addItem(listeUniteTemperature.get(i));
		}
		contenu.add(Box.createRigidArea(new Dimension(10, 0)));
		contenu.add(listeUnite);
		contenu.add(Box.createRigidArea(new Dimension(10, 0)));
		contenu.add(resultat);
		
		listeUnite.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent action)
			{
				int idListe = listeUnite.getSelectedIndex();
				
				double valeur = Double.parseDouble(saisieValeur.getText());
				double conversion;
				
				DecimalFormat decimal = new DecimalFormat("#.##");
				decimal.setRoundingMode(RoundingMode.HALF_UP);
				
				String resultatConversion = "";
				
				Temperature aConvertir = new Temperature(valeur);
				switch(idListe)
				{
				case 0:
					break;
				case 1:
					conversion = aConvertir.celsiusToFahrenheit();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Farhenheit");
					break;
				case 2:
					conversion = aConvertir.celsiusToKelvin();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Kelvin");
					break;
				case 3:
					conversion = aConvertir.celsiusToRankine();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Rankine");
					break;
				case 4:
					conversion = aConvertir.fahrenheitToCelsius();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Celsius");
					break;
				case 5:
					conversion = aConvertir.fahrenheitToKelvin();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Kelvin");
					break;
				case 6:
					conversion = aConvertir.fahrenheitToRankine();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Rankine");
					break;
				case 7:
					conversion = aConvertir.kelvinToCelsius();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Celsius");
					break;
				case 8:
					conversion = aConvertir.kelvinToFahrenheit();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Farhenheit");
					break;
				case 9:
					conversion = aConvertir.kelvinToRankine();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Rankine");
					break;
				case 10:
					conversion = aConvertir.rankineToCelsius();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Celsius");
					break;
				case 11:
					conversion = aConvertir.rankineToFahrenheit();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Farhenheit");
					break;
				case 12:
					conversion = aConvertir.rankineToKelvin();
					resultatConversion = decimal.format(conversion);
					resultat.setText(resultatConversion+"° Kelvin");
					break;
				}
			}
		});
	}
}
