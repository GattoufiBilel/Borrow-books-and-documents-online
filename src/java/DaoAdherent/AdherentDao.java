package DaoAdherent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Beans.Adherent;
import DaoLivreEditeur.InterDao;
import java.sql.SQLException;
import utilitaire.SingletonConnection;

public class AdherentDao implements InterDao<Adherent> {

    private static Connection conn;
    private PreparedStatement stmt;
    
    public AdherentDao()
    {
        conn = SingletonConnection.getConn();
    }

    @Override
    public boolean ajouter(Adherent o) 
    {
        //String query = "INSERT INTO adherent VALUES (? , ?, ?, ?, ?, ?, ?, ?) ";
        String query = "INSERT INTO adherent(matricule, nom, prenom, age, adresse, email, password, role) VALUES (? , ?, ?, ?, ?, ?, ?, ?) " ; 
        try 
        {
            stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, o.getMatricule());
            stmt.setString(2 , o.getNom());
            stmt.setString(3 , o.getPrenom());
            stmt.setInt(4, o.getAge());
            stmt.setString(5 , o.getAdresse());
            stmt.setString(6,  o.getEmail()) ; 
            stmt.setString(7, o.getPassword()); 
            stmt.setInt(8, o.getRole());
          
            stmt.executeUpdate();
            
            return true;
            
        } 
        catch (SQLException e) 
        {
            System.out.println("erreur insert in dao " + e.getMessage());
        }
        
        return false;
    }

    @Override
    public boolean editer(Adherent o , int id) 
    {
        String query = "UPDATE ADHERENT SET NOM = ? , PRENOM = ? , AGE = ? , ADRESSE = ? WHERE matricule = ? ";
        try 
        {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, o.getNom());
            stmt.setString(2, o.getPrenom());
            stmt.setInt(3, o.getAge());
            stmt.setString(4 , o.getAdresse());
            stmt.setInt(5 , o.getMatricule());
            
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
    public boolean supprimer(int id) 
    {
        String query = "DELETE FROM ADHERENT WHERE matricule = ? ";
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
    public Adherent getObject(String nom) 
    {
        Adherent adherent = null;
        String query = "SELECT * FROM ADHERENT WHERE nom = ? ";
        try 
        {
            stmt = conn.prepareStatement(query);
            stmt.setString(1 , nom);
            ResultSet result = stmt.executeQuery();
            
            while(result.next()) 
            {
                adherent = new Adherent
                (
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4), 
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getInt(8)
                );
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return adherent;
    }

    @Override
    public ArrayList<Adherent> getAll() 
    {
        ArrayList<Adherent> listAdherent = new ArrayList<>();
        String query = "SELECT * FROM ADHERENT";
        try 
        {
            stmt = conn.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            
            while(result.next()) 
            {
                Adherent adherent = new Adherent
                (
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4), 
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getInt(8)
                );
                
                listAdherent.add(adherent);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return listAdherent;
    }

    @Override
    public void CloseConnexion() {
        try 
        {
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }

    public Adherent getObject(int matricule) {
        Adherent adherent = null;
        String query = "SELECT * FROM ADHERENT WHERE matricule = ?";
        try 
        {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1 , matricule);
            ResultSet result = stmt.executeQuery();
            
            while(result.next()) 
            {
                adherent = new Adherent
                (
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getInt(8)
                );
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return adherent;
    }

    
    
    public Adherent Chercher(String mail , String passe) {
        String nom = null ; 
        Adherent adherent = null;
        String query = "SELECT * FROM ADHERENT WHERE email = ? and password = ? ";
        try 
        {
            stmt = conn.prepareStatement(query);
            stmt.setString(1 , mail);
            stmt.setString(2 , passe);
            ResultSet result = stmt.executeQuery();

            while(result.next()) 
            {
                adherent = new Adherent
                (
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4), 
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getInt(8)
                );
            }
            // nom = adherent.getNom() ; 

            
        } 
        catch (SQLException e) 
        {
         
        }
        
        return adherent  ;
    }
        
}


    
 