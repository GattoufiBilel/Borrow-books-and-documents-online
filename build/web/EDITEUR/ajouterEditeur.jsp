<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="ControllerEditeur.AjouterEditeur"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!--  bootstrap js -->
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <title>Ajouter Editeur</title>
    </head>
    <body>
        <div class="container-fluid">
            <h2> Ajout Editeur </h2>
        </div>
        <div class="container">
            
            <form method="POST" action="../AjouterEditeur">
                <fieldset>
                <legend>Informations Editeur</legend>
                <div class="form-group">
                    <label for="IdEditeur">Id editeur <span class="requis">*</span></label>
                    <input class="form-control" type="text" id="IdEditeur" name="IdEditeur" value="" size="20" maxlength="20"/>
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
            
            <h2> ${message} </h2>
               
        </div>       
         <footer class="container">         
            <div class="footer" class="container">
                <h3><a href="../accueil.jsp" > Page D'acceuil </a> </h3>
                <h3><a href="ajouterEditeur.jsp" > Ajouter un editeur </a> </h3>
                <h3><a href="../ListeEditeur" > Tous les editeurs  </a> </h3>
                <hr/>
                <%@include file="../Footer.jsp" %>
                
            </div>
        </footer>
  
    </body>
</html>