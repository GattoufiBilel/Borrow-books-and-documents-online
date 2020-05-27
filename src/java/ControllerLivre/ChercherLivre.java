
package ControllerLivre;

import Beans.Livre;
import ModelLivreEditeur.LivreMetier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ChercherLivre", urlPatterns = {"/ChercherLivre"})
public class ChercherLivre extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                
        String mot = request.getParameter("trouver") ;
        LivreMetier model = new LivreMetier()  ; 
        Livre monLivre = new Livre() ; 
        String msg = null ; 
       
        if (model.getLivre(mot) != null)  
        {
            msg = " Bien Livre trouver " ;
            request.setAttribute("monLivre", model.getLivre(mot));
        }
        else {
            msg =  mot  + "  c'est Livre non trouver   " ; 
        }
        
        request.setAttribute("message", msg);
        
        request.getRequestDispatcher("/LIVRE/chercherLivre.jsp").forward(request, response);
        
    }
        
}

  
