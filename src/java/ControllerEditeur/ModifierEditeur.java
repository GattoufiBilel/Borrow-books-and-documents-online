
package ControllerEditeur;

import ModelLivreEditeur.EditeurMetier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ModifierEditeur", urlPatterns = {"/ModifierEditeur"})
public class ModifierEditeur extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = (String) request.getParameter("idEdit");
        request.setAttribute("idedit",id);       
        request.getRequestDispatcher("/EDITEUR/ModifierEditeur.jsp").forward(request, response);
        
    }
    
    
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
       
         HttpSession session = request.getSession();
        
        if(request.getParameter("IdEditeur") != null) { 
            
            String idEdit = request.getParameter("IdEditeur") ; 
            String nom = request.getParameter("nomEditeur"); 
            String adr = request.getParameter("Adresse") ; 
            String msg ; 
           

            int id = Integer.parseInt(idEdit); 
            
            EditeurMetier model = new EditeurMetier() ;
            model.getEditeur().setNomEditeur(nom);
            model.getEditeur().setAdresse(adr);

            msg = model.modifier(id)  ? " editeur bien modifier " : 
                      "editeur exist deja" ; 
            
            
            request.setAttribute("editeur", model.getEditeur());
            //request.setAttribute("editors", model.getAll());
            request.setAttribute("message", msg);
          
           
            request.getRequestDispatcher("/EDITEUR/ModifierEditeur.jsp").forward(request, resp);
        }
    }   
    

    
  
    
}
