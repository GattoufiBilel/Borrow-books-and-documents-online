
package DaoAdherent;

import Beans.Site;
import DaoLivreEditeur.InterDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utilitaire.SingletonConnection;


public class SiteDao  implements InterDao<Site> {
    
    private static java.sql.Connection conn;
    private PreparedStatement stmt;
    
    public SiteDao()
    {
       conn = SingletonConnection.getConn();
    }
        @Override
    public boolean ajouter(Site o) 
    {
        String query = "INSERT INTO Site (adresse, zone)  VALUES(? , ? )";
        try 
        {
            stmt = conn.prepareStatement(query);
            
            stmt.setString(1, o.getAdresse())  ; 
            stmt.setString(2 , o.getZone()) ;

            stmt.executeUpdate();
            
            return true;
            
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return false;
    }

    @Override
    public boolean editer(Site o , int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Site getObject(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Site> getAll() {
       ArrayList<Site> Sites = new ArrayList<>();
        String query = "SELECT * FROM SITE ";
        try 
        {
            stmt = conn.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            
            while(result.next()) 
            {
                Site adherent = new Site
                (
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3)

                );
                
                Sites.add(adherent);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return Sites;
    }
    

    @Override
    public void CloseConnexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
