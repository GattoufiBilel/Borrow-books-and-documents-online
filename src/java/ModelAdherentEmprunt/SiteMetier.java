
package ModelAdherentEmprunt;

import Beans.Site;
import DaoAdherent.SiteDao;
import java.util.ArrayList;

public class SiteMetier {
    private final SiteDao dao ; 
    private Site site ; 

    public SiteMetier() {
        dao = new SiteDao() ;
        site = new Site(); 
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
        
    public boolean Ajouter() {
        return dao.ajouter(site); 
    }
    
        
   public ArrayList<Site> Tous() {
       return dao.getAll();
   }
    
}
