
package ControllerEditeur;

import ModelLivreEditeur.EditeurMetier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DeleteEditeur", urlPatterns = {"/DeleteEditeur"})
public class DeleteEditeur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cd = request.getParameter("idEdit") ; 
        String msg ; 
        int id = Integer.parseInt(cd) ; 
        
        EditeurMetier deleEdit = new EditeurMetier();
        msg = deleEdit.supprimer(id) ? " editeur supprimer avec success" : 
                " editeur non supprimer " ; 
        
        request.setAttribute("message", msg);
        request.getRequestDispatcher("/ListeEditeur").forward(request, response);
    }

    
    
}
