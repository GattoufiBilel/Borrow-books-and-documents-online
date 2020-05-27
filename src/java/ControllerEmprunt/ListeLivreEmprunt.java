
package ControllerEmprunt;

import Beans.Emprunt;
import ModelEmprunt.EmpruntMetier;
import ModelLivreEditeur.LivreMetier;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListeLivreEmprunt", urlPatterns = {"/ListeLivreEmprunt"})
public class ListeLivreEmprunt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList listelivre = new ArrayList() ; 
        LivreMetier modellivre = new LivreMetier() ; 
        
            listelivre = modellivre.getLivreEmprunte(); 


            request.setAttribute("Livreemprunte" , listelivre);

            request.getRequestDispatcher("/EMPRUNT/ListeLivreEmprunte.jsp").forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }


}
