<%@page import="Beans.Site"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.Adherent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inscription </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" >
          <!--  Css -->
        <link href="../src/table_style.css" rel="stylesheet" type="text/css" />
        <link href="src/table_style.css" rel="stylesheet" type="text/css" />
            <!--  bootstrap js -->
        <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <title>Inscription Adherent</title>
    </head>
    <body>

        <div class="container-fluid">
            <h2> Inscription Adherent </h2>
        </div>
        <div class="container">
            <form method="POST" action="${pageContext.request.contextPath}/InscriptionAdherent">
                <fieldset>
                    <legend>Informations Adherent</legend>

                    <div class="form-group">
                        <label for="matricule">Nummero inscription <span class="requis">*</span></label>
                        <input class="form-control"  type="text" id="matricule" name="matriculeAdherent" value="" size="20" maxlength="20"/>
                    </div>
                    <div class="form-group">   
                        <label for="nomAdherent">Nom Adherent </label>
                        <input class="form-control" type="text" id="nomAdherent" name="nomAdherent" value="" size="20" maxlength="20" />
                    </div>

                    <div class="form-group">
                        <label for="prenomAdherent">Prenom Adherent </label>
                        <input class="form-control" type="text" id="prenomAdherent" name="prenomAdherent" value="" size="20" max="20" />
                    </div>
                    
                    <div class="form-group">

                      <label for="age">Votre Age :</label>
                        <select class="form-control" id="age" name="age"> 

                            <option selected="">choisie votre age </option>
                                                    <%
                            for(int i=6; i<=100 ; i++) {
                        %>
                        <option> <%= i  %> </option> 
                             <% } %>
                        </select>               
                    </div>
                        
                    <div class="form-group">
                        <label for="adresseAdherent">Select list adresse:</label>
                        <select class="form-control" id="adresseAdherent" name="adresseAdherent">  
                            <option selected="">choisie une site </option>

                            <% if (request.getAttribute("lesSites") != null) {

                                    ArrayList<Site> list = (ArrayList<Site>) request.getAttribute("lesSites");
                                    for (Site s : list) {%>       
                            <option value="<%= s.getAdresse() %>"> <%= s.getAdresse() %> </option>

                            <%}
                                }%>
                        </select>                        
                    </div>    
                        
<!--                    <div class="form-group">
                        <label for="adresseAdherent">Adresse postale </label>
                        <input class="form-control" type="text" id="adresseAdherent" name="adresseAdherent" value="" size="20" max="20" />
                    </div>-->
    
                    <div class="form-group">
                        <label for="Email">Email </label>
                        <input class="form-control" type="email" id="Email" name="Email" value="" size="20" max="20" />
                    </div>
                    <div class="form-group">
                        <label for="Password"> Mot de Passe </label>
                        <input class="form-control" type="password" id="Password" name="Password" value="" size="20" max="20" />
                    </div>

                      <div class="form-check">
                          <label class="form-check-label" for="role">Administrateur</label>
                          <input type="checkbox" class="form-check-input" id="roles" name="roles">
                      </div>
<!--                    <div class="form-group">
                        <label for="Pass_word"> Confirme Mot de Passe </label>
                        <input class="form-control" type="password" id="Pass_word" name="Pass_word" value="" size="20" max="20" />
                    </div>-->

                </fieldset>


                <fieldset>
                    <legend> Boite Commande </legend>
                    <input type="submit" value="S'inscrire" class="btn btn-group-justified"/>
                    <br>
                    <input type="reset" value="Remettre à zéro" class="btn btn-group-justified"/> <br />
                </fieldset>
            </form>
                        
        </div>  
        <hr/>
        <div class="alert-success">
            ${message}
        </div>

        <div class="container">     
        <h3><a href="ADHERENT/Connecter.jsp" > Se Connecter </a> </h3>

        <hr/>
        <%@include file="../Footer.jsp" %>   
    </div>   
                           
    </body>
</html>
                       
