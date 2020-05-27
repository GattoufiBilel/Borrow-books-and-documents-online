<%@page import="Beans.Livre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" >
          <!--  Css -->
        <link href="../src/table_style.css" rel="stylesheet" type="text/css" />
        <link href="src/table_style.css" rel="stylesheet" type="text/css" />
        <link href="src/style2.css" rel="stylesheet" type="text/css" />
            <!--  bootstrap js -->
        <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <title>Chercher dans votre Biblio</title>
    </head>
    <body>
        
      <%@include file="../Header.jsp" %>
        
        <div class="container"> 
            <div class="titre">
            <h1>Chercher Votre Livre ! <span class="glyphicon glyphicon-search"></span> </h1>
            </div>
            <form action="${pageContext.request.contextPath}/ChercherLivre" method="get">
                
                <div class="form-group">
                    <div class="input-group input-group-lg icon-addon addon-lg">
                        <input type="text" placeholder="Texte" name="trouver" id="schbox" class="form-control input-lg">
                        <i class="icon icon-search"></i>
                        <span class="input-group-btn">
                            <button type="submit" class="btn btn-inverse btn-lg right-rounded">Rechercher</button>
                        </span>
                    </div>
                </div>
 
            </form>
                <br/>
                <hr/>
            
        <div class="container">
            <h2> Notification :   ${message} </h2> 
            <br/>
            
            <h4>
                <table  class="tabRech">
                    <tr class="TrRech">
                        <th>Code Livre </th>
                        <th>Titre Livre </th>
                        <th>Prix Livre </th>
                        <th>Date Achat </th>
                        <th>editeur</th>
                        <th>Eta de Livre </th>
                        <th>Nombre Exemplaire</th>
                    </tr>
                    
                    <tr class="TrBody">
                        <td>
                            ${monLivre.codeLivre}
                        </td>
                        <td>
                            ${monLivre.titre}
                        </td>
                        <td>
                           ${monLivre.prix}
                        </td>
                        <td>
                            ${monLivre.dateAchat}
                        </td>
                        <td>
                            ${monLivre.nomEdit}
                        </td>
                        <td>
                            ${monLivre.disponibilite}
                        </td>
                        <td>
                            ${monLivre.nombreCopie}
                        </td>
                    </tr>
                    
                    <tr>
                        <th>
                            <button class="btn btn-lg btn-info glyphicon glyphicon-home" type="button" onclick="javascript:location.href='/LaBibliotheque/accueil.jsp';"> Accueille </button>
                        </th>
                        <th>	
                            <button class="btn btn-success btn-lg  glyphicon glyphicon-shopping-cart"  type="button" value="Emprunt" onclick="javascript:location.href='EmpruntLivre?idlivr=${monLivre.codeLivre} ' ;  "> Emprunt </button>
                        </th>
                    </tr>
                </table>
                        
                <hr/>
                <p> <i>pour tester </i> </p> 
                code livre : ${monLivre.codeLivre}
                <br/>
                tite : ${monLivre.titre}
                <br/>
                prix : ${monLivre.prix}
                <br/>
                date achat : ${monLivre.dateAchat}
                <br/>
                editeur : ${monLivre.nomEdit}
            </h4>
                
                        

</div>
          
</body>
</html>
