package ControllerEditeur;

import Beans.Editeur;
import ModelLivreEditeur.EditeurMetier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ChercherEditeur", urlPatterns = {"/ChercherEditeur"})
public class ChercherEditeur extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String mot = request.getParameter("trouver") ;
        EditeurMetier model = new EditeurMetier()  ; 
        Editeur monEdit = new Editeur() ; 
        String msg = null ; 
       
        if (model.getEditeur(mot) != null)  
        {
            msg = " Bien editeur trouver " ;
            request.setAttribute("monEdit", model.getEditeur(mot));
        }
        else {
            msg = mot + " le nom de cet editeur introuvable !  " ; 
        }
        
        request.setAttribute("message", msg);
        
        request.getRequestDispatcher("/EDITEUR/chercherEditeur.jsp").forward(request, response);
        
       
    }
 
}
