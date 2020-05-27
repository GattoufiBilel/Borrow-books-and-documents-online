package ControllerAdherent;

import Beans.Adherent;
import DaoAdherent.AdherentDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServletSeConnect", urlPatterns = {"/ServletSeConnect"})
public class ServletSeConnect extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String mail = request.getParameter("email") ; 
        String passe = request.getParameter("pwd"); 
        String msg = null ;
        String username = null ; 
        
        if ((mail.trim().isEmpty())   ||   (passe.trim().isEmpty()) )  {
            
            msg = "les chaamps is vide  <a href=\"ADHERENT/Connecter.jsp\" />  " ; 
            request.setAttribute("msgUpdate", msg);
            this.getServletContext().getRequestDispatcher("/ADHERENT/Connecter.jsp").forward(request, response); 
            
        }
        else {    

            AdherentDao model = new AdherentDao() ; 
            Adherent adherent  = new  Adherent() ; 
            
            if (model.Chercher(mail, passe) != null ) { 
                adherent = model.Chercher(mail, passe) ;
                msg = "bienvenue " ; 
                request.setAttribute("msgUpdate", msg);
                request.setAttribute("adherents", adherent);
                session.setAttribute("user", adherent );
                request.getRequestDispatcher("/accueil.jsp").forward(request, response);
            }
            else 
            {
             msg = "login or mot passe incorrect ";  
             request.setAttribute("msgUpdate", msg);
             this.getServletContext().getRequestDispatcher("/ADHERENT/Connecter.jsp").forward(request, response); 
             //response.sendRedirect("ADHERENT/Connecter.jsp");
             
            }
        }
     }
            
        
       
}

