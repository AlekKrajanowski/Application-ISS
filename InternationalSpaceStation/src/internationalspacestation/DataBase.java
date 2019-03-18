package internationalspacestation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alek
 */
public class DataBase {
    Connection conn=null;
    public static Connection ConnecrDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/latitudeandlongitudeandtime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","AK","root");
            return connection;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
        public void savePosition(double time, double longitude,double latitude)throws SQLException{
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/latitudeandlongitudeandtime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","AK","root");
             try (Statement statment = connection.createStatement()){
                 statment.execute("INSERT INTO latitudeandlongitudeandtime.position VALUES('"+time+"','"+longitude+"','"+latitude+"')");
            }
             System.out.println("Saving succeed");
        }catch (ClassNotFoundException ex) {
             Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }catch(SQLTimeoutException ex){
             System.out.println("The connection time with the database has been exceeded");
        }catch(SQLException ex){
             System.out.println("Connection error with the database");
        }   
    }       
}
