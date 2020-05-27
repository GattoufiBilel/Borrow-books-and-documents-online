<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Beans.Livre"%>
<%@page import="Beans.Editeur"%>
<%@page import="ControllerEditeur.AjouterEditeur"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <title>Ajouter Livre</title>
    </head>
    <body>
        <div class="container-fluid">
            <h2> Modifier Editeur </h2>
        </div>
        <div class="container">
            
            <form method="post" action="ModifierEditeur">
                <fieldset>
                <legend>Informations Editeur</legend>
                <div class="form-group">
                    <label for="IdEditeur">Id editeur <span class="requis">*</span></label>
                    <input class="form-control" type="text" id="IdEditeur" name="IdEditeur" value="${ idedit }" size="20" maxlength="20"/>
                </div>
                <div class="form-group">   
                    <label for="nomEditeur">Nom Editeur</label>
                    <input class="form-control" type="text" id="nomEditeur" name="nomEditeur" value="" size="20" maxlength="20" />
                </div>
                
                <div class="form-group">
                    <label for="Adresse">Adresse </label>
                    <input class="form-control" type="text" id="Adresse" name="Adresse" value="" size="20" max="20" />
                </div>
                </fieldset>
    
                <fieldset>
                    <legend> Boite Commande </legend>
                <input type="submit" value="Valider" class="btn btn-group-justified"/>
                <br>
                <input type="reset" value="Remettre à zéro" class="btn btn-group-justified"/> <br />
                </fieldset>
            </form>
            
         <% 
             if (request.getAttribute("editeur") !=null ){
             
            // if (request.getAttribute("message") != null ) {
                String msg = (String)request.getAttribute("message");
         %>
            <div class="alert alert-info" role="alert">
                <%= msg %>                    
            </div>  
            <% } %>
                
            <h2>  ${messageErr} </h2>       
             <br/>
            <h2>${message}</h2>
                
        </div>
        <footer class="container">         
         <footer class="container">         
            <div class="footer" class="container">
                <h3><a href="index.jsp" > Page D'acceuil </a> </h3>
                <h3><a href="AjouterEditeur" > Ajouter un editeur </a> </h3>
                <h3><a href="ListeEditeur" > Tous les editeurs  </a> </h3>
            </div>
        </footer>
        </footer>
        
        
    </body>
</html>