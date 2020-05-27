
<%@page import="Beans.Adherent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bibliotheque en ligne </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"> 
    </head>
    <body>
        <h1> La Bibliothque en Ligne </h1>
        <div class="container">
        <% 
            Adherent adh = (Adherent) session.getAttribute("user") ;       
        %>
        <div class="alert alert-success" role="alert">
            <h2>
                ${notification}
                Welcome  <%= adh.getNom()  + "  " + adh.getPrenom() %>
              
            </h2>                     
        </div>  
       
        </div>
        
    </body>
</html>
