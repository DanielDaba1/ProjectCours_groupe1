# ProjectCours_groupe1
E-MAIL : josamuna@gmail.com
Mot de pass : @Josue1
Repository github : https://github.com/DanielDaba1/ProjectCours_groupe1.git

1. DESCRIPTION DES INTERFACES ET TESTS
a.	 Interface de connexion (Login.java)
Permet à l’utilisateur d’entrer son adresse e-mail et son mot de passe pour se connecter.
Tests :
N°	Cas de test	Entrée utilisateur	Résultat attendu	Message affiché
1	Champs vides	Email et mot de passe vides	Refus de connexion	"Veuillez remplir tous les champs"
2	Email incorrect	Email inexistant	Refus de connexion	"Utilisateur non trouvé"
3	Mot de passe incorrect	Mauvais mot de passe	Refus de connexion	"Mot de passe incorrect"
4	Connexion réussie	Email et mot de passe valides	Accès au tableau de bord	"Connexion réussie"
   
b.	 Interface d’ajout d’utilisateur (Home.java)
Fonctionnalités
	Validation des champs,
	Hachage du mot de passe avant enregistrement,
	Insertion dans la table person,
	Message de confirmation.
Tests fonctionnels
N°	Cas de test	Entrée utilisateur	Résultat attendu	Message affiché
1	Champs vides	Aucun champ saisi	Erreur de validation	"Tous les champs sont obligatoires"
2	Email invalide	Email sans @	Refus d’ajout	"Email invalide"
3	Email déjà existant	Email existant en base	Échec d’ajout	"Email déjà enregistré"
4	Données valides	Toutes les infos correctes	Succès	"Utilisateur ajouté avec succès !"
   


c.	 Interface de modification d’utilisateur (Home.java)
Permet de modifier les informations d’un utilisateur existant.
 Fonctionnalités
	Chargement automatique des données actuelles,
	Hachage du nouveau mot de passe,
	Mise à jour en base.
Test
N°	Cas de test	Entrée utilisateur	Résultat attendu	Message affiché
1	Champs vides	Aucun champ saisi	Échec	"Veuillez remplir tous les champs"
2	Modification du mot de passe	Nouveau mot de passe saisi	Mise à jour réussie	"Utilisateur modifié avec succès !"
3	Modification email existant	Email déjà pris	Échec	"Email déjà utilisé"
4	Données valides	Tous les champs corrects	Succès	"Utilisateur modifié avec succès !"
  
 
d.	 Interface d’affichage / Liste des utilisateurs (Home.java)
Affiche tous les utilisateurs enregistrés dans la base.
Tests :
1.	Table vide → message : « Aucun utilisateur trouvé »
2.	Table non vide → affichage correct de la liste des utilisateurs
3.	Actualisation après ajout ou Modification → mise à jour immédiate du tableau
 
e.	 Messages système
Action	Message affiché
Connexion réussie	Connexion réussie
Ajout réussi	Utilisateur ajouté avec succès !
Modification réussie	Utilisateur modifié avec succès !
Suppression réussie	Utilisateur supprimé avec succès !
Erreur SQL	 Erreur : + message d’erreur
Champs vides	Veuillez remplir tous les champs
 
f.	 Outils utilisés
1.	Langage : Java
2.	Base de données : MySQL
3.	Interface graphique : Swing + FlatLaf
4.	IDE : NetBeans
5.	Sécurité : BCrypt pour le hachage
6.	Outils de test : JOptionPane + affichage console + JUnit 
 

