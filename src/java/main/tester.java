
package main;


import Beans.Adherent;
import Beans.Livre;
import ModelLivreEditeur.LivreMetier;
import ModelAdherentEmprunt.AdherentMetier;
import utilitaire.SingletonConnection; 

public class tester {
    
   public static void main(String[] args) 
    {
       SingletonConnection con = new SingletonConnection();
       SingletonConnection.getConn(); 
       String ms ; 
       
        LivreMetier mode = new LivreMetier(); 
        Livre Monlivre  = new Livre() ; 
        Monlivre = mode.getLivre(100); 
        int n = Monlivre.getNombreCopie(); 
       
        //mode.Disponibilite(200);
        mode.DisponibiliteFalse(200); 
        
        
       
       
       System.out.println("nbr copier : " +   Monlivre.getNombreCopie()) ; 
       System.out.println("disponibilite :" + Monlivre.getDisponibilite()) ;
     
        }
    
}
   