package utilitaire;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    
    private static Connection conn;
    
    static 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgestionbib" , "root" , "");
            System.out.println("Connexion etablir avec succes ");
        }   
        catch(ClassNotFoundException | SQLException e) 
        {
            System.err.println("Not connected");
        }
    }
    
    public static Connection getConn() 
    {
        return conn;
    }
    
}
