<%@page import="Beans.Emprunt"%>
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
        <h2>Liste des Livres Emprunté  </h2>
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
                    <th> Code Emprunt </th>
                    <th> Code Livre </th>
                    <th> Titre </th>
                    <th> Editeur </th>
                    <th> Code adherent </th>
                    <th> Date Emprunte </th>
                    <th> Date de retour</th>
                    <th> Action </th>
                </tr>
            </thead>
            
            
            
            
            <tbody>
         <%
        // declarer tableau de type List<Produit> 
        // remplir le tableau par le resultat introduit par request 
        List<Livre> listeLivreEmprunte = (List<Livre>) request.getAttribute("Livreemprunte");
            if(listeLivreEmprunte.size()< 0 ) 
                { out.println("the liste is vide"); }
            else { 
            //parcouru la liste et affiche 
              for (Livre emp : listeLivreEmprunte) 
                { 
            %>
            <tr class="TrBody"> 
           <td> 
               <% out.println("1");  %> 
           </td>
           <td> 
               <% out.println(emp.getCodeLivre()); %> 
           </td>
           <td> 
               <% out.println(emp.getTitre()); %> 
           </td>
           <td> 
               <% out.println(emp.getNomEdit()); %> 
           </td>
           <td> 
               <% out.println(adh.getNom()); %> 
           </td>
           
           <td> 
               
           </td>
           
           <td> 
               
           </td>
           <td> 
               
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
                        <button class="btn btn-lg btn-info glyphicon glyphicon-plus" type="button" onclick="javascript:location.href='ListeLivre';"> Liste des tous livres </button>
                    </th>
                    <% 
                    } %>


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
                    
                    
                    
    </body>
</html>
