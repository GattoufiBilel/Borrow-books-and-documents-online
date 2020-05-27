package ControllerLivre;

import Beans.Editeur;
import ModelLivreEditeur.EditeurMetier;
import ModelLivreEditeur.LivreMetier;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

public class AjouterLivre extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        EditeurMetier ed = new EditeurMetier();
        ArrayList<Editeur> lstEditeur = ed.getAll();
        request.setAttribute("editeurs", lstEditeur);
        request.getRequestDispatcher("/LIVRE/ajouterLivre.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        if (request.getParameter("CodeLivre") != null) {
            String code = request.getParameter("CodeLivre");
            String Titre = request.getParameter("TitreLivre");
            String prix = request.getParameter("PrixLivre");
            String date = request.getParameter("DateAchat");
            String nEditeur = request.getParameter("nomEdit");
            String disp = request.getParameter("disponibilite") ; 
            String nbrcop = request.getParameter("nbrCopie") ; 
            String msg;

            int CodeL = Integer.parseInt(code);
            double PrixL = Double.parseDouble(prix);
            
            if( disp == null || disp.equalsIgnoreCase("")){
                disp ="0";
            }
            else { disp ="1" ; }
            
            int dispo = Integer.parseInt(disp) ; 
            
            int nombrCopie = Integer.parseInt(nbrcop); 

            //Editeur e = new Editeur() ; 
            // e.setNomEditeur(nEditeur); 
            
            LivreMetier model = new LivreMetier();
            model.getLivre().setCodeLivre(CodeL);
            model.getLivre().setTitre(Titre);
            model.getLivre().setPrix(PrixL);
            model.getLivre().setDateAchat(date);
            model.getLivre().setNomEdit(nEditeur);
            model.getLivre().setDisponibilite(dispo);
            model.getLivre().setNombreCopie(nombrCopie);

            msg = model.Ajouter() ? "Livre ajouter avec succes" :
                "Aucun Livre a ete ajoute";   
            request.setAttribute("msgUpdate", msg);
            
            request.getRequestDispatcher("/LIVRE/ajouterLivre.jsp").forward(request, resp);
                  
        }
    }
    
    

}
