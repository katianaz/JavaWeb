package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author katia
 */
public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/exerciciosweb2";
    private static final String USER ="root";
    private static final String PASS = "";
    
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }
    
    
    public static void closeConnection(Connection con) throws SQLException{
        try{
            if(con != null)
            con.close();
        } catch (SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    
     public static void closeConnection(Connection con, PreparedStatement stmt) throws SQLException{        
         closeConnection(con);         
         
         try{
             if(stmt != null)
                 stmt.close();
             
        } catch (SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
      public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) throws SQLException{        
         closeConnection(con, stmt);         
         
         try{
             if(rs != null)
                 rs.close();
             
        } catch (SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
}
