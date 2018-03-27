# MyConverter
Convertisseur universel

L'application est entièrement automatisée et peut être facilement alimentée en nouveau convertisseur si vous respectez la structure de construction des objets "Convertisseur" (Distance, Poids, Température,...) selon le modèle suivant :

- Une valeur de type "double" qui correspond à la valeur qui sera convertie;
- Un tableau de nom d'unités de conversion (String[] uniteConversion = {});
- D'une valeur par défaut de conversion;
- D'un constructeur qui initialise le tableau d'unités de conversion.
- D'une méthode "getUniteConversion" permettant de récupérer le tableau des unités de conversion;
- D'une méthode "getUniteBase" qui permet de récupérer la valeur de l'unité par défaut;
- D'une méthode "setValeur(double valeur)" qui permettra de pouvoir modifier l'attribut "valeur" dans le traitement automatisé;
- L'ensemble des méthodes permettant la conversion vers l'unité par défaut :
  - public double nomUniteDepart+"TO"+nomUniteDefaut () {…}
  - public double nomUniteDefaut+"TO"+nomUniteConversion () {…}

----- Je vous invite à prendre pour exemple les classes « Température », « Poids » et/ou « Distance » pour construire efficacement les nouveaux convertisseurs -----
  
Il suffira d'ajouter la nouvelle classe à l'intérieur du package "Convertisseur" et le système automatisera : 

- L'ajout du nouveau convertisseur à la liste déroulante de l'onglet d'accueil;
- L'ouverture de l'onglet correspondant au convertisseur sélectionné;
- Le remplissage des listes déroulantes permettant de sélectionner l'unité de départ et l'unité de conversion de la valeur saisie;
- L'appel automatique des fonctions de conversion;

N'hésitez pas à partager tout nouveau convertisseur ou à me signaler tout mauvais fonctionnement.
