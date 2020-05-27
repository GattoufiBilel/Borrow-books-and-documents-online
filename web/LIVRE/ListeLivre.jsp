<%@page import="Beans.Adherent"%>
<%@page import="Beans.Livre"%>
<%@page import="Beans.Editeur"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <Title>Voir Les listes de livres </Title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link href="src/table_style.css" rel="stylesheet" type="text/css" />
        <link href="src/style2.css" rel="stylesheet" type="text/css" />
    </head>
    <body> 
        
        <%@include file="../Header.jsp" %>

   
     <div class="container">
        <div class="titre">
        <h2>Liste des Livres  </h2>
        </div>
        <br>
        <form role="search" name="searchform" method="get" action="ChercherLivre">
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
                <tr class="Trvue">
                    <th> Code Livre </th>
                    <th> Titre Livre </th>
                    <th> Prix Livre </th>
                    <th> Date achat </th>
                    <th> Editeur </th>
                    <% 
                        if (adh.getRole() == 1 ) {
                    %>
                    <th colspan="2"> Update / Delete  </th>
                    <%
                        }
                    %>
                    <th>Action</th>
                    <th> Etat de livre </th>
                    <th> Nombre exemplaire livre </th>
                </tr>
            </thead>
        <tbody>
         <%
        // declarer tableau de type List<Produit> 
        // remplir le tableau par le resultat introduit par request 
        List<Livre> listeLivre = (List<Livre>) request.getAttribute("livres");
            if(listeLivre.size()< 0 ) 
                { out.println("the liste is vide"); }
            else { 
            //parcouru la liste et affiche 
              for (Livre l : listeLivre) 
                { 
            %>
            <tr class="TrBody"> 
           <td> 
               <% out.println(l.getCodeLivre());  %> 
           </td>
           <td> 
               <% out.println(l.getTitre()); %> 
           </td>
           <td> 
               <% out.println(l.getPrix()); %> 
           </td>
           <td> 
               <% out.println(l.getDateAchat()); %> 
           </td>
           <td> 
               <% out.println(l.getNomEdit()); %> 
           </td>
           
        <% 
           if (adh.getRole() == 1 ) {
        %>
           
           
            <td> 
                <button class="btn btn-warning btn-lg  glyphicon glyphicon-edit" type="button" value="modifier" onclick="javascript:location.href='ModifierLivre?idlivr=<%= l.getCodeLivre() %>' ; "> Modifier </button>
           </td>
           
           <td> 
               <button class="btn btn-danger btn-lg  glyphicon glyphicon-trash"  type="button" value="delete" onclick="javascript:location.href='DeleteLivre?idlivr=<%= l.getCodeLivre() %>' ;  "> Supprimer </button>
           </td>
        <% 
           }
        %>
           <td> 
               <button class="btn btn-success btn-lg  glyphicon glyphicon-shopping-cart"  type="button" value="Emprunt" onclick="javascript:location.href='EmpruntLivre?idlivr=<%= l.getCodeLivre()%>&idUser=<%= adh.getMatricule() %> ' ;  "> Emprunt </button>
           </td>
           
           <td>  
               <% 
                if (l.getNombreCopie()<= 1  ) {
                    out.println("Nom disponible"); 
                %> 
                <label for="disponibilite" class="glyphicon glyphicon-remove-sign alert-danger "  ></label>
                <input id="disponibilite" name="disponibilite" type="checkbox" value="" checked="true" disabled="true">
                <%
                }
                else {
                    out.println("disponible"); 
                %> 
                <label for="disponibilite" class="glyphicon glyphicon-ok-sign alert-success"  ></label>
                <input id="disponibilite" name="disponibilite" type="checkbox" value="${l.getCodeLivre()}" >
                <%
                }
               %>

           </td>
           
           <td>
                <% out.println(l.getNombreCopie()); %> 
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
                        <button class="btn btn-lg btn-info glyphicon glyphicon-home" type="button" onclick="javascript:location.href='accueil.jsp';"> Accueille </button>
                    </th>
                    <% 
                    if (adh.getRole() == 1 ) {
                    %>
          
                    <th>	
                        <button class="btn btn-lg btn-info glyphicon glyphicon-plus" type="button" onclick="javascript:location.href='AjouterLivre';"> Plus </button>
                    </th>
                    <% 
                    }else { %>
                    <th>
                    <button class="btn btn-lg btn-info glyphicon glyphicon-plus" type="button" onclick="javascript:location.href='AjouterLivre';" disabled="TRUE"> Plus </button>
                    </th>
                    <% } %>

                </div>  
            </tfoot>
        </table>
     </div>
                    
     <hr> 
        <footer class="container"> 
           <%@include file="../Footer.jsp" %>
        </footer>
        
    </body>
</html>
