package ControllerAdherent;

import ModelAdherentEmprunt.AdherentMetier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteAdherent", urlPatterns = {"/DeleteAdherent"})
public class DeleteAdherent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String mat = request.getParameter("matric"); 
        String msg ; 
        int id = Integer.parseInt(mat); 
       
        AdherentMetier del = new AdherentMetier(); 
        msg = del.Supprimer(id)? " bien adherent supprimer "  :
                "non supprimer ";
        
        request.setAttribute("message", msg);
        
        request.getRequestDispatcher("/ListeAdherent").forward(request, response);
    }
       
    }

  
