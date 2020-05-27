<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Beans.Editeur"%>
<%@page import="ControllerEditeur.AjouterEditeur"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--  bootstrap css -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!--  bootstrap js -->
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <!-- style css -->
        <link href="src/style2.css" rel="stylesheet" type="text/css" />
        <title>Ajouter Nouveau Livre</title>
    </head>
    <body>
         <%@include file="../Header.jsp" %>
         <hr>
        <div class="container">
            <div class="titre">
                <h2>  Ajouter Nouveau Livre  </h2>
            </div>
            <form method="POST" action="AjouterLivre">
                <fieldset>
                    <legend>Informations Livre</legend>
                    <div class="form-group">
                        <label for="codeLivre">Code Livre <span class="requis">*</span></label>
                        <input class="form-control"  type="text" id="codeLivre" name="CodeLivre" value="" size="20" maxlength="20"/>
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
                                
                <div class="form-check">
                    <label class="disponibilite-label" for="disponibilite">Disponibilé : </label>
                    <input type="checkbox" class="form-check-input" id="disponibilite" name="disponibilite">
                </div>    
                                
                <div class="form-group form-inline">
                      <label for="nbrCopie">Nombre d'exemplaire livre  :</label>
                      <select class="form-control" id="nbrCopie" name="nbrCopie" style="width:150px;">
                            <option selected="">choisie nombre </option>
                        <%
                          for(int i=0; i<=100 ; i++) {
                        %>
                        <option> <%= i  %> </option> 
                             <% } %>
                        </select>               
                    </div>
            </div>           

                </fieldset>
                <div class="container">
                    <fieldset>
                        <legend> Boite Commande </legend>
                        <input type="submit" value="Valider" class="btn btn-group-justified"/>
                        <br>
                        <input type="reset" value="Remettre à zéro" class="btn btn-group-justified"/> <br />
                    </fieldset>
                </div>   
            </form>
                                
            <% if (request.getAttribute("message") != null) {
                String msg = (String)request.getAttribute("msgUpdate");
            %>

            <% }   %>

       
           
        <footer class="container">         
            
                <h3><a href="accueil.jsp" > Page D'acceuil </a> </h3>
                <h3><a href="AjouterLivre" > Ajouter un Livre </a> </h3>
                <h3><a href="ListeLivre" > Liste des Livre </a> </h3>
                <%@include file="../Footer.jsp" %>   
           
        </footer>
    </body>
</html>