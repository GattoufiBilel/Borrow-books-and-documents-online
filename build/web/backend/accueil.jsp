
<%@page import="Beans.Adherent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        
    </head>
    <body>
        <h1> La Bibliothque en Ligne </h1>
        <div class="container-fluid">
        <% 
            Adherent adh = (Adherent) session.getAttribute("user") ;       
        %>
        <div class="alert alert-success" role="alert">
            <h2>
                ${notification}
                Welcome  <%= adh.getNom()  +  adh.getPrenom() %>
                ${msgUpdate} 
            </h2>                     
        </div>  
        <% 
           if (adh.getRole() == 1 ) {
        %>
          <h1> admin</h1>  
        <% } 
        else { %>
        <h1> adherent </h1> 
        <% } %>
        </div> 
       
        <br/>
        
        <table class="table-striped container">
              <thead class="container">
                <tr>
                    <th> Administrateur   </th>
                </tr>
            </thead>
            
            <tbody>
               <tr>
                   <td class="text-center bg-danger">
                       <h3 class="glyphicon glyphicon-book">  GESTION LIVRE </h3>
                    </td>
               </tr>
               <tr>
                   <td>
                          <div class="btn-group-lg">    
                            <a class="btn btn-primary btn-lg btn-block" href="AjouterLivre" role="button">ajouter Livre </a>
                            <a class="btn btn-info btn-lg btn-block" href="ListeLivre" role="button">Liste de livre </a>
                            <a class="btn btn-info btn-lg btn-block" href="LIVRE/chercherLivre.jsp" role="button">Chercher un Titre</a>
                            
                          </div>
                    </td>
                </tr>
                
                
                <tr>
                    <td class="text-center bg-danger">
                        <h3 class="glyphicon glyphicon-education">  GESTION EDITEUR </h3>
                    </td>
               </tr>
               <tr>
                    <td>
                          <div class="btn-group-lg">    
                            <a class="btn btn-primary btn-lg btn-block" href="EDITEUR/ajouterEditeur.jsp" role="button">ajouter Editeur </a>
                            <a class="btn btn-info btn-lg btn-block" href="ListeEditeur" role="button">Listes des editeurs  </a>
                          </div>
                    </td>
                </tr>
                
                
                <tr>
                   <td class="text-center bg-danger">
                       <h3 class="glyphicon glyphicon-user">  GESTION ADHERENT </h3>
                    </td>
               </tr>
               <tr>
                    <td>
                          <div class="btn-group-lg">    
                            <a class="btn btn-primary btn-lg btn-block" href="ServletAdherent" role="button">ajouter adherent </a>
                            <a class="btn btn-info btn-lg btn-block" href="ListeAdherent" role="button">Liste adherent </a>
                          </div>
                    </td>
                </tr
                
                
                
                <tr>
                    <td class="text-center bg-danger">
                        <h3 class="glyphicon glyphicon-tasks">  OPERATION EMPRUNT </h32>
                    </td>
               </tr>
               <tr>
                    <td>
                          <div class="btn-group-lg">    
                            <a class="btn btn-primary btn-lg btn-block" href="#" role="button">Emprunter </a>
                            <a class="btn btn-info btn-lg btn-block" href="#" role="button">Historique </a>
                          </div>
                    </td>
                </tr>
                
                
                <tr>
                    <td class="text-center bg-danger">
                        <h3 class="glyphicon glyphicon-log-in">  Authentification </h3>
                    </td>
               </tr>
               <tr>
                    <td>
                          <div class="btn-group-lg">    
                            <a class="btn btn-danger btn-lg btn-block" href="ServletDeconnexion" role="button">Deconnexion </a>
                          </div>
                    </td>
                </tr>
            
            </tbody>
            
        </table>
        
  
    </body>
</html>
