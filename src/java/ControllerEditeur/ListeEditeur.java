package ControllerEditeur;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.Editeur;
import ModelLivreEditeur.EditeurMetier;

@WebServlet(name = "ListeEditeur", urlPatterns = {"/ListeEditeur"})

public class ListeEditeur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        EditeurMetier modele = new EditeurMetier();
        ArrayList<Editeur> lst = modele.getAll(); 
        
        request.setAttribute("editors" , lst);

       request.getRequestDispatcher("/EDITEUR/ListeEditeur.jsp").forward(request, response);
       
    }

  
    
}
