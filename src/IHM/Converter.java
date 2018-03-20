package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Extension.Onglets;
import Extension.RechercheClasse;

public class Converter extends JFrame
{

	public static void main(String[] args)
	{
		/*---------- INITIALISATION DE LA FENETRE ----------*/
			/*---------- Création de la fenetre ----------*/
		Converter fenetre = new Converter();
		fenetre.setLayout(null);
		fenetre.setResizable(false);
		fenetre.setSize(450, 450);
		fenetre.getContentPane().setBackground(Color.BLACK);
		fenetre.setTitle("MyConverter - Mon convertisseur de données");
			/*---------- Création de la fenetre ----------*/
		
			/*---------- Gestion du titre ----------*/
		JLabel titre = new JLabel("My Converter");
		titre.setBounds(165,10,200,20);
		titre.setFont(new Font ("Arial", Font.BOLD, 16));
		titre.setForeground(Color.WHITE);
		
		JLabel sousTitre = new JLabel("Mon convertisseur de données");
		sousTitre.setBounds(135,25,200,20);
		sousTitre.setForeground(Color.WHITE);
			/*---------- Gestion du titre ----------*/
		
			/*---------- Gestion des onglets ----------*/
		JTabbedPane onglets = new JTabbedPane();
		JPanel contenu = new JPanel();
		
		contenu.setLayout(new BoxLayout(contenu, BoxLayout.LINE_AXIS));
		onglets.setBounds(0, 75, 450, 250);
			/*---------- Gestion des onglets ----------*/
		
			/*---------- Création du contenu de l'onglet d'accueil ----------*/
		ArrayList <Class> listeConversion = new ArrayList <Class> ();
		
		RechercheClasse classe = new RechercheClasse();
		try
		{
			listeConversion = (ArrayList<Class>) classe.getClasses("Convertisseur");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		JComboBox liste = new JComboBox();
		liste.setPreferredSize(new Dimension(100, 20));
		liste.setMinimumSize(new Dimension(100,20));
		liste.setMaximumSize(new Dimension(100,20));
		
		JLabel selection = new JLabel("Que désirez-vous convertir ?");
		selection.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 0));
		
		for (int i = 0; i < listeConversion.size(); i++)
		{
			String unite = listeConversion.get(i).toString();
			
			String [] tabUnite = unite.split("\\.");
			unite = tabUnite[1];

			liste.addItem(unite);
		}
			/*---------- Création de la liste déroulante ----------*/
		JButton valider = new JButton("Valider");
		
		contenu.add(selection);
		//On crée une goutière (marge) entre les éléments pour gérer l'espacement entre les éléments
		//Sans goutière, les éléments sont en fusion de marges (collés)
		contenu.add(Box.createRigidArea(new Dimension(10, 0)));
		contenu.add(liste);
		contenu.add(Box.createRigidArea(new Dimension(10, 0)));
		contenu.add(valider);

		onglets.addTab("Accueil", null, contenu, "Accueil");
			/*---------- Création du contenu de l'onglet d'accueil ----------*/

			/*---------- Gestion du bouton ----------*/
		JButton quitter = new JButton();
		quitter.setText("Quitter");
		quitter.setBackground(Color.WHITE);
		quitter.setBounds(150, 350, 150, 25);
			/*---------- Gestion du bouton ----------*/

			/*---------- Ajout des éléments à la fenêtre ----------*/
		fenetre.getContentPane().add(titre);
		fenetre.getContentPane().add(sousTitre);
		fenetre.getContentPane().add(onglets);
		fenetre.getContentPane().add(quitter);
			/*---------- Ajout des éléments à la fenêtre ----------*/
		
		fenetre.setVisible(true);
		/*---------- INITIALISATION DE LA FENETRE ----------*/
		
		/*---------- GESTION EVENEMENTS ----------*/
		quitter.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent action)
			{
				System.exit(0);
			}
		});
		
		valider.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent action)
			{
				int idListe = liste.getSelectedIndex();
				String nomSelection = liste.getSelectedItem().toString();
				
				Onglets nouvelOnglet = new Onglets();
				nouvelOnglet.creerOnglets(onglets, idListe, nomSelection);
			}
		});
		
	    onglets.addMouseListener(new java.awt.event.MouseAdapter() 
	    {
	           public void mouseReleased(java.awt.event.MouseEvent evt) 
	           {
	        	   int i = onglets.getTabCount();
	        	   
	        	   if(evt.getClickCount()==2)
	        	   {
	        		   if(i != 1)
		        		   onglets.remove(onglets.getSelectedComponent()); 
	        	   }  
	           }
         });
		/*---------- GESTION EVENEMENTS ----------*/
	}
}
