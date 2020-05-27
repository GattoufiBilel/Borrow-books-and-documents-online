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

public class EditeurDao implements InterDao<Editeur> {
    
    private static Connection conn;
    private PreparedStatement stmt;
    
    public EditeurDao() 
    {
        conn = SingletonConnection.getConn();
    }

    @Override
    public boolean ajouter(Editeur o) 
    {
        String query = "INSERT INTO EDITEUR(idediteur , editeur , adresse) VALUES(? , ? , ?)";
        
        try 
        {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, o.getIdEditeur());
            stmt.setString(2 , o.getNomEditeur());
            stmt.setString(3 , o.getAdresse());
            
            stmt.executeUpdate();
            
         return true;
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return false ;
    }

    @Override
    public boolean editer(Editeur o , int id) 
    {
        String query = "UPDATE EDITEUR SET editeur = ? , adresse = ? WHERE idediteur = ?";
        try 
        {
            stmt = conn.prepareStatement(query);
            stmt.setString(1 , o.getNomEditeur());
            stmt.setString(2, o.getAdresse());
            stmt.setInt(3 , id);
            
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
        String query = "DELETE FROM EDITEUR WHERE IDEDITEUR = ?";
        try 
        {
            stmt= conn.prepareStatement(query);
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
    public Editeur getObject(String nom) 
    {
        Editeur editeur = null;
        
        String query = "SELECT * FROM EDITEUR WHERE editeur = ? "; 
        try 
        {
            stmt = conn.prepareStatement(query);
            stmt.setString(1 , nom);
            
            ResultSet result = stmt.executeQuery();
            
           ArrayList<Livre> listeLivre = new ArrayList<>();
                
           listeLivre = getListLivre(nom) ;
            
            while(result.next()) 
            { 
                editeur = new Editeur(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3) 
                );
            }

        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return editeur;
    }

    @Override
    public ArrayList<Editeur> getAll() 
    {
        String query = "SELECT * FROM EDITEUR order by idediteur asc ";        
        ArrayList<Editeur> listeEditeur = new ArrayList();

        try 
        {
            stmt = conn.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            
            while(result.next()) 
            {      
               
                Editeur e ; 
                e = new Editeur( 
                    result.getInt(1), 
                    result.getString(2),               
                    result.getString(3)
                );
                listeEditeur.add(e);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
            throw new RuntimeException("no list categorie found " , e);
        }
        return listeEditeur;
    }
    
    public ArrayList<Livre> getListLivre(String nomEdit) 
    {
        ArrayList<Livre> listLivre = new ArrayList<>();
        
        String query = "SELECT * FROM LIVRE WHERE IDEDITEUR = ?";
        try 
        {
            stmt = conn.prepareStatement(query);
            stmt.setString(1 , nomEdit);
            
            ResultSet result = stmt.executeQuery();
            
            while(result.next()) 
            {
                Livre livre;
                livre = new Livre
                (
                    result.getInt(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4), 
                    result.getString(5),
                    result.getInt(6),
                    result.getInt(7)
                );
                    listLivre.add(livre);
            }
                    
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
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
            Logger.getLogger(EditeurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
