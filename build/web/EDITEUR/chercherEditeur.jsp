<%@page import="Beans.Livre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <!--  bootstrap css -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" >
          <!--  Css -->
        <link href="../src/table_style.css" rel="stylesheet" type="text/css" />
        <link href="src/table_style.css" rel="stylesheet" type="text/css" />
            <!--  bootstrap js -->
        <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <title>Chercher dans votre Biblio</title>
    </head>
    <body>
        <div class="container"> 
            <h1>Trouver un Editeur ! <span class="glyphicon glyphicon-search"></span> </h1>
        <form role="search" name="searchform" method="get" action="${pageContext.request.contextPath}/ChercherEditeur">
            <div class="form-group">
                <div class="input-group">
                    <input type="text" placeholder="recherche" name="trouver" class="form-control left-rounded input-lg">
                    <div class="input-group-btn">
                        <button type="submit" class="btn btn-inverse right-rounded btn-lg">Chercher</button>
                    </div>
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
                        <th>Matricule </th>
                        <th>Nom  </th>
                        <th>Adresse </th>
                        <th>Liste livre </th>
                        <th>Action</th>   
                    </tr>
                    
                    <tr class="TrBody">
                        <td>
                            ${monEdit.idEditeur}
                        </td>
                        <td>
                            ${monEdit.nomEditeur}
                        </td>
                        <td>
                           ${monEdit.adresse}
                        </td>

                    </tr>
                    
                    <tr>
                        <th>
                            <button class="btn btn-lg btn-info glyphicon glyphicon-home" type="button" onclick="javascript:location.href='/LaBibliotheque/index.jsp';"> Accueille </button>
                        </th>
                        <th>	
                            <button class="btn btn-lg btn-info glyphicon glyphicon-plus" type="button" onclick="javascript:location.href='/LaBibliotheque/backend/accueil.jsp';"> acc </button>
                        </th>
                    </tr>
                </table>
                        
                <hr/>
            </h4>               

</div>
        
    </body>
</html>
