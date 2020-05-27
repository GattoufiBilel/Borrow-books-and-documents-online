<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Beans.Editeur"%>
<%@page import="ControllerEditeur.AjouterEditeur"%>


<% 
         String  c = (String) request.getAttribute("cd"); 
         int id = Integer.parseInt(c);            
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <title>Modifier Livre</title>
    </head>
    <body>

        <div class="container-fluid">
            <h2> Modifier Livre </h2>
        </div>
        <div class="container">
            
            ${msgUpdate}

            <form method="POST" action="ModifierLivre">
                <fieldset>
                    <legend>Informations Livre Modifier</legend>
                    <div class="form-group">
                        <label for="codeLivre">Code Livre <span class="requis">*</span></label>
                            <input class="form-control" type="text" id="CodeLivre" name="CodeLivre" value ="<%= id %>" size="20" maxlength="20"/>
                    </div>
                    <div class="form-group">   
                        <label for="TitreLivre">Titre Livre </label>
                        <input class="form-control" type="text" id="TitreLivre" name="TitreLivre" value="" size="20" maxlength="20" />
                    </div>

                    <div class="form-group">
                        <label for="PrixLivre">Prix Livre </label>
                        <input class="form-control" type="text" id="PrixLivre" name="PrixLivre" value="" size="20" max="20" />
                    </div>

                    <div class="form-group">
                        <label for="DateAchat">Date Achat Livre </label>
                        <input class="form-control" type="date" id="DateAchat" name="DateAchat" value="" size="20" max="20" />
                    </div>



                    <div class="form-group">

                        <label for="nomEdit">Select Categorie list:</label>
                        <select class="form-control" id="nomEdit" name="nomEdit">  
                            <option selected="">choisie un editeur </option>

                            <% if (request.getAttribute("editeurs") != null) {

                                    ArrayList<Editeur> list = (ArrayList<Editeur>) request.getAttribute("editeurs");
                                    for (Editeur e : list) {%>       
                            <option value="<%= e.getNomEditeur()%>"> <%= e.getNomEditeur()%> </option>

                            <%}
                                }%>


                        </select>                        
                    </div>




                </fieldset>


                <fieldset>
                    <legend> Boite Commande </legend>
                    <input type="submit" value="Valider" class="btn btn-group-justified"/>
                    <br>
                    <input type="reset" value="Remettre à zéro" class="btn btn-group-justified"/> <br />
                </fieldset>
            </form>                         
        </div>
            
        <footer class="container">         
            <div class="footer" class="container">
                <h3><a href="index.jsp" > Page D'acceuil </a> </h3>
                <h3><a href="ListeLivre" > Liste des Livre </a> </h3>
                <%@include file="../Footer.jsp" %>
            </div>
            </footer>
    </body>
</html>