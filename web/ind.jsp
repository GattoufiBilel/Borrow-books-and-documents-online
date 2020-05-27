<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gestionnaire Bibliotheque </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"> 
    </head>
    
        <div class="container-fluid">
            <h2>  Bienvenue au Gestionnaire de Bibliotheque </h2>
        </div>
       
        <div class="container"> 
            
            <br/>
            Gestion de Livre 
            <hr/> 
            
            <h2>Ajouter Nouveau Livre : <a href="AjouterLivre" > Clique ici </a> </h2>
            <h2>Afficher Liste Livre  : <a href="ListeLivre" > Clique ici </a> </h2>
            <h2> chercher livre : <a href="LIVRE/chercherLivre.jsp" > Chercher un titre  </a> </h2>
            
            <br/>
            Gestion de editeur
            <hr/>
            
            
            <h2>Ajouter nouveau Editeur : <a href="EDITEUR/ajouterEditeur.jsp" > Clique ici </a> </h2>
            <h2>Afficher Liste Editeur  : <a href="ListeEditeur" > Clique ici </a> </h2>
            <h2> chercher edit : <a href="EDITEUR/chercherEditeur.jsp" > Chercher un editeur  </a> </h2>
            
           
            <br/>
            Gestion de adherent
            <hr/>
            
            <h2>Ajouter nouveau Adherant : <a href="ajouterAdherent.jsp" > Clique ici </a> </h2>
            <h2>Afficher Liste Adherent  : <a href="ListeAdherent" > Clique ici </a> </h2>
            
            <br/>
             Authentification
            <hr/>
            <h2> Page Connexion : <a href="Authentification.jsp"> Page UNE </a> </h2>
            <h2> page d'accueil  : <a href="accueil.jsp" > clique her </a> </h2>
            <h2> se connecter : <a href="ADHERENT/Connecter.jsp" > connecter </a>  </h2>
            <h2> Inscription :  <a href="ServletAdherent"> Inscription </a></h2>
           
            
            
        </div>
    
     
        
     
    
</html>
