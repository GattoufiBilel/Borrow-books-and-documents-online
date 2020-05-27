package ControllerAdherent;


import Beans.Editeur;
import Beans.Site;
import ModelAdherentEmprunt.AdherentMetier;
import ModelAdherentEmprunt.SiteMetier;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InscriptionAdherent extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
    
            SiteMetier mod = new SiteMetier() ;    
            ArrayList<Site>  lstSite = mod.Tous() ; 
            request.setAttribute("lesSites", lstSite);
            request.getRequestDispatcher("/ADHERENT/inscription.jsp").forward(request, resp);
            
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {

     if    (request.getParameter("matriculeAdherent") != null) {
            String mat = request.getParameter("matriculeAdherent");
            String nom = request.getParameter("nomAdherent");
            String prenom = request.getParameter("prenomAdherent");
            String g = request.getParameter("age") ; 
            String adresse = request.getParameter("adresseAdherent");
            String mail = request.getParameter("Email");
            String passe = request.getParameter("Password") ; 
            
            int role ; 
            if(request.getParameter("roles") != null ) {
                    role = 1 ; 
            }
            else {  role = 0 ; }
            

           
            String msg; 
            
            int matricule = Integer.parseInt(mat) ;
            int age = Integer.parseInt(g); 
            
            
            AdherentMetier model = new AdherentMetier() ; 
            model.getAdherent().setMatricule(matricule);
            model.getAdherent().setNom(nom);
            model.getAdherent().setPrenom(prenom);
            model.getAdherent().setAge(age);
            model.getAdherent().setAdresse(adresse);
            model.getAdherent().setEmail(mail);
            model.getAdherent().setPassword(passe); 
            model.getAdherent().setRole(role);
            
            
            msg = model.Ajouter() ? "Adherent ajouter avec succes  "+ model.getAdherent().getNom() +  model.getAdherent().getPrenom()  :
                "Aucun Adherent a ete ajoute  "; 
            
            request.setAttribute("msgUpdate", msg);
            request.getRequestDispatcher("/ADHERENT/Connecter.jsp").forward(request, resp);
            
     }
   
    }

}
