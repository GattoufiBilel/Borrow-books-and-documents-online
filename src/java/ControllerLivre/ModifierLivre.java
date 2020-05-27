package ControllerLivre;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import ModelLivreEditeur.EditeurMetier;
import java.util.ArrayList;
import Beans.Editeur;
import ModelLivreEditeur.LivreMetier;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ModifierLivre", urlPatterns = {"/ModifierLivre"})
public class ModifierLivre extends HttpServlet {
    
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String code = (String) request.getParameter("idlivr");
        request.setAttribute("cd",code);

        EditeurMetier ed = new EditeurMetier();
        ArrayList<Editeur> lstEditeur = ed.getAll();
        request.setAttribute("editeurs", lstEditeur);
        request.getRequestDispatcher("/LIVRE/ModifierLivre.jsp").forward(request, response);

    }


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse respons)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
         if (request.getParameter("CodeLivre") != null) {
            
           
            String Titre = request.getParameter("TitreLivre");
            String prix =  request.getParameter("PrixLivre");
            String date =  request.getParameter("DateAchat");
            String nEditeur = request.getParameter("nomEdit");
            String idlivre =  request.getParameter("CodeLivre")   ;
            String msg;
            double PrixL = Double.parseDouble(prix); 
            int cdlivre = Integer.parseInt(idlivre) ; 
           
            
            LivreMetier model = new LivreMetier();
           // Livre l = new Livre(Titre,PrixL,date,nEditeur) ; 
           //model.getLivre().setCodeLivre(cdlivre);
            model.getLivre().setTitre(Titre);
            model.getLivre().setPrix(PrixL);
            model.getLivre().setDateAchat(date);
            model.getLivre().setNomEdit(nEditeur);

            msg = model.Modifier(cdlivre) ? "Livre modifier avec succes" :
                "Modification non effectué" ;   

            request.setAttribute("msgUpdate", msg);
          
            //request.getRequestDispatcher("/ListeLivre").forward(request, respons);
            //request.getRequestDispatcher("ListeLivre").forward(request, respons);   
            respons.sendRedirect("ListeLivre");

    }
    
}
}

    
