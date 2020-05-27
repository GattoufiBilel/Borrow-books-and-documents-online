
package ControllerLivre;

import ModelLivreEditeur.LivreMetier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteLivre", urlPatterns = {"/DeleteLivre"})
public class DeleteLivre extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       String cd = request.getParameter("idlivr"); 
       String msg ; 
       int id = Integer.parseInt(cd); 
       
        LivreMetier del = new LivreMetier(); 
        msg = del.Supprimer(id)? " bien livre supprimer "  :
                " livre non supprimer  ";
        
        request.setAttribute("msgUpdate", msg);
        
        request.getRequestDispatcher("/ListeLivre").forward(request, response);
    }

}
