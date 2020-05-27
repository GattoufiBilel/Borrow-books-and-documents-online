package ModelAdherentEmprunt;

import Beans.Adherent;
import java.util.ArrayList;
import DaoAdherent.AdherentDao;

public class AdherentMetier {
    
    private final AdherentDao dao;
    private Adherent adherent ; 
    //private String login , passe ; 
    
    public AdherentMetier()
    {
        dao = new AdherentDao();
        adherent = new Adherent() ; 
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
    
    
    

      
    public boolean Ajouter() { 
        return dao.ajouter(adherent);
    }
    
     public ArrayList<Adherent> getAll()
    {
        return dao.getAll() ;
    }
    
     
     
     
    public Boolean Modifier(int id ) {
       return dao.editer(adherent , id); 
    }
    
    public Boolean Supprimer(int id) { 
        return dao.supprimer(id);
    }
    
    public Adherent getAdherent(String nom) { 
        return dao.getObject(nom);
    }
    
     public Adherent getAdh(int matricule) { 
        return dao.getObject(matricule);
    }
    
     
     public Adherent Connecter(String login , String passe){
        return dao.Chercher(login, passe) ; 
     }

  
   
}
