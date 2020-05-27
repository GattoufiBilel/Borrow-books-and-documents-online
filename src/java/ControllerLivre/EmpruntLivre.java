package ControllerLivre;

import Beans.Livre;
import ModelLivreEditeur.LivreMetier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmpruntLivre", urlPatterns = {"/EmpruntLivre"})
public class EmpruntLivre extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
         String cd = request.getParameter("idlivr"); 
         String cduser = request.getParameter("idUser"); 
         String msg = null ; 
         int id = Integer.parseInt(cd); 
         int idadh = Integer.parseInt(cduser); 
         
        LivreMetier mode = new LivreMetier(); 
        Livre Monlivre  = new Livre() ; 
        Monlivre = mode.getLivre(id); 
        int n = Monlivre.getNombreCopie(); 
        
     
        if(Monlivre.getNombreCopie() > 1 ) {

               msg = mode.EditerNombreCopie(id) ? Monlivre.getTitre()+ " livre emprunter avec succes " :
                   "non disponible pour l'instant "; 
            }
             else if(Monlivre.getNombreCopie() <= 1 ){
               msg = mode.DisponibiliteFalse(id) ? " c'est une copier original " :
                        "erreur" ; 
            }
           
        request.setAttribute("msgUpdate", msg);
        request.setAttribute("codeliv", id);
        request.setAttribute("iduser", idadh);
        
        request.getRequestDispatcher("/ListeLivre").forward(request, response);
        //response.sendRedirect("ListeLivre");
    }

    
}
