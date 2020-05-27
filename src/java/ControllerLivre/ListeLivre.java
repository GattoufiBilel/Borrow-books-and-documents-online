package ControllerLivre;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.Livre;
import ModelLivreEditeur.LivreMetier;

@WebServlet(name = "ListeLivre", urlPatterns = {"/ListeLivre"})
public class ListeLivre extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        LivreMetier model = new LivreMetier(); 
       // request.setAttribute("livre", model.getLivre());
        ArrayList<Livre> listeL = model.getAll(); 
        
        
        
        request.setAttribute("livres" , listeL);

        request.getRequestDispatcher("/LIVRE/ListeLivre.jsp").forward(request, response);
         
    }


}
