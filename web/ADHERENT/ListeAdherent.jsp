<%@page import="Beans.Adherent"%>
<%@page import="Beans.Site"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title> Liste des adherents </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link href="src/table_style.css" rel="stylesheet" type="text/css" />
    </head>
    <body> 
        
     <div class="container-fluid"> 
       
        <h3> Gestion Bibliotheque  <br> 
           <hr>
        </h3>
     </div>
     <div class="container">
        <h2>Les Adherents : </h2>
        <br>
        <table class="tabvue">
            <thead  class="thvue"> 
                <tr>
                    <th> Matricule </th>
                    <th> Nom </th>
                    <th> Prenom </th>
                    <th> Adresse </th>
                    <th> email </th>
                    <th> mot passe </th>
                    <th colspan="2" > Update / Delete </th>
                    <th> Role </th>
                </tr>
            </thead>
            <tbody>
         <%
        // declarer tableau de type List<Produit> 
        // remplir le tableau par le resultat introduit par request 
        List<Adherent> listeAdherent = (List<Adherent>) request.getAttribute("adherents");
            if(listeAdherent.size()< 0 ) 
                { out.println("the liste is vide"); }
            else { 
            //parcouru la liste et affiche 
              for (Adherent a : listeAdherent) 
                { 
            %>
           <tr class="TrBody"> 
           <td> 
               <% out.println(a.getMatricule());  %> 
           </td>
           <td> 
               <% out.println(a.getNom()); %> 
           </td>
           <td> 
               <% out.println(a.getPrenom()); %> 
           </td>
           <td> 
               <% out.println(a.getAdresse()); %> 
           </td>
           <td> 
               <% out.println(a.getEmail()); %> 
           </td>
            <td> 
               <% out.println(a.getPassword()); %> 
           </td>
           <td> 
               <button type="button" value="delete" onclick="javascript:location.href='DeleteAdherent?matric=<%= a.getMatricule() %>' ;  "> Supprimer </button>
           </td>
           <td>
               <button type="button" value="modifier" onclick="javascript:location.href='ModifierLivre?matric=<%= a.getMatricule() %>' ; "> Modifier </button>
           </td>
           <td>
               <% if (a.getRole()==1) {
               out.println("admin");  
                }
                else{ out.println("user"); 
                } 
               %>
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
                    <th>	
                        <button class="btn btn-danger glyphicon glyphicon-plus" type="button" onclick="javascript:location.href='AjouterAdherent';"> Plus </button>
                    </th>
                    <th>

                    </th>
                </div>  
            </tfoot>
        </table>
            
     </div>  
        <hr/>
        <div class="container">
                <h3><a href="accueil.jsp" > Page D'acceuil </a> </h3>
                <h3><a href="AjouterAdherent" > Ajouter un Adherent </a> </h3>
                <h3><a href="ListeAdherent" > Tous les Adherents  </a> </h3>
            <hr/>
                <%@include file="../Footer.jsp" %>   
        </div>    
           
    </body>
</html>
