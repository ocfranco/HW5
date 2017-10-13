/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cars;

/**
 *
 * @author btfra
 */
public class AddQuery {
    
    private Connection conn;
    
   public AddQuery () {
         Properties props = new Properties ();
     InputStream  instr = getClass().getResourceAsStream ("dbCon.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
     String driver = props.getProperty("driver.name");
     String url = props.getProperty("server.name");
     String username = props.getProperty("user.name");
     String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
   public void doAdd (Cars car){
       
        try {
            String query = "INSERT INTO cars (carMake, carModel, modelYear, torque, horsepower) VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, car.getCarMake());
            ps.setString(2, car.getCarModel());
            ps.setInt(3, car.getModelYear());
            ps.setInt(4, car.getTorque());
            ps.setInt(5, car.getHorsepower());
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
            
   }
   }
    

