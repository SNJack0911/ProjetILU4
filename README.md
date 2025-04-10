# ProjetILU4
Dépôt pour le projet du jeu pirates dans le cadre de l'UE ILU4 


## Règle concerant ce dépot : 
<ul>
  <li> Lors du développement initial du projet, nous travaillerons dans la branche main. Une fois que la première version du jeu est fonctionnelle, nous devrons utiliser des branches pour ajouter des fonctionnalités et régler des problèmes. Une fois que ces branche seront valide, elles seront merge avec la branche main </li>
  <li> Les branches d'ajout de fonctionnalité seront nommé de la façon suivante <strong>work-nomFonctionnalité</strong> </li>
  <li> Les branches pour régler des erreurs seront nommé de la façon suivante <strong>fix-nomErreur</strong> </li>
  <li> Quand vous avez un code qui ne produit pas d’erreur et qui fonctionne, vous avez le droit de faire un push dans la branche main </li>
  <li> À chaque fois que vous faites une suite de commits dans n'importe quelles branches, vous devez expliquer ce que vous avez fait (2, 3 lignes) pour les autres dans la feuille log du fichier Google Sheets.</li>
  <li> S’il n’existe pas d’UML pour la fonctionnalité ou que vous n’avez pas le ok de Fanny pour coder une fonctionnalité du noyau, VOUS NE POUVEZ PAS LA CODER </li>
  <li> À chaque fois qu’il y aura un merge d'une fonctionnalité ou d'un fix d'erreur avec la branche main, une annonce sera faite dans le discord </li>
</ul>

## Informations importantes :

### Lien vers le fichier [google sheets](https://docs.google.com/spreadsheets/d/1pEVe0BCmCFwTrj3oVM-OLpM3KjLV1VXAa6MbzpMAnc4/edit?gid=0#gid=0) avec la repartition du travail pour le projet.

### Lien vers l'[UML](https://lucid.app/lucidchart/2e8563b0-2497-4d1a-8210-dc52462ad762/edit?viewport_loc=-660%2C290%2C3778%2C1852%2C0_0&invitationId=inv_8b7d8a13-1c0c-465e-966b-c41893010b6c) du projet.

Dans la branche main se trouvent les fichiers qui fonctionnent. Les autres branches contiennent des fonctionnalités qui ne sont pas terminées et qui serviront au développement du projet final. Le projet est découpé en une architecture ECB pour garantir la sécurité des données. 

### Le fichier main contient les packages :  
<ul>
  <li> Le package noyau contient les objets sur lesquels est basé le jeu. Il contient les objets fondamentaux et les ressources pour l'IHM. </li>
  <li> Le package controleur permet de faire le lien entre le noyau et le boundary. Il garantit que le noyau reçoit des éléments du bon type et valide. </li>
  <li> Le package boundary contient l'IHM (et l'affiche console). Il permet de récupérer les entrées utilisateur. </li>
</ul>

