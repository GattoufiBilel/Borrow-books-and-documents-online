package ModelLivreEditeur;

import DaoLivreEditeur.LivreDao;
import java.util.ArrayList;
import Beans.Livre;

public class LivreMetier {
    
    private final LivreDao dao;
    private Livre livre ; 

    
    public LivreMetier()
    {
        dao = new LivreDao();
        livre = new Livre() ; 
    }

    public LivreDao getDao() {
        return dao;
    }

    
    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
    
    
      
    public boolean Ajouter() { 
        return dao.ajouter(livre);
    }
    
    public ArrayList<Livre> getAll()
    {
        return dao.getAll() ;
    }
    
    public ArrayList<Livre> getLivreEmprunte() 
    {
        return dao.getAllEmprunts(); 
    }
    
    public Boolean Modifier(int id) {
       return dao.editer(livre , id); 
    }
    
    public Boolean Supprimer(int id) { 
        return dao.supprimer(id);
    }
    
    public Livre getLivre(String titre) { 
        return dao.getObject(titre);
    }
    
        public Livre getLivre(int id) { 
        return dao.getObject(id);
    }
    
    public Boolean Disponibilite(int id) {
        return dao.disponiblite(id); 
    }
    
        public Boolean DisponibiliteFalse(int id) {
        return dao.DisponibiliteFalse(id) ;
    }
    
    public Boolean EditerNombreCopie(int id){
        return dao.editerNombreCopie(id);
    }
    
   
}
