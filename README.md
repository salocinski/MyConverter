# MyConverter
Convertisseur universel

L'application est entièrement automatisée et peut être facilement alimentée en nouveau convertisseur si vous respectez la structure de construction des objets "Convertisseur" (Distance, Poids, Température,...) selon le modèle suivant :

- Une valeur de type "double" qui correspond à la valeur qui sera convertie;
- Un tableau de nom d'unités de conversion (String[] uniteConversion = {});
- D'un constructeur prenant en paramètre l'attribut "valeur";
- D'un constructeur qui initialise le tableau d'unités de conversion.
- L'ensemble des méthodes permettant l'inter-conversion des unités entre elles en respectant le schéma suivant :
  - public double nomUniteDepart+"To"+nomUniteConversion () {…}

----- Je vous invite à prendre pour exemple les classes « Température », « Poids », « Distance » pour construire efficacement les nouveaux convertisseurs -----
  
Il suffira d'ajouter la nouvelle classe à l'intérieur du package "Convertisseur" et le système automatisera : 

- L'ajout du nouveau convertisseur à la liste déroulante de l'onglet d'accueil;
- L'ouverture de l'onglet correspondant au convertisseur sélectionné;
- Le remplissage des listes déroulantes permettant de sélectionner l'unité de départ et l'unité de conversion de la valeur saisie;
- L'appel automatique de la fonction de conversion;

N'hésitez pas à partager tout nouveau convertisseur ou à me signaler tout mauvais fonctionnement.
