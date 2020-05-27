
package ControllerAdherent;

import Beans.Adherent;
import ModelAdherentEmprunt.AdherentMetier;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListeAdherent", urlPatterns = {"/ListeAdherent"})
public class ListeAdherent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        AdherentMetier model = new AdherentMetier(); 
        //request.setAttribute("adherent", model.getAdherent();
        ArrayList<Adherent> lstAdherent = model.getAll(); 
        request.setAttribute("adherents" , lstAdherent);
        
        request.getRequestDispatcher("/ADHERENT/ListeAdherent.jsp").forward(request, response);
    }
        
    
}
   
