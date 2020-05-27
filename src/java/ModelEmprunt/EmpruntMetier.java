
package ModelEmprunt;

import Beans.Adherent;
import Beans.Emprunt;
import Beans.Livre;
import DaoEmprunt.EmpruntDao;
import java.util.ArrayList;


public class EmpruntMetier {
    private final EmpruntDao dao ; 
    private Emprunt emprunt ; 
    private Livre livre ; 
    private Adherent adherent; 
    private String dateactu , dateret ; 
    
    
    public EmpruntMetier() {
        dao = new EmpruntDao() ;
        emprunt = new Emprunt() ;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }
    
    
    public boolean OperationEmprunt() {
        return dao.OperationEmprunt(emprunt) ; 
    }
    
     public ArrayList<Emprunt> getAll()
    {
        return dao.getAll();
    } 

    public String DateActu(){
        return dao.getCurrentTimeUsingDate(); 
    }
    
    public String DateRetour(){
        return dao.getRetourtTimeUsingDate(); 
    }
     public void Closedsession() {
        dao.CloseConnexion();
     }
    
    
    
}
