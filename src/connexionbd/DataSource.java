/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elife-Sil-049
 */
public class DataSource {
    
    private String url="jdbc:mysql://localhost:3306/elife";
    private String login="root";
    private String pwd="";
    private Connection connection;
    private static DataSource instance;

    private DataSource() {
        try {
            connection=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DataSource getInstance(){
        if(instance==null)
            instance=new DataSource(); 
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
    
    
    
    
}
