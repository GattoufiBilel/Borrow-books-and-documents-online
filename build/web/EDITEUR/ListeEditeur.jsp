<%@page import="Beans.Editeur"%>
<%@page import="Beans.Livre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title> Liste de Nos Editeurs </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link href="src/table_style.css" rel="stylesheet" type="text/css" />
        <link href="src/style2.css" rel="stylesheet" type="text/css" />
    </head>
    <body>  
        <%@include file="../Header.jsp" %>
        
     <div class="container">
         <div class="titre" >
            <h2> Liste Editeurs  </h2>
         </div>
        <br>
            <form role="search" name="searchform" method="get" action="ChercherEditeur">
            <div class="form-group">
                <div class="input-group">
                    <input type="text" placeholder="recherche" name="trouver" class="form-control left-rounded input-lg">
                    <div class="input-group-btn">
                        <button type="submit" class="btn btn-inverse right-rounded btn-lg">Chercher</button>
                    </div>
                </div>
            </div>
        </form> 
        
        <table class="tabvue">
            <thead class="thvue"> 
                <tr> 
                    <th> Id Editeur </th>
                    <th> Nom Editeur </th>
                    <th> Adresse </th>
                    <% 
                        if (adh.getRole() == 1 ) {
                    %>
                    <th colspan="2"> Update / Delete </th>
                    <% } %>
                    <th> Action </th>
                </tr>
            </thead>
            <tbody>
         <%
        // declarer tableau de type List<Produit> 
        // remplir le tableau par le resultat introduit par request 
        List<Editeur> listeediteur = (List<Editeur>) request.getAttribute("editors");
            if(listeediteur.size()< 0 ) 
             
                { out.println("the liste is vide"); }
            else { 
            //parcouru la liste et affiche 
              for (Editeur e : listeediteur) 
                { 
            %>
           <tr class="TrBody"> 
           <td> 
               <% out.println(e.getIdEditeur());  %> 
           </td>
           <td> 
               <% out.println(e.getNomEditeur()); %> 
           </td>
           <td> 
               <% out.println(e.getAdresse()); %> 
           </td>
            <% 
               if (adh.getRole() == 1 ) {
            %>
           <td> 
                <button type="button" value="modifier" onclick="javascript:location.href='ModifierEditeur?idEdit=<%= e.getIdEditeur() %>' ; "> Modifier </button>
           </td>
           
            <td> 
               <button type="button" value="delete" onclick="javascript:location.href='DeleteEditeur?idEdit=<%= e.getIdEditeur() %>' ;  "> Supprimer </button>
           </td>
           <% } %>
           
           <td>
               <input type="radio" name="r1" value="${e.getIdEditeur()}"
           </td> 
           </tr>
             <%
                }  
            }
               
              %>
            </tbody>
            
            <tfoot class="tfvue">
                <div class="footer">
                      <th>
                        <button class="btn btn-danger glyphicon glyphicon-home" type="button" onclick="javascript:location.href='accueil.jsp';"> Accueille </button>
                    </th>
                    <% 
                        if (adh.getRole() == 1 ) {
                    %>
                    <th>	
                        <button class="btn btn-danger glyphicon glyphicon-plus" type="button" onclick="javascript:location.href='EDITEUR/ajouterEditeur.jsp';"> Plus </button>
                    </th>
                    <% } else { %> 
                     <th>	
                         <button class="btn btn-danger glyphicon glyphicon-plus" disabled="true" type="button" onclick="javascript:location.href='EDITEUR/ajouterEditeur.jsp';"> Plus </button>
                    </th>
                    <% } %>
                </div>  
            </tfoot>
        </table>
            
            <% 
                if (request.getAttribute("message") != null) {
                String msg = (String)request.getAttribute("message");
            %>
            <div class="alert alert-info" role="alert">
                <%= msg %>                    
            </div>  
           <% }   %> 
            
            <div class="container">
            <% 
                   if (adh.getRole() == 1 ) {
            %>
                <h3><a href="EDITEUR/ajouterEditeur.jsp" > Ajouter un editeur </a> </h3>
            <% } %>
                <h3><a href="ListeEditeur" > Tous les editeurs  </a> </h3>
            <hr/>
                <%@include file="../Footer.jsp" %>   
            </div>
            
     </div>    
     
    </body>
</html>
