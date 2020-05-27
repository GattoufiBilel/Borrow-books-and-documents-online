package DaoLivreEditeur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Beans.Editeur;
import Beans.Livre;
import utilitaire.SingletonConnection;

public class LivreDao implements InterDao<Livre> {
    
    private static Connection conn;
    private PreparedStatement stmt;
    
    public LivreDao() 
    {
        conn = SingletonConnection.getConn();
    }

    @Override
    public boolean ajouter(Livre o) 
    {
        String query = "insert INTO LIVRE values (? , ? , ? , ? , ? , ? , ?) ";
       
        try 
        {
            stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, o.getCodeLivre());
            stmt.setString(2 , o.getTitre());
            stmt.setDouble(3, o.getPrix());
            stmt.setString(4, o.getDateAchat());
            stmt.setString(5, o.getNomEdit());
            stmt.setInt(6, o.getDisponibilite());
            stmt.setInt(7, o.getNombreCopie()); 
           
            stmt.executeUpdate();
            
            return true;
        } 
        catch (SQLException e) 
        {
            System.out.println("erreur in dao " + e.getMessage());
        }
        return false;
    }

    
    public void modifierLivre(int code , String t , double p , String d , String ne ) {
        String req =  "update livre set titre = ?, prix = ?, dateachat = ?, idediteur = ? " + " where codelivre = ?  " ; 
        try {
            stmt = conn.prepareStatement(req) ;
            stmt.setString(1, t);
            stmt.setDouble(2, p);
            stmt.setString(3, d);
            stmt.setString(4, ne);
            stmt.setInt(5, code);
            
            stmt.executeUpdate(); 
             System.out.println(" mis a jour livre avec succes " ); 
        }
        catch(SQLException ex) {
            System.err.println("error modification " + ex.getMessage()); 
        }
    }
    
    @Override
    public boolean editer(Livre o , int code) 
    {
      
         String query = "UPDATE livre SET titre = ?, prix = ?, dateachat = ? , idediteur = ? " + " WHERE codelivre = ? " ;
        try 
        {
            stmt = conn.prepareStatement(query);
            
            stmt.setString(1 , o.getTitre());
            stmt.setDouble(2, o.getPrix());
            stmt.setString(3, o.getDateAchat());
            stmt.setObject(4, o.getNomEdit());
            stmt.setInt(5, code);
            
            
            stmt.executeUpdate();
            
            return true;
        } 
        catch (SQLException e) 
        {
            System.err.println("non modifier " + e.getMessage());
           
        }
            return false  ; 
    }
    
    
    public boolean editerNombreCopie(int code ) 
    {
         String query = "UPDATE livre SET nombreCopie = nombreCopie -1 " + " WHERE codelivre = ? " ;
        try 
        {
            stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, code);
            
            stmt.executeUpdate();
            return true ; 
        }
        catch(SQLException ex) {
        }
        return false ; 
    }

    @Override
    public boolean supprimer(int id) 
    {
        String query = "DELETE FROM LIVRE WHERE CODELIVRE = ?";
        try 
        {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1 , id);
            
            stmt.executeUpdate();

            return true;
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
     public boolean disponiblite(int id) 
    {
        String query = "update livre set disponibilite = 1 WHERE codelivre = ? ";
        try 
        {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1 , id);
            stmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
     
     
    public boolean DisponibiliteFalse(int id) 
    {
        String query = "update livre set disponibilite = 0 WHERE codelivre = ? ";
        try 
        {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1 , id);
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
    public Livre getObject(String nom) 
    {
        Livre livre = null;
       
        String req = "Select * from livre WHERE titre = ? " ; 
        
        try 
        {
            stmt = conn.prepareStatement(req);
            stmt.setString(1 , nom);
            
            ResultSet result = stmt.executeQuery();

            while(result.next()) 
            {
                livre = new Livre
                (
                    result.getInt(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4) , 
                    result.getString(5),
                    result.getInt(6),
                    result.getInt(7)
                );
            }

        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage() + "--");
        }
        
        return livre;
    }


    public Livre getObject(int id) 
    {
        Livre livre = null;
       
        String req = "Select * from livre WHERE codelivre = ? " ; 
        
        try 
        {
            stmt = conn.prepareStatement(req);
            stmt.setInt(1 , id);
            
            ResultSet result = stmt.executeQuery();

            while(result.next()) 
            {
                livre = new Livre
                (
                    result.getInt(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4) , 
                    result.getString(5),
                    result.getInt(6),
                    result.getInt(7)
                );
            }

        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage() + "--");
        }
        
        return livre;
    }

    @Override
    public ArrayList<Livre> getAll() 
    {

        String req = " SELECT * FROM LIVRE order by codelivre asc " ; 
        
        ArrayList<Livre> listLivre = new ArrayList();
        try 
        {
            stmt = conn.prepareStatement(req);
            ResultSet result = stmt.executeQuery();
            
            while(result.next()) 
            {
                Livre l ;
                l = new Livre 
                (
                    result.getInt(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4), 
                    result.getString(5),
                    result.getInt(6),
                    result.getInt(7)
                );
                    listLivre.add(l);
            }
            
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage() + "--");
        }
        
        return listLivre;
    }
    
    
   
    public ArrayList<Livre> getAllEmprunts() 
    {

        String req = " SELECT * FROM LIVRE where disponibilite = 0 order by codelivre asc " ; 
        
        ArrayList<Livre> listLivre = new ArrayList();
        try 
        {
            stmt = conn.prepareStatement(req);
            ResultSet result = stmt.executeQuery();
            
            while(result.next()) 
            {
                Livre l ;
                l = new Livre 
                (
                    result.getInt(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4), 
                    result.getString(5),
                    result.getInt(6),
                    result.getInt(7)
                );
                    listLivre.add(l);
            }
            
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage() + "--");
        }
        
        return listLivre;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void CloseConnexion() 
    {
        try 
        {
            stmt.close();
            conn.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(LivreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
