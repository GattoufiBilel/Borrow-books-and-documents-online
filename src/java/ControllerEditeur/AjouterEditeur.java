package ControllerEditeur;

import ModelLivreEditeur.EditeurMetier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AjouterEditeur extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("IdEditeur") != null) { 
            String idEdit = request.getParameter("IdEditeur") ; 
            String nom = request.getParameter("nomEditeur"); 
            String adr = request.getParameter("Adresse") ; 
            String msg ; 
           

            int id = Integer.parseInt(idEdit); 
            
            EditeurMetier model = new EditeurMetier() ;
            model.getEditeur().setIdEditeur(id);
            model.getEditeur().setNomEditeur(nom);
            model.getEditeur().setAdresse(adr);


            msg = model.ajouter() ? " editeur ajouter avec succees" :
                    "Err editor exist deja"  ; 
            
            
            request.setAttribute("editeur", model.getEditeur());
            //request.setAttribute("editors", model.getAll());
            request.setAttribute("message", msg);
            request.getRequestDispatcher("/EDITEUR/ajouterEditeur.jsp").forward(request, response);
        }
    }   
}
       

    
