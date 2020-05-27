
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deconnexion</title>
    </head>
    <body>
        </hr>
        <% 
            String msgupdate = (String) request.getAttribute("msgUpdate") ; 
            if ( msgupdate != null)  {
        %>
        <div class="alert alert-info" role="alert">
            ${msg}
            ${msgUpdate} 
        </div>
        <% } %>
        <div class="btn-group-lg">    
            <a class="btn btn-danger btn-lg btn-block glyphicon glyphicon-log-out" href="${pageContext.request.contextPath}/ServletDeconnexion" role="button">  Deconnexion </a>
        </div>
    </body>
</html>
