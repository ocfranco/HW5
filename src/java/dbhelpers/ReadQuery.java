
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cars;



public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery () {
     
     Properties props = new Properties ();
     InputStream  instr = getClass().getResourceAsStream ("dbCon.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
     String driver = props.getProperty("driver.name");
     String url = props.getProperty("server.name");
     String username = props.getProperty("user.name");
     String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void doRead(){

        PreparedStatement ps = null;
        try {
            String query = "Select * from cars";
            ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }
}
    
    public String getHTMLTable(){
        
        String table = "";
        table += "<table border=2>";
        
        try {
            while(this.results.next()){
                
                Cars Car = new Cars();
                Car.setCarID(this.results.getInt("CarID"));
                Car.setCarMake(this.results.getString("CarMake"));
                Car.setCarModel(this.results.getString("CarModel"));
                Car.setModelYear(this.results.getInt("ModelYear"));
                Car.setTorque(this.results.getInt("Torque"));
                Car.setHorsepower(this.results.getInt("Horsepower"));
                
                table += "<tr>";
                table += "<td>";
                table += Car.getCarID();
                table += "</td>";
            
                table += "<td>";
                table += Car.getCarMake();
                table += "</td>";
                
                table += "<td>";
                table += Car.getCarModel();
                table += "</td>";
                
                table += "<td>";
                table += Car.getModelYear();
                table += "</td>";
                
                table += "<td>";
                table += Car.getTorque();
                table += "</td>";
                
                table += "<td>";
                table += Car.getHorsepower();
                table += "</td>";
                table += "<a href=delete?carID=" + Car.getCarID() + "Delete </a>";
                table+= "</tr>";
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
           
           
        return table;
        
   }
}
        
    
     

   



    