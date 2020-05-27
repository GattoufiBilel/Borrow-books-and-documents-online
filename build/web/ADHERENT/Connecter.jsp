
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
            <!--  bootstrap js -->
        <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

        <title>SeConnecter</title>
    </head>
    <body>
        <h1> Se Connecter </h1>
        <div class="container">
            <form action="${pageContext.request.contextPath}/ServletSeConnect" method="GET">
              <fieldset>
                <legend> information connexion :</legend>
                    <div class="form-group">
                      <label for="email">Email address:</label>
                      <input type="email" class="form-control" id="email" name="email" placeholder="ex:em@il">
                    </div>
                    <div class="form-group">
                      <label for="pwd">Password:</label>
                      <input type="password" class="form-control" id="pwd" name="pwd">
                    </div>
                    <div class="checkbox">
                      <label><input type="checkbox"> Remember me</label>
                    </div>
                    <button type="submit" class="btn btn-default">Se connecter</button> 
              </fieldset>
            </form>
            <hr>
            <% 
                String msgupdate = (String) request.getAttribute("msgUpdate") ; 
                if ( msgupdate != null)  {
            %>
            <div class="alert alert-info" >
                ${msgUpdate} 
            </div>
            <%   } %>
            
          
        </div>
            
       
      
        
            
    </body>
</html>
