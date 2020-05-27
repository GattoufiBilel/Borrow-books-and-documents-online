package DaoEmprunt;

import Beans.Adherent;
import Beans.Emprunt;
import Beans.Livre;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitaire.SingletonConnection;


public class EmpruntDao implements InterDaoEmprunt<Object> {
    
    private static Connection conn;
    private PreparedStatement stmt;
    
    public EmpruntDao()
    {
        conn = SingletonConnection.getConn();
    }


    
    @Override
    public ArrayList<Emprunt> getAll() {
         
        ArrayList<Emprunt> listelivreEmprunte = new ArrayList<>();
        String query = "SELECT * FROM Emprunt";
        try 
        {
            stmt = conn.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            
            while(result.next()) 
            {
                Emprunt emprunt = new Emprunt
                (
                    result.getInt(1), 
                    result.getInt(2), 
                    result.getInt(3),
                    result.getString(4),
                    result.getString(5)
              
                );
                
                listelivreEmprunte.add(emprunt);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        
        return listelivreEmprunte ;
    }

    
    
    @Override
    public Boolean OperationEmprunt(Emprunt o) {
        
     String query = "insert INTO EMPRUNT values (? , ? , ? , ? ) ";
       
        try 
        {
            //Livre l = new Livre() ;
            //Adherent a = new Adherent() ; 
//            l = TrouverLivre(codelivre) ; 
//            a = TrouverEmprunteur(codeadherent) ; 
//            dateemprunt = getCurrentTimeUsingDate() ; 
//            dateretour  = getRetourtTimeUsingDate()  ; 
            
            stmt = conn.prepareStatement(query);
            stmt.setInt(1 , o.getCodelivre());
            stmt.setInt(2, o.getIdadherent());
            stmt.setString(3, o.getDateemprunt());
            stmt.setString(4, o.getDateretour());
            
            stmt.executeUpdate();
            
            return true;
        } 
        catch (SQLException e) 
        {
            System.out.println("erreur in dao " + e.getMessage());
        }
        return false;
    }
    
    
    
    public Livre TrouverLivre(int code) {
        
        Livre l = new Livre() ; 
      
        String req = " SELECT * from Livre where codelivre = ? " ;   
 
        try 
        {
            stmt = conn.prepareStatement(req);
            stmt.setInt(1 , code);
            
            ResultSet result = stmt.executeQuery();

            while(result.next()) 
            {
                l = new Livre
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
        
        return l;
    }
    
    
    public Adherent TrouverEmprunteur(int code) {
        
        Adherent a = new Adherent() ; 
        String req = " SELECT * from Adherent where matricule = ? " ;   
 
        try 
        {
            stmt = conn.prepareStatement(req);
            stmt.setInt(1 , code);
            ResultSet result = stmt.executeQuery();
            while(result.next()) 
            {
                a = new Adherent 
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
        
        return a ;
    }
    
    
    
    
public static String getCurrentTimeUsingDate() {
    Date date = new Date();
    String strDateFormat = "hh:mm:ss a";
    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
    String formattedDate = dateFormat.format(date);
    return formattedDate ; 
    
}

public static String getRetourtTimeUsingDate() {
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	//Getting current date
	Calendar cal = Calendar.getInstance();
	//Displaying current date in the desired format
	System.out.println("Current Date: "+sdf.format(cal.getTime()));
	   
	//Number of Days to add
        cal.add(Calendar.DAY_OF_MONTH, 7);  
	//Date after adding the days to the current date
	String newDate = sdf.format(cal.getTime());  
	//Displaying the new Date after addition of Days to current date
	//System.out.println("Date after Addition: "+newDate);

        return newDate ; 
    }

@Override
    public void CloseConnexion() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpruntDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    
}
    
     
    
    
    
   
