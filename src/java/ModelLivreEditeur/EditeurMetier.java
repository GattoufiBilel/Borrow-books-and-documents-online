package ModelLivreEditeur;

import DaoLivreEditeur.EditeurDao;
import Beans.Editeur;
import Beans.Livre;
import java.util.ArrayList;

public class EditeurMetier {
    
    private final EditeurDao dao ;
    private Editeur editeur ; 
    
    
    public EditeurMetier() 
    {
        dao = new EditeurDao();
        editeur = new Editeur() ; 
    }

    public EditeurDao getDao() {
        return dao;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }
    
    public Boolean ajouter(){
        return dao.ajouter(editeur); 
    }
    
    public ArrayList<Editeur> getAll() {
        return dao.getAll(); 
    }
    
    public Boolean supprimer(int id) {
        return dao.supprimer(id); 
    }
    
    public Boolean modifier(int id) {
        return dao.editer(editeur , id); 
    }
    
    
    public Editeur getEditeur(String nom) {
        
        return dao.getObject(nom) ; 
    }
    
    public ArrayList<Livre> lstLivre(String nom) {
        return dao.getListLivre(nom) ; 
    }

    

}
